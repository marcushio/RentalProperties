import java.sql.*;
import java.sql.SQLException;


/**
 * test code for filling 2d array to rep a resultset
 *
 * @author Marcus Trujillo
 * @version CS2251 - Intermediate Programming
 * email: mtrujillo255@cnm.edu
 * assignment due date:
 */
public class ResultSetTest {
    Object[][] table;
    private static final String url = "jdbc:derby:RentalData";
    private static final String user = "student";
    private static final String password = "student";
    Connection con;
    Statement st;
    ResultSet rs;
    ResultSetMetaData metaData;

    public static void main(String[] args) {
        ResultSetTest rst = new ResultSetTest();
        try {
            rst.con = DriverManager.getConnection("jdbc:derby:rentaldata", "student", "student");
            rst.st = rst.con.createStatement();
            rst.rs = rst.st.executeQuery("select * from Properties");
            rst.metaData = rst.rs.getMetaData();

            int columnCount = rst.metaData.getColumnCount();
            for(int column=1; column < columnCount; column++)
                System.out.println(rst.metaData.getColumnClassName(column));

        } catch (
                SQLException e) {

            e.printStackTrace();
        }
    }
}
