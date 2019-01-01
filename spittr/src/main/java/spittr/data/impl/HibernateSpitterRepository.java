package spittr.data.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spittr.data.SpitterRepository;
import spittr.domain.Spitter;

@Repository
public class HibernateSpitterRepository implements SpitterRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public HibernateSpitterRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public long count() {
		return findAll().size();
	}

	@Override
	public Spitter save(Spitter spitter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spitter findOne(long id) {
		return (Spitter) currentSession().get(Spitter.class, id);
	}

	@Override
	public Spitter findByUsername(String username) {
		return (Spitter) currentSession()
				.createCriteria(Spitter.class)
				.add(Restrictions.eq("username", username))
				.list()
				.get(0);
	}

	@Override
	public List<Spitter> findAll() {
		return (List<Spitter>)currentSession().createCriteria(Spitter.class).list();
	}

}
