import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

	@Test
	@Ignore
	public void deveInteragirComAlertSimples() {
		System.setProperty("webdriver.chrome.driver", "C:/WSCursoWebdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("alert")).click();
		Alert alerta = driver.switchTo().alert();
		String textoAlerta = alerta.getText();
		Assert.assertEquals("Alert Simples", textoAlerta);
		alerta.accept();

		driver.findElement(By.id("elementosForm:nome")).sendKeys(textoAlerta);

		driver.quit();
	}

	@Test
	@Ignore
	public void deveInteragirComAlertConfirm() {
		System.setProperty("webdriver.chrome.driver", "C:/WSCursoWebdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		Alert alert2 = driver.switchTo().alert();
		String texto2 = alert.getText();
		Assert.assertEquals("Confirmado", texto2);
		alert2.accept();

		driver.findElement(By.id("confirm")).click();
		alert = driver.switchTo().alert();
		texto = alert.getText();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		driver.quit();
	}

	@Test
	@Ignore
	public void deveInteragirComAlertPrompt() {
		System.setProperty("webdriver.chrome.driver", "C:/WSCursoWebdriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("17");
		alerta.accept();
		Assert.assertEquals("Era 17?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
		alerta.accept();
	}

}
