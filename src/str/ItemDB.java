package str;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class ItemDB {
	// метод itemDB сохраняет все свойства товара
	public void Save(Item item) throws SQLException, ClassNotFoundException {
		// создание sql запроса для вставки данных в таблицу
		String sql = String.format(
				"INSERT INTO str  (name, expirationDate, pieceCount, id, price, weight)"
						+ "VALUES ('%s', '%s', '%d', '%d', '%.2f', '%.2f')",
				item.getName(), item.getExpirationDate(), item.getPieceCount(), item.getId(), item.getPrice(), item.getWeight());
		System.out.println(sql);
		// вставка в базу данных. Возвращает количество строк, вставленных в таблицу
		int rowsInserted = connectionDB().executeUpdate(sql);
		// выводит количество строк вставленных в таблицу
		System.out.println(rowsInserted + "row(s) inserted. ");
	}

	// метод с помощью которого обновляем свойства товара
	public void updateItem(Item item) throws SQLException, ClassNotFoundException {
		DecimalFormat df = new DecimalFormat("#.##");
		String sql = String.format(
				"UPDATE str SET name= '%s', expirationDate = '%s', pieceCount = %d, price = '%s', weight = '%s' WHERE id = %d",
				item.getName(), item.getExpirationDate(), item.getPieceCount(), df.format(item.getPrice()), df.format(item.getWeight()),
				item.getId());
		System.out.println(sql);
		// добавляет элемент в базу данных
		int rowsInserted = connectionDB().executeUpdate(sql);
		System.out.println(rowsInserted + "row(s) inserted. ");
	}

	// метод который принимает Id код товара и возвращает количество совпадений в
	// базе данных
	public int foundID(int id) throws SQLException, ClassNotFoundException {
		// создаем переменную count
		int count = 0;
		// создается запрос к столбцу с названием cnt с помощью where получает данные,
		// удовлетворяющей условию
		String sql = "Select count (*) as cnt FROM str WHERE id = " + id;
		// выполняет запрос к базе данных и сохраняет результат в объект ResultSet
		ResultSet resultSet = connectionDB().executeQuery(sql);

		// Перебираем результаты запроса
		while (resultSet.next()) {
			// сохраняем макс значение в переменной count
			count = resultSet.getInt("cnt");
		}
		return count;

	}

	// метод который нахлдит и возвращает нам максимальное число
	public int findMaxId() throws SQLException, ClassNotFoundException {
		int max = 0;
		// создается запрос к столбцу где находит максимальное число
		String sql = "Select max (id) mxm From str ";
		// выполняет запрос к базе данных и сохраняет результат в объект ResultSet
		ResultSet resultSet = connectionDB().executeQuery(sql);
		// Перебираем результаты запроса
		while (resultSet.next()) {
			// сохраняем макс значение в переменной max
			max = resultSet.getInt("mxm");
		}
		return max;
	}

	public void deleteItem(int id) throws SQLException, ClassNotFoundException {

		String sql = "Delete From str WHERE id =" + id;
		int row = connectionDB().executeUpdate(sql);

	}

	public Statement connectionDB() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\DB\\database.db");
		Statement stm = conn.createStatement();
		return stm;
	}
	
	
}
