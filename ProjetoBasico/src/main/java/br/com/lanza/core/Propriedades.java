package br.com.lanza.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = false;

	public static Browsers BROWSER = Browsers.CHROME;

	// public static String NOME_CONTA_ALTERADA = "Conta Alterada " +
	// System.nanoTime();

	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;

	public enum Browsers {
		CHROME, FIREFOX
	}

	public enum TipoExecucao {
		LOCAL, GRID, NUVEM
	}

}
