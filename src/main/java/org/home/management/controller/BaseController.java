/***************************************************************
 * Project Name: EDDIConsumerUI
 * 
 * File Name: BaseController.java
 * 
 * Author: Manoj Kumar Gupta, Created on 26 Jun 2014 at 14:42:40
 * 
 * *************************************************************
 * Home Management Project 2014 
 * *************************************************************/

package org.home.management.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.jsf.FacesContextUtils;

/**
 * Base Controller, All the controller classes should extend this class in order
 * to get the common accessible methods
 * 
 * @author guptam22
 * 
 */
@Named
@Controller
@Scope( value = "session" )
public abstract class BaseController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2388830266797828146L;

	/**
	 * Logger instance
	 */
	private static Logger logger = Logger.getLogger( BaseController.class );

	/**
	 * Returns instance of required controller
	 * 
	 * @param Class
	 * @return
	 */
	public static <T extends BaseController> T getInstance( Class<T> clazz ) {
		ApplicationContext applicationContext = FacesContextUtils
				.getWebApplicationContext( FacesContext.getCurrentInstance() );
		return applicationContext.getBean( clazz );
	}

	/**
	 * Default Constructor
	 */
	public BaseController() {
		super();
	}

	/**
	 * Init method invoked when the bean is first loaded
	 */
	@PostConstruct
	protected void onCreateBean() {
		logger.info( "OnCreate Bean Called from "
				+ this.getClass().getCanonicalName() );
	}

	/**
	 * Called on page load event
	 */
	protected void onCreateView() {
		logger.info( "onCreateView Called from "
				+ this.getClass().getCanonicalName() );
	}

	/**
	 * Destroy method invoked when the bean is unloaded, no guarantee to execute
	 */
	protected void onDestroyBean() {
		logger.info( "OnDestroyBean Bean Called from "
				+ this.getClass().getCanonicalName() );
	}

	protected void showErrorMessage( String message ) {
		this.showMessage( message, FacesMessage.SEVERITY_ERROR );
		logger.error( message );
	}

	/**
	 * Shows Info Message
	 * 
	 * @param message
	 */
	protected void showInfoMessage( String message ) {
		this.showMessage( message, FacesMessage.SEVERITY_INFO );
		logger.info( message );
	}

	/**
	 * Shows custom message on the screen
	 * 
	 * @param message
	 * @param severity
	 */
	private void showMessage( String message, Severity severity ) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage( null, new FacesMessage( severity, message,
				message ) );
	}

	/**
	 * Shows Warning message
	 * 
	 * @param message
	 */
	protected void showWarningMessage( String message ) {
		this.showMessage( message, FacesMessage.SEVERITY_WARN );
		logger.warn( message );
	}
}