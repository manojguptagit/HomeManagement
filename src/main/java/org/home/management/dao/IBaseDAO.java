/***************************************************************
 * Project Name: HomeManagement
 * 
 * File Name: IBaseDAO.java
 * 
 * Author: Manoj Kumar Gupta, Created on 6 Apr 2015 at 15:15:12
 * 
 * *************************************************************
 * 2015 Home Management Project
 * *************************************************************/

package org.home.management.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author guptam22
 * 
 */
public interface IBaseDAO<T> extends Serializable {

	void deleteAll( List<Serializable> ids );

	void deleteById( Serializable id );

	List<T> getAll();

	List<T> getAllByIds( List<Serializable> ids );

	T getById( Serializable id );

	void save( T t );

	void saveAll( List<T> list );

	void update( T t );

	void updateAll( List<T> list );

}
