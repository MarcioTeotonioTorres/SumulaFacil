package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import basicas.TipoUsuario;
import controlador.UsuarioControlador;
import dao.UsuarioDao;
import interfaceControlador.IusuarioControlador;
import interfaceDao.IusuarioDao;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JComboBox<TipoUsuario> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagens/Login_37128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel_1 = new JLabel("Bem vindo ao S\u00FAmula F\u00E1cil Desktop");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagens/Lock-Lock-icon.png")));
		lblNewLabel.setBounds(73, 83, 96, 133);
		panel.add(lblNewLabel);

		Label label = new Label("*Usuario:");
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBounds(281, 54, 152, 33);
		panel.add(label);

		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textField.setBackground(Color.WHITE);
				
			}
		});
		textField.setToolTipText("Digite seu Nome de usuario!");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField.setColumns(10);
		textField.setBounds(463, 54, 188, 33);
		panel.add(textField);

		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.setToolTipText("Limpar campos!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
				comboBox.setSelectedIndex(0);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(281, 251, 172, 45);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Entrar...");
		btnNewButton_1.setToolTipText("Entrar!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IusuarioDao iDao = new UsuarioDao();
				IusuarioControlador iControlador = new UsuarioControlador();

				String senha = new String(passwordField.getPassword());

				if (iControlador.loginControlador(textField.getText(), senha,
						(TipoUsuario) comboBox.getSelectedItem())!=null) {

					if (iDao.loginDao(iControlador.loginControlador(textField.getText(), senha,
							(TipoUsuario) comboBox.getSelectedItem())) == true) {

						setVisible(false);
						Principal principal = new Principal();
						principal.setVisible(true);
						

					} else {
						
						
						JOptionPane.showMessageDialog(null, "Usuário não existe ou inválido");
						
					}
				} else {
					textField.setBackground(Color.RED);
					passwordField.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Campos \"Usuário\" e/ou \"Senha\" são obrigatórios!");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1.setBounds(463, 251, 188, 45);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Novo dirigente...");
		btnNewButton_2.setToolTipText("N\u00E3o \u00E9 cadastrado? Cadastre-se aqui!");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				NovoDirigente dirigente;
				try { 
					setVisible(false);
					dirigente = new NovoDirigente();
					dirigente.setVisible(true);
				} catch (ParseException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace(); 
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_2.setBounds(405, 307, 246, 45);
		panel.add(btnNewButton_2);

		Label label_1 = new Label("*Senha:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_1.setBounds(281, 117, 152, 33);
		panel.add(label_1);

		Label label_2 = new Label("*Perfil:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_2.setBounds(281, 184, 152, 32);
		panel.add(label_2);

		comboBox = new JComboBox<TipoUsuario>();
		comboBox.setToolTipText("Selecione o seu n\u00EDvel de acesso!");
		comboBox.setModel(new DefaultComboBoxModel<TipoUsuario>(TipoUsuario.values()));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 22));
		comboBox.setBounds(463, 184, 188, 32);
		panel.add(comboBox);

		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setBackground(Color.WHITE);
			}
		});
		passwordField.setToolTipText("Digite a senha!");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 22));
		passwordField.setBounds(463, 117, 188, 33);
		panel.add(passwordField);

		JButton btnNewButton_2_1 = new JButton("Sair...");
		btnNewButton_2_1.setToolTipText("Fechar!");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_2_1.setBounds(281, 307, 114, 45);
		panel.add(btnNewButton_2_1);

		JTextArea txtrCadastreseComodirigente = new JTextArea();
		txtrCadastreseComodirigente.setText(
				"Cadastre-se como \"Dirigente\" \r\npara acesso completo, ou \r\ntenha permiss\u00E3o de \"Anotador\" \r\npara inserir dados de um \r\njogo numa s\u00FAmula existente.\r\n*  Campos obrigat\u00F3rios");
		txtrCadastreseComodirigente.setEditable(false);
		txtrCadastreseComodirigente.setBounds(10, 219, 235, 112);
		panel.add(txtrCadastreseComodirigente);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(56)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 661,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(518, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addContainerGap(655, Short.MAX_VALUE)
												.addComponent(lblNewLabel_1).addGap(186)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGap(49)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGap(35).addComponent(panel, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
						.addGap(30)));
		contentPane.setLayout(gl_contentPane);

	}
}
