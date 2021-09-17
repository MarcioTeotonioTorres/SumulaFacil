package telas;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controlador.UsuarioControlador;
import dao.UsuarioDao;
import interfaceControlador.IusuarioControlador;
import interfaceDao.IusuarioDao;

public class NovoDirigente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JFormattedTextField formattedTextField_1_2;
	private JFormattedTextField formattedTextField_1;
	private JFormattedTextField formattedTextField;
	private JSpinner spinner;
	private JFormattedTextField formattedTextField_1_1;

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public NovoDirigente() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(NovoDirigente.class.getResource("/imagens/icons8_add_administrator_32.png")));
		setTitle("Registrar-se como novo dirigente.");
		setResizable(false);
		setEnabled(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 700);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(238, 11, 838, 649);
		contentPane.add(panel);

		Label label_1 = new Label("*Nome:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_1.setBounds(104, 92, 79, 33);
		panel.add(label_1);

		textField = new JTextField();
		textField.setToolTipText("Digite seu nome completo!");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBounds(189, 92, 551, 33);
		panel.add(textField);

		Label label_1_1 = new Label("*CPF.:");
		label_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_1_1.setBounds(112, 155, 71, 33);
		panel.add(label_1_1);

		Label label_2 = new Label("*Idade:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_2.setBounds(361, 155, 79, 32);
		panel.add(label_2);

		Label label_2_1 = new Label("*CEP.:");
		label_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_2_1.setBounds(112, 216, 71, 32);
		panel.add(label_2_1);

		Label label = new Label("*N\u00B0 Residencial:");
		label.setBounds(361, 216, 166, 33);
		panel.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD, 22));

		MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
		cpfMask.setValidCharacters("0123456789");
		formattedTextField = new JFormattedTextField(cpfMask);
		formattedTextField.setToolTipText("Digite seu CPF!");
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		formattedTextField.setBounds(189, 155, 166, 33);

		panel.add(formattedTextField);

		MaskFormatter cepMask = new MaskFormatter("#####-###");
		cepMask.setValidCharacters("0123456789");
		formattedTextField_1 = new JFormattedTextField(cepMask);
		formattedTextField_1.setToolTipText("Digite seu c\u00F3dogo postal CEP.!");
		formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		formattedTextField_1.setBounds(189, 215, 166, 33);
		panel.add(formattedTextField_1);

		spinner = new JSpinner();
		spinner.setToolTipText("Selecione sua idade!");

		spinner.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 22));
		spinner.setModel(new SpinnerNumberModel(7, 7, 75, 1));
		spinner.setBounds(446, 156, 71, 32);
		JFormattedTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
		tf.setEditable(false);
		panel.add(spinner);

		JSeparator separator = new JSeparator();
		separator.setBounds(104, 328, 636, 2);
		panel.add(separator);

		JLabel lblNewLabel_1_1 = new JLabel("Informa\u00E7\u00F5es de login.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(296, 341, 249, 27);
		panel.add(lblNewLabel_1_1);

		formattedTextField_1_1 = new JFormattedTextField();
		formattedTextField_1_1.setToolTipText("Digite o seu numero residencial com ou sem complemento!");
		formattedTextField_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		formattedTextField_1_1.setBounds(533, 215, 105, 33);

		panel.add(formattedTextField_1_1);

		Label label_3 = new Label("Nome de usuario:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_3.setBounds(189, 400, 185, 33);
		panel.add(label_3);

		Label label_4 = new Label("Senha:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_4.setBounds(207, 453, 79, 33);
		panel.add(label_4);

		Label label_5 = new Label("Digite a senha novamente:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_5.setBounds(460, 453, 272, 33);
		panel.add(label_5);

		textField_1 = new JTextField();
		textField_1.setToolTipText("Digite um nome de usu\u00E1rio para o login!");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(380, 400, 238, 33);
		panel.add(textField_1);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Digite a senha!");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordField.setBounds(104, 492, 280, 33);
		panel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("Repita a senha!");
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordField_1.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField_1.setBounds(460, 492, 280, 33);
		panel.add(passwordField_1);

		JLabel lblNewLabel_1 = new JLabel("Cadastre-se como novo \"Dirigente\".");
		lblNewLabel_1.setBounds(221, 40, 401, 27);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));

		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.setToolTipText("Cadastrar!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				IusuarioDao iDao = new UsuarioDao();
				IusuarioControlador iControlador = new UsuarioControlador();

				String senha = new String(passwordField.getPassword());
				String repitaSenha = new String(passwordField_1.getPassword());

				if (iControlador.inserirUsuarioControladorAnotador(formattedTextField_1.getText(),
						formattedTextField.getText(), (int) spinner.getValue(), textField.getText(),
						formattedTextField_1_1.getText(), formattedTextField_1_2.getText(), senha,
						textField_1.getText(), repitaSenha) != null) {

					if (iDao.inserirUsuarioDao(iControlador.inserirUsuarioControlador(formattedTextField_1.getText(),
							formattedTextField.getText(), (int) spinner.getValue(), textField.getText(),
							formattedTextField_1_1.getText(), formattedTextField_1_2.getText(), senha,
							textField_1.getText(), repitaSenha)) == true) {

						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso. Efetue o login!");
						dispose();

						SumulaFacil login = new SumulaFacil();
						login.setVisible(true);

					}
				} else {
					JOptionPane.showMessageDialog(null, "Tente novamente!");

				}
			}

		});
		btnNewButton_1.setBounds(339, 549, 172, 45);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));

		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.setToolTipText("Limpar campos!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();

			}
		});
		btnNewButton.setBounds(162, 549, 172, 45);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));

		JButton btnNewButton_2_1 = new JButton("Sair...");
		btnNewButton_2_1.setToolTipText("Fechar!");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Object[] confirme = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Tem certeza de que deseja sair?",
						"Os dados não salvos serão perdidos!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, confirme, confirme[0]);

				if (i == 0) {
					dispose();
					SumulaFacil login;
					try {

						login = new SumulaFacil();
						login.setVisible(true);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();

					}
				}

			}
		});
		btnNewButton_2_1.setBounds(515, 549, 172, 45);
		panel.add(btnNewButton_2_1);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));

		Label label_6 = new Label("Telefone:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_6.setBounds(85, 277, 98, 33);
		panel.add(label_6);

		MaskFormatter telefoneMask = new MaskFormatter("(##)#####-####");
		telefoneMask.setValidCharacters("0123456789");
		formattedTextField_1_2 = new JFormattedTextField(telefoneMask);
		formattedTextField_1_2.setToolTipText("Digite seu celular para contato!");
		formattedTextField_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		formattedTextField_1_2.setBounds(189, 277, 166, 33);
		panel.add(formattedTextField_1_2);
		setLocationRelativeTo(null);
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
	}
}
