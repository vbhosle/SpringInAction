package spittr.data.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spittr.data.SpittleRepository;
import spittr.domain.Spittle;

@Repository
public class HibernateSpittleRepository implements SpittleRepository {

	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateSpittleRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public long count() {
		return findAll().size();
	}

	@Override
	public List<Spittle> findRecent() {
		return findRecent(10);
	}

	@Override
	public List<Spittle> findRecent(int count) {
		return (List<Spittle>)spittleCriteria()
				.setMaxResults(count)
				.list();
	}

	@Override
	public Spittle findOne(long id) {
		return (Spittle) currentSession()
				.byId(Spittle.class);
	}

	@Override
	public Spittle save(Spittle spittle) {
		return (Spittle) currentSession().save(spittle);
	}

	@Override
	public List<Spittle> findBySpitterId(long spitterId) {
		return (List<Spittle>)currentSession()
				.createCriteria(Spittle.class)
				.add(Restrictions.eq("spitter", spitterId))
				.list();
	}

	@Override
	public void delete(long id) {
		currentSession().delete(new Spittle(id, null, null, null));
	}
	
	public List<Spittle> findAll() {
		return (List<Spittle>) spittleCriteria().list(); 
	}

	private Criteria spittleCriteria() {
		return currentSession() 
				.createCriteria(Spittle.class)
				.addOrder(Order.desc("postedTime"));
	}

}
