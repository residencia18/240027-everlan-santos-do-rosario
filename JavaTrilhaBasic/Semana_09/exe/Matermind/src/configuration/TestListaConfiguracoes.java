package configuration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestListaConfiguracoes {

	@Test
	void testNovaConfiguracao() {
		Configuracao c0 = new Configuracao();
		c0.setNome("Conf 0");
		Configuracao c1 = new Configuracao();
		c1.setNome("Conf 1");
		Configuracao c2 = new Configuracao();
		c2.setNome("Conf 2");
		
		ListaConfiguracoes listaConfiguracoes = new ListaConfiguracoes();
		
		//caso geral: acrescentar uma lista perfeitamente válida
		assertEquals(0, listaConfiguracoes.getLista().size());
		
		try {
			listaConfiguracoes.addConfiguracao(c0);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		assertEquals(1, listaConfiguracoes.getLista().size());
		try {
			listaConfiguracoes.addConfiguracao(c1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		try {
			listaConfiguracoes.addConfiguracao(c2);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exceção");
		}
		assertEquals(3, listaConfiguracoes.getLista().size());
		assertEquals("Conf 0", listaConfiguracoes.getLista().get(0).getNome());
		assertEquals("Conf 1", listaConfiguracoes.getLista().get(1).getNome());
		assertEquals("Conf 2", listaConfiguracoes.getLista().get(2).getNome());
		
		listaConfiguracoes = new ListaConfiguracoes();
		assertEquals(0, listaConfiguracoes.getLista().size());
		c0.setNome("Conf 0");
		c0.setAlfabeto("ABCDEFGH");
		c0.setTamanhoSenha(3);
		c0.setMaxTentativas(3);
		c1.setNome("Conf 0");
		
		try {
			listaConfiguracoes.addConfiguracao(c0);
		}catch (Exception e) {
			fail("Não deveria gerar exceção");
		}
		assertEquals(1, listaConfiguracoes.getLista().size());
		try {
			listaConfiguracoes.addConfiguracao(c1);
		}catch (Exception e) {
			assertEquals("Nome de configuração já existe", e.getMessage());
		}
		assertEquals(1, listaConfiguracoes.getLista().size());
	}
}
