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

import com.jegab.persistenceEntities.TipoMovimiento;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TipoMovimiento.
 * @see .TipoMovimiento
 * @author Hibernate Tools
 */
public class TipoMovimientoDAO {

	private static final Log log = LogFactory.getLog(TipoMovimientoDAO.class);

	private final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addResource("com/jegab/persistenceEntities/TipoMovimiento.hbm.xml").buildSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TipoMovimiento transientInstance) {
		log.debug("persisting TipoMovimiento instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TipoMovimiento instance) {
		log.debug("attaching dirty TipoMovimiento instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TipoMovimiento instance) {
		log.debug("attaching clean TipoMovimiento instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TipoMovimiento persistentInstance) {
		log.debug("deleting TipoMovimiento instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TipoMovimiento merge(TipoMovimiento detachedInstance) {
		log.debug("merging TipoMovimiento instance");
		try {
			TipoMovimiento result = (TipoMovimiento) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoMovimiento findById(int id) {
		log.debug("getting TipoMovimiento instance with id: " + id);
		try {
			TipoMovimiento instance = (TipoMovimiento) sessionFactory.getCurrentSession().get("TipoMovimiento", id);
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

	public List<TipoMovimiento> findByExample(TipoMovimiento instance) {
		log.debug("finding TipoMovimiento instance by example");
		try {
			List<TipoMovimiento> results = (List<TipoMovimiento>) sessionFactory.getCurrentSession()
					.createCriteria("TipoMovimiento").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
