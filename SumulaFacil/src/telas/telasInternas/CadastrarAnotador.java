package telas.telasInternas;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;

import basicas.Usuario;
import controlador.UsuarioControlador;
import dao.UsuarioDao;
import interfaceControlador.IusuarioControlador;
import interfaceDao.IusuarioDao;
import relatorios.TableModelAnotador;

public class CadastrarAnotador extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	private JFormattedTextField formattedTextField_1_2;
	private JFormattedTextField formattedTextField_1;
	private JFormattedTextField formattedTextField;
	private JSpinner spinner;
	private JFormattedTextField formattedTextField_1_1;

	private IusuarioControlador iControlador;
	private IusuarioDao iDao;
	private JTable table;
	private TableModelAnotador modelAnotador;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_1_1;

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 * @throws PropertyVetoException
	 */
	public CadastrarAnotador() throws ParseException {

		iControlador = new UsuarioControlador();
		iDao = new UsuarioDao();

		setBorder(UIManager.getBorder("PopupMenu.border"));
		setTitle("Cadastrar Anotador");

		setMaximizable(true);
		setResizable(false);
		setClosable(true);
		setBounds(0, 33, 1360, 700);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(55, 52, 1248, 548);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cadastre Anotadores.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(318, 22, 243, 27);
		panel.add(lblNewLabel_1);

		Label label_1 = new Label("*Nome:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(214, 89, 54, 25);
		panel.add(label_1);

		textField = new JTextField();
		textField.setToolTipText("Digite seu nome completo!");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBounds(274, 89, 328, 25);
		panel.add(textField);

		Label label_1_1 = new Label("*CPF.:");
		label_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1_1.setBounds(221, 120, 47, 25);
		panel.add(label_1_1);

		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
		maskCpf.setValidCharacters("0123456789");

		formattedTextField = new JFormattedTextField(maskCpf);
		formattedTextField.setToolTipText("Digite seu CPF!");
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		formattedTextField.setBounds(274, 120, 137, 25);
		panel.add(formattedTextField);

		Label label_2 = new Label("*Idade:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(471, 120, 54, 25);
		panel.add(label_2);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(7, null, 75, 1));
		spinner.setToolTipText("Selecione sua idade!");
		spinner.setFont(new Font("Tahoma", Font.BOLD, 14));
		spinner.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spinner.setBounds(531, 120, 71, 25);
		JFormattedTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
		tf.setEditable(false);
		panel.add(spinner);

		Label label_2_1 = new Label("*CEP.:");
		label_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2_1.setBounds(221, 151, 47, 25);
		panel.add(label_2_1);

		MaskFormatter maskCep = new MaskFormatter("#####-###");
		maskCep.setValidCharacters("0123456789");
		formattedTextField_1 = new JFormattedTextField(maskCep);
		formattedTextField_1.setToolTipText("Digite seu c\u00F3dogo postal CEP.!");
		formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		formattedTextField_1.setBounds(274, 151, 120, 25);
		panel.add(formattedTextField_1);

		Label label = new Label("*N\u00B0 Residencial:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(411, 151, 114, 25);
		panel.add(label);

		formattedTextField_1_1 = new JFormattedTextField();
		formattedTextField_1_1.setToolTipText("Digite o seu numero residencial com ou sem complemento!");
		formattedTextField_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		formattedTextField_1_1.setBounds(531, 151, 71, 25);
		panel.add(formattedTextField_1_1);

		Label label_6 = new Label("*Telefone:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(191, 182, 77, 25);
		panel.add(label_6);

		MaskFormatter maskTelefone = new MaskFormatter("(##)#####-####");
		maskTelefone.setValidCharacters("0123456789");
		formattedTextField_1_2 = new JFormattedTextField(maskTelefone);
		formattedTextField_1_2.setToolTipText("Digite seu celular para contato!");
		formattedTextField_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		formattedTextField_1_2.setBounds(274, 182, 137, 25);
		panel.add(formattedTextField_1_2);

		JLabel lblNewLabel_1_1 = new JLabel("Informa\u00E7\u00F5es de login.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(768, 22, 249, 27);
		panel.add(lblNewLabel_1_1);

		Label label_3 = new Label("*Nome de usuario:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(731, 87, 137, 25);
		panel.add(label_3);

		textField_1 = new JTextField();
		textField_1.setToolTipText("Digite um nome de usu\u00E1rio para o login!");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(874, 87, 172, 25);
		panel.add(textField_1);

		Label label_4 = new Label("*Senha:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(806, 120, 62, 25);
		panel.add(label_4);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Digite a senha!");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(874, 120, 172, 25);
		panel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("Repita a senha!");
		passwordField_1.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField_1.setBounds(874, 151, 172, 25);
		panel.add(passwordField_1);

		Label label_5 = new Label("*Digite a senha novamente:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(667, 151, 201, 25);
		panel.add(label_5);

		JButton btnNewButton = new JButton("Limpar/Novo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnNewButton.setToolTipText("Limpar campos!");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(214, 230, 191, 45);
		panel.add(btnNewButton);

		btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String senha = new String(passwordField.getPassword());
				String repitaSenha = new String(passwordField_1.getPassword());

				Usuario u = iControlador.inserirUsuarioControladorAnotador(formattedTextField_1.getText(),
						formattedTextField.getText(), (int) spinner.getValue(), textField.getText(),
						formattedTextField_1_1.getText(), formattedTextField_1_2.getText(), senha,
						textField_1.getText(), repitaSenha);

				if (u != null) {

					if (iDao.inserirUsuarioDao(u) == true) {

						JOptionPane.showMessageDialog(null, "Anotador cadastrado com sucesso!");
						limparCampos();
						modelAnotador = new TableModelAnotador();
						table = new JTable(modelAnotador);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								if (arg0.getClickCount() == 1) {
									textField.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 1));
									formattedTextField
											.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 2));
									spinner.setValue(modelAnotador.getValueAt(table.getSelectedRow(), 3));
									formattedTextField_1
											.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 4));
									formattedTextField_1_1
											.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 5));
									formattedTextField_1_2
											.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 6));
									textField_1.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 7));
									passwordField.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 8));
									passwordField_1
											.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 8));

								}
							}
						});
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane.setViewportView(table);
					} else {

						JOptionPane.showMessageDialog(null, "Usuário e/ou/ dados deste usuário já estão cadastrados");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Tente novamente!");

				}
			}
		});
		btnNewButton_1.setToolTipText("Cadastrar!");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1.setBounds(431, 230, 172, 45);
		panel.add(btnNewButton_1);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 349, 1099, 133);
		panel.add(scrollPane);

		modelAnotador = new TableModelAnotador();
		table = new JTable(modelAnotador);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 1) {
					textField.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 1));
					formattedTextField.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 2));
					spinner.setValue(modelAnotador.getValueAt(table.getSelectedRow(), 3));
					formattedTextField_1.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 4));
					formattedTextField_1_1.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 5));
					formattedTextField_1_2.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 6));
					textField_1.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 7));
					passwordField.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 8));
					passwordField_1.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 8));
					btnNewButton_1.setEnabled(false);
					btnNewButton_2.setEnabled(true);
					btnNewButton_1_1.setEnabled(true);
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Long id = (Long) modelAnotador.getValueAt(table.getSelectedRow(), 0);
				if (iDao.excluirUsuarioPorId(id)) {
					modelAnotador = new TableModelAnotador();
					table = new JTable(modelAnotador);
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							if (arg0.getClickCount() == 1) {
								textField.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 1));
								formattedTextField
										.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 2));
								spinner.setValue(modelAnotador.getValueAt(table.getSelectedRow(), 3));
								formattedTextField_1
										.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 4));
								formattedTextField_1_1
										.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 5));
								formattedTextField_1_2
										.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 6));
								textField_1.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 7));
								passwordField.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 8));
								passwordField_1.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 8));

							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
					JOptionPane.showMessageDialog(null, "Registro apagado com sucesso!");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_2.setBounds(823, 230, 191, 45);
		panel.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("Selecione um item na lista para edit\u00E1-lo ou exclu\u00ED-lo.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(78, 523, 361, 25);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Campos marcados (*) s\u00E3o obrigat\u00F3rios.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(78, 498, 283, 25);
		panel.add(lblNewLabel_2);

		btnNewButton_1_1 = new JButton("Editar");
		btnNewButton_1_1.setEnabled(false);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String senha = new String(passwordField.getPassword());
				String repitaSenha = new String(passwordField_1.getPassword());

				Usuario u = iControlador.inserirUsuarioControladorAnotador(formattedTextField_1.getText(),
						formattedTextField.getText(), (int) spinner.getValue(), textField.getText(),
						formattedTextField_1_1.getText(), formattedTextField_1_2.getText(), senha,
						textField_1.getText(), repitaSenha);

				if (u != null) {
					if (iDao.alterarUsuarioDaoAnotador(u)) {
						modelAnotador = new TableModelAnotador();
						table = new JTable(modelAnotador);

						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								if (arg0.getClickCount() == 1) {
									textField.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 1));
									formattedTextField
											.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 2));
									spinner.setValue(modelAnotador.getValueAt(table.getSelectedRow(), 3));
									formattedTextField_1
											.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 4));
									formattedTextField_1_1
											.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 5));
									formattedTextField_1_2
											.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 6));
									textField_1.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 7));
									passwordField.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 8));
									passwordField_1
											.setText((String) modelAnotador.getValueAt(table.getSelectedRow(), 8));
									
									btnNewButton_1.setEnabled(false);
									btnNewButton_2.setEnabled(true);
									btnNewButton_1_1.setEnabled(true);
								}
							}
						});

						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane.setViewportView(table);
						JOptionPane.showMessageDialog(null, "Registro atualizado!");
						limparCampos();
					}
				}
			}

		});
		btnNewButton_1_1.setToolTipText("Editar");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1_1.setBounds(629, 230, 172, 45);
		panel.add(btnNewButton_1_1);

	}

	public void limparCampos() {
		formattedTextField_1.setText("");
		formattedTextField.setText("");
		spinner.setValue(7);
		textField.setText("");
		formattedTextField_1_1.setText("");
		formattedTextField_1_2.setText("");
		passwordField.setText("");
		textField_1.setText("");
		passwordField_1.setText("");
		btnNewButton_1.setEnabled(true);
		btnNewButton_2.setEnabled(false);
		btnNewButton_1_1.setEnabled(false);
	}
}
