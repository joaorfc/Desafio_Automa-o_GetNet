package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utils.DefaultActions;

public class ResultadoBuscaPage{

    private WebDriver driver;
    private DefaultActions actions;

    //Como o elemento é um link href a forma que consegui capturar o elemento foi percorrendo os nós até encontrar uma string que possuia o link que estaja desejando.
    By linkDesejado = By.xpath("//a[contains(., 'Como posso abrir uma conta SuperGet?')]");
    By mensagemModal = By.xpath("/html/body/div[20]/div/div[2]");

    public ResultadoBuscaPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new DefaultActions(driver);
    }

    public ResultadoBuscaPage clicaLinkComoPossoAbrirContaSuperGet() throws InterruptedException {
        actions.waitForElementVisibled(linkDesejado);
        driver.findElement(linkDesejado).click();
        return new ResultadoBuscaPage(driver);
    }

    public void verificaMensagemModal(){
        SoftAssert softAssert = new SoftAssert();
        actions.waitForElementVisibled(mensagemModal);
        String mensagem = driver.findElement(mensagemModal).getText();
        softAssert.assertEquals(mensagem, "Como posso abrir uma conta SuperGet?");
    }

}
