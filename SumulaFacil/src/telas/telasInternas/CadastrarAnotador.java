package telas.telasInternas;



import javax.swing.JInternalFrame;
import javax.swing.UIManager;

public class CadastrarAnotador extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public CadastrarAnotador() {
		
		setBorder(UIManager.getBorder("PopupMenu.border"));
		setTitle("Cadastrar Anotador");
		setMaximizable(true);
		setResizable(false);		 
		setIconifiable(true);		
		setClosable(true);
		setBounds(0, 33, 1350, 700);
		
	}

}
