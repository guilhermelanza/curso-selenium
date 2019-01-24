package br.com.lanza.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.lanza.core.BaseTest;
import br.com.lanza.pages.MenuPage;
import br.com.lanza.pages.ResumoPage;

public class ResumoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();

	@Test
	public void testExcluirMovimentacao() {
		menuPage.acessarTelaResumoMensal();
		resumoPage.excluirMovimentacao();

		Assert.assertEquals("Movimenta��o removida com sucesso!", resumoPage.obterMensagemSucesso());
	}

}