package configuration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestConfiguracao {
	@Test
	void testSteAlfabeto() {
		Configuracao configuracao = new Configuracao();

		String senha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		try {
			configuracao.setAlfabeto(senha);
		} catch (IllegalArgumentException e) {
			fail("Gerou uma exceção invalida");
			e.printStackTrace();
		}
		assertEquals(configuracao.getAlfabeto(), senha);

		senha = null;

		try {
			configuracao.setAlfabeto(senha);
		} catch (Exception e) {
			assertEquals("Alfabeto não pode ser nulo", e.getMessage());
		}
		assertFalse(configuracao.getAlfabeto() == null);

		senha = "A";

		try {
			configuracao.setAlfabeto(senha);
		} catch (Exception e) {
			assertEquals("Alfabeto deve ter pelo menos 5 caracteres", e.getMessage());
		}
		assertFalse(configuracao.getAlfabeto().length() < 5);

		senha = "aabddce";

		try {
			configuracao.setAlfabeto(senha);
		} catch (Exception e) {
			assertEquals("Alfabeto não deve conter caracteres repetidos", e.getMessage());
		}
		assertNotEquals(senha, configuracao.getAlfabeto());

		senha = "abc9rde";

		try {
			configuracao.setAlfabeto(senha);
		} catch (Exception e) {
			assertEquals("Alfabeto não deve conter números", e.getMessage());
		}
		assertNotEquals(senha, configuracao.getAlfabeto());
	}

	@Test
	void testSetTamanhoSenha() {
		Configuracao configuracao = new Configuracao();
		configuracao.setAlfabeto("ABCD");
		// Caso geral: um tamanho de senha válido (entre 1 e 4)
		int tam = 2;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			fail("Não deveria gerar exception aqui");
			e1.printStackTrace();
		}
		assertEquals(tam, configuracao.getTamanhoSenha());

		// Caso 1: tentar inserir uma senha de tamanho negativo
		tam = -1;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			assertEquals("Senha deve ter ao menos 1 caracter", e.getMessage());
		}
		// o tamanho da senha não pode ter sido aceito
		assertNotEquals(tam, configuracao.getTamanhoSenha());

		// Caso 1 versão 2: tentar inserir uma senha de tamanho 0
		tam = 0;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			assertEquals("Senha deve ter ao menos 1 caracter", e.getMessage());
		}
		// o tamanho da senha não pode ter sido aceito
		assertNotEquals(tam, configuracao.getTamanhoSenha());

		// Caso 2: tentar inserir senha de tamanho maior que o alfabeto (que tem 4
		// caracteres)
		tam = 5;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			assertEquals("Senha não pode ser maior que o alfabeto", e.getMessage());
		}
		// o tamanho da senha não pode ter sido aceito
		assertNotEquals(tam, configuracao.getTamanhoSenha());

		// Caso 2 versão 2: inserir com sucesso senha de tamanho iguao ao alfabeto (que
		// tem 4 caracteres)
		tam = 4;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			fail("Não era para gerar exception aqui");
		}
		// o tamanho da senha precisa ter sido aceito
		assertEquals(tam, configuracao.getTamanhoSenha());

		// Caso 2 versão 3: tentar inserir senha de tamanho maior que o alfabeto (que
		// agora tem 10 caracteres)
		try {
			configuracao.setAlfabeto("asdfghjkly");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tam = 11;
		try {
			configuracao.setTamanhoSenha(tam);
		} catch (Exception e) {
			assertEquals("Senha não pode ser maior que o alfabeto", e.getMessage());
		}
		// o tamanho da senha não pode ter sido aceito
		assertNotEquals(tam, configuracao.getTamanhoSenha());
	}
	
	@Test
	void testSetMaxTentativas() {
		Configuracao configuracao = new Configuracao();
		// Caso geral: um tamanho de senha valido 
		int maxTentativas = 3;
		try {
			configuracao.setAlfabeto("ABCDEFG");
			configuracao.setTamanhoSenha(4);
			configuracao.setMaxTentativas(maxTentativas);
		}catch(Exception e) {
			fail("Nao devera gerar exception aqui");
		}
		assertEquals(maxTentativas, configuracao.getMaxTentativas());
		
		maxTentativas = -1;
		try {
			configuracao.setMaxTentativas(maxTentativas);
		}catch(Exception e) {
			assertEquals("Número máximo de tentativas deve ser maior que 0", e.getMessage());
		}
		assertNotEquals(maxTentativas, configuracao.getMaxTentativas());
		
		maxTentativas = 8;
		try {
			configuracao.setMaxTentativas(maxTentativas);
		}catch(Exception e) {
			assertEquals("Número máximo de tentativas deve ser menor que o tamanho do alfabeto", e.getMessage());
		}
		assertNotEquals(maxTentativas, configuracao.getMaxTentativas());
	}
	
	@Test
	void testSetNome() {
		Configuracao configuracao = new Configuracao();
		// Caso geral: um Nome valido
		String nome = "Nome";
		try {
			configuracao.setNome(nome);
		}catch(Exception e) {
			fail("Nao devera gerar exception aqui");
		}
		assertEquals(nome, configuracao.getNome());
		
		// Caso geral: um Nome vazio
		nome = "";
		try {
			configuracao.setNome(nome);
		}catch(Exception e) {
			assertEquals("Nome não pode ser nulo ou vazio", e.getMessage());
		}
		assertNotEquals(nome, configuracao.getNome());
	}
}
