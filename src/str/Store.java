package str;
import java.sql.SQLException;
import java.util.Scanner;
public class Store {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	    Scanner s = new Scanner(System.in);
	    Item tem = new Item();
	    System.out.println("1. Add new item");
	    System.out.println("2. Update existing item by ID");
	    	    
	    int choice = s.nextInt();

	    if (choice == 1) {
	        
	        System.out.println("Enter the name for item");
	        String name = s.next();
	        System.out.println("Enter the expiration date for item");
	        String expirationDate = s.next();
	        System.out.println("Enter piece count for item");
	        int pieceCount = s.nextInt();
	        System.out.println("Enter identification number");
	        int id = s.nextInt();
	   
	        tem.setName(name);
	        tem.setExpirationDate(expirationDate);
	        tem.setPieceCount(pieceCount);
	        tem.setId(id);

	        System.out.println(tem.getName() + " " + tem.getExpirationDate() + " " + tem.getPieceCount() + " " + tem.getId());

	        ItemDB db = new ItemDB();
	        if (db.foundId(id)==0) {
	        	db.Save(tem);
	        }
	        else {
	        	System.out.println("There is such an Id");
	        } 
	    }
	        
	    else if (choice == 2) {
	
	        System.out.println("Enter the ID of the item you want to update:");
	        int id = s.nextInt();
	        System.out.println("Enter the new name for the item:");
	        String name = s.next();
	        System.out.println("Enter the new expiration date for the item:");
	        String expirationDate = s.next();
	        System.out.println("Enter the new piece count for the item:");
	        int pieceCount = s.nextInt();

	        tem.setId(id);
	        tem.setName(name);
	        tem.setExpirationDate(expirationDate);
	        tem.setPieceCount(pieceCount);

	        ItemDB db = new ItemDB();
	        db.updateItem(tem);
	    } 
	  
	    else {
	        System.out.println("Invalid choice.");
	    }
	    

	    s.close();
	}
}