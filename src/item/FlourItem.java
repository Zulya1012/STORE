package item;

public class FlourItem {
   int count;
   double price;
   String flourType;
   
   public FlourItem(int count,double price,String flourType) {
	   this.count=count;
	   this.price=price;
	   this.flourType=flourType;
   }
   
   public int getCount() {return count;}
   public double getPrice() {return price;}
   public String getFlourType() {return flourType;}
}
