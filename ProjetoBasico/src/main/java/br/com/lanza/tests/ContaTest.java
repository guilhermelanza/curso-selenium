package br.com.lanza.tests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.lanza.core.BaseTest;
import br.com.lanza.pages.ContasPage;
import br.com.lanza.pages.MenuPage;

public class ContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	@Ignore
	public void testInserirConta() {
		menuPage.acessarTelaInserirConta();

		contasPage.setNome("Conta do Teste");
		contasPage.salvar();

		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	@Ignore
	public void testAlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do Teste");
		contasPage.setNome("Conta do Teste Alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void testInserirContaMesmoNome() throws InterruptedException {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta do Teste Alterada");
		contasPage.salvar();
		//Thread.sleep(5000);
		
		Assert.assertEquals("J� existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}

}