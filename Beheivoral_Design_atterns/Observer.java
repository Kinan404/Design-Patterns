

public class Observer {
    
 public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    int state;
    void setState(int s) {
        this.state = s;
        notefyAllObservers(state);
    }
    void notefyAllObservers(int s){
        for(Observer o : observers) {
            o.update(s);
        }
    }
    void attach(Observer o) {
        observers.add(o); 
    }
    
    
 }   
public abstract class Observer {
    public Subject s;
    public void abstract update();
    
    
}
    public class BinaryObserver extends Observer {
        public BinaryObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }
        @Override
        public void update() {
            System.out.println( "Binary String: " + 
            Integer.toBinaryString( subject.getState() ) ); 
    }
    }
    
    
    
    
    
    
    
  public static void main(String args[]) {
    System.out.println("Sum of x+y = " + z);
  }
}
