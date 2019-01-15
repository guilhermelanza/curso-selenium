package br.com.lanza.source;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

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
	public void testeTextField() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}

	@Test
	@Ignore
	public void deveInteragirComTextArea() {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Testes");
		Assert.assertEquals("Testes", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}

	@Test
	@Ignore
	public void deveInteragirComRadioButton() {
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
	}

	@Test
	@Ignore
	public void deveInteragirComCheckBox() {
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	}

	@Test
	@Ignore
	public void deveInteragirComComboBox() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		// combo.selectByIndex(4);
		// combo.selectByValue("superior");
		combo.selectByVisibleText("Mestrado"); // melhor utilização

		Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
	}

	@Test
	@Ignore
	public void deveVerificarValoresCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());

		boolean encontrou = false;
		for (WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}

		Assert.assertTrue(encontrou);
	}

	@Test
	@Ignore
	public void deveVerificarValoresComboMultiplo() {
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");

		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());

		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
	}

	@Test
	@Ignore
	public void deveInteragirComBotoes() {
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();

		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}

	@Test
	@Ignore
	public void deveInteragirComLinks() {
		driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}

	@Test
	@Ignore
	public void deveBuscarTextosNaPagina() {
		// Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo
		// de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				driver.findElement(By.className("facilAchar")).getText());
	}

}