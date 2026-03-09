package MatchEngine.cathy;

public class Order {
    public enum Type { BUY, SELL }

    private final int id;
    private final Type type;
    private final double price;
    private int quantity;

    public Order(int id, Type type, double price, int quantity) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public Type getType() { return type; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int q) { this.quantity = q; }

    @Override
    public String toString() {
        return String.format("Order{id=%d, type=%s, price=%.2f, qty=%d}", id, type, price, quantity);
    }
}