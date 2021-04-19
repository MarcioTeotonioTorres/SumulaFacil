package telas.telasInternas;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;

public class CadastrarJogo extends JInternalFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CadastrarJogo() {
		setBorder(UIManager.getBorder("PopupMenu.border"));
		setTitle("Cadastrar Jogo");
		setMaximizable(true);
		setResizable(false);		 
		setIconifiable(true);		
		setClosable(true);
		setBounds(0, 33, 1350, 700);
	}

}
