package br.com.lanza.pages;

import br.com.lanza.core.BasePage;
import br.com.lanza.core.DriverFactory;

public class LoginPage extends BasePage {

	public void acessarTelaInicialAlelo() {
		DriverFactory.getDriver().get("https://www.meualelo.com.br/");
	}

	public void setCpf(String cpf) {
		escrever("cpf", cpf);
	}

	public void setSenha(String senha) {
		escreverXpath(senha);
	}

	public void entrar() {
		clicarBotaoXpath("/html/body/div[2]/div/div[3]/div/div/div[2]/div/form/div[3]/input");
	}

	public void logar(String email, String senha) {
		setCpf(email);
		setSenha(senha);
		clicarBotaoEntrar();
	}

	public void aguardarCarregamento() throws InterruptedException {
		Thread.sleep(4000);		
	}

}
