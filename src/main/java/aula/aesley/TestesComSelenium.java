package aula.aesley;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestesComSelenium extends Hooks
{
//    @Test
//    @DisplayName("Cenario: Pesquisa Google")
//    public void teste1() throws InterruptedException
//    {
//        By pathInputPesquisa = By.id("APjFqb");
//        By pathBtnPesquisar = By.xpath("(//input[@name='btnK'])[2]");
//        By pathTxtResultadosPesquisa = By.id("result-stats");
//
//        // Excecucao do Teste
//        Thread.sleep(1000);
//        driver.findElement(pathInputPesquisa).sendKeys("Aula do Tio Aesley!");
//
//        Thread.sleep(1000);
//        actions.sendKeys(Keys.ESCAPE).perform();
//        driver.findElement(pathBtnPesquisar).click();
//
//        Thread.sleep(4000);
//        String texto = driver.findElement(pathTxtResultadosPesquisa).getText();
//        Assertions.assertTrue(texto.contains("Aproximadamente"));
//    }
    @Test //script que abre no google
    @DisplayName("Cenario: Download Google Imagens")
    public void teste2() throws InterruptedException
    {
        // Excecucao do Teste

        Thread.sleep(3000);
        //clica no link google imagens
        By cliqueGoogleImagens = By.cssSelector("#gb > div > div:nth-child(1) > div > div:nth-child(2) > a");
        driver.findElement(cliqueGoogleImagens).click();

        //o usuario vai preencher a pesquisa com o texto: atlantico
        By pathInputPesquisa = By.id("APjFqb");
        Thread.sleep(3000);
        driver.findElement(pathInputPesquisa).sendKeys("atlantico");
        Thread.sleep(3000);

        //o usuario vai clicar no botão pesquisar
        By btnPesquisarGoogleImagens = By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > button > div");
        driver.findElement(btnPesquisarGoogleImagens).click();
        Thread.sleep(3000);

        // o usuario vai clicar salvar a primeira imagem do resultado
        By elementLocator = By.xpath("/html/body/div[2]/c-wiz/div[3]/div[1]/div/div/div/div/div[1]/div[1]/span/div[1]/div[1]/div[1]/a[1]"); // Substitua com o localizador apropriado
        WebElement element = driver.findElement(elementLocator);

        Thread.sleep(3000); // Tempo adicional para garantir que o menu esteja totalmente aberto
        actions.sendKeys(Keys.chord(Keys.CONTROL, "s")).build().perform(); // Seleciona a opção "Guardar imagem como"

        Thread.sleep(3000); // Tempo adicional para garantir que o menu esteja totalmente aberto
        actions.sendKeys("C:\\Users\\aesle\\Code\\teste-google-imagens\\src\\main\\java\\aula\\aesley").sendKeys(Keys.RETURN).build().perform();
    }
}
