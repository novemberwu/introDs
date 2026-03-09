package MatchEngine.qingwen;

public class Order {
    private String orderId;
    private String side;
    private long quantity;
    private double price;
    private long timestamp;

    public Order(String orderId, String side, long quantity, double price) {
        if (!side.equals("BUY") && !side.equals("SELL")) {
            throw new IllegalArgumentException("Side must be \"BUY\" or \"SELL\"");
        }
        this.orderId = orderId;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.timestamp = System.nanoTime();
    }

    public String getOrderId() { return orderId; }
    public String getSide() { return side; }
    public long getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public long getTimestamp() { return timestamp; }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("[ID: %s, Q: %d, P: %.2f]", orderId, quantity, price);
    }
}