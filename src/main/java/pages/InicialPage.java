package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DefaultActions;

public class InicialPage {

    private WebDriver driver;
    private DefaultActions actions;

    By botaoLupa = By.id("search-trigger");
    By campoPreencheDesejoBusca = By.id("global-search-input");
    By botaoProcurar = By.xpath("/html/body/section/div/div/div/form/button");


    public InicialPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new DefaultActions(driver);
    }

    public void navega(String url) {
        this.driver.get(url);
    }

    public InicialPage clicaBotaoBuscar(){
        driver.findElement(botaoLupa).click();
        return new InicialPage(driver);
    }

    public InicialPage preencheCampoBuscaDesejada(){
        actions.waitForElementVisibled(campoPreencheDesejoBusca);
        driver.findElement(campoPreencheDesejoBusca).sendKeys("superget");
        return new InicialPage(driver);
    }

    public ResultadoBuscaPage clicaBotaoProcurar(){
        driver.findElement(botaoProcurar).click();
        return new ResultadoBuscaPage(driver);
    }




}
