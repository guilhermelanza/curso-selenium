package br.com.lanza.source;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFramesJanelas {

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
	@Ignore
	public void deveInteragirComAlertPrompt() {
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String mensagem = alert.getText();
		Assert.assertEquals("Frame OK!", mensagem);
		alert.accept();

		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(mensagem);
	}

	@Test
	@Ignore
	public void deveInteragirComJanelas() {
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("TESTE");
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo!");
	}

	@Test
	@Ignore
	public void deveInteragirComJanelasSemTitulo() {
		// Id da janela inicial/principal
		System.out.println(driver.getWindowHandle());
		// Id de todas as janelas
		System.out.println(driver.getWindowHandles());

		driver.findElement(By.id("buttonPopUpHard")).click();
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Foi");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("Foi?????");
	}
}
