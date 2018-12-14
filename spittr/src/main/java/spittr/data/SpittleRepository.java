package spittr.data;

import java.util.List;

import spittr.Spittle;

public interface SpittleRepository {
	long count();

	List<Spittle> findRecent();

	List<Spittle> findRecent(int count);

	Spittle findOne(long id);

	Spittle save(Spittle spittle);

	List<Spittle> findBySpitterId(long spitterId);

	void delete(long id);

	List<Spittle> findSpittles(long max, int count);
}
