package br.com.lanza.source;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteAjax {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializaTeste() {
		System.setProperty("webdriver.chrome.driver", "C:/WSCursoWebdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL(driver);
	}

	@After
	public void finalizaTeste() {
		// driver.quit();
	}
	
	@Test
	public void testeAjax() {
		dsl.escrever("j_idt694:name", "Teste");
		dsl.clicarBotao("j_idt694:j_idt697");
		WebDriverWait wait = new WebDriverWait(driver, 30);		
		//wait.until(ExpectedConditions.textToBe(By.id("j_idt694:display"), "Teste")); //Aguarda aparecer o campo na tela
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt709_start"))); //Aguarda o spin de carregamento sumir
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt694:display"));
	}

}
