/***************************************************************
 * Project Name: HomeManagement
 * 
 * File Name: FeedJobsService.java
 * 
 * Author: Manoj Kumar Gupta, Created on 6 Apr 2015 at 17:21:43
 * 
 * *************************************************************
 * 2015 Home Management Project
 * *************************************************************/

package org.home.management.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.home.management.dao.IFeedJobsStartTimeDAO;
import org.home.management.entity.FeedJobsStartTimeVO;
import org.home.management.service.IFeedJobsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guptam22
 * 
 */
@Named
public class FeedJobsService extends BaseService implements IFeedJobsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6812162106119595135L;

	private static final Logger logger = Logger
			.getLogger( FeedJobsService.class );

	@Inject
	private IFeedJobsStartTimeDAO feedJobsStartTimeDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.barclays.gtss.HomeManagement.service.IFeedJobsService#printAll()
	 */
	@Override
	@Transactional( isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED )
	public void printAll() {
		List<FeedJobsStartTimeVO> feedJobsStartTimeVOs = this.feedJobsStartTimeDAO
				.getAll();
		for ( FeedJobsStartTimeVO feedJobsStartTimeVO : feedJobsStartTimeVOs ) {
			logger.info( feedJobsStartTimeVO );
		}
	}

	/**
	 * @param feedJobsStartTimeDAO
	 *            the feedJobsStartTimeDAO to set
	 */
	public void setFeedJobsStartTimeDAO(
			IFeedJobsStartTimeDAO feedJobsStartTimeDAO ) {
		this.feedJobsStartTimeDAO = feedJobsStartTimeDAO;
	}

}
