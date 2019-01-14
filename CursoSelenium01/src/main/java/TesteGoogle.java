import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

	@Test
	public void teste() {
		System.setProperty("webdriver.chrome.driver", "C:/WSCursoWebdriver/chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver",
		// "C:/WSCursoWebdriver/geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().setSize(new Dimension(1200, 765));
		driver.manage().window().maximize();
		driver.get("http://www.google.com.br");		
		Assert.assertEquals("Google", driver.getTitle().toString());
		driver.quit(); //fecha tudo -> close fecha só a aba
	}

}