package MatchEngine.youyi;

public class Order {
    public enum Type { BUY, SELL }

    private final String id;
    private final Type type;
    private double price;
    private int quantity;
    private final long timestamp;

    public Order(String id, Type type, double price, int quantity) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = System.currentTimeMillis();
    }

    public String getId() { return id; }
    public Type getType() { return type; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public long getTimestamp() { return timestamp; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return String.format("[%s] %s %.2f x %d", id, type, price, quantity);
    }
}
