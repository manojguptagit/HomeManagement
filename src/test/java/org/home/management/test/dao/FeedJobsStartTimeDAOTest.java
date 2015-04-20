/***************************************************************
 * Project Name: JobMonitor
 * 
 * File Name: FeedJobsStartTimeDAOTest.java
 * 
 * Author: Manoj Kumar Gupta, Created on 15 Apr 2015 at 12:14:13
 * 
 * *************************************************************
 * 2015 Barclays Capital
 * *************************************************************/

package org.home.management.test.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.home.management.dao.IFeedJobsStartTimeDAO;
import org.home.management.entity.FeedJobsStartTimeVO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guptam22
 * 
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = "file:src/main/webapp/WEB-INF/applicationContext.xml" )
public class FeedJobsStartTimeDAOTest {

	@Inject
	private IFeedJobsStartTimeDAO feedJobsStartTimeDAO;

	private List<FeedJobsStartTimeVO> feedJobsStartTimeVOs;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	@Transactional
	public void setUp() throws Exception {
		this.feedJobsStartTimeVOs = new ArrayList<FeedJobsStartTimeVO>();
		for ( int i = 0; i < 100; i++ ) {
			FeedJobsStartTimeVO feedJobsStartTimeVO = new FeedJobsStartTimeVO();
			feedJobsStartTimeVO.setEndTime( new Date() );
			feedJobsStartTimeVO.setFeedPK( ( long ) i );
			feedJobsStartTimeVO.setFr( ( int ) ( Math.random() * 10 ) );
			feedJobsStartTimeVO.setSa( ( int ) ( Math.random() * 10 ) );
			feedJobsStartTimeVO.setSu( ( int ) ( Math.random() * 10 ) );
			feedJobsStartTimeVO.setTh( ( int ) ( Math.random() * 10 ) );
			feedJobsStartTimeVO.setTu( ( int ) ( Math.random() * 10 ) );
			feedJobsStartTimeVO.setWe( ( int ) ( Math.random() * 10 ) );
			feedJobsStartTimeVO.setMo( ( int ) ( Math.random() * 10 ) );
			feedJobsStartTimeVO.setStartMins( "Start : " + i );
			feedJobsStartTimeVO.setStartTime( new Date() );
			feedJobsStartTimeVO.setStatusRun( "StatusRun : " + i );
			this.feedJobsStartTimeVOs.add( feedJobsStartTimeVO );
		}
		this.feedJobsStartTimeDAO.saveAll( this.feedJobsStartTimeVOs );
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.barclays.gtss.jobmonitor.dao.impl.BaseDAO#getAll()}.
	 */
	@Test
	@Transactional
	public void testGetAll() {
		List<FeedJobsStartTimeVO> feedJobsStartTimeVOs = this.feedJobsStartTimeDAO
				.getAll();

		Assert.assertTrue( feedJobsStartTimeVOs.size() == feedJobsStartTimeVOs
				.size() );
	}

	/**
	 * Test method for
	 * {@link com.barclays.gtss.jobmonitor.dao.impl.BaseDAO#getById(java.io.Serializable)}
	 * .
	 */
	@Test
	@Transactional
	public void testGetById() {
		FeedJobsStartTimeVO feedJobsStartTimeVO = this.feedJobsStartTimeDAO
				.getById( 1 );
		Boolean returnVal = false;
		for ( FeedJobsStartTimeVO feedJobsStartTimeVO2 : this.feedJobsStartTimeVOs ) {
			if ( feedJobsStartTimeVO2.equals( feedJobsStartTimeVO ) ) {
				returnVal = true;
			}
		}
		Assert.assertTrue( returnVal );
	}

	/**
	 * Test method for
	 * {@link com.barclays.gtss.jobmonitor.dao.impl.BaseDAO#save(java.lang.Object)}
	 * .
	 */
	@Test
	@Transactional
	public void testSave() {
		Assert.assertTrue( true );
	}

	/**
	 * Test method for
	 * {@link com.barclays.gtss.jobmonitor.dao.impl.BaseDAO#saveAll(java.util.List)}
	 * .
	 */
	@Test
	@Transactional
	public void testSaveAll() {
		Assert.assertTrue( true );
	}

}
