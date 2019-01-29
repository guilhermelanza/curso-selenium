package br.com.lanza.core;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import br.com.lanza.pages.LoginPage;

public class BaseTest {

	@Rule
	public TestName testName = new TestName();

	private static LoginPage page = new LoginPage();

	@Before
	public void inicializa() {
		String email = "lanza@lanza.com";
		String senha = "123456";
		page.acessarTelaInicial();
		page.logar(email, senha);
	}

	@After
	public void finaliza() throws IOException {
		/*
		 * TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver(); File
		 * arquivo = ss.getScreenshotAs(OutputType.FILE); FileUtils.copyFile(arquivo,
		 * new File("target" + File.separator + "screenshot" + File.separator +
		 * testName.getMethodName() + ".jpg"));
		 */
		if (Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}
	}

}