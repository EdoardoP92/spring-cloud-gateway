package reactive.proxy.properties;

import org.springframework.stereotype.Component;

@Component
public class PropertyGetter {
	
	public static String getProperty(String key) {
		System.out.println("********* "+key);
		return System.getProperty(key) != null ? System.getProperty(key) : System.getenv(key);
	}
}
