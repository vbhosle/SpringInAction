package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import spittr.Spittle;

@Repository
public class SpittleDemoRepository implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		spittles.add(new Spittle("Test Spittle", new Date(), 19.232, 17.34));
		return spittles;
	}

}
