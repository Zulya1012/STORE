package item;

public class Bun extends FlourItem {
   boolean withRaises;
   
   public Bun(   boolean withRaises,int count,double price,String flourType) {
	   super(count,price,flourType);
   }
   
   public boolean getwithRaises() {return withRaises;}
}
