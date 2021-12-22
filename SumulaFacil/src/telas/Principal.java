package telas;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import basicas.TipoUsuario;
import telas.telasInternas.CadastrarAnotador;
import telas.telasInternas.CadastrarJogador;
import telas.telasInternas.CadastrarJogo;
import telas.telasInternas.ExcluirDirigente;
import util.Relogio;
import util.Sessao;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JList;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private Insets in;
	private Dimension d;
	private JDesktopPane desktopPane;
	private CadastrarAnotador mp;
	private CadastrarJogo cadastrarJogo;
	private ExcluirDirigente dirigente;
	private CadastrarJogador cadastrarJogador;
	private JMenu mnNewMenu;

	public Principal() {

//		if (Sessao.getInstance().getUsuario().getTipoUsuario() == TipoUsuario.Anotador) {
//			mnNewMenu.setEnabled(false);
//		}

		setExtendedState(Frame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
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
					} catch (Exception ex) {
						// TODO: handle exception
						ex.printStackTrace();

					}
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Principal.class.getResource("/imagens/Computer_icon-icons.com_55237.png")));
		setTitle("Area de Trabalho do S\u00FAmula F\u00E1cil");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		in = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
		d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width - (in.left + in.top);
		int height = d.height - (in.top + in.bottom);
		setSize(width, height);
		setLocation(in.left, in.top);
		getContentPane().setLayout(null);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 32, 1340, 630);

		getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1350, 34);
		getContentPane().add(menuBar);

		mnNewMenu = new JMenu("Cadastro");
		mnNewMenu.setFont(new Font("Tahoma", Font.BOLD, 22));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Jogador");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					if (cadastrarJogador == null) {
						cadastrarJogador = new CadastrarJogador();
					}
					if (!cadastrarJogador.isVisible()) {
						desktopPane.add(cadastrarJogador);
						cadastrarJogador.setVisible(true);
					}
					cadastrarJogador.toFront();
					cadastrarJogador.setMaximum(true);
				} catch (Exception ex) {
					ex.getStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Arbitro");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Time");
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Competi\u00E7\u00E3o");
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Jogo");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (cadastrarJogo == null) {
						cadastrarJogo = new CadastrarJogo();
					}
					if (!cadastrarJogo.isVisible()) {
						desktopPane.add(cadastrarJogo);
						cadastrarJogo.setVisible(true);
					}
					cadastrarJogo.toFront();
					cadastrarJogo.setMaximum(true);
				} catch (Exception ex) {
					ex.getStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Anotador");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (mp == null) {
						mp = new CadastrarAnotador();
					}
					if (!mp.isVisible()) {
						desktopPane.add(mp);
						mp.setVisible(true);
					}
					mp.toFront();
					mp.setMaximum(true);
				} catch (IllegalArgumentException | PropertyVetoException | java.text.ParseException ex) {
					ex.getStackTrace();
				}

			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Dirigente");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (dirigente == null) {
						dirigente = new ExcluirDirigente();
					}
					if (!dirigente.isVisible()) {
						desktopPane.add(dirigente);
						dirigente.setVisible(true);
					}
					dirigente.toFront();
					dirigente.setMaximum(true);
				} catch (IllegalArgumentException | PropertyVetoException ex) {
					ex.printStackTrace();
				}

			}
		});
		mnNewMenu.add(mntmNewMenuItem_11);

		JMenu mnNewMenu_1 = new JMenu("S\u00FAmula");
		mnNewMenu_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Criar S\u00FAmula de Jogo Avulso");
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Criar S\u00FAmulas de uma Competi\u00E7\u00E3o");
		mnNewMenu_1.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Excluir/Editar S\u00FAmula Existente");
		mnNewMenu_1.add(mntmNewMenuItem_8);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Imprimir S\u00FAmula");
		mnNewMenu_1.add(mntmNewMenuItem_9);

		JMenu mnNewMenu_2 = new JMenu("Sobre");
		mnNewMenu_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("S\u00FAmula F\u00E1cil");
		mnNewMenu_2.add(mntmNewMenuItem_10);

		JSeparator separator_1 = new JSeparator();
		menuBar.add(separator_1);
		separator_1.setMaximumSize(new Dimension(970, 40));
		separator_1.setOrientation(SwingConstants.VERTICAL);

		JMenu mnNewMenu_3 = new JMenu("Sair...");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
					} catch (Exception ex) {
						// TODO: handle exception
						ex.printStackTrace();

					}
				}
			}
		});

		mnNewMenu_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		menuBar.add(mnNewMenu_3);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 664, 1350, 25);
		getContentPane().add(toolBar);
		toolBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		toolBar.setFloatable(false);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		toolBar.add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);

		JLabel lblNewLabel = new JLabel("Bem vindo: " + Sessao.getInstance().getUsuario().getNomeUsuario());
		toolBar.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);

		Relogio.start(lblNewLabel_1);
		if(Sessao.getInstance().getUsuario().getTipoUsuario()==TipoUsuario.Anotador) {
			mnNewMenu.setEnabled(false);
		}
	}
}
