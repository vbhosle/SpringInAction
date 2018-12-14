package spittr.data.impl.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import spittr.Spitter;
import spittr.Spittle;
import spittr.data.SpittleRepository;
import spittr.web.SpittleNotFoundException;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {

	private static final String SELECT_SPITTLE = "select sp.id, s.id as spitterId, s.username, s.password, s.firstName, s.lastName, s.email, sp.message, sp.postedTime from Spittle sp, Spitter s where sp.spitterId = s.id";
	private static final String SELECT_SPITTLE_BY_ID = SELECT_SPITTLE + " and sp.id=?";
	private static final String SELECT_SPITTLES_BY_SPITTER_ID = SELECT_SPITTLE
			+ " and s.id=? order by sp.postedTime desc";
	private static final String SELECT_RECENT_SPITTLES = SELECT_SPITTLE + " order by sp.postedTime desc limit ?";
	private static final String FIND_SPITTLES = SELECT_SPITTLE + " and sp.id <= ? order by sp.id desc limit ?";

	private JdbcOperations jdbcOperations;

	@Autowired
	public JdbcSpittleRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	@Override
	public long count() {
		return jdbcOperations.queryForObject("select count(id) from spittle", Long.class);
	}

	@Override
	public List<Spittle> findRecent() {
		return findRecent(10);
	}

	@Override
	public List<Spittle> findRecent(int count) {
		return jdbcOperations.query(SELECT_RECENT_SPITTLES, JdbcSpittleRepository::mapSpittle, count);
	}

	@Override
	public Spittle findOne(long id) {
		try {
			return jdbcOperations.queryForObject(SELECT_SPITTLE_BY_ID, JdbcSpittleRepository::mapSpittle, id);
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override
	public Spittle save(Spittle spittle) {
		long spittleId = insertSpittleAndReturnId(spittle);
		return new Spittle(spittleId, spittle.getSpitter(), spittle.getMessage(), spittle.getPostedTime());
	}

	private long insertSpittleAndReturnId(Spittle spittle) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert((DataSource) jdbcOperations).withTableName("Spittle");
		jdbcInsert.setGeneratedKeyName("id");
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("spitter", spittle.getSpitter().getId());
		args.put("message", spittle.getMessage());
		args.put("postedTime", spittle.getPostedTime());
		long spittleId = jdbcInsert.executeAndReturnKey(args).longValue();
		return spittleId;
	}

	@Override
	public List<Spittle> findBySpitterId(long spitterId) {
		return jdbcOperations.query(SELECT_SPITTLES_BY_SPITTER_ID, JdbcSpittleRepository::mapSpittle, spitterId);
	}

	@Override
	public void delete(long id) {
		jdbcOperations.update("delete from Spittle where id=?", id);
	}

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		return jdbcOperations.query(FIND_SPITTLES,
				JdbcSpittleRepository::mapSpittle, max, count);
	}

	public static Spittle mapSpittle(ResultSet rs, int row) throws SQLException {
		long id = rs.getLong("id");
		String message = rs.getString("message");
		Date postedTime = rs.getTimestamp("postedTime");
		long spitterId = rs.getLong("spitterId");
		String username = rs.getString("username");
		String password = rs.getString("password");
		String firstName = rs.getString("firstName");
		String lastName = rs.getString("lastName");
		String email = rs.getString("email");
		Spitter spitter = new Spitter(spitterId, username, password, firstName, lastName, email);
		return new Spittle(id, spitter, message, postedTime);
	}

	public static class SpittleMapper implements RowMapper<Spittle> {

		@Override
		public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
			long id = rs.getLong("id");
			String message = rs.getString("message");
			Date postedTime = rs.getTimestamp("postedTime");
			long spitterId = rs.getLong("spitterId");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			String email = rs.getString("email");
			Spitter spitter = new Spitter(spitterId, username, password, firstName, lastName, email);
			return new Spittle(id, spitter, message, postedTime);
		}

	}

}
