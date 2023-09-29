package br.com.sistema304.DAO;

import br.com.sistema304.BEAN.ContatosUsuariosBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.sistema304.DAL.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuariosDAO {

    Connection conexao= null;
    PreparedStatement pstmt = null;
    
    public UsuariosDAO() throws SQLException {
    } 

    public boolean Inclusao(ContatosUsuariosBeans contato1) throws SQLException {
        this.conexao = Conexao.qConexao();
        boolean teste = false;
        String sql = "insert into usuarios (usuario, login, "
                    + "senha, perfil, email) "
                    + "values (?, ?, ?, ?, ?)";
        try {
             pstmt = conexao.prepareStatement(sql);
             pstmt.setString(1, contato1.getUsuario());
             pstmt.setString(2, contato1.getLogin());
             pstmt.setString(3, contato1.getSenha());
             pstmt.setString(4, contato1.getPerfil());
             pstmt.setString(5, contato1.getEmail());
             
             int adicionado = pstmt.executeUpdate();
             
             if (adicionado > 0) {
                 JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
                 teste = true;
             } else {
                 JOptionPane.showMessageDialog(null, "Usuario não cadastrado");
             }
            
        } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, "Deu um erro de "+error);
        }       
        
        return teste;
    } 
    
public boolean Alteracao(ContatosUsuariosBeans contato1) throws SQLException {
        this.conexao = Conexao.qConexao();
        boolean teste = false;
        String sql = "Update usuarios set usuario=?, login=? ,senha=? ,perfil=?, email=?  "
                   + "where idusuarios=?";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, contato1.getUsuario());
            pstmt.setString(2, contato1.getLogin());
            pstmt.setString(3, contato1.getSenha());
            pstmt.setString(4, contato1.getPerfil());
            pstmt.setString(5, contato1.getEmail());
            pstmt.setInt(6, contato1.getIdusuarios());

            int alterado = pstmt.executeUpdate();
            if (alterado > 0) {
               JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso");
               teste = true;
            } else {
               JOptionPane.showMessageDialog(null, "Nada alterado !!!");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro "+erro);
        }
        return teste;
 }
 
public boolean Exclusao(ContatosUsuariosBeans contato1) throws SQLException {
        this.conexao = Conexao.qConexao();
        boolean teste = false;
        String sql = "Delete from usuarios where idusuarios=?";
        try {
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, contato1.getIdusuarios());

            int excluido = pstmt.executeUpdate();
            if (excluido > 0) {
               JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso");
               teste = true;
            } else {
               JOptionPane.showMessageDialog(null, "Nada excluido !!!");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro "+erro);
        }
        return teste;
}
    
 // CRUD (read leia)
    public List<ContatosUsuariosBeans> buscar() throws SQLException {
        this.conexao = Conexao.qConexao();
        String sqL = "select * from usuarios";
        List<ContatosUsuariosBeans> minhaLista2;
        try {
            PreparedStatement pstatmt = this.conexao.prepareStatement(sqL);
            ResultSet rs = pstatmt.executeQuery();
            minhaLista2 = new ArrayList<>();
            ContatosUsuariosBeans contatos1 = null; 
            while (rs.next()) {                
                contatos1 = new ContatosUsuariosBeans();
                contatos1.setIdusuarios(rs.getInt("idUsuarios"));
                contatos1.setUsuario(rs.getString("usuario"));
                contatos1.setLogin(rs.getString("login"));
                contatos1.setSenha(rs.getString("senha"));
                contatos1.setPerfil(rs.getString("perfil"));
                minhaLista2.add(contatos1);
            }
            return minhaLista2;
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Um erro de " + ee.toString());
            return null;
        }
    
    }
     public String ultimoRegUsuario() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ContatosUsuariosBeans contato2 = null;
        String ret = "1";
        int contar = 0;
        try {
            String sql = "SELECT * FROM usuarios Where idUsuarios=(SELEct max(idUsuarios) from usuarios)";
            con = Conexao.qConexao();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                contato2 = new ContatosUsuariosBeans();
                contato2.setIdusuarios(contar);
                contato2.setIdusuarios(rs.getInt("idUsuarios"));
                int xId = rs.getInt("idUsuarios");
                contato2.setIdusuarios(xId);
                contar = contato2.getIdusuarios();
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
