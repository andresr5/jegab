package com.jegab.persistenceDAO;
// default package
// Generated 15-sep-2017 0:05:57 by Hibernate Tools 5.2.5.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jegab.persistenceEntities.Movimiento;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Movimiento.
 * @see .Movimiento
 * @author Hibernate Tools
 */
public class MovimientoDAO {

	private static final Log log = LogFactory.getLog(MovimientoDAO.class);

	private final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addResource("com/jegab/persistenceEntities/Movimiento.hbm.xml").buildSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Movimiento transientInstance) {
		log.debug("persisting Movimiento instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Movimiento instance) {
		log.debug("attaching dirty Movimiento instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Movimiento instance) {
		log.debug("attaching clean Movimiento instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Movimiento persistentInstance) {
		log.debug("deleting Movimiento instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Movimiento merge(Movimiento detachedInstance) {
		log.debug("merging Movimiento instance");
		try {
			Movimiento result = (Movimiento) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Movimiento findById(int id) {
		log.debug("getting Movimiento instance with id: " + id);
		try {
			Movimiento instance = (Movimiento) sessionFactory.getCurrentSession().get("Movimiento", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Movimiento> findByExample(Movimiento instance) {
		log.debug("finding Movimiento instance by example");
		try {
			List<Movimiento> results = (List<Movimiento>) sessionFactory.getCurrentSession()
					.createCriteria("Movimiento").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
