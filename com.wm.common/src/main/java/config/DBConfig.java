package config;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wm.common.io.PropertiesExpand;

public class DBConfig {

	private static Logger LOGGER = LogManager.getLogger(DBConfig.class);
	private static PropertiesExpand propertiesExpand = null;
	
	public static String DRIVER = null;
	public static String URL = null;
	public static String USER = null;
	public static String PASSWORD = null;

	public static Integer RECONNECTION_COUNT = null;
	public static Long RECONNECTION_MILLIS = null;

	static {
		propertiesExpand = new PropertiesExpand();
		try {
			String folder = DBConfig.class.getCanonicalName().replaceAll("\\.", "//");
			propertiesExpand.loadByRelativePath(folder+".properties");
			reloaData();
		} catch (IOException e) {
		}
	}

	public static void reloaData() {
		DRIVER = propertiesExpand.getProperty("DRIVER");
		URL = propertiesExpand.getProperty("URL");
		USER = propertiesExpand.getProperty("USER");
		PASSWORD = propertiesExpand.getProperty("PASSWORD");
		LOGGER.debug("DRIVER : " + DRIVER);
		LOGGER.debug("URL : " + URL);
		LOGGER.debug("USER : " + USER);
		LOGGER.debug("PASSWORD : " + PASSWORD);
		RECONNECTION_COUNT = Integer.parseInt(propertiesExpand
				.getProperty("RECONNECTION_COUNT"));
		RECONNECTION_MILLIS = Long.parseLong(propertiesExpand
				.getProperty("RECONNECTION_MILLIS"));
		LOGGER.debug("RECONNECTION_COUNT : " + RECONNECTION_COUNT);
		LOGGER.debug("nRECONNECTION_MILLIS : " + RECONNECTION_MILLIS);
	}

	public static void main(String[] args) {
		
	}
}
