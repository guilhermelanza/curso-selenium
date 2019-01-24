package br.com.lanza.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import br.com.lanza.core.BaseTest;
import br.com.lanza.core.DriverFactory;
import br.com.lanza.pages.MenuPage;
import br.com.lanza.pages.ResumoPage;

public class ResumoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();

	// @Test
	public void test1_ExcluirMovimentacao() {
		menuPage.acessarTelaResumoMensal();
		resumoPage.excluirMovimentacao();

		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
	}

	@Test // (expected=org.openqa.selenium.NoSuchElementException.class) //pode ser feito
			// assim - não recomendado
	public void test2_ResumoMensal() {
		menuPage.acessarTelaResumoMensal();

		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());

		/*
		 * try { // pode fazer assim DriverFactory.getDriver().findElement(By.xpath(
		 * "//*[@id='tabelaExtrato']/tbody/tr")); Assert.fail(); } catch
		 * (NoSuchElementException e) {
		 * 
		 * }
		 */

		// ou pode fazer assim
		List<WebElement> elementosEncontrados = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
	}

}