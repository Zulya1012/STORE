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
		    String sql = String.format("INSERT INTO store (name, expirationDate, pieceCount) " +
		                 "VALUES ('%s', '%s', %d)", item.getName(), item.getExpirationDate(), item.getPieceCount());
		    System.out.println(sql);
		    Statement stmt = null;
		    stmt = conn.createStatement();
		    int rowsInserted = stmt.executeUpdate(sql);
		    System.out.println(rowsInserted + " row(s) inserted.");

		    // Close the connection
		    conn.close();
	}

}
