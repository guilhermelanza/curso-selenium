package br.com.lanza.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.lanza.core.BaseTest;
import br.com.lanza.pages.ContasPage;
import br.com.lanza.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void test1_InserirConta() {
		menuPage.acessarTelaInserirConta();

		contasPage.setNome("Conta do Teste");
		contasPage.salvar();

		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}

	@Test
	public void test2_AlterarConta() {
		menuPage.acessarTelaListarConta();

		contasPage.clicarAlterarConta("Conta do Teste");

		contasPage.setNome("Conta do Teste alterada");
		contasPage.salvar();

		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}

	@Test
	public void test3_InserirContaMesmoNome() throws InterruptedException {
		menuPage.acessarTelaInserirConta();

		contasPage.setNome("Conta do Teste Alterada");
		contasPage.salvar();
		Thread.sleep(3000);
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}

}
