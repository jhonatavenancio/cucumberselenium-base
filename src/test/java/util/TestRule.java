package util;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestRule extends TestWatcher {

    private static WebDriver driver;

    public TestRule() {
        super();
    }

    /**
     * Executado antes de cada cenário Cucumber.
     */
    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Iniciando cenário: " + scenario.getName());
    }

    /**
     * Executado após cada cenário Cucumber.
     * Encerra o navegador se estiver em execução.
     */
    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("Finalizando cenário: " + scenario.getName());
        closeDriver();
    }

    /**
     * Abre o navegador com a URL especificada.
     */
    public static void abrirNavegador(String url) {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");

            Utils.setDriverByOS();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        driver.get(url);
    }

    /**
     * Fecha e finaliza o WebDriver com segurança.
     */
    private static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                System.out.println("Driver finalizado com sucesso.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao finalizar o driver: " + e.getMessage());
        } finally {
            driver = null;
        }
    }

    /**
     * Retorna o driver atual.
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Método JUnit opcional (caso use também com testes unitários).
     */
    @Override
    protected void finished(Description description) {
        super.finished(description);
        closeDriver();
    }
}
