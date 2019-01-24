package br.com.lanza.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.lanza.core.BaseTest;
import br.com.lanza.pages.ContasPage;
import br.com.lanza.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();

		contasPage.clicarExcluirConta("Conta do Teste Alterada");

		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}

}
