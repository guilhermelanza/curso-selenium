package br.com.lanza.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.lanza.core.BaseTest;
import br.com.lanza.pages.HomePage;

public class SaldoTest extends BaseTest {

	HomePage homePage = new HomePage();
	
	@Test
	public void testSandoConta() {
		Assert.assertEquals("123.00", homePage.obterSaldoConta("Conta do Teste Alterada"));
	}
}
