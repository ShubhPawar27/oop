class Complex {
    // Data members to store the real and imaginary parts
    private double real;
    private double imaginary;

    // Default constructor
    public Complex() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    // Parameterized constructor
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to add two complex numbers
    public Complex add(Complex other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    // Method to subtract two complex numbers
    public Complex subtract(Complex other) {
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    // Method to display the complex number in a readable form
    public void display() {
        System.out.println(this.real + " + " + this.imaginary + "i");
    }

    // Main method to demonstrate the operations
    public static void main(String[] args) {
        // Creating two complex numbers
        Complex num1 = new Complex(2.5, 3.5);
        Complex num2 = new Complex(1.5, 2.0);

        // Adding the two complex numbers
        Complex sum = num1.add(num2);
        System.out.print("Sum: ");
        sum.display();

        // Subtracting the two complex numbers
        Complex difference = num1.subtract(num2);
        System.out.print("Difference: ");
        difference.display();
    }
}

