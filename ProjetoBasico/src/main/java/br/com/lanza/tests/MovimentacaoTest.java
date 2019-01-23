package br.com.lanza.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.lanza.core.BasePage;
import br.com.lanza.core.BaseTest;
import br.com.lanza.pages.MenuPage;
import br.com.lanza.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();

	@Test
	@Ignore
	public void testInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();

		movPage.setDataMovimentacao("20/01/2019");
		movPage.setDataPagamento("22/01/2019");
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Teste");
		movPage.setValor("200");
		movPage.setConta("Conta do Teste Alterada");
		movPage.setStatusPago();
		movPage.salvar();

		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
	}

	@Test
	public void testCamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();

		movPage.salvar();
		List<String> erros = movPage.obterErros();
		// Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
		// Assert.assertEquals(erros.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}
}