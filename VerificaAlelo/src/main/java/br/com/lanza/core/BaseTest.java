package br.com.lanza.core;

import java.io.IOException;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

public class BaseTest {

	@Rule
	public TestName testName = new TestName();

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