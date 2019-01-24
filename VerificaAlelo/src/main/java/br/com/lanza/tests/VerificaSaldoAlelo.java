package br.com.lanza.tests;

import java.util.Date;

import org.junit.Test;

import br.com.lanza.core.BaseTest;
import br.com.lanza.pages.LoginPage;
import br.com.lanza.utils.DataUtils;

public class VerificaSaldoAlelo extends BaseTest {

	LoginPage loginPage = new LoginPage();

	@Test
	public void verificaSaldo() throws InterruptedException {
		loginPage.acessarTelaInicialAlelo();
		loginPage.aguardarCarregamento();
		loginPage.setCpf(""); //Preencher
		loginPage.setSenha(""); //Preencher
		loginPage.entrar();
		loginPage.aguardarCarregamento();
		loginPage.clicarBotaoXpath("/html/body/div[2]/div/div[3]/div/div[1]/div[2]/div/div/div[1]/div/div/button[1]");
		loginPage.aguardarCarregamento();
		String saldo = loginPage
				.obterValorSaldo("/html/body/div[2]/div/div[3]/div/div[1]/div[2]/div/div/div[1]/div/div/div/span[2]/b");

		System.out.println("Saldo em " + DataUtils.obterDataFormatada(new Date()) + " " + saldo);
	}

}
