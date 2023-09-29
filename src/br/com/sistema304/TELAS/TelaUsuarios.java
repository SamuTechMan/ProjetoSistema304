
package br.com.sistema304.TELAS;

import br.com.sistema304.BEAN.ContatosUsuariosBeans;
import br.com.sistema304.DAL.Conexao;
import br.com.sistema304.DAO.UsuariosDAO;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

/**
 *
 * @author professor
 */
public class TelaUsuarios extends javax.swing.JInternalFrame {

   Connection conexao = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    UsuariosDAO pdao = null;
    ContatosUsuariosBeans contato2 = null;
    public String sql = null;
    public String nomeTabela = "Usuários";
   
    public TelaUsuarios() throws SQLException {
    	setClosable(true);
        initComponents();
        pdao = new UsuariosDAO();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	setPreferredSize(new Dimension(800, 600));
		pack();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
        txtUSUARIO = new javax.swing.JTextField();
        txtUSUARIO.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
        txtLOGIN = new javax.swing.JTextField();
        txtLOGIN.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
        txtSENHA = new javax.swing.JTextField();
        txtSENHA.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
        cbxPERFIL = new javax.swing.JComboBox();
        cbxPERFIL.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
        txtEMAIL = new javax.swing.JTextField();
        txtEMAIL.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
        txtIDUSUARIO = new javax.swing.JTextField();
        txtIDUSUARIO.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
        jPanel2 = new javax.swing.JPanel();
        btnGRAVAR = new javax.swing.JButton();
        btnALTERAR = new javax.swing.JButton();
        btnEXCLUIR = new javax.swing.JButton();
        btnFECHAR = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados dos usuários", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setText("Nome do usuário");

        jLabel2.setText("Login do usuário");

        jLabel3.setText("Senha do usuário");

        jLabel4.setText("Perfil do usuário");

        jLabel5.setText("Email do usuáro");

        cbxPERFIL.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Usuario" }));

        jLabel6.setText("ID usuário");

        txtIDUSUARIO.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDUSUARIOFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jLabel4)
        						.addComponent(jLabel3)
        						.addComponent(jLabel5))
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(cbxPERFIL, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtSENHA, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        						.addComponent(txtEMAIL)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jLabel6)
        						.addComponent(jLabel2)
        						.addComponent(jLabel1))
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(txtIDUSUARIO, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtUSUARIO, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        						.addComponent(txtLOGIN, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))))
        			.addGap(17))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(15)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtIDUSUARIO, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6))
        			.addGap(20)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(txtUSUARIO, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(txtLOGIN, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(txtSENHA, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel4)
        				.addComponent(cbxPERFIL, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(txtEMAIL, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(249, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        btnGRAVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__EXPORT.png"))); // NOI18N
        btnGRAVAR.setText("Gravar");
        btnGRAVAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGRAVARActionPerformed(evt);
            }
        });

        btnALTERAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__Alteracao.png"))); // NOI18N
        btnALTERAR.setText("Alterar");
        btnALTERAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALTERARActionPerformed(evt);
            }
        });

        btnEXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__Nomaior.png"))); // NOI18N
        btnEXCLUIR.setText("Excluir");
        btnEXCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXCLUIRActionPerformed(evt);
            }
        });

        btnFECHAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__Sair.png"))); // NOI18N
        btnFECHAR.setText("Fechar");
        btnFECHAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFECHARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnFECHAR, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        				.addComponent(btnEXCLUIR, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        				.addComponent(btnALTERAR, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        				.addComponent(btnGRAVAR, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(28)
        			.addComponent(btnGRAVAR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(35)
        			.addComponent(btnALTERAR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(35)
        			.addComponent(btnEXCLUIR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
        			.addComponent(btnFECHAR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(35))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 644, Short.MAX_VALUE)
        			.addGap(1)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
        			.addGap(2))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFECHARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFECHARActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnFECHARActionPerformed

    private void btnGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVARActionPerformed
       try {
            String usuario, login, senha, perfil, email;
            int gravar;
            boolean teste;
            ContatosUsuariosBeans contato1 = new ContatosUsuariosBeans(); 
            //Connection conexao = Conexao.qConexao();
            UsuariosDAO udao = new UsuariosDAO();
            usuario = txtUSUARIO.getText();
            login   = txtLOGIN.getText();
            senha   = txtSENHA.getText();
            perfil  = cbxPERFIL.getSelectedItem().toString()+"";
            email   = txtEMAIL.getText();
            
            gravar = JOptionPane.showConfirmDialog(null, 
                     "Está correto para gravar?",
                     "Atenção!!!",
                     JOptionPane.YES_NO_OPTION);
            if (gravar == JOptionPane.YES_OPTION) {
                contato1.setUsuario(usuario);
                contato1.setLogin(login);
                contato1.setSenha(senha);
                contato1.setPerfil(perfil);
                contato1.setEmail(email);
               
                teste = udao.Inclusao(contato1) ;
                if (teste) {
                    JOptionPane.showMessageDialog(null, "OK, salvou");
                    txtUSUARIO.setText(null);
                    txtLOGIN.setText(null);
                    txtSENHA.setText(null);
                    cbxPERFIL.setSelectedIndex(0);
                    txtEMAIL.setText(null);
                    String proximo = String.valueOf(udao.ultimoRegUsuario());
                    txtIDUSUARIO.setText(proximo);
                    txtIDUSUARIO.requestFocus();
                } else JOptionPane.showMessageDialog(null, "Não salvou nada!");
              }
            } catch(SQLException error) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro de: "+error);
            }
    }//GEN-LAST:event_btnGRAVARActionPerformed

    private void txtIDUSUARIOFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDUSUARIOFocusLost
       String id = txtIDUSUARIO.getText();
       //boolean achou = false;
       Connection conexao = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
       String sql = "Select * from Usuarios where idusuarios=?";
       try {
          conexao = Conexao.qConexao();
          pst = conexao.prepareStatement(sql);
          pst.setString(1, id);
          rs = pst.executeQuery();
          if (rs.next()) {
             txtUSUARIO.setText(rs.getString(2));
                txtLOGIN.setText(rs.getString(3));
                txtSENHA.setText(rs.getString(4));
                cbxPERFIL.setSelectedItem(rs.getString(5));
                 txtEMAIL.setText(rs.getString(6));
              btnGRAVAR.setEnabled(false);
              btnALTERAR.setEnabled(true);
              btnEXCLUIR.setEnabled(true);
          } else {
              btnGRAVAR.setEnabled(true);
              btnALTERAR.setEnabled(false);
              btnEXCLUIR.setEnabled(false);
              txtUSUARIO.setText(null);
              txtLOGIN.setText(null);
              txtSENHA.setText(null);
              cbxPERFIL.setSelectedItem(null);
               txtEMAIL.setText(null);
         }
         txtUSUARIO.requestFocus();
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro de "+ex);
       }

    }//GEN-LAST:event_txtIDUSUARIOFocusLost

    private void btnALTERARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERARActionPerformed
       try {
            String usuario, login, senha, perfil, email;
            int alterar, idusuarios;
            boolean teste;
            ContatosUsuariosBeans contato1 = new ContatosUsuariosBeans(); 
            //Connection conexao = Conexao.qConexao();
            UsuariosDAO udao = new UsuariosDAO();
            idusuarios = Integer.valueOf(txtIDUSUARIO.getText());
            usuario = txtUSUARIO.getText();
            login   = txtLOGIN.getText();
            senha   = txtSENHA.getText();
            perfil  = cbxPERFIL.getSelectedItem().toString()+"";
            email   = txtEMAIL.getText();
            
            alterar = JOptionPane.showConfirmDialog(null, 
                     "Está correto para Alterar ?",
                     "Atenção!!!",
                     JOptionPane.YES_NO_OPTION);
            if (alterar == JOptionPane.YES_OPTION) {
                contato1.setIdusuarios(idusuarios);
                contato1.setUsuario(usuario);
                contato1.setLogin(login);
                contato1.setSenha(senha);
                contato1.setPerfil(perfil);
                contato1.setEmail(email);
               
                teste = udao.Alteracao(contato1) ;
                if (teste) {
                    JOptionPane.showMessageDialog(null, "OK ");
                    txtUSUARIO.setText(null);
                    txtLOGIN.setText(null);
                    txtSENHA.setText(null);
                    cbxPERFIL.setSelectedIndex(0);
                    txtEMAIL.setText(null);
                    String proximo = String.valueOf(udao.ultimoRegUsuario());
                    txtIDUSUARIO.setText(proximo);
                    txtIDUSUARIO.requestFocus();
                } else JOptionPane.showMessageDialog(null, "Não fez nada!");
              }
            } catch(SQLException error) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro de: "+error);
            }
    }//GEN-LAST:event_btnALTERARActionPerformed

    private void btnEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIRActionPerformed
       try {
            String usuario, login, senha, perfil, email;
            int excluir, idusuarios;
            boolean teste=false;
            ContatosUsuariosBeans contato1 = new ContatosUsuariosBeans(); 
            //Connection conexao = Conexao.qConexao();
            UsuariosDAO udao = new UsuariosDAO();
            idusuarios = Integer.valueOf(txtIDUSUARIO.getText());
            usuario = txtUSUARIO.getText();
            login   = txtLOGIN.getText();
            senha   = txtSENHA.getText();
            perfil  = cbxPERFIL.getSelectedItem().toString()+"";
            email   = txtEMAIL.getText();
            
            excluir = JOptionPane.showConfirmDialog(null, 
                     "Está correto para Excluir ?",
                     "Atenção!!!",
                     JOptionPane.YES_NO_OPTION);
            if (excluir == JOptionPane.YES_OPTION) {
                contato1.setIdusuarios(idusuarios);
                contato1.setUsuario(usuario);
                contato1.setLogin(login);
                contato1.setSenha(senha);
                contato1.setPerfil(perfil);
                contato1.setEmail(email);
               
                teste = udao.Exclusao(contato1) ;
                if (teste) {
                    JOptionPane.showMessageDialog(null, "OK ");
                    txtUSUARIO.setText(null);
                    txtLOGIN.setText(null);
                    txtSENHA.setText(null);
                    cbxPERFIL.setSelectedIndex(0);
                    txtEMAIL.setText(null);
                    String proximo = String.valueOf(udao.ultimoRegUsuario());
                    txtIDUSUARIO.setText(proximo);
                    txtIDUSUARIO.requestFocus();
                } else JOptionPane.showMessageDialog(null, "Não fez nada!");
              }
            } catch(SQLException error) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro de: "+error);
            }
    }//GEN-LAST:event_btnEXCLUIRActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnALTERAR;
    private javax.swing.JButton btnEXCLUIR;
    private javax.swing.JButton btnFECHAR;
    private javax.swing.JButton btnGRAVAR;
    private javax.swing.JComboBox cbxPERFIL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtEMAIL;
    private javax.swing.JTextField txtIDUSUARIO;
    private javax.swing.JTextField txtLOGIN;
    private javax.swing.JTextField txtSENHA;
    private javax.swing.JTextField txtUSUARIO;
    // End of variables declaration//GEN-END:variables
}
