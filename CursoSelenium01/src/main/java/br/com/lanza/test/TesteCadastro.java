package br.com.lanza.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.lanza.core.BaseTest;
import br.com.lanza.core.DriverFactory;
import br.com.lanza.page.CampoTreinamentoPage;

public class TesteCadastro extends BaseTest {

	private CampoTreinamentoPage page;

	@Before
	public void inicializaTeste() {
		DriverFactory.getDriver().get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}	

	@Test
	public void deveRealizarCadastroComSucesso() {
		page.setNome("Guilherme");
		page.setSobrenome("Lanza");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setEscolaridade("Superior");
		page.setEsporte("Natacao");
		page.botaoCadastrar();

		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Guilherme", page.obterNomeCadastro());
		Assert.assertEquals("Lanza", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Carne", page.obterComidaCadastro());
		Assert.assertEquals("superior", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Natacao", page.obterEsporteCadastro());
	}
}