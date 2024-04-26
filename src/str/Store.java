package str;
import java.sql.SQLException;
import java.util.Scanner;
 
public class Store {
//основной метод main на котором строится вся программа
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// создание объекта Scanner для считывания информации с консоли
		Scanner sc = new Scanner (System.in);
		//создается новый объект с названием Item
		Item tem = new Item();
		//Выводится на консоль два пункта, один из которых мы должны выбрать
		System.out.println("1. Add new item");
		System.out.println("2. Update existing item by ID");
		System.out.println("3. Delete item");
		
		//считываем один из выбранных пунктов с консоли
		int choise = sc.nextInt();
		sc.nextLine();
		//проверяем условия после считывания выбранного пункта
		//при выборе 1 вводим новые данные товара 
		if (choise == 1) {
			System.out.println("Enter the name for item");
			String name = sc.nextLine();
			System.out.println("Enter the expirationDate for item");
			String expirationDate = sc.nextLine();
			System.out.println("Enter the pieceCount");
			int pieceCount = sc.nextInt();
			System.out.println("Enter the price for item");
			double price = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter the weight for item");
			double weight = sc.nextDouble();
			//создаем новый объект itemDB для работы с базой данных
			ItemDB db = new ItemDB();
			// к перемменной id присваиваем максимальное число, найденное в базе данных и добаляем к нему 1
			//для того, чтобы не было одинаковых id кодов
			int id = db.findMaxId()+1;
			
			
			//устанавливаем введенные с консоли значения для каждого свойства товара
			tem.setName(name);
			tem.setExpirationDate(expirationDate);
			tem.setPeiceCount(pieceCount);
			tem.setId(id);
			tem.setPrice(price);
			tem.setWeight(weight);
			
			//выводим на консоль все свойства товаров 
			System.out.println (tem.getName()+ " "+ tem.getExpirationDate()+ " " +tem.getPieceCount()+ " "+ tem.getId()+ " "+tem.getPrice()+ " "+tem.getWeight());
			
			//проверка условия, если введенный в консоли id код не совпадает с существующими id кодами, 
			//то этот id сохраняется в базе данных
			 
			if (db.foundID(id)==0)
				db.Save(tem);
		}
		//если мы в консоли выбрали пункт 2 для изменения данных в базе данных, 
		//вводим в консоле id код и добавляем новые свойства товара 
		else if (choise == 2){
			System.out.println("Enter the Id code of the item you want to update: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the new name for the item: ");
			String name = sc.nextLine();
			sc.nextLine();
			System.out.println("Enter the new expiration for the item: ");
			String expirationDate = sc.nextLine();
			System.out.println("Enter the new peice count for the item: ");
			int pieceCount = sc.nextInt();
			System.out.println("Enter the new price for the item");
			double price = sc.nextDouble();
			System.out.println("Enter the new weight for the weight");
			double weight = sc.nextDouble();
			
			//устанавливаем измененные свойства товара
			tem.setId(id);
			tem.setName(name);
			tem.setExpirationDate(expirationDate);
			tem.setPeiceCount(pieceCount);
			tem.setPrice(price);
			tem.setWeight(weight);
			
			//создаем новый объект itemDB для обновления свойств товара
			ItemDB db = new ItemDB();
			db.updateItem(tem);
			
		}
		
		else if (choise==3) {
			System.out.println("Enter the id item");
			int id = sc.nextInt();
			
			ItemDB db = new ItemDB();
			db.deleteItem(id);
			
		}
		else {
			System.out.println("Invalid choise.");
			
		
		}
		//создан для безопасного закрытия программы
		sc.close();
		
	}

}
