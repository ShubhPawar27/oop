// Publication Class (Base Class)
class Publication {
    // Common instance variables
    String title;
    double price;
    int copies;

    // Constructor for the Publication class
    public Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    // Method to calculate sale from copies sold
    public double saleCopy() {
        return price * copies;
    }

    // Method to display details of the publication
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Price: $" + price);
        System.out.println("Copies: " + copies);
    }
}

// Book Class (Subclass of Publication)
class Book extends Publication {
    // Additional instance variable for Book
    String author;

    // Constructor for the Book class
    public Book(String title, double price, int copies, String author) {
        super(title, price, copies);  // Calling the constructor of the superclass
        this.author = author;
    }

    // Method to order more copies of the book
    public void orderCopies(int qty) {
        copies += qty;
        System.out.println(qty + " copies of '" + title + "' ordered.");
    }

    // Method to display book details
    public void display() {
        super.display();
        System.out.println("Author: " + author);
    }
}

// Magazine Class (Subclass of Publication)
class Magazine extends Publication {
    // Instance variable for Magazine
    String currentIssue;

    // Constructor for the Magazine class
    public Magazine(String title, double price, int copies, String currentIssue) {
        super(title, price, copies);  // Calling the constructor of the superclass
        this.currentIssue = currentIssue;
    }

    // Method to order more magazines (Qty)
    public void orderQty(int qty) {
        copies += qty;
        System.out.println(qty + " copies of magazine '" + title + "' ordered.");
    }

    // Method to receive a new issue of the magazine
    public void receiveIssue(String newIssue) {
        currentIssue = newIssue;
        System.out.println("New issue received: " + newIssue);
    }

    // Method to display magazine details
    public void display() {
        super.display();
        System.out.println("Current Issue: " + currentIssue);
    }
}

// Main Class to Test the Program
public class publication {
    public static void main(String[] args) {
        // Creating Book object
        Book book1 = new Book("Java Programming", 50.0, 100, "John Doe");

        // Creating Magazine object
        Magazine mag1 = new Magazine("Tech Monthly", 10.0, 200, "April 2024");

        // Display details of the Book
        System.out.println("Book Details:");
        book1.display();

        // Display details of the Magazine
        System.out.println("\nMagazine Details:");
        mag1.display();

        // Order more copies for Book and Magazine
        System.out.println("\nOrdering more copies...");
        book1.orderCopies(50);  // Order 50 more copies of the book
        mag1.orderQty(100);     // Order 100 more copies of the magazine

        // Display updated details after ordering more copies
        System.out.println("\nUpdated Book Details:");
        book1.display();

        System.out.println("\nUpdated Magazine Details:");
        mag1.display();

        // Display total sale for the Book and Magazine
        double totalSale = book1.saleCopy() + mag1.saleCopy();
        System.out.println("\nTotal Sale: $" + totalSale);
    }
}
