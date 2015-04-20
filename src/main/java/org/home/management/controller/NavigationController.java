/***************************************************************
 * Project Name: EDDIConsumerUI
 * 
 * File Name: NavigationController.java
 * 
 * Author: Manoj Kumar Gupta, Created on 26 Jun 2014 at 14:42:40
 * 
 * *************************************************************
 * Home Management Project 2014 
 * *************************************************************/

package org.home.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.home.management.service.IFeedJobsService;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author guptam22
 * 
 */
@Named
@Scope( "session" )
@Controller( value = "navigationController" )
public class NavigationController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 639068458616883679L;

	/**
	 * 
	 */

	private static Logger logger = Logger
			.getLogger( NavigationController.class );

	private List<String> options = new ArrayList<String>();

	private MenuModel menuModel;

	private DashboardModel dashboardModel;

	@Inject
	private IFeedJobsService feedJobsService;

	/**
	 * 
	 */
	public NavigationController() {
	}

	public void actionClear() {
		logger.debug( "On Clear" );
		this.options = new ArrayList<String>();
		this.showInfoMessage( "Clear called" );
	}

	public String buttonClicked( MenuActionEvent menuActionEvent ) {
		String s = "Button : is clicked.";
		logger.info( s );
		return null;
	}

	/**
	 * @return the dashboardModel
	 */
	public DashboardModel getDashboardModel() {
		return this.dashboardModel;
	}

	/**
	 * @return the menuModel
	 */
	public MenuModel getMenuModel() {

		return this.menuModel;
	}

	/**
	 * @return the options
	 */
	public List<String> getOptions() {
		return this.options;
	}

	/**
	 * Initializes Dashboard
	 */
	private void initDashboard() {
		this.dashboardModel = new DefaultDashboardModel();
		DashboardColumn runningColumn = new DefaultDashboardColumn();
		DashboardColumn failedColumn = new DefaultDashboardColumn();
		runningColumn.addWidget( "running" );
		failedColumn.addWidget( "failed" );
		this.dashboardModel.addColumn( runningColumn );
		this.dashboardModel.addColumn( failedColumn );
	}

	private void initMenu() {
		this.menuModel = new DefaultMenuModel();
		// First submenu

		DefaultSubMenu firstSubmenu = new DefaultSubMenu( "Dynamic Submenu" );
		DefaultMenuItem item = new DefaultMenuItem( "External" );
		item.setUrl( "http://www.primefaces.org" );
		item.setIcon( "ui-icon-home" );
		firstSubmenu.addElement( item );
		this.menuModel.addElement( firstSubmenu );
		// Second submenu
		DefaultSubMenu secondSubmenu = new DefaultSubMenu( "Dynamic Actions" );
		item = new DefaultMenuItem( "Save" );
		item.setIcon( "ui-icon-disk" );
		item.setCommand( "#{navigationController.buttonClicked}" );
		// item.setUpdate( "msg" );
		secondSubmenu.addElement( item );
		item = new DefaultMenuItem( "Delete" );
		item.setIcon( "ui-icon-close" );
		item.setCommand( "#{navigationController.buttonClicked}" );
		item.setAjax( false );
		secondSubmenu.addElement( item );
		item = new DefaultMenuItem( "Redirect" );
		item.setIcon( "ui-icon-search" );
		item.setCommand( "#{navigationController.buttonClicked}" );
		secondSubmenu.addElement( item );
		this.menuModel.addElement( secondSubmenu );

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.barclays.imatch.eddi.ui.controller.BaseController#onCreateBean()
	 */
	@Override
	protected void onCreateBean() {
		this.initMenu();
		this.initDashboard();
	}

	public void save() {
		this.feedJobsService.printAll();
	}

	/**
	 * @param feedJobsService
	 *            the feedJobsService to set
	 */
	public void setFeedJobsService( IFeedJobsService feedJobsService ) {
		this.feedJobsService = feedJobsService;
	}

	/**
	 * @param menuModel
	 *            the menuModel to set
	 */
	public void setMenuModel( MenuModel menuModel ) {
		this.menuModel = menuModel;
	}

	/**
	 * @param options
	 *            the options to set
	 */
	public void setOptions( List<String> options ) {
		this.options = options;
	}
}
