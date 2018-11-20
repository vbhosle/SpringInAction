package spittr.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import spittr.Spitter;

@Repository
public class SpitterDemoRepository implements SpitterRepository {

	public static final Map<String, Spitter> spitters = new HashMap<>();
	public static long SPITTER_SEQUENCE = 1L; //not thread safe, just for testing
	
	@Override
	public Spitter save(Spitter spitter) {
		Spitter spitter_db = findByUsername(spitter.getUsername());
		if(spitter_db != null) return spitter_db;
		
		Long next_id = ++SPITTER_SEQUENCE;
		spitter.setId(next_id);
		spitters.put(spitter.getUsername(), spitter);
		return spitter;
	}

	@Override
	public Spitter findByUsername(String username) {
		return spitters.get(username);
	}

}
