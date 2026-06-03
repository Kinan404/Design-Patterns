
class Main {
    
    public class context{
        State state;
      public void setState(State s) {
            this.state= s;
        }
    }
    public interface State {
        public void doaction(context c);
    }
    public class startstate implements State {
        public void doaction(context c){
            System.out.print("start state");
            c.setState(this);
        }
    }
    public class stopstate implements State {
        public void doaction(context c){
            System.out.print("stopState");
            c.setState(this);
        }
    }
    public static void main(String[] args) {
        context context = new context();
        startstate startState = new startstate();
        startState.doaction(context);
        
        stopstate stopState = new stopstate();
        stopState.doaction(context);


    }
}
