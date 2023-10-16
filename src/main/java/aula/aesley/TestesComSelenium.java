package aula.aesley;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

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
@Test
@DisplayName("Cenario: Download Google Imagens")
public void teste2() throws InterruptedException {
    // Excecucao do Teste

    Thread.sleep(3000);
    // Clique no link google imagens
    By cliqueGoogleImagens = By.cssSelector("#gb > div > div:nth-child(1) > div > div:nth-child(2) > a");
    driver.findElement(cliqueGoogleImagens).click();

    // O usuário vai preencher a pesquisa com o texto: atlantico
    By pathInputPesquisa = By.id("APjFqb");
    Thread.sleep(3000);
    driver.findElement(pathInputPesquisa).sendKeys("atlantico");
    Thread.sleep(3000);

    // O usuário vai clicar no botão pesquisar
    By btnPesquisarGoogleImagens = By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > button > div");
    driver.findElement(btnPesquisarGoogleImagens).click();
    Thread.sleep(3000);

    // O usuário vai clicar na primeira imagem do resultado
    By elementLocator = By.xpath("//*[@id=\"islrg\"]/div[1]/div[1]/a[1]"); // Substitua com o localizador apropriado
    driver.findElement(elementLocator).click();
    Thread.sleep(5000);


    // O usuário vai clicar com o botão direito do mouse para abiri o menu de contexto na primeira imagem do resultado
    WebElement element = driver.findElement(elementLocator);
    Thread.sleep(5000);
    actions.contextClick(element).perform();
    Thread.sleep(5000); // Tempo para o menu de contexto aparecer

    // O usuário vai descer o menu de contexto até a opção guardar imagem como...
        for (int i = 0; i < 8; i++) {
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000); // Pequeno atraso entre as teclas de seta
        }

    // Pressione no menu de contexto tecla "Enter" para "Guardar imagem como..."
    actions.sendKeys(Keys.ENTER).perform();
    Thread.sleep(10000); // Tempo para o menu de contexto aparecer

    // comandos para pressionar teclas Pressione "ctrl" + "s"
    /*actions.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
    Thread.sleep(3000); // Tempo para o menu de contexto aparecer*/


    /*comandos mouse
    //click com o botão esquerdo
    actions.click(element).perform();
    //click com o botão direito
    actions.contextClick(element1).perform();
    //soltar o botão
    actions.release().perform();
    //duplo cliclk
    actions.doubleClick(element).perform();*/

}

}
