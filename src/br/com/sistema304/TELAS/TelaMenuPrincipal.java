package br.com.sistema304.TELAS;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.ImageIcon;


public class TelaMenuPrincipal extends javax.swing.JFrame {
	private static String nomeUsuario;
	private Timer popupTimer;

	/**
	 * Creates new form TelaMenuPrincipal
	 * 
	 * @param nomeUsuario O nome do usuário logado
	 * @throws SQLException
	 */
	public TelaMenuPrincipal(String nomeUsuario) {
		initComponents();
		this.nomeUsuario = nomeUsuario;
		this.setExtendedState(MAXIMIZED_BOTH);
		exibirPopupBoasVindas();
	}

	private void exibirPopupBoasVindas() {
		if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
			String mensagem = "Bem-vindo, " + nomeUsuario + "!";
			 final JOptionPane optionPane = new JOptionPane(mensagem, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
			 final JDialog dialog = new JDialog();
		        dialog.setTitle("Boas-Vindas");
		        dialog.setModal(true);
		        dialog.setContentPane(optionPane);
		        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		        dialog.pack();
		        
		        Timer timer = new Timer(1000, new AbstractAction() {
		            public void actionPerformed(ActionEvent ae) {
		                dialog.dispose();
		            }
		        });
		        timer.setRepeats(false);
		        dialog.setLocationRelativeTo(null);
		        timer.start();
		        dialog.setVisible(true);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		Desktop = new javax.swing.JDesktopPane();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem6 = new javax.swing.JMenuItem();
		jMenuItem6.setIcon(new ImageIcon(TelaMenuPrincipal.class.getResource("/br/com/sistema304/ICONES/AnyConv.com__NewDoc.png")));
		jMenuItem7 = new javax.swing.JMenuItem();
		jMenuItem7.setIcon(new ImageIcon(TelaMenuPrincipal.class.getResource("/br/com/sistema304/ICONES/AnyConv.com__TRISIZE.png")));
		jMenuItem8 = new javax.swing.JMenuItem();
		jMenuItem8.setIcon(new ImageIcon(TelaMenuPrincipal.class.getResource("/br/com/sistema304/ICONES/AnyConv.com__Users.png")));
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
		Desktop.setLayout(DesktopLayout);
		DesktopLayout.setHorizontalGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 723, Short.MAX_VALUE));
		DesktopLayout.setVerticalGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 394, Short.MAX_VALUE));

		jMenu1.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__Folder.png"))); // NOI18N
		jMenu1.setText("Cadastros");
		jMenu1.setToolTipText("Clicar aqui para a tela de cadastros");

		jMenuItem3.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__FERMER2.png"))); // NOI18N
		jMenuItem3.setText("Clientes");
		jMenuItem3.setToolTipText("Clicar aqui para a tela dos clientes");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem3);

		jMenuItem4.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__OPENDOC.png"))); // NOI18N
		jMenuItem4.setText("Produtos");
		jMenuItem4.setToolTipText("Clicar aqui para a tela dos produtos");
		jMenu1.add(jMenuItem4);

		jMenuItem5.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__Users.png"))); // NOI18N
		jMenuItem5.setText("Usuários");
		jMenuItem5.setToolTipText("Clicar aqui para a tela dos usuários");
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem5ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem5);

		jMenuBar1.add(jMenu1);

		jMenu2.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__Novajanela.png"))); // NOI18N
		jMenu2.setText("Consultas");
		jMenu2.setToolTipText("Clicar aqui para a tela das consultas");

		jMenuItem6.setText("Clientes");
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem6);

		jMenuItem7.setText("Produtos");
		jMenu2.add(jMenuItem7);

		jMenuItem8.setText("Usuários");
		jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem8ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem8);

		jMenuBar1.add(jMenu2);

		jMenu3.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__LIBRARY1.png"))); // NOI18N
		jMenu3.setText("Manutenção");
		jMenu3.setToolTipText("Clicar aqui para entrat na tela de manutenção");
		jMenuBar1.add(jMenu3);

		jMenu4.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__Saida.png"))); // NOI18N
		jMenu4.setText("Finalizar");
		jMenu4.setToolTipText("Clicar aqui para finalizar o programa");

		jMenuItem1.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__CHECK.png"))); // NOI18N
		jMenuItem1.setText("Sim");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem1);

		jMenuItem2.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__DELETE2.png"))); // NOI18N
		jMenuItem2.setText("Não");
		jMenu4.add(jMenuItem2);

		jMenuBar1.add(jMenu4);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(Desktop));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(Desktop));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
		// TODO add your handling code here:
		System.exit(0);
	}// GEN-LAST:event_jMenuItem1ActionPerformed

	private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem5ActionPerformed

		TelaUsuarios telausuarios = null;
		try {
			telausuarios = new TelaUsuarios();
		} catch (SQLException ex) {
			Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
		}
		Desktop.add(telausuarios);
		telausuarios.setVisible(true);
	}// GEN-LAST:event_jMenuItem5ActionPerformed

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
		// TODO add your handling code here:
		TelaClientes clientes = null;
		try {
			clientes = new TelaClientes();
			Desktop.add(clientes);
			clientes.setVisible(true);
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro de " + ex);
		}

	}// GEN-LAST:event_jMenuItem3ActionPerformed

	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem6ActionPerformed
		TelaConsultaClientes consultaClientes = null;
		try {
			consultaClientes = new TelaConsultaClientes();
			Desktop.add(consultaClientes);
			consultaClientes.setVisible(true);
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro de " + ex);
		}
	}// GEN-LAST:event_jMenuItem6ActionPerformed

	private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem8ActionPerformed
		// TODO add your handling code here:
		TelaConsultasUsuarios consultaUsuario = null;
		try {
			consultaUsuario = new TelaConsultasUsuarios();
			Desktop.add(consultaUsuario);
			consultaUsuario.setVisible(true);
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro de " + ex);
		}
	}// GEN-LAST:event_jMenuItem8ActionPerformed

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
			java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaMenuPrincipal(nomeUsuario).setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JDesktopPane Desktop;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JMenuItem jMenuItem7;
	private javax.swing.JMenuItem jMenuItem8;
	// End of variables declaration//GEN-END:variables
}
