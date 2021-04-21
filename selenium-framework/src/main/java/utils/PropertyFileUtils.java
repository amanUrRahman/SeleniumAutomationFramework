package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import constants.FrameworkConstants;
import enums.ConfigProperties;

public final class PropertyFileUtils {

	private PropertyFileUtils() {

	}

	private static Properties properties;
	private static FileInputStream file;

	static {
		try {
			file = new FileInputStream(FrameworkConstants.getConfigfilepath());
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

	public static String getValue(ConfigProperties key) throws Exception {
		if (Objects.isNull(properties.getProperty(key.name().toUpperCase())) || Objects.isNull(key))
			throw new Exception("The key: " + key + "is not present in the config.properties file");
		return properties.getProperty(key.name().toUpperCase());
	}

	public static Object setValue(ConfigProperties key, String value) throws Exception {
		if (Objects.isNull(key))
			throw new Exception("The key: " + key + "is null");
		return properties.setProperty(key.name().toUpperCase(), value);

	}

}
