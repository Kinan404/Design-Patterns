

public class Templete {


public abstract class Beverage {

    // Template Method
    public final void prepareRecipe() {

        boilWater();

        addIngredients();

        pourInCup();

        serve();
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    private void serve() {
        System.out.println("Serving drink");
    }

    protected abstract void addIngredients();
}

public class Tea extends Beverage {

    @Override
    protected void addIngredients() {
        System.out.println("Adding tea leaves");
    }

}

public class Coffee extends Beverage {

    @Override
    protected void addIngredients() {
        System.out.println("Adding coffee bouder");
    }

}

        
    public void main(String[] args) {
        Tea tea = new Tea();
        
        tea.prepareRecipe();
    
    }
}
