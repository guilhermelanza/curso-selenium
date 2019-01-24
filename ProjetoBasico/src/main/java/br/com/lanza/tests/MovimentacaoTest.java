package br.com.lanza.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.lanza.core.BaseTest;
import br.com.lanza.pages.MenuPage;
import br.com.lanza.pages.MovimentacaoPage;
import br.com.lanza.utils.DataUtils;

public class MovimentacaoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();

	@Test
	@Ignore
	public void testInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();

		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		movPage.setDescricao("Movimenta��o do Teste");
		movPage.setInteressado("Interessado Teste");
		movPage.setValor("200");
		movPage.setConta("Conta do Teste Alterada");
		movPage.setStatusPago();
		movPage.salvar();

		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemSucesso());
	}

	@Test
	@Ignore
	public void testCamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();

		movPage.salvar();
		List<String> erros = movPage.obterErros();
		// Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0));
		// Assert.assertEquals(erros.contains("Data da Movimenta��o � obrigat�rio"));
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio", "Descri��o � obrigat�rio", "Interessado � obrigat�rio",
				"Valor � obrigat�rio", "Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());
	}

	@Test
	@Ignore
	public void testInserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		String dataFutura = DataUtils.obterDataFutura(3);
		
		movPage.setDataMovimentacao(dataFutura);
		movPage.setDataPagamento(dataFutura);
		movPage.setDescricao("Movimenta��o do Teste");
		movPage.setInteressado("Interessado Teste");
		movPage.setValor("200");
		movPage.setConta("Conta do Teste Alterada");
		movPage.setStatusPago();
		movPage.salvar();

		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
		Assert.assertEquals(1, erros.size());
	}

}