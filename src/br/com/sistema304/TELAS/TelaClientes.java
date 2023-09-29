package br.com.sistema304.TELAS;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.com.sistema304.BEAN.ContatosClientesBeans;
import br.com.sistema304.DAL.Conexao;
import br.com.sistema304.DAO.ClientesDAO;

public class TelaClientes extends javax.swing.JInternalFrame {

	private JRadioButton rdbtnSexoMasculino;
	private JRadioButton rdbtnSexoFeminino;
	private MaskFormatter mascaraData;
	

	public TelaClientes() {
		initComponents();
	}

	public String formatarCPF(String cpf) {
		if (cpf == null || cpf.length() != 11) {
			return cpf;
		}
		return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		setPreferredSize(new Dimension(800, 600));
		pack();
		jPanel2 = new javax.swing.JPanel();
		btnGravar = new javax.swing.JButton();
		btnGravar.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		btnAlterar = new javax.swing.JButton();
		btnAlterar.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		btnExcluir = new javax.swing.JButton();
		btnExcluir.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		btnFechar = new javax.swing.JButton();
		btnFechar.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBounds(72, 57, 50, 16);
		jLabel1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		txtIDCliente = new javax.swing.JTextField();
		rdbtnSexoMasculino = new JRadioButton("Masculino");
		rdbtnSexoMasculino.setBounds(140, 233, 85, 25);
		rdbtnSexoMasculino.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));

		rdbtnSexoFeminino = new JRadioButton("Feminino");
		rdbtnSexoFeminino.setBounds(230, 233, 82, 25);
		rdbtnSexoFeminino.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));

		txtIDCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String id = txtIDCliente.getText();
				Connection conexao = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				String sql = "Select * from clientes where idclientes=?";
				try {
					conexao = Conexao.qConexao();
					pst = conexao.prepareStatement(sql);
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()) {
						String cpfBd = rs.getString(3);
						String cpfFormatado = formatarCPF(cpfBd);
						txtNomeCliente.setText(rs.getString(2));
						txtCPFCliente.setText(cpfFormatado);
						txtDTNascimento.setText(rs.getString(4));
						txtCelular.setText(rs.getString(6));
						txtEmail.setText(rs.getString(7));
						txtDTCadastro.setText(rs.getString(8));
						txtSituacao.setText(rs.getString(9));
						String sexo = rs.getString(5);
						rdbtnSexoMasculino.setSelected(false);
						rdbtnSexoFeminino.setSelected(false);
						txtSexoOutro.setText(null);
						if ("Masculino".equals(sexo)) {
							rdbtnSexoMasculino.setSelected(true);
							txtSexoOutro.setText(null);
						} else if ("Feminino".equals(sexo)) {
							rdbtnSexoFeminino.setSelected(true);
							txtSexoOutro.setText(null);
						} else {
							txtSexoOutro.setText(sexo);
						}
						btnGravar.setEnabled(false);
						btnAlterar.setEnabled(true);
						btnExcluir.setEnabled(true);
					} else {
						btnGravar.setEnabled(true);
						btnAlterar.setEnabled(false);
						btnExcluir.setEnabled(false);
						txtNomeCliente.setText(null);
						txtCPFCliente.setText(null);
						txtDTNascimento.setText(null);
						txtCelular.setText(null);
						txtEmail.setText(null);
						txtDTCadastro.setText(null);
						txtSituacao.setText(null);
						rdbtnSexoMasculino.setSelected(false);
						rdbtnSexoFeminino.setSelected(false);
						txtSexoOutro.setText(null);
					}
					txtNomeCliente.requestFocus();

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Erro de " + ex);
				}
			}
		});

		txtIDCliente.setBounds(139, 48, 100, 34);
		txtIDCliente.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setBounds(34, 102, 88, 16);
		jLabel2.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		txtNomeCliente = new javax.swing.JTextField();
		txtNomeCliente.setBounds(140, 93, 440, 34);
		txtNomeCliente.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setBounds(46, 147, 76, 16);
		jLabel3.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		txtCPFCliente = new javax.swing.JFormattedTextField();
		txtCPFCliente.setBounds(140, 138, 440, 34);
		txtCPFCliente.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		try {
		    MaskFormatter mask = new MaskFormatter("###.###.###-##");
		    mask.setPlaceholderCharacter('_');
		    ((JFormattedTextField) txtCPFCliente).setFormatterFactory(new DefaultFormatterFactory(mask));
		} catch (ParseException ex) {
		    ex.printStackTrace();
		}
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setBounds(16, 192, 106, 16);
		jLabel4.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		txtDTNascimento = new javax.swing.JFormattedTextField();
		txtDTNascimento.setBounds(140, 183, 100, 34);
		txtDTNascimento.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		try {
		    MaskFormatter mask = new MaskFormatter("##/##/####");
		    mask.setPlaceholderCharacter('_');
		    ((JFormattedTextField) txtDTNascimento).setFormatterFactory(new DefaultFormatterFactory(mask));
		} catch (ParseException ex) {
		    ex.printStackTrace();
		}
		jPanel2.setBackground(new java.awt.Color(255, 255, 204));

		btnGravar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__EXPORT.png"))); // NOI18N
		btnGravar.setText("Gravar");
		btnGravar.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnGravarActionPerformed(evt);
			}
		});

		btnAlterar.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__Alteracao.png"))); // NOI18N
		btnAlterar.setText("Alterar");
		btnAlterar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAlterarActionPerformed(evt);
			}
		});

		btnExcluir.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__Nomaior.png"))); // NOI18N
		btnExcluir.setText("Excluir");
		btnExcluir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExcluirActionPerformed(evt);
			}
		});

		btnFechar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema304/ICONES/AnyConv.com__Sair.png"))); // NOI18N
		btnFechar.setText("Fechar");
		btnFechar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnFECHARActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout
				.createSequentialGroup().addContainerGap()
				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
						.addComponent(btnGravar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(btnAlterar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(btnFechar, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
				.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(30)
						.addComponent(btnGravar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addGap(30)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addGap(30)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
						.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGap(23)));
		jPanel2.setLayout(jPanel2Layout);

		jPanel1.setBackground(new java.awt.Color(51, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de clientes",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

		jLabel1.setText("ID Cliente");

		txtIDCliente.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jLabel2.setText("Nome do Cliente");

		txtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jLabel3.setText("CPF do Cliente");

		jLabel4.setText("Data de Nascimento");

		JLabel jLabel5 = new JLabel();
		jLabel5.setBounds(97, 237, 25, 16);
		jLabel5.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
		jLabel5.setText("Sexo");

		txtSexoOutro = new JTextField();
		txtSexoOutro.setBounds(352, 228, 228, 34);
		txtSexoOutro.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));

		rdbtnSexoFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSexoFeminino.isSelected()) {
					rdbtnSexoMasculino.setSelected(false);
					txtSexoOutro.setText(null);
				}
			}
		});

		rdbtnSexoMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSexoMasculino.isSelected()) {
					rdbtnSexoFeminino.setSelected(false);
					txtSexoOutro.setText(null);
				}
			}
		});

		txtSexoOutro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				rdbtnSexoMasculino.setSelected(false);
				rdbtnSexoFeminino.setSelected(false);
			}
		});

		JLabel lblNewLabel = new JLabel("Outro");
		lblNewLabel.setBounds(317, 237, 31, 16);
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));

		JLabel jLabel6 = new JLabel();
		jLabel6.setBounds(86, 281, 36, 16);
		jLabel6.setText("Celular");
		jLabel6.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));

		txtCelular = new javax.swing.JFormattedTextField();
		txtCelular.setBounds(140, 272, 165, 34);
		txtCelular.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		try {
		    MaskFormatter mask = new MaskFormatter("(##)#-####-####");
		    mask.setPlaceholderCharacter('_');
		    ((JFormattedTextField) txtCelular).setFormatterFactory(new DefaultFormatterFactory(mask));
		} catch (ParseException ex) {
		    ex.printStackTrace();
		}
		
		JLabel jLabel7 = new JLabel();
		jLabel7.setBounds(94, 326, 28, 16);
		jLabel7.setText("Email");
		jLabel7.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));

		txtEmail = new JTextField();
		txtEmail.setBounds(140, 317, 440, 34);
		txtEmail.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));

		JLabel jLabel8 = new JLabel();
		jLabel8.setBounds(33, 370, 89, 18);
		jLabel8.setText("Data de Cadastro");
		jLabel8.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));

		txtDTCadastro = new javax.swing.JFormattedTextField();
		txtDTCadastro.setBounds(140, 362, 100, 34);
		txtDTCadastro.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		try {
		    MaskFormatter mask = new MaskFormatter("##/##/####");
		    mask.setPlaceholderCharacter('_');
		    ((JFormattedTextField) txtDTCadastro).setFormatterFactory(new DefaultFormatterFactory(mask));
		} catch (ParseException ex) {
		    ex.printStackTrace();
		}
		JLabel jLabel9 = new JLabel();
		jLabel9.setBounds(77, 416, 45, 16);
		jLabel9.setText("Situação");
		jLabel9.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 554, Short.MAX_VALUE))
				.addContainerGap()));
		jPanel1.setLayout(null);
		jPanel1.add(jLabel9);
		jPanel1.add(jLabel5);
		jPanel1.add(jLabel3);
		jPanel1.add(jLabel4);
		jPanel1.add(jLabel6);
		jPanel1.add(jLabel7);
		jPanel1.add(jLabel8);
		jPanel1.add(txtDTCadastro);
		jPanel1.add(txtEmail);
		jPanel1.add(txtCPFCliente);
		jPanel1.add(txtDTNascimento);
		jPanel1.add(txtCelular);
		jPanel1.add(rdbtnSexoMasculino);
		jPanel1.add(rdbtnSexoFeminino);
		jPanel1.add(lblNewLabel);
		jPanel1.add(txtSexoOutro);
		jPanel1.add(jLabel1);
		jPanel1.add(jLabel2);
		jPanel1.add(txtIDCliente);
		jPanel1.add(txtNomeCliente);

		txtSituacao = new JTextField();
		txtSituacao.setFont(new Font("Segoe UI Variable", Font.PLAIN, 13));
		txtSituacao.setBounds(140, 407, 100, 34);
		jPanel1.add(txtSituacao);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGravarActionPerformed
		try {
			String nome, CPF, DTNascimento, sexo, celular, email, DTCadastro, situacao;
			int gravar;
			boolean teste;
			ContatosClientesBeans contato1 = new ContatosClientesBeans();
			// Connection conexao = Conexao.qConexao();
			ClientesDAO udao = new ClientesDAO();
			nome = txtNomeCliente.getText();
			CPF = txtCPFCliente.getText();
			DTNascimento = txtDTNascimento.getText();
			if (rdbtnSexoMasculino.isSelected()) {
				sexo = "Masculino";
			} else if (rdbtnSexoFeminino.isSelected()) {
				sexo = "Feminino";
			} else {
				sexo = txtSexoOutro.getText();
			}
			celular = txtCelular.getText();
			email = txtEmail.getText();
			DTCadastro = txtDTCadastro.getText();
			situacao = txtSituacao.getText();

			gravar = JOptionPane.showConfirmDialog(null, "Está correto para gravar?", "Atenção!!!",
					JOptionPane.YES_NO_OPTION);
			if (gravar == JOptionPane.YES_OPTION) {
				contato1.setNome(nome);
				contato1.setCPF(CPF);
				contato1.setDtnascimento(DTNascimento);
				contato1.setSexo(sexo);
				contato1.setCelular(celular);
				contato1.setEmail(email);
				contato1.setDTCadastro(DTCadastro);
				contato1.setSituacao(situacao);

				teste = udao.Inclusao(contato1);
				if (teste) {
					JOptionPane.showMessageDialog(null, "OK, salvou");
					txtNomeCliente.setText(null);
					txtCPFCliente.setText(null);
					txtDTNascimento.setText(null);
					rdbtnSexoMasculino.setSelected(false);
					rdbtnSexoFeminino.setSelected(false);
					txtSexoOutro.setText(null);
					txtCelular.setText(null);
					txtEmail.setText(null);
					txtDTCadastro.setText(null);
					txtSituacao.setText(null);
					String proximo = String.valueOf(udao.ultimoRegClientes());
					txtIDCliente.setText(proximo);
					txtIDCliente.requestFocus();
				} else
					JOptionPane.showMessageDialog(null, "Não salvou nada!");
			}

		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro de: " + error);
		}
	}

	private void btnFECHARActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
	}

	private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String nome, CPF, Dtnascimento, sexo, celular, email, Dtcadastro, situacao;
			int excluir, idclientes;
			boolean teste = false;
			ContatosClientesBeans contato1 = new ContatosClientesBeans();
			ClientesDAO udao = new ClientesDAO();
			idclientes = Integer.valueOf(txtIDCliente.getText());
			nome = txtNomeCliente.getText();
			CPF = txtCPFCliente.getText();
			celular = txtCelular.getText();
			Dtnascimento = txtDTNascimento.getText();
			if (rdbtnSexoMasculino.isSelected()) {
				sexo = "Masculino";
			} else if (rdbtnSexoFeminino.isSelected()) {
				sexo = "Feminino";
			} else {
				sexo = txtSexoOutro.getText();
			}
			email = txtEmail.getText();
			Dtcadastro = txtDTCadastro.getText();
			situacao = txtSituacao.getText();
			excluir = JOptionPane.showConfirmDialog(null, "Está correto para Excluir ?", "Atenção!!!",
					JOptionPane.YES_NO_OPTION);
			if (excluir == JOptionPane.YES_OPTION) {
				contato1.setIdclientes(idclientes);
				contato1.setNome(nome);
				contato1.setCPF(CPF);
				contato1.setDtnascimento(Dtnascimento);
				contato1.setSexo(sexo);
				contato1.setCelular(celular);
				contato1.setEmail(email);
				contato1.setDTCadastro(Dtcadastro);
				contato1.setSituacao(situacao);

				teste = udao.Exclusao(contato1);
				if (teste) {
					JOptionPane.showMessageDialog(null, "OK ");
					txtNomeCliente.setText(null);
					txtCPFCliente.setText(null);
					txtDTNascimento.setText(null);
					rdbtnSexoMasculino.setSelected(false);
					rdbtnSexoFeminino.setSelected(false);
					txtSexoOutro.setText(null);
					txtCelular.setText(null);
					txtEmail.setText(null);
					txtDTCadastro.setText(null);
					txtSituacao.setText(null);
					String proximo = String.valueOf(udao.ultimoRegClientes());
					txtIDCliente.setText(proximo);
					txtIDCliente.requestFocus();
				} else
					JOptionPane.showMessageDialog(null, "Não fez nada!");
			}
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro de: " + error);
		}
	}

	private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			String nome, CPF, Dtnascimento, sexo, celular, email, Dtcadastro, situacao;
			int alterar, idclientes;
			boolean teste;
			ContatosClientesBeans contato1 = new ContatosClientesBeans();
			ClientesDAO udao = new ClientesDAO();
			idclientes = Integer.valueOf(txtIDCliente.getText());
			nome = txtNomeCliente.getText();
			CPF = txtCPFCliente.getText();
			celular = txtCelular.getText();
			Dtnascimento = txtDTNascimento.getText();
			if (rdbtnSexoMasculino.isSelected()) {
				sexo = "Masculino";
			} else if (rdbtnSexoFeminino.isSelected()) {
				sexo = "Feminino";
			} else {
				sexo = txtSexoOutro.getText();
			}
			email = txtEmail.getText();
			Dtcadastro = txtDTCadastro.getText();
			situacao = txtSituacao.getText();

			alterar = JOptionPane.showConfirmDialog(null, "Está correto para Alterar ?", "Atenção!!!",
					JOptionPane.YES_NO_OPTION);
			if (alterar == JOptionPane.YES_OPTION) {
				contato1.setIdclientes(idclientes);
				contato1.setNome(nome);
				contato1.setCPF(CPF);
				contato1.setDtnascimento(Dtnascimento);
				contato1.setSexo(sexo);
				contato1.setCelular(celular);
				contato1.setEmail(email);
				contato1.setDTCadastro(Dtcadastro);
				contato1.setSituacao(situacao);

				teste = udao.Alteracao(contato1);
				if (teste) {
					JOptionPane.showMessageDialog(null, "OK ");
					txtNomeCliente.setText(null);
					txtCPFCliente.setText(null);
					txtDTNascimento.setText(null);
					rdbtnSexoMasculino.setSelected(false);
					rdbtnSexoFeminino.setSelected(false);
					txtSexoOutro.setText(null);
					txtCelular.setText(null);
					txtEmail.setText(null);
					txtDTCadastro.setText(null);
					txtSituacao.setText(null);
					String proximo = String.valueOf(udao.ultimoRegClientes());
					txtIDCliente.setText(proximo);
					txtIDCliente.requestFocus();
				} else
					JOptionPane.showMessageDialog(null, "Não fez nada!");
			}
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro de: " + error);
		}
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
	}// GEN-LAST:event_jTextField1ActionPerformed

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField2ActionPerformed
	}// GEN-LAST:event_jTextField2ActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAlterar;
	private javax.swing.JButton btnExcluir;
	private javax.swing.JButton btnFechar;
	private javax.swing.JButton btnGravar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JTextField txtIDCliente;
	private javax.swing.JTextField txtNomeCliente;
	private javax.swing.JTextField txtCPFCliente;
	private JTextField txtDTNascimento;
	private JTextField txtSexoOutro;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtDTCadastro;
	private JTextField txtSituacao;
}
