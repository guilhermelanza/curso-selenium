package br.com.lanza.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.lanza.core.BaseTest;
import br.com.lanza.core.Propriedades;
import br.com.lanza.pages.MenuPage;
import br.com.lanza.pages.MovimentacaoPage;
import br.com.lanza.utils.DataUtils;

public class MovimentacaoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();

	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();

		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Teste");
		movPage.setValor("123");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();

		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
	}

	@Test
	public void test2_CamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();

		movPage.salvar();
		List<String> erros = movPage.obterErros();
		// Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
		// Assert.assertEquals(erros.contains("Data da Movimentação é obrigatório"));
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório", "Descrição é obrigatório", "Interessado é obrigatório",
				"Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}

	@Test
	public void test3_InserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		String dataFutura = DataUtils.obterDataFutura(3);
		
		movPage.setDataMovimentacao(dataFutura);
		movPage.setDataPagamento(dataFutura);
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Teste");
		movPage.setValor("123");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setStatusPago();
		movPage.salvar();

		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size());
	}

}