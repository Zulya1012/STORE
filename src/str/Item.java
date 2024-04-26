package str;
public class Item {
	//объявление приватных переменных для хранения названия, даты истечения срока годности, 
	//колличества товара  и идентифицированного номера товаров
	private String name;
	private String expirationDate;
	private int pieceCount;
	private int id;
	private double price;
	private double weight;
	
	//метод который позволяет получать значение name
	public String getName() {
		return name;
	}
	//метод который устанавливает значения name
	public void setName(String name) {
		this.name = name;
	}
	//метод который позволяет получать значение expirationDate
	public String getExpirationDate () {
		return expirationDate;
	}
	//метод который устанавливает значение expirationDate
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	//метод который позволяет получать значение pieceCount
	public int getPieceCount () {
		return pieceCount;
	}
	//метод который позволяет устанавливать значение pieceCount
	public void setPeiceCount (int pieceCount) {
		this.pieceCount = pieceCount;
	}
	//метод который позволяет получать значение id
	public int getId () {
		return id;
	}
	//метод который позволяет устанавливать значение id
	public void setId (int id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
