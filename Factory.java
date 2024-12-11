// Base Car class
abstract class Car {
    protected String model;

    public Car(String model) {
        this.model = model;
    }

    // Building process methods
    public void allocateAccessories() {
        System.out.println(model + ": Accessories allocated.");
    }

    public void assembleParts() {
        System.out.println(model + ": Parts assembled.");
    }

    public void applyPaint() {
        System.out.println(model + ": Paint applied.");
    }

    public void finalMakeup() {
        System.out.println(model + ": Final makeup completed.");
    }

    // Template method to build a car
    public void buildCar() {
        allocateAccessories();
        assembleParts();
        applyPaint();
        finalMakeup();
    }
}

// Hatchback class
class Hatchback extends Car {
    public Hatchback() {
        super("Hatchback");
    }
}

// Sedan class
class Sedan extends Car {
    public Sedan() {
        super("Sedan");
    }
}

// SUV class
class SUV extends Car {
    public SUV() {
        super("SUV");
    }
}

// Car Factory class
class CarFactory {
    public static Car createCar(String type) {
        switch (type.toLowerCase()) {
            case "hatchback":
                return new Hatchback();
            case "sedan":
                return new Sedan();
            case "suv":
                return new SUV();
            default:
                throw new IllegalArgumentException("Unknown car type: " + type);
        }
    }
}

// Test Factory Pattern
public class Factory{
    public static void main(String[] args) {
        System.out.println("Factory Design Pattern - Car Building Process:");

        // Build a Hatchback
        System.out.println("\nBuilding a Hatchback:");
        Car hatchback = CarFactory.createCar("Hatchback");
        hatchback.buildCar();

        // Build a Sedan
        System.out.println("\nBuilding a Sedan:");
        Car sedan = CarFactory.createCar("Sedan");
        sedan.buildCar();

        // Build an SUV
        System.out.println("\nBuilding an SUV:");
        Car suv = CarFactory.createCar("SUV");
        suv.buildCar();
    }
}
