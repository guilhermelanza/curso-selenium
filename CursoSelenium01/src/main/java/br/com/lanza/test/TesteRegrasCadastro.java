package br.com.lanza.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.com.lanza.core.BaseTest;
import br.com.lanza.core.DSL;
import br.com.lanza.core.DriverFactory;
import br.com.lanza.page.CampoTreinamentoPage;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro extends BaseTest {

	private DSL dsl;
	private CampoTreinamentoPage page;

	// Variáveis Parametrizadas
	@Parameter
	public String nome;
	@Parameter(value = 1)
	public String sobrenome;
	@Parameter(value = 2)
	public String sexo;
	@Parameter(value = 3)
	public List<String> comidas;
	@Parameter(value = 4)
	public String[] esportes;
	@Parameter(value = 5)
	public String mensagem;

	@Before
	public void inicializaTeste() {
		DriverFactory.getDriver().get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new CampoTreinamentoPage();
	}

	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] { { "", "", "", Arrays.asList(), new String[] {}, "Nome eh obrigatorio" },
				{ "Guilherme", "", "", Arrays.asList(), new String[] {}, "Sobrenome eh obrigatorio" },
				{ "Guilherme", "Lanza", "", Arrays.asList(), new String[] {}, "Sexo eh obrigatorio" },
				{ "Guilherme", "Lanza", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[] {},"Tem certeza que voce eh vegetariano?" },
				{ "Guilherme", "Lanza", "Masculino", Arrays.asList("Carne"), new String[] { "Corrida", "O que eh esporte?" }, "Voce faz esporte ou nao?" } });
	}

	@Test
	public void deveValidarRegras() {
		page.setNome(nome);
		page.setSobrenome(sobrenome);

		if (sexo.equals("Masculino")) {
			page.setSexoMasculino();
		}
		if (sexo.equals("Feminino")) {
			page.setSexoFeminino();
		}

		if (comidas.contains("Carne"))
			page.setComidaCarne();
		if (comidas.contains("Pizza"))
			page.setComidaPizza();
		if (comidas.contains("Vegetariano"))
			page.setComidaVegetariano();

		page.setEsporte(esportes);
		page.botaoCadastrar();
		Assert.assertEquals(mensagem, dsl.alertaObterTextoEAceita());
	}
}
