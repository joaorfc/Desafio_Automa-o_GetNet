package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.InicialPage;
import pages.ResultadoBuscaPage;
import utils.DefaultTestConfigs;

public class DesafioAutomacaoTests extends DefaultTestConfigs{
	
	private WebDriver driver;
	private InicialPage inicialPage;
	private ResultadoBuscaPage resultadoBusca;

	@BeforeMethod
    public void setUp() throws Exception {
        this.driver = new ChromeDriver();
        this.inicialPage = new InicialPage(driver);
        this.inicialPage.navega(URLBASE);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception{
        //driver.quit();
    }

    @Test
    public void Desafio1Teste() throws Exception {
        inicialPage.clicaBotaoBuscar().
                    preencheCampoBuscaDesejada().
                    clicaBotaoProcurar().
                    clicaLinkComoPossoAbrirContaSuperGet().
                    verificaMensagemModal();
    }
}
