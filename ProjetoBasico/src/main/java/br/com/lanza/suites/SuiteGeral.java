package br.com.lanza.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.lanza.tests.ContaTest;
import br.com.lanza.tests.MovimentacaoTest;
import br.com.lanza.tests.RemoverMovimentacaoContaTest;
import br.com.lanza.tests.ResumoTest;
import br.com.lanza.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	
	
	
}