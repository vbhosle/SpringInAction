package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

import spittr.Spittle;

@Repository
public class SpittleDemoRepository implements SpittleRepository {

	private static List<Spittle> spittles = new ArrayList<>();
	private static Long nextID = new Long(10000);
	
	static {
		for(int i=1; i <= 50; i++) {
			spittles.add(new Spittle(nextID, "This is Spittle number "+nextID, new Date(), Math.random()*10,  Math.random()*10));
			nextID++;
		}
		java.util.Collections.reverse(spittles);
		System.out.println(spittles);
	}
	
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		return spittles.stream().filter(spittle -> spittle.getId()<=max).limit(count).collect(Collectors.toList());
	}

	@Override
	public Spittle findOne(Long id) {
		return spittles.stream().filter(spittle -> ((Long)spittle.getId()).equals(id)).findFirst().orElse(null);
	}

}
