package com.jegab.persistenceDAO;
// default package
// Generated 15-sep-2017 0:05:57 by Hibernate Tools 5.2.5.Final

import java.util.List;
import javax.naming.InitialContext;
import org.hibernate.Transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jegab.bean.BeanCategoria;
import com.jegab.persistenceEntities.Categoria;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Categoria.
 * @see .Categoria
 * @author Hibernate Tools
 */
public class CategoriaDAO {

	private static final Log log = LogFactory.getLog(CategoriaDAO.class);

	private final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addResource("com/jegab/persistenceEntities/Categoria.hbm.xml").buildSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Categoria transientInstance) {
		Session session  = sessionFactory.getCurrentSession();
		Transaction tx = null;
		if (!session.getTransaction().isActive()) {
			tx = session.beginTransaction();
		} else {
			tx = session.getTransaction();
		}
		
		
		log.debug("persisting Categoria instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
			tx.commit();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			tx.rollback();
			throw re;
		}
	}

	public void attachDirty(Categoria instance) {
		log.debug("attaching dirty Categoria instance");
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		if (!session.getTransaction().isActive()) {
			tx = session.beginTransaction();
		} else {
			tx = session.getTransaction();
		}
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
			tx.commit();
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			tx.rollback();
			throw re;
		}
	}

	public void attachClean(Categoria instance) {
		log.debug("attaching clean Categoria instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Categoria persistentInstance) {
		log.debug("deleting Categoria instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Categoria merge(Categoria detachedInstance) {
		log.debug("merging Categoria instance");
		try {
			Categoria result = (Categoria) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Categoria findById(int id) {
		log.debug("getting Categoria instance with id: " + id);
		try {
			Categoria instance = (Categoria) sessionFactory.getCurrentSession().get("Categoria", id);
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

	public List<Categoria> findByExample(Categoria instance) {
		log.debug("finding Categoria instance by example");
		try {
			List<Categoria> results = (List<Categoria>) sessionFactory.getCurrentSession().createCriteria("Categoria")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public int getLastIdCategoria(){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		if (!session.getTransaction().isActive()) {
			tx = (Transaction) session.beginTransaction();
		} else {
			tx = (Transaction) session.getTransaction();
		}
		Query query = session.createQuery(" FROM Categoria c ORDER BY c.idCategoria DESC ");
		List<Categoria> categoriaList = query.list();
		if (categoriaList.size() > 0) {
			int categoriaId = categoriaList.get(0).getIdCategoria();
			return categoriaId;
		} else {
			return 0;
		}
	}
	
	public List<Categoria> getAllcategoria(){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		List<Categoria> categoriaList = null;
		if (!session.getTransaction().isActive()) {
			tx = session.beginTransaction();
		} else {
			tx = session.getTransaction();
		}
		try {
			Query query = session.createQuery("from Categoria");
			categoriaList = query.list();
			return categoriaList;
		} catch (RuntimeException e) {
			// TODO: handle exception
		}
		return null;
	}
}
