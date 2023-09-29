package br.com.sistema304.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String BANCO = "empresa304db";
    private static final String USUARIO = "root";    
    private static final String SENHA = "";            
    
    public static Connection qConexao() throws SQLException {
        try {
            Class.forName(DRIVER);
//            System.out.println("Conectando ao banco de dados");
            return DriverManager.getConnection(URL+BANCO,USUARIO,SENHA);

        } catch (ClassNotFoundException e1) {
            throw new SQLException(e1.getMessage());
        }
    }
    
    public static void closeConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
            } catch (SQLException ex) {
              Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public static void closeConexao(Connection con, PreparedStatement stmt) {
        
        closeConexao(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
            } catch (SQLException ex) {
              Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public static void closeConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
        
        closeConexao(con,stmt);
        
        try {
            if (rs != null) {
                rs.close();
            }
            } catch (SQLException ex) {
              Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
}
