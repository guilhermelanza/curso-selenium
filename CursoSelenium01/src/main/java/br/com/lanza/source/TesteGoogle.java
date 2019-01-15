package br.com.lanza.source;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
	
	private WebDriver driver;
	
	@Before
	public void inicializaTeste() {
		System.setProperty("webdriver.chrome.driver", "C:/WSCursoWebdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}

	@After
	public void finalizaTeste() {
		driver.quit();
	}

	@Test
	public void teste() {
		driver.get("http://www.google.com.br");		
		Assert.assertEquals("Google", driver.getTitle().toString());
		driver.quit(); //fecha tudo -> close fecha s� a aba
	}

}