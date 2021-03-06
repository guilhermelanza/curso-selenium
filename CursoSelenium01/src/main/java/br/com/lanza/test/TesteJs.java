package br.com.lanza.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import br.com.lanza.core.DSL;
import br.com.lanza.core.DriverFactory;

public class TesteJs {

	private DSL dsl;

	@Before
	public void inicializaTeste() {
		DriverFactory.getDriver().get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}

	@After
	public void finalizaTeste() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void testJavascript() {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
		//js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		
		WebElement element = DriverFactory.getDriver().findElement(By.id("elementosForm:nome"));
		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}
}
