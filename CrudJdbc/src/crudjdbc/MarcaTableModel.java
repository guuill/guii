/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crudjdbc;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author henrique_custodia
 */
public class MarcaTableModel extends AbstractTableModel {
    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
   
    private String[] colunas = {"id","Nome",};
    
    private List<Marca>linhas;
    
    //retorna a qtde de linhas da tabela
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    //retorna a qtde de colunas
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    //retorna o dados do objeto da linha
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    Marca m = linhas.get(row);
    if (columnIndex == COL_ID){
        return m.getId();
        
    }else(COL_NOME == COL_NOME){
        return m.getNome();
    }
    }
    
}
