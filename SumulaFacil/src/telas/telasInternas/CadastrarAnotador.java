package telas.telasInternas;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

import basicas.Usuario;
import controlador.UsuarioControlador;
import dao.UsuarioDao;
import interfaceControlador.IusuarioControlador;
import interfaceDao.IusuarioDao;
import net.proteanit.sql.DbUtils;
import relatorios.TableModelAnotador;

import javax.swing.JScrollPane;

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
		panel.setBounds(55, 52, 586, 548);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cadastre-se como novo \"Dirigente\".");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(102, 22, 398, 27);
		panel.add(lblNewLabel_1);

		Label label_1 = new Label("*Nome:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(95, 71, 54, 25);
		panel.add(label_1);

		textField = new JTextField();
		textField.setToolTipText("Digite seu nome completo!");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBounds(155, 71, 328, 25);
		panel.add(textField);

		Label label_1_1 = new Label("*CPF.:");
		label_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1_1.setBounds(102, 102, 47, 25);
		panel.add(label_1_1);

		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
		maskCpf.setValidCharacters("0123456789");

		formattedTextField = new JFormattedTextField(maskCpf);
		formattedTextField.setToolTipText("Digite seu CPF!");
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		formattedTextField.setBounds(155, 102, 137, 25);
		panel.add(formattedTextField);

		Label label_2 = new Label("*Idade:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(352, 102, 54, 25);
		panel.add(label_2);

		spinner = new JSpinner();
		spinner.setToolTipText("Selecione sua idade!");
		spinner.setFont(new Font("Tahoma", Font.BOLD, 14));
		spinner.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		spinner.setBounds(412, 102, 71, 25);
		JFormattedTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
		tf.setEditable(false);
		panel.add(spinner);

		Label label_2_1 = new Label("*CEP.:");
		label_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2_1.setBounds(102, 133, 47, 25);
		panel.add(label_2_1);

		MaskFormatter maskCep = new MaskFormatter("#####-###");
		maskCep.setValidCharacters("0123456789");
		formattedTextField_1 = new JFormattedTextField(maskCep);
		formattedTextField_1.setToolTipText("Digite seu c\u00F3dogo postal CEP.!");
		formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		formattedTextField_1.setBounds(155, 133, 120, 25);
		panel.add(formattedTextField_1);

		Label label = new Label("*N\u00B0 Residencial:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(292, 133, 114, 25);
		panel.add(label);

		formattedTextField_1_1 = new JFormattedTextField();
		formattedTextField_1_1.setToolTipText("Digite o seu numero residencial com ou sem complemento!");
		formattedTextField_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		formattedTextField_1_1.setBounds(412, 133, 71, 25);
		panel.add(formattedTextField_1_1);

		Label label_6 = new Label("Telefone:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(78, 164, 71, 25);
		panel.add(label_6);

		MaskFormatter maskTelefone = new MaskFormatter("(##)#####-####");
		maskTelefone.setValidCharacters("0123456789");
		formattedTextField_1_2 = new JFormattedTextField(maskTelefone);
		formattedTextField_1_2.setToolTipText("Digite seu celular para contato!");
		formattedTextField_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		formattedTextField_1_2.setBounds(155, 164, 137, 25);
		panel.add(formattedTextField_1_2);

		JLabel lblNewLabel_1_1 = new JLabel("Informa\u00E7\u00F5es de login.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(168, 211, 249, 27);
		panel.add(lblNewLabel_1_1);

		Label label_3 = new Label("Nome de usuario:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(22, 258, 127, 25);
		panel.add(label_3);

		textField_1 = new JTextField();
		textField_1.setToolTipText("Digite um nome de usu\u00E1rio para o login!");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(155, 258, 328, 25);
		panel.add(textField_1);

		Label label_4 = new Label("Senha:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(95, 299, 54, 25);
		panel.add(label_4);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Digite a senha!");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(40, 329, 163, 25);
		panel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("Repita a senha!");
		passwordField_1.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField_1.setBounds(383, 329, 163, 25);
		panel.add(passwordField_1);

		Label label_5 = new Label("Digite a senha novamente:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(366, 299, 191, 25);
		panel.add(label_5);

		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnNewButton.setToolTipText("Limpar campos!");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(40, 393, 172, 45);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				iDao = new UsuarioDao();
				iControlador = new UsuarioControlador();

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
												
					}
				} else {
					JOptionPane.showMessageDialog(null, "Tente novamente!");

				}
			}
		});
		btnNewButton_1.setToolTipText("Cadastrar!");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1.setBounds(374, 393, 172, 45);
		panel.add(btnNewButton_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(713, 52, 586, 548);
		getContentPane().add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 356, 431, 94);
		panel_1.add(scrollPane);
		
		modelAnotador = new TableModelAnotador((ArrayList<Usuario>) iDao.listaDeAnotadores());				
		table = new JTable(modelAnotador);
		scrollPane.setViewportView(table);
		
	
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
