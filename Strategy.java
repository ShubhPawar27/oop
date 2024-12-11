// Payment Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Credit Card Payment Strategy
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card (Card Holder: " + cardHolderName + ").");
    }
}

// PayPal Payment Strategy
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal (Email: " + email + ").");
    }
}

// Bitcoin Payment Strategy
class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Bitcoin (Wallet: " + walletAddress + ").");
    }
}

// Shopping Cart Item
class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

// Shopping Cart
class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public void pay(PaymentStrategy paymentMethod) {
        double totalAmount = calculateTotal();
        paymentMethod.pay(totalAmount);
    }
}

// Main Class to Test Strategy Pattern
public class Strategy {
    public static void main(String[] args) {
        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add items to the cart
        cart.addItem(new Item("Book", 500));
        cart.addItem(new Item("Pen", 50));
        cart.addItem(new Item("Notebook", 300));

        // Calculate total and pay using Credit Card
        System.out.println("Total Amount: " + cart.calculateTotal());
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        cart.pay(creditCardPayment);

        // Pay using PayPal
        PaymentStrategy paypalPayment = new PayPalPayment("johndoe@example.com");
        cart.pay(paypalPayment);

        // Pay using Bitcoin
        PaymentStrategy bitcoinPayment = new BitcoinPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
        cart.pay(bitcoinPayment);
    }
}

