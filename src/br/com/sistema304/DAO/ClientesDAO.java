package br.com.sistema304.DAO;

import br.com.sistema304.BEAN.ContatosClientesBeans;
import br.com.sistema304.DAL.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ClientesDAO {

	public Connection conexao = null;
	public PreparedStatement pstmt = null;

	public ClientesDAO() throws SQLException {
		conexao = Conexao.qConexao();
	}

	public boolean Inclusao(ContatosClientesBeans contato) throws SQLException {
		boolean teste = false;
		String sql = "insert into clientes (Nome, CPF, Nascimento, Sexo, Celular, Email, DTCadastro, Situacao) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, contato.getNome());
			pstmt.setString(2, contato.getCPF());
			pstmt.setString(3, contato.getDtnascimento());
			pstmt.setString(4, contato.getSexo());
			pstmt.setString(5, contato.getCelular());
			pstmt.setString(6, contato.getEmail());
			pstmt.setString(7, contato.getDTCadastro());
			pstmt.setString(8, contato.getSituacao());

			int adicionado = pstmt.executeUpdate();

			if (adicionado > 0) {
				JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
				teste = true;
			} else {
				JOptionPane.showMessageDialog(null, "Usuario não cadastrado");
			}

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "Deu um erro de " + error);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return teste;
	}

	public boolean Alteracao(ContatosClientesBeans contato) throws SQLException {
		this.conexao = Conexao.qConexao();
		boolean teste = false;
		String sql = "Update clientes set Nome=?, CPF=? ,Nascimento=? ,Sexo=?, Celular=?, Email=?, DTCadastro=?, Situacao=? where idclientes=?";
		try {
			pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, contato.getNome());
			pstmt.setString(2, contato.getCPF());
			pstmt.setString(3, contato.getDtnascimento());
			pstmt.setString(4, contato.getSexo());
			pstmt.setString(5, contato.getCelular());
			pstmt.setString(6, contato.getEmail());
			pstmt.setString(7, contato.getDTCadastro());
			pstmt.setString(8, contato.getSituacao());
			pstmt.setInt(9, contato.getIdclientes());

			int alterado = pstmt.executeUpdate();
			if (alterado > 0) {
				JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso");
				teste = true;
			} else {
				JOptionPane.showMessageDialog(null, "Nada alterado !!!");
			}
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro " + error);
		}
		return teste;
	}

	public boolean Exclusao(ContatosClientesBeans contato) throws SQLException {
		this.conexao = Conexao.qConexao();
		boolean teste = false;
		String sql = "Delete from clientes where idclientes=?";
		try {
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, contato.getIdclientes());

			int excluido = pstmt.executeUpdate();
			if (excluido > 0) {
				JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso");
				teste = true;
			} else {
				JOptionPane.showMessageDialog(null, "Nada excluido !!!");
			}
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro " + error);
		}
		return teste;
	}

	// CRUD (read leia)
	public List<ContatosClientesBeans> buscar() throws SQLException {
		this.conexao = Conexao.qConexao();
		String sqL = "select * from clientes";
		List<ContatosClientesBeans> minhaLista2;
		try {
			PreparedStatement pstatmt = this.conexao.prepareStatement(sqL);
			ResultSet rs = pstatmt.executeQuery();
			minhaLista2 = new ArrayList<>();
			ContatosClientesBeans contatos1 = null;
			while (rs.next()) {
				contatos1 = new ContatosClientesBeans();
				contatos1.setIdclientes(rs.getInt("idclientes"));
				contatos1.setNome(rs.getString("Nome"));
				contatos1.setCPF(rs.getString("CPF"));
				contatos1.setDtnascimento(rs.getString("Nascimento"));
				contatos1.setSexo(rs.getString("Sexo"));
				contatos1.setCelular(rs.getString("Celular"));
				contatos1.setEmail(rs.getString("Email"));
				contatos1.setDTCadastro(rs.getString("DTCadastro"));
				contatos1.setSituacao(rs.getString("Situacao"));
				minhaLista2.add(contatos1);
			}
			return minhaLista2;
		} catch (Exception ee) {
			JOptionPane.showMessageDialog(null, "Um erro de " + ee.toString());
			return null;
		}
	}

	public String ultimoRegClientes() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ContatosClientesBeans contato2 = null;
		String ret = "1";
		int contar = 0;
		try {
			String sql = "SELECT * FROM clientes Where idclientes=(SELEct max(idclientes) from clientes)";
			con = Conexao.qConexao();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				contato2 = new ContatosClientesBeans();
				contato2.setIdclientes(contar);
				contato2.setIdclientes(rs.getInt("idclientes"));
				int xId = rs.getInt("idclientes");
				contato2.setIdclientes(xId);
				contar = contato2.getIdclientes();
				contar++;
				ret = String.valueOf(contar);
			}
			Conexao.closeConexao(con, stmt, rs);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex, "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return ret;
	}
}