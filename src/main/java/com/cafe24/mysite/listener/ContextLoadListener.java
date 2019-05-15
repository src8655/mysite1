package com.cafe24.mysite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoadListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	//sce.getServletContext().servlet
    	System.out.println("Container Starts...");
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }
	
}
