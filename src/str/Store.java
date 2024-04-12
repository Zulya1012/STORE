package str;
import java.sql.SQLException;
import java.util.Scanner;
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
		
		ItemDB db = new ItemDB();
		 db.Save(tem);




	}

}
