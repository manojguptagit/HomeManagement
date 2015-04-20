/***************************************************************
 * Project Name: HomeManagement
 * 
 * File Name: BaseService.java
 * 
 * Author: Manoj Kumar Gupta, Created on 6 Apr 2015 at 15:57:25
 * 
 * *************************************************************
 * 2015 Home Management Project
 * *************************************************************/

package org.home.management.service.impl;

import javax.inject.Named;

import org.home.management.service.IBaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guptam22
 * 
 */
@Transactional
@Named
public abstract class BaseService implements IBaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6774603571782848207L;

}
