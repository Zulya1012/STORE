package str;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.sql.*;

public class ItemDB {
	
	public void Save(Item item) throws SQLException, ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\DB\\database.db");
		 System.out.println("Connected to SQLite database");
		 // Create the SQL INSERT statement
		 DecimalFormat df = new DecimalFormat("#.00");
		 df.setDecimalSeparatorAlwaysShown(true); 
		    String sql = String.format("INSERT INTO store (name, expirationDate, pieceCount, id) " +
		                 "VALUES ('%s', '%s', %d, %d)", item.getName(), item.getExpirationDate(), item.getPieceCount(), item.getId());
		    System.out.println(sql);
		    Statement stmt = null;
		    stmt = conn.createStatement();
		    int rowsInserted = stmt.executeUpdate(sql);
		    System.out.println(rowsInserted + " row(s) inserted.");

		    // Close the connection
		    conn.close();
	}
	public void updateItem(Item item) throws SQLException, ClassNotFoundException {
	    Class.forName("org.sqlite.JDBC");
	    Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\DB\\database.db");
	    System.out.println("Connected to SQLite database");

	    // Create the SQL UPDATE statement
	    String sql = String.format("UPDATE store SET name = '%s', expirationDate = '%s', pieceCount = %d WHERE id = %d",
	            item.getName(), item.getExpirationDate(), item.getPieceCount(), item.getId());
	    System.out.println(sql);
	    Statement stmt = conn.createStatement();
	    int rowsUpdated = stmt.executeUpdate(sql);
	    System.out.println(rowsUpdated + " row(s) updated.");

	    // Close the connection
	    conn.close();
	}
	
	public int foundId (int id) throws SQLException, ClassNotFoundException {
		int count=0;
		 Class.forName("org.sqlite.JDBC");
		    Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\DB\\database.db");
		    System.out.println("Connected to SQLite database");
		    System.out.println("Connection to SQLite has been established.");

        Statement statement = connection.createStatement();
        String sql = "SELECT count (*) as cnt FROM Store WHERE id = "+ id;
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
           count = resultSet.getInt("cnt");
            

           
        }
        return count;
	}
	

}
