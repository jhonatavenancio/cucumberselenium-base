package util;

import java.nio.file.Paths;

public class Utils {

    /**
     * Define o caminho do driver do Chrome com base no sistema operacional.
     */
    public static void setDriverByOS() {
        String os = System.getProperty("os.name").toLowerCase();
        String driverName = os.contains("windows") ? "chromedriver.exe" : "chromedriver";

        // Usa Paths para melhor portabilidade entre sistemas
        String driverPath = Paths.get("src", "test", "resources", "drivers", driverName).toString();

        System.setProperty("webdriver.chrome.driver", driverPath);
    }
}
