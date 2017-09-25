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

import com.jegab.persistenceEntities.Producto;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Producto.
 * @see .Producto
 * @author Hibernate Tools
 */
public class ProductoDAO {

	private static final Log log = LogFactory.getLog(ProductoDAO.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
					.addResource("com/jegab/persistenceEntities/Producto.hbm.xml").buildSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Producto transientInstance) {
		log.debug("persisting Producto instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Producto instance) {
		log.debug("attaching dirty Producto instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Producto instance) {
		log.debug("attaching clean Producto instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Producto persistentInstance) {
		log.debug("deleting Producto instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Producto merge(Producto detachedInstance) {
		log.debug("merging Producto instance");
		try {
			Producto result = (Producto) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Producto findById(int id) {
		log.debug("getting Producto instance with id: " + id);
		try {
			Producto instance = (Producto) sessionFactory.getCurrentSession().get("Producto", id);
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

	public List<Producto> findByExample(Producto instance) {
		log.debug("finding Producto instance by example");
		try {
			List<Producto> results = (List<Producto>) sessionFactory.getCurrentSession().createCriteria("Producto")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
