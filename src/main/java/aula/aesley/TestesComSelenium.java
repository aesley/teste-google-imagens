package aula.aesley;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestesComSelenium extends Hooks {

    @Test
    @DisplayName("Cenario: Download Google Imagens")
    public void teste1() throws InterruptedException {
        // Google imagens
        By cliqueGoogleImagens = By.cssSelector("#gb > div > div:nth-child(1) > div > div:nth-child(2) > a");
        driver.findElement(cliqueGoogleImagens).click();

        // Pesquisar: atlantico
        By pathInputPesquisa = By.id("APjFqb");
        driver.findElement(pathInputPesquisa).sendKeys("atlantico");

        // clicar no botão pesquisar
        By btnPesquisarGoogleImagens = By.cssSelector("div.A8SBwf > div.RNNXgb > button > div");
        driver.findElement(btnPesquisarGoogleImagens).click();

        // primeira imagem
        Thread.sleep(1000);
        List<WebElement> listaImagens = driver.findElements(By.cssSelector(".isv-r.PNCib.ViTmJb.BUooTd"));
        listaImagens.get(0).click();

        // Get Url Imagem
        Thread.sleep(1000);
        WebElement imgElement = driver.findElement(By.cssSelector("a > img.sFlh5c.pT0Scc.iPVvYb"));
        String linkImg = imgElement.getAttribute("src");
        downloadFile(linkImg);
    }

    public void downloadFile(String urlImagem) {
        String data = (new SimpleDateFormat("yyyy-MM-dd_-_HH-mm-ss_-_")).format(new Date());
        String destinationFolder = "target/downloads";
        new File(destinationFolder).mkdirs();
        try {
            URL url = new URL(urlImagem);
            try (InputStream in = url.openStream()) {
                String fileName = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
                fileName = data + fileName;
                Path outputPath = Path.of(destinationFolder, fileName);
                Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.err.println("Error downloading file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        }
    }
}
