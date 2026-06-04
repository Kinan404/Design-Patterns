import java.util.*;
import java.lang.*;
import java.io.*;

class Null Pointer {
    
    abstract class Customer {
        String name;
        abstract String getName();
        abstract boolean isNil();
    }
    
    public class RealCustomer extends Customer {
        public RealCustomer(String n) {
            this.name = n;
        }
        String getName(){
            return name;
        }
        boolean isNil(){
            return false;
        }
    }
    public class NullCustomer extends Customer {
        public RealCustomer(String n) {
            this.name = n;
        }
        String getName(){
            return "Get null error !";
        }
        boolean isNil(){
            return true;
        }
    }
    public class CustomerFactory {
    
        public static Customer getCustomer(String name){
    
            if(name.equals("Ali"))
                return new RealCustomer("Ali");
    
            return new NullCustomer();
        }
    }    
    
    
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{

	}
}
