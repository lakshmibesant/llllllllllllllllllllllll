package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Lakshmi Raj
 *
 */

public class FileUtility {
	/**
	 * this method is used to read data from commonData.properties file based on key which we pass as an argument
	 * @param key
	 * @return
	 * @throws IOException
	 */
		
		public String readDatafromPropertyfile(String key) throws IOException
		{
			FileInputStream fs=new FileInputStream(IPathConstant.Filepath);
			Properties pLoad=new Properties();
			pLoad.load(fs);
			return pLoad.getProperty(key);
		}


}


