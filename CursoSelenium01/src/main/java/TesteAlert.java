import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {	

	@Test
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
		
		//driver.quit();
	}
}
