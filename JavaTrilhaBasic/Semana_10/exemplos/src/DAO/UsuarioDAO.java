package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Usuario;

public class UsuarioDAO {
	public static void insert(Usuario user) throws SQLException {
		Connection con = DAO.conectar();
		String query = "INSERT INTO Usuario (Login, Senha, Email) VALUES (?, ?, ?)";
		if (user == null) {
			throw new IllegalArgumentException("Usuário não pode ser nulo");
		}
		try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getSenha());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(con);
		}
	}

	public static Usuario select(String user) {
		Connection con = DAO.conectar();
		String query = "SELECT * FROM Usuario WHERE Login = ?";
		Usuario usuario = null;
		try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
			preparedStatement.setString(1, user);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				usuario = new Usuario();
				usuario.setNome(resultSet.getString("Login"));
				usuario.setSenha(resultSet.getString("Senha"));
				usuario.setEmail(resultSet.getString("Email"));
			} else {
				System.out.println("Usuário não encontrado");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(con);
		}
		return usuario;
	}

	public static List<Usuario> selectAll() {
		Connection con = DAO.conectar();
		String query = "SELECT * FROM Usuario";
		List<Usuario> usuarios = new ArrayList<>();
		Usuario usuario = null;
		try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
			preparedStatement.executeQuery();
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				usuario = new Usuario();
				usuario.setNome(resultSet.getString("Login"));
				usuario.setSenha(resultSet.getString("Senha"));
				usuario.setEmail(resultSet.getString("Email"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(con);
		}
		return usuarios;
	}

	public static void update(Usuario user, String nome) {
		Connection con = DAO.conectar();
		String query = "UPDATE Usuario SET Senha = ?, Email = ? WHERE Login = ?";
		try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
			preparedStatement.setString(1, user.getSenha());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, nome);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(con);
		}
	}

	public static void delete(String nome) {
		Connection con = DAO.conectar();
		String query = "DELETE FROM Usuario WHERE Login = ?";
		try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
			preparedStatement.setString(1, nome);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(con);
		}
	}

	public static void main(String[] args) {
		Usuario user = new Usuario("Jubyleu", "321", "Jubileu@tutu.com");

//		try {
//			UsuarioDAO.insert(criarUsuario());
//			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário!");
//		}

		UsuarioDAO.update(user, "Jubyleu");
		// Usuario usuario = UsuarioDAO.select("Sara");
		// System.out.println(usuario.toString());
		// UsuarioDAO.delete("Jubyleu");

//		List<Usuario> usuarios = UsuarioDAO.selectAll();
//		System.out.println("Usuários: \n");
//		for (Usuario usuario : usuarios) {
//			System.out.println(usuario.toString());
//		}
//		
//		JOptionPane.showMessageDialog(null, "Usuários: \n"+usuarios.toString());

//		Usuario usuario = UsuarioDAO.BuscarUsuario();
//		if (usuario != null) {
//			JOptionPane.showMessageDialog(null, "Usuário encontrado: \n"+usuario.toString());
//		}else {
//			JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
//		}
	}

	public static Usuario BuscarUsuario() {
		Usuario usuario = new Usuario();
		String nome = JOptionPane.showInputDialog("Digite o nome do usurário: ");
		usuario = UsuarioDAO.select(nome);
		return usuario;
	}

	public static Usuario criarUsuario() {
		Usuario usuario = new Usuario();

		// Validar o nome
		String nome = JOptionPane.showInputDialog("Digite o nome do usuário: ");
		if (nome.length() < 2) {
			JOptionPane.showMessageDialog(null, "O nome deve ter pelo menos 2 caracteres.");
			throw new IllegalArgumentException("O nome deve ter pelo menos 2 caracteres.");
		}
		usuario.setNome(nome);

		// Validar a senha
		String senha = JOptionPane.showInputDialog("Digite a senha do usuário: ");
		if (senha.length() < 8) {
			JOptionPane.showMessageDialog(null, "A senha deve ter pelo menos 8 caracteres.");
			throw new IllegalArgumentException("A senha deve ter pelo menos 8 caracteres.");
		}
		usuario.setSenha(senha);

		// Validar o email
		String email = JOptionPane.showInputDialog("Digite o email do usuário: ");
		if (!email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
			JOptionPane.showMessageDialog(null, "O email é inválido.");
			throw new IllegalArgumentException("O email é inválido.");
		}
		usuario.setEmail(email);

		return usuario;
	}
}
