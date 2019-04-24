import javax.swing.table.AbstractTableModel;
import javax.xml.transform.Result;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Class Description
 *
 * @author Marcus Trujillo
 * @version CS2251 - Intermediate Programming
 * email: mtrujillo255@cnm.edu
 * assignment due date:
 */
public class ResultSetModel extends AbstractTableModel {
    //just need these for testing delete later
    Connection con;
    Statement st;
    ResultSet rs;
    ResultSetMetaData metaData;
    /// ok real code starts now
    private ArrayList<ArrayList<Object>> table;
    private ArrayList<String> columnNames;
    private int numRows;
    private int numColumns;

    public ResultSetModel(ArrayList<ArrayList<Object>> table, int numRows, int numColumns){
        this.numColumns = numColumns;
        this.numRows = numRows;
        this.table = table;
    }

    @Override
    public int getRowCount() {
        return numRows;
    }

    @Override
    public int getColumnCount(){
        return numColumns;
    }

    @Override
    public Object getValueAt(int row, int column){
        return table.get(row+1).get(column);
    }

    public static void main(String[] args) {

    }
    //here we are for tester purposes tz
    public void displayTable(){
        for(int i = 0; i < getRowCount() + 1 ; i++){ // because we made it to truly model, our first row is labels.
            for(int j = 0; j < table.get(i).size()  ; j++){
                System.out.println(table.get(i).get(j));
            }
        }
    }

}
