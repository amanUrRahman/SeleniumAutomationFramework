package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	private static Properties properties;
	private static FileInputStream file;

	static {
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
			properties = new Properties();
			properties.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getValue(String key) throws Exception {
		if (Objects.isNull(properties.getProperty(key)) || Objects.isNull(key))
			throw new Exception("The key: " + key + "is not present in the config.properties file");
		return properties.getProperty(key);
	}
	
	public static Object setValue(String key, String value) throws Exception {
		if (Objects.isNull(key))
			throw new Exception("The key: " + key + "is null");
		return properties.setProperty(key, value);
	}

}
