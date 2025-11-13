package Utilities;

import java.util.Optional;

public class configReader {
	
	public static String getEnv() {
        return Optional.ofNullable(System.getenv("ENV")).orElse("local");
    }

    public static String getGridUrl() {
        return Optional.ofNullable(System.getenv("GRID_URL"))
                .orElse("http://localhost:4444/wd/hub");
    }

    public static String getBrowserStackUrl() {
        String user = System.getenv("BROWSERSTACK_USERNAME");
        String key = System.getenv("BROWSERSTACK_ACCESS_KEY");
        return "https://" + user + ":" + key + "@hub.browserstack.com/wd/hub";
    }

}
