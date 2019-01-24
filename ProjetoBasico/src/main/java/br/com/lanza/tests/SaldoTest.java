package br.com.lanza.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.lanza.core.BaseTest;
import br.com.lanza.core.Propriedades;
import br.com.lanza.pages.HomePage;
import br.com.lanza.pages.MenuPage;

public class SaldoTest extends BaseTest {

	HomePage homePage = new HomePage();
	MenuPage menuPage = new MenuPage();

	@Test
	public void testSaldoConta() {
		menuPage.acessarTelaHome();
		Assert.assertEquals("123.00", homePage.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
	}
}
