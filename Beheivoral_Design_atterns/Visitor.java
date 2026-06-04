import java.util.*;
import java.lang.*;
import java.io.*;

class Visitor {
    
    public interface IElement {
        int void accept(Visitor v);
    }
    
    public interface IVisitor {
        public void visit(Book k);
        public void visit(Fruit f);
    }    
    
    public class Book implements IElement {
    private int price;
        private String isbnNumber;
    
        public Book(int cost, String isbn) {
            this.price = cost;
            this.isbnNumber = isbn;
        }
    
        public int getPrice() { return price; }
        public String getIsbnNumber() { return isbnNumber; }
    
        @Override
        public int accept(IVisitor visitor) {
            // The Book hands itself over to the visitor
            return visitor.visit(this); 
        }
    }
        public class Fruit implements ItemElement {
        private int pricePerPound;
        private int weight;
        private String name;
    
        public Fruit(int priceKg, int wt, String nm) {
            this.pricePerPound = priceKg;
            this.weight = wt;
            this.name = nm;
        }
    
        public int getPricePerPound() { return pricePerPound; }
        public int getWeight() { return weight; }
    
        @Override
        public int accept(IVisitor visitor) {
            // The Fruit hands itself over to the visitor
            return visitor.visit(this);
        }
    }
        public class shopcardvisitor implements IVisitor {
                   @Override
            public int visit(Book book) {
                int cost = book.getPrice();
                // Apply a flat $5 discount if the book is expensive
                if (cost > 50) {
                    cost -= 5;
                }
                System.out.println("Book ISBN::" + book.getIsbnNumber() + " cost =" + cost);
                return cost;
            }
        
            @Override
            public int visit(Fruit fruit) {
                int cost = fruit.getPricePerPound() * fruit.getWeight();
                System.out.println(fruit.getName() + " cost = " + cost);
                return cost;
            }
        }

    
    
	public static void main (String[] args) throws java.lang.Exception
	{
    IElement[] items = new IElement[]{
                new Book(20, "1234"), 
                new Book(100, "5678"), // Will get a $5 discount
                new Fruit(10, 2, "Banana"), 
                new Fruit(5, 5, "Apple")
            };
    
            // Create our pricing visitor
            IVisitor visitor = new shopcardvisitor();
            
            int totalSum = 0;
            for (IElement item : items) {
                // Each item accepts the visitor and calculates its own contribution
                totalSum += item.accept(visitor);
            }
            
            System.out.println("Total Cost = " + totalSum);
	}
}
