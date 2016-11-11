package com.mamba.common;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * environment properties
 */
public final class Environment {
	
	/** FTP属性 KEY */
	public static final String FTP_HOST = "ftp.host";
	public static final String FTP_PORT = "ftp.port";
	public static final String FTP_USERNAME = "ftp.username";
	public static final String FTP_PASSWORD = "ftp.password";
	public static final String FTP_DISPLAYDATA_REMOTEPATH = "ftp.displayData.remotePath";
	public static final String FTP_CLICKDATA_REMOTEPATH = "ftp.clickData.remotePath";


	private static final ResourceBundle propertyResource;
	
	static {
		propertyResource = PropertyResourceBundle.getBundle("environment");
	}

	public static String get(String key) {
		return propertyResource.getString(key);
	}

	public static Integer getInteger(String key) {
		return Integer.valueOf(propertyResource.getString(key));
	}
}
