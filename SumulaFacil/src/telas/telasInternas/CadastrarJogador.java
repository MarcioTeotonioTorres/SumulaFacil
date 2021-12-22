package telas.telasInternas;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;

public class CadastrarJogador extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CadastrarJogador() {
		
		setBorder(UIManager.getBorder("PopupMenu.border"));
		setTitle("Cadastrar Jogador");
		setResizable(false);
		setClosable(true);
		setBounds(0, 33, 1350, 700);
	}
}
