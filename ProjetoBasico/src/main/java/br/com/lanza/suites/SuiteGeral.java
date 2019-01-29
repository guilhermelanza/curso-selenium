package br.com.lanza.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.lanza.core.DriverFactory;
import br.com.lanza.pages.LoginPage;
import br.com.lanza.tests.ContaTest;
import br.com.lanza.tests.MovimentacaoTest;
import br.com.lanza.tests.RemoverMovimentacaoContaTest;
import br.com.lanza.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	ContaTest.class, 
	MovimentacaoTest.class, 
	RemoverMovimentacaoContaTest.class, 
	SaldoTest.class/*,
	ResumoTest.class*/
})
public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		
		String email = "lanza@lanza.com";
		String senha = "123456";
		page.acessarTelaInicial();
		page.logar(email, senha);
		
		page.resetar();
		
		DriverFactory.killDriver();
	}
	
}