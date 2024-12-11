// Define the interface
interface Vehicle {
    void changeGear(int gear);
    void speedUp(int increment);
    void applyBrakes(int decrement);
}

// Bicycle class implementing the Vehicle interface
class Bicycle implements Vehicle {
    private int speed;
    private int gear;

    @Override
    public void changeGear(int gear) {
        this.gear = gear;
        System.out.println("Bicycle gear changed to: " + gear);
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bicycle speed increased to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.println("Bicycle speed decreased to: " + speed);
    }
}

// Bike class implementing the Vehicle interface
class Bike implements Vehicle {
    private int speed;
    private int gear;

    @Override
    public void changeGear(int gear) {
        this.gear = gear;
        System.out.println("Bike gear changed to: " + gear);
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bike speed increased to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.println("Bike speed decreased to: " + speed);
    }
}

// Car class implementing the Vehicle interface
class Car implements Vehicle {
    private int speed;
    private int gear;

    @Override
    public void changeGear(int gear) {
        this.gear = gear;
        System.out.println("Car gear changed to: " + gear);
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Car speed increased to: " + speed);
    }

    @Override
    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.println("Car speed decreased to: " + speed);
    }
}

// Main class to test the implementation
public class vehicles {
    public static void main(String[] args) {
        Vehicle bicycle = new Bicycle();
        Vehicle bike = new Bike();
        Vehicle car = new Car();

        // Test Bicycle
        System.out.println("Testing Bicycle:");
        bicycle.changeGear(2);
        bicycle.speedUp(10);
        bicycle.applyBrakes(5);

        // Test Bike
        System.out.println("\nTesting Bike:");
        bike.changeGear(3);
        bike.speedUp(20);
        bike.applyBrakes(10);

        // Test Car
        System.out.println("\nTesting Car:");
        car.changeGear(4);
        car.speedUp(40);
        car.applyBrakes(15);
    }
}
