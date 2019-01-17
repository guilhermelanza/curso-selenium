package br.com.lanza.source;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrime {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializaTeste() {
		System.setProperty("webdriver.chrome.driver", "C:/WSCursoWebdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		dsl = new DSL(driver);
	}

	@After
	public void finalizaTeste() {
		// driver.quit();
	}

	@Test
	@Ignore
	public void deveInteragirComRadioPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt695:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt695:console:0"));
		
		dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt695:console:1"));
	}
	
	@Test
	public void deveInteragirComSelectPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt695:console", "PS4");
		Assert.assertEquals("PS4", dsl.obterTexto("j_idt695:console"));
	}

}
