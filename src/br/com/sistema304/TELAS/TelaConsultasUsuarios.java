
package br.com.sistema304.TELAS;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import br.com.sistema304.BEAN.ContatosUsuariosBeans;
import br.com.sistema304.DAO.UsuariosDAO;

/**
 *
 * @author professor
 */
public class TelaConsultasUsuarios extends javax.swing.JInternalFrame {

	private String nomeUsuario;

	public TelaConsultasUsuarios() throws SQLException {
		setTitle("Consulta de Usuários");
		setClosable(true);
		initComponents();
		DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();
		Tabela.setRowSorter(new TableRowSorter(modelo));
		setPreferredSize(new Dimension(1280, 768));
		pack();
		MostrarTabela();
	}

	public void MostrarTabela() throws SQLException {
		DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();
		UsuariosDAO pdao = new UsuariosDAO();
		modelo.setNumRows(0);
		for (ContatosUsuariosBeans cb : pdao.buscar()) {
			modelo.addRow(
					new Object[] { cb.getIdusuarios(), cb.getUsuario(), cb.getLogin(), cb.getSenha(), cb.getPerfil() });
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		jScrollPane1 = new javax.swing.JScrollPane();
		Tabela = new javax.swing.JTable();

		jButton1.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__Sair.png"))); // NOI18N
		jButton1.setText("Fechar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		Tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "id usuários", "Usuários", "Login", "Senha", "Perfil" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(Tabela);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout.createSequentialGroup().addContainerGap()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695,
												Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
						.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(22, 22, 22)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		dispose();
	}// GEN-LAST:event_jButton1ActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTable Tabela;
	private javax.swing.JButton jButton1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration//GEN-END:variables
}
