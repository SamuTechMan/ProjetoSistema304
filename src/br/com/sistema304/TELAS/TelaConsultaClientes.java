
package br.com.sistema304.TELAS;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import br.com.sistema304.BEAN.ContatosClientesBeans;
import br.com.sistema304.DAO.ClientesDAO;


public class TelaConsultaClientes extends javax.swing.JInternalFrame {

	/**
	 * Creates new form TelaConsultasUsuarios
	 */
	public TelaConsultaClientes() throws SQLException {
		setResizable(true);
		setTitle("Consulta de Clientes");
		setClosable(true);
		initComponents();
		DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();
		Tabela.setRowSorter(new TableRowSorter(modelo));
		setPreferredSize(new Dimension(1280, 768));
		pack();

		MostrarTabela();
		ajustarTamanhoColunas();
	}

	public void MostrarTabela() throws SQLException {
		DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();
		ClientesDAO pdao = new ClientesDAO();
		modelo.setNumRows(0);
		for (ContatosClientesBeans cb : pdao.buscar()) {
			modelo.addRow(new Object[] { cb.getIdclientes(), cb.getNome(), cb.getCPF(), cb.getDtnascimento(),
					cb.getSexo(), cb.getCelular(), cb.getEmail(), cb.getDTCadastro(), cb.getSituacao() });
		}
	}

	private void ajustarTamanhoColunas() {
		TableColumnModel columnModel = Tabela.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(170); // Coluna "id clientes"
		columnModel.getColumn(1).setPreferredWidth(500); // Coluna "Nome"
		columnModel.getColumn(2).setPreferredWidth(280); // Coluna "CPF"
		columnModel.getColumn(3).setPreferredWidth(220); // Coluna "Nascimento"
		columnModel.getColumn(4).setPreferredWidth(170); // Coluna "Sexo"
		columnModel.getColumn(5).setPreferredWidth(260); // Coluna "Celular"
		columnModel.getColumn(6).setPreferredWidth(430); // Coluna "Email"
		columnModel.getColumn(7).setPreferredWidth(280); // Coluna "Data Cadastro"
		columnModel.getColumn(8).setPreferredWidth(150); // Coluna "Situação"
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
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
				new String[] { "id clientes", "Nome", "CPF", "Nascimento", "Sexo", "Celular", "Email", "Data Cadastro",
						"Situação" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };

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
