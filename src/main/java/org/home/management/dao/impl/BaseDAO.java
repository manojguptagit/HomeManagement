/***************************************************************
 * Project Name: HomeManagement
 * 
 * File Name: BaseDAO.java
 * 
 * Author: Manoj Kumar Gupta, Created on 6 Apr 2015 at 15:15:45
 * 
 * *************************************************************
 * 2015 Home Management Project
 * *************************************************************/

package org.home.management.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.home.management.dao.IBaseDAO;

/**
 * @author guptam22
 * 
 */
@Named
public class BaseDAO<T> implements IBaseDAO<T> {

	private static final Integer BATCH_SIZE = 1000;

	@Inject
	private SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger( BaseDAO.class );

	/**
	 * 
	 */
	private static final long serialVersionUID = -1190584613882300760L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.barclays.gtss.HomeManagement.dao.IBaseDAO#deleteAll(java.util.List)
	 */
	@Override
	public void deleteAll( List<Serializable> ids ) {
		Session session = this.getCurrentSession();
		List<T> deletionObjects = this.getAllByIds( ids );
		logger.info( "Starting batch detele with batch size : " + BATCH_SIZE );
		int i = 0;
		for ( T t : deletionObjects ) {
			session.delete( t );
			if ( i++ % BATCH_SIZE == 0 ) {
				session.flush();
				session.clear();
			}
		}
		logger.info( "Batch deletion completed successfully" );

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.barclays.gtss.HomeManagement.dao.IBaseDAO#deleteById(java.io.Serializable
	 * )
	 */
	@Override
	public void deleteById( Serializable id ) {
		T t = this.getById( id );
		logger.warn( "DELETING record : " + t );
		this.getCurrentSession().delete( t );
	}

	@SuppressWarnings( "unchecked" )
	@Override
	public List<T> getAll() {
		Query query = this.getCurrentSession().getNamedQuery( "selectAll" );
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.barclays.gtss.HomeManagement.dao.IBaseDAO#getAllByIds(java.util.List)
	 */
	@SuppressWarnings( "unchecked" )
	@Override
	public List<T> getAllByIds( List<Serializable> ids ) {
		Query query = this.getCurrentSession().getNamedQuery( "selectAllById" )
				.setParameterList( "ids", ids );
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.barclays.gtss.HomeManagement.dao.IBaseDAO#getById(java.io.Serializable)
	 */
	@SuppressWarnings( "unchecked" )
	@Override
	public T getById( Serializable id ) {
		Query query = this.getCurrentSession().getNamedQuery( "selectById" )
				.setParameter( "id", id );
		return ( T ) query.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.barclays.gtss.HomeManagement.dao.IBaseDAO#getAll()
	 */
	/**
	 * Gets the current session
	 * 
	 * @return
	 */
	protected Session getCurrentSession() {
		return this.getSessionFactory().getCurrentSession();
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		logger.info( "Returning sessionFactory object : " + this.sessionFactory );
		return this.sessionFactory;
	}

	/**
	 * Creates a new session object and return it.
	 * 
	 * @return
	 */
	protected Session openNewSession() {
		return this.getSessionFactory().openSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.barclays.gtss.HomeManagement.dao.IBaseDAO#save(java.lang.Object)
	 */
	@Override
	public void save( T t ) {
		this.getCurrentSession().save( t );
		logger.info( "Record " + t + " saved successfully" );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.barclays.gtss.HomeManagement.dao.IBaseDAO#saveAll(java.util.List)
	 */
	@Override
	public void saveAll( List<T> list ) {
		Session session = this.getCurrentSession();
		logger.info( "Starting batch commit with batch size : " + BATCH_SIZE );
		int i = 0;
		for ( T t : list ) {
			session.save( t );
			if ( i++ % BATCH_SIZE == 0 ) {
				session.flush();
				session.clear();
			}
		}
		logger.info( "Batch commit completed successfully" );
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory( SessionFactory sessionFactory ) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.barclays.gtss.HomeManagement.dao.IBaseDAO#update(java.lang.Object)
	 */
	@Override
	public void update( T t ) {
		this.getCurrentSession().update( t );

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.barclays.gtss.HomeManagement.dao.IBaseDAO#updateAll(java.util.List)
	 */
	@Override
	public void updateAll( List<T> list ) {
		Session session = this.getCurrentSession();
		logger.info( "Starting batch update with batch size : " + BATCH_SIZE );
		int i = 0;
		for ( T t : list ) {
			session.update( t );
			if ( i++ % BATCH_SIZE == 0 ) {
				session.flush();
				session.clear();
			}
		}
		logger.info( "Batch update completed successfully" );
	}

}
