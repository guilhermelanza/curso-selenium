package br.com.lanza.pages;

import br.com.lanza.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaListarConta() {
		clicarLink("Contas");
		clicarLink("Listar");
	}

	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	 
}