package aula.aesley;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    public static WebDriver getBrowser() {
        // Variaveis necessarias
        WebDriver navegador;
        ChromeOptions options;

        // Webdriver do Chrome
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();

        // Inicio
        options.addArguments("--disable-crash-reporter");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");

        // Configuração de preferências de download chromelocal
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);

        navegador = new ChromeDriver(options);
        navegador.manage().window().maximize();

        return navegador;
    }
}
