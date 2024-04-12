package str;
import java.util.Scanner;
import java.sql.*;
import java.text.DecimalFormat;
public class Store {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Item tem = new Item();
		System.out.println("Enter the name for item");
		String name = s.nextLine();
		System.out.println("Enter the expiration date for item");
		String expirationDate = s.nextLine();
		System.out.println("Enter piece count for item");
		int pieceCount = s.nextInt();
		
		tem.setName(name);
		tem.setExpirationDate(expirationDate);
		tem.setPieceCount(pieceCount);
		
		System.out.println(tem.getName()+ " " + tem.getExpirationDate()+ " "+ tem.getPieceCount());
		
		Class.forName("org.sqlite.JDBC");
		 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\DB\\database.db");
		 System.out.println("Connected to SQLite database");
		 // Create the SQL INSERT statement
		 DecimalFormat df = new DecimalFormat("#.00");
		 df.setDecimalSeparatorAlwaysShown(true); 
		    String sql = String.format("INSERT INTO store (name, expirationDate, pieceCount) " +
		                 "VALUES ('%s', '%s', %d)", tem.getName(), tem.getExpirationDate(), tem.getPieceCount());
		    System.out.println(sql);
		    Statement stmt = null;
		    stmt = conn.createStatement();
		    int rowsInserted = stmt.executeUpdate(sql);
		    System.out.println(rowsInserted + " row(s) inserted.");

		    // Close the connection
		    conn.close();
		 




	}

}
