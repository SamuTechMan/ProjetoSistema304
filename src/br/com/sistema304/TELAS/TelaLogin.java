
package br.com.sistema304.TELAS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.sistema304.DAL.Conexao;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaLogin extends javax.swing.JFrame {

	Connection conexao = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public TelaLogin() {
		initComponents();
		try {

			conexao = Conexao.qConexao();

			if (conexao != null) {
				String bancodedados = Conexao.BANCO;

				lblCONEXAO2.setIcon(
						new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/dbok.png")));
				lblCONEXAO2.setText("OK Conectado ao Banco de Dados: " + bancodedados.toUpperCase());
			} else {
				lblCONEXAO2.setIcon(new javax.swing.ImageIcon(
						getClass().getResource("/br/com/sistema304/ICONES/icones/dberror.png")));
				lblCONEXAO2.setText("Não consegui conectar");

			}
		} catch (Exception e) {

		}
	}

	public boolean logar() {

		boolean ret = false;

		String sql = "select * from usuarios where login=? and senha=?";

		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, txtUSUARIO.getText());
			pstm.setString(2, txtSENHA.getText());
			rs = pstm.executeQuery();
			if (rs.next()) {

				String o_titulo, usuario, perfil;
				usuario = rs.getString(2);
				perfil = rs.getString(5).toUpperCase();

				if (usuario.isEmpty()) {
					usuario = "desconhecido";
				}

				if (perfil.isEmpty()) {
					perfil = "em branco";
				}

				if (perfil.equalsIgnoreCase("admin")) {
					perfil = "ADMINISTRADOR DO SISTEMA";
				}

				if (perfil.equalsIgnoreCase("user")) {
					perfil = "USUÁRIO DO SISTEMA";
				}

				ret = true;
			} else {
				JOptionPane.showMessageDialog(null, "O usuário ou a senha são inválidos");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "O erro é : " + e);
		}

		return ret;
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		setPreferredSize(new Dimension(800, 600));
		pack();
		jPanel1 = new javax.swing.JPanel();
		lblLOGIN = new javax.swing.JLabel();
		lblLOGIN.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		lblSENHA = new javax.swing.JLabel();
		lblSENHA.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		lblCONEXAO2 = new javax.swing.JLabel();
		lblCONEXAO2.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		txtUSUARIO = new javax.swing.JTextField();
		txtUSUARIO.setText("admin");
		txtUSUARIO.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		txtSENHA = new javax.swing.JPasswordField();
		txtSENHA.setText("123");
		txtSENHA.setToolTipText("");
		txtSENHA.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		jButton1 = new javax.swing.JButton();
		jButton1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		jButton2 = new javax.swing.JButton();
		jButton2.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Autentificação do SISTEMA 304");
		setAutoRequestFocus(false);
		setResizable(false);

		jPanel1.setBackground(new java.awt.Color(255, 255, 51));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de conexão",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		lblLOGIN.setText("Login");

		lblSENHA.setText("Senha");

		lblCONEXAO2.setText("Conectar");
		txtUSUARIO.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtUSUARIOActionPerformed(evt);
			}
		});
		txtSENHA.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSENHAActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(30)
						.addGroup(jPanel1Layout
								.createParallelGroup(Alignment.TRAILING).addComponent(lblSENHA).addComponent(lblLOGIN))
						.addGap(18)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtUSUARIO, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
								.addComponent(txtSENHA, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
						.addContainerGap())
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(222, Short.MAX_VALUE)
						.addComponent(lblCONEXAO2, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
						.addGap(165)));
		jPanel1Layout
				.setVerticalGroup(
						jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										jPanel1Layout.createSequentialGroup().addGap(65)
												.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(txtUSUARIO, GroupLayout.PREFERRED_SIZE, 32,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblLOGIN))
												.addGap(55)
												.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(txtSENHA, GroupLayout.PREFERRED_SIZE, 32,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblSENHA))
												.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
												.addComponent(lblCONEXAO2).addGap(65)));
		jPanel1.setLayout(jPanel1Layout);

		jButton1.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__CHECK.png"))); // NOI18N
		jButton1.setText("Logar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jButton2.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__Saida.png"))); // NOI18N
		jButton2.setText("Fechar");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGap(15)
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE).addContainerGap())
						.addGroup(layout.createSequentialGroup()
								.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 570, Short.MAX_VALUE)
								.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(25)))));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				layout.createSequentialGroup().addGap(21)
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE).addGap(18)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGap(25)));
		getContentPane().setLayout(layout);

		jPanel1.getAccessibleContext().setAccessibleName("Dados de Conexão");

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		// TODO a your handling code here:
		System.exit(0);
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
		if (logar()) {
			this.dispose();
			TelaMenuPrincipal menuPrincipal = new TelaMenuPrincipal(txtUSUARIO.getText());
			menuPrincipal.setVisible(true);
		}
	}

	private void txtSENHAActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSENHAActionPerformed

	}// GEN-LAST:event_txtSENHAActionPerformed

	private void txtUSUARIOActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtUSUARIOActionPerformed

	}// GEN-LAST:event_txtUSUARIOActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaLogin().setVisible(true);
			}
		});

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lblCONEXAO2;
	private javax.swing.JLabel lblLOGIN;
	private javax.swing.JLabel lblSENHA;
	private javax.swing.JPasswordField txtSENHA;
	private javax.swing.JTextField txtUSUARIO;
	// End of variables declaration//GEN-END:variables
}
