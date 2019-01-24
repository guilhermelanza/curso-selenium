package br.com.lanza.core;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	/********* TextField e TextArea ************/

	public void escrever(By by, String texto) {
		DriverFactory.getDriver().findElement(by).clear();
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto) {
		escrever(By.id(id_campo), texto);
	}
	
	public void escreverXpath(String texto) {
		DriverFactory.getDriver().findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div[2]/div/form/div[2]/div/div/input")).sendKeys(texto);		
	}

	public String obterValorSaldo(String xpath) {
		return DriverFactory.getDriver().findElement(By.xpath(xpath)).getText();
	}	
	
	public String obterValorCampo(String id_campo) {
		return DriverFactory.getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}

	/********* Botao ************/

	public void clicarBotao(By by) {
		DriverFactory.getDriver().findElement(by).click();
	}

	public void clicarBotao(String id) {
		clicarBotao(By.id(id));
	}	
	
	public void clicarBotaoXpath(String xpath) {
		clicarBotao(By.xpath(xpath));
	}
	
	public void clicarBotaoEntrar() {
		clicarBotao(By.xpath("/html/body/div[2]/div/div[3]/div/div/div[2]/div/form/div[3]/input"));
	}
	
	public String obterValorCampoXpath(String xpath) {
		return DriverFactory.getDriver().findElement(By.xpath(xpath)).getAttribute("value");
	}
}
