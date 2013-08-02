/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crudjdbc;

import br.com.senai.negocio.Marca;
import java.util.ArrayList;
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
    
    
    
    public MarcaTableModel(){
        linhas = new ArrayList<Marca>();
                
    }
    public MarcaTableModel(List<Marca> marcas){
      linhas = new ArrayList<Marca>();  
    }
    public String getColumnName(int columnIndex){
        return colunas [columnIndex]; 
    }
    public Class getColumnClass (int columnindex){
        if (columnindex == COL_ID){
            return Integer.class;
        }else if (columnindex == COL_NOME){
            return String.class;
        }
        return null;
    }
    
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
    Marca m = linhas.get(rowIndex);
    if (columnIndex == COL_ID){
        return m.getId();
        
    }else if (COL_NOME == COL_NOME){
        return m.getNome();
    }
    return "";
    }
    public void setValueAt (Object aValue, int rowIndex, int columnIndex){
        Marca m = linhas.get(rowIndex);
        if (columnIndex == COL_ID){
            m.setId((Integer)aValue);
        }else if (columnIndex == COL_NOME){
            m.setNome(aValue.toString());
        }
    }
    //Indica se a celula é editável
    public boolean isCellEditable (int rowIndex, int columnIndex){
        return false; 
    }
    /*
     * Retorna a marca referente a linha especificada
     */
    public Marca getMarca (int indiceLinha){
        return linhas.get(indiceLinha);   
    }
    public void addMarca(Marca marca){
        //Adiciona o registro
        linhas.add(marca);
        //Pega a quantidade de registros(Os registros começam com zero
        int ultimoIndice = getRowCount() - 1;
        
        //Notifica a mudança
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        
    }
     public void udateMarca (int indiceLinha, Marca marca){
         linhas.set(indiceLinha, marca);
         fireTableRowsUpdated(indiceLinha, indiceLinha);
         
     }
      
     public void removeMarca (int indiceLinha){
         linhas.remove(indiceLinha);
         fireTableRowsDeleted (indiceLinha, indiceLinha);
         
     }
   
}
