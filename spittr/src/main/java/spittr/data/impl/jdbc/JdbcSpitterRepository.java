package spittr.data.impl.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Spitter save(Spitter spitter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spitter findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spitter> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
