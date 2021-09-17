package relatorios;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import basicas.TipoUsuario;
import basicas.Usuario;
public class TableModelAnotador extends AbstractTableModel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//aqui transformei em coluna cada propriedade de Funcionario
    //que eu quero que seja exibida na tabela  
    private String colunas[] = {"Matricula", "nome de usuario", "Senha", "Perfil"};
    private ArrayList<Usuario> usuarios;

    public TableModelAnotador(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return usuarios.size();
    }
    //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Long.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return TipoUsuario.class;
            default:
                return String.class;
        }
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = this.usuarios.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return usuario.getMatricula();
            case 1:
                return usuario.getNomeUsuario();
            case 2:
                return usuario.getSenha();
            case 3:
                return usuario.getTipoUsuario();
        }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
        Usuario usuario = this.usuarios.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
            case 0:
            	usuario.setMatricula((long) aValue);
                break;
            case 1:
                usuario.setNomeUsuario((String) aValue);
                break;
            case 2:
                usuario.setSenha((String) aValue);
                break;
            case 3:
                usuario.setTipoUsuario((TipoUsuario) aValue);
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }

}
