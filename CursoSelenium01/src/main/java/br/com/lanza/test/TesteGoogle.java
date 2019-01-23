package br.com.lanza.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.lanza.core.DriverFactory;

public class TesteGoogle {
	
	private WebDriver driver;
	
	@Before
	public void inicializaTeste() {
		DriverFactory.getDriver().get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}

	@After
	public void finalizaTeste() {
		DriverFactory.killDriver();
	}

	@Test
	public void teste() {
		driver.get("http://www.google.com.br");		
		Assert.assertEquals("Google", driver.getTitle().toString());
		driver.quit(); //fecha tudo -> close fecha s� a aba
	}

}