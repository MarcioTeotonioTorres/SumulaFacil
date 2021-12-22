package telas.telasInternas;



import java.awt.Font;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExcluirDirigente extends JInternalFrame {

	private static final long serialVersionUID = 1L;


	public ExcluirDirigente() {
		setBorder(UIManager.getBorder("PopupMenu.border"));
		setTitle("Excluir Dirigente");
		setResizable(false);
		setClosable(true);
		setBounds(0, 33, 1350, 700);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(255, 124, 850, 343);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Excluir minha conta de Dirigente...");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_1.setBounds(74, 145, 715, 35);
		panel.add(btnNewButton_1);
		btnNewButton_1.setToolTipText("Cadastrar!");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel lblNewLabel = new JLabel("Ao excluir sua conta, vo\u00E7\u00EA ser\u00E1 deslogado, e todos os registros efetuados por esta conta tamb\u00E9m ser\u00E3o exclu\u00EDdos.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 82, 792, 35);
		panel.add(lblNewLabel);

	}
}
