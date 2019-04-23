import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Class Description
 *
 * @author Marcus Trujillo
 * @version CS2251 - Intermediate Programming
 * email: mtrujillo255@cnm.edu
 * assignment due date:
 */
public class ResultSetModel extends AbstractTableModel {
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numRows;
    private int numColumns;

    public ResultSetModel(ResultSet resultSet){
        this.resultSet = resultSet;
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
        return new Object();
    }
}
