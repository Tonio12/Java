public class Car {
    protected String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine(){
        System.out.println("Engine Started");
    }

    public void drive(){
        runEngine();
        System.out.println("Drive Mode activated");
        System.out.println("Car -> Driving, type is "+ getClass().getSimpleName());
    }

    public void runEngine(){
        System.out.println("Engine Is Running");
    }
}
