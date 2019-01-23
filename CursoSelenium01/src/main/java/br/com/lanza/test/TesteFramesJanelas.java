package br.com.lanza.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.lanza.core.DSL;
import br.com.lanza.core.DriverFactory;

public class TesteFramesJanelas {

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
	@Ignore
	public void deveInteragirComFrames() {
		dsl.entrarFrame("frame1");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);

		dsl.sairFrame();
		dsl.escrever("elementosForm:nome", msg);
	}

	@Test
	@Ignore
	public void deveInteragirComJanelas() {
		dsl.clicarBotao("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		DriverFactory.getDriver().close();
		dsl.trocarJanela("");
		dsl.escrever(By.tagName("textarea"), "e agora?");
	}

	@Test
	@Ignore
	public void deveInteragirComJanelasSemTitulo() {
		dsl.clicarBotao("buttonPopUpHard");
		System.out.println(DriverFactory.getDriver().getWindowHandle());
		System.out.println(DriverFactory.getDriver().getWindowHandles());
		dsl.trocarJanela((String) DriverFactory.getDriver().getWindowHandles().toArray()[1]);
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		dsl.trocarJanela((String) DriverFactory.getDriver().getWindowHandles().toArray()[0]);
		dsl.escrever(By.tagName("textarea"), "e agora?");
	}
	
	@Test
	public void deveInteragirComFrameEscondido() {
		WebElement frame = DriverFactory.getDriver().findElement(By.id("frame2"));
		dsl.executarJS("window.scrollBy(0, arguments[0])",  frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicarBotao("frameButton");
		String msg = dsl.alertaObterTextoEAceita();
		Assert.assertEquals("Frame OK!", msg);
	}
}
