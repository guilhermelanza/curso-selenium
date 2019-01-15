package br.com.lanza.source;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {

	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializaTeste() {
		System.setProperty("webdriver.chrome.driver", "C:/WSCursoWebdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finalizaTeste() {
		driver.quit();
	}

	@Test
	@Ignore
	public void verificaNomeObrigatorio() {
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		String textoAlerta = alerta.getText();
		Assert.assertEquals("Nome eh obrigatorio", textoAlerta);
		alerta.accept();
	}

	@Test
	public void verificaSobrenomeObrigatorio() {
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Guilherme");
		dsl.preencherCampo("elementosForm:nome", "Guilherme");

		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		String textoAlerta = alerta.getText();
		Assert.assertEquals("Sobrenome eh obrigatorio", textoAlerta);
		alerta.accept();
	}

	@Test
	@Ignore
	public void verificaSexoObrigatorio() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Guilherme");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Lanza");

		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		String textoAlerta = alerta.getText();
		Assert.assertEquals("Sexo eh obrigatorio", textoAlerta);
		alerta.accept();
	}

	@Test
	@Ignore
	public void verificaComidaFavorita() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Guilherme");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Lanza");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();

		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		String textoAlerta = alerta.getText();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", textoAlerta);
		alerta.accept();
	}

	@Test
	@Ignore
	public void verificaPraticaEsportes() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Guilherme");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Lanza");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");

		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		String textoAlerta = alerta.getText();
		Assert.assertEquals("Voce faz esporte ou nao?", textoAlerta);
		alerta.accept();
	}

	@Test
	@Ignore
	public void cadastroComSucesso() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Guilherme");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Lanza");
		driver.findElement(By.id("elementosForm:sexo")).click();

		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

		WebElement escolaridades = driver.findElement(By.id("elementosForm:escolaridade"));
		Select comboEscolaridade = new Select(escolaridades);
		comboEscolaridade.selectByVisibleText("Superior");

		WebElement esportes = driver.findElement(By.id("elementosForm:esportes"));
		Select comboEsportes = new Select(esportes);
		comboEsportes.selectByVisibleText("Natacao");
		comboEsportes.selectByVisibleText("Corrida");

		driver.findElement(By.id("elementosForm:cadastrar")).click();

		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Guilherme"));
		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Lanza"));
		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
		Assert.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Carne Frango Pizza"));
		Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("superior"));
		Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Natacao Corrida"));
	}

}