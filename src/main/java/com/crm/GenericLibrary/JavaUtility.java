package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;
/**
 * This class contains all the generic libraries which contains generic methods of specific to java 
 *  * @author Lakshmi Raj
 *
 */

public class JavaUtility{
	

	/**
	  * this method will generate a randam number and return it to the caller
	  * @return
	  */

    public int getRandamNumber()
    {
    
    	Random ran=new Random();
    	int randam = ran.nextInt(1000);
    	return randam;
    	
    }
    /**
     * this method used to get current system date and time 
     * @return
     */
    
    public String getCurrentDate()
    {
    	Date date=new Date();
    	String Currentdate = date.toString();
    	return Currentdate;
    }
    /**
     * this method used to get currrent system date and time in required format yyyy-mm-dd
     * @return
     */
    public String getSystemRequiredFormat()
    {
    	Date date=new Date();
    	String systemdate_time = date.toString();
    	System.out.println(systemdate_time);
    	String[] arr = systemdate_time.split(" ");
    	String DD = arr[2];
    	String YYYY = arr[5];
    	String MM = arr[1];
    	String finaldate = YYYY+"-"+MM+"-"+DD;
    	return finaldate;
    	
    	
    }
   
    	
    	
   
	
	}

