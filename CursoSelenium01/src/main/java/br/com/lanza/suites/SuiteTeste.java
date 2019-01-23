package br.com.lanza.suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.lanza.core.DriverFactory;
import br.com.lanza.test.TesteCadastro;
import br.com.lanza.test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({ TesteCadastro.class, TesteRegrasCadastro.class })
public class SuiteTeste {

	@AfterClass
	public static void finalizaTestes() {
		DriverFactory.killDriver();
	}

}