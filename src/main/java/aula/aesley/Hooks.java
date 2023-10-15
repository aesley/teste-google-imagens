package aula.aesley;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;

public class Hooks {
    WebDriver driver = BrowserFactory.getBrowser(); // Corrigido o nome do método aqui
    Actions actions = new Actions(driver);

    @BeforeEach
    public void abrirNavegador() {
        driver.get("https://google.com.br");
    }

    @AfterEach
    public void fecharNavegador() {
        driver.quit();
        driver = null;
    }

    public void downloadFile(String fileUrl, String downloadPath) {
        try {
            driver.get(fileUrl);

            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Download")));

            downloadButton.click();

            // Aguardar o download ser concluído
            File downloadedFile = new File(downloadPath);
            while (!downloadedFile.exists()) {
                Thread.sleep(1000);
            }

            // Anexar o arquivo baixado ao cenário (não incluído aqui, pois o cenário não é passado como argumento)
            byte[] fileBytes = Files.readAllBytes(downloadedFile.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
