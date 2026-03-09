package MatchEngine.xuantong;



// ===== Order Class =====
class Order {
    public enum Side { BUY, SELL }

    private final long orderId;
    private final Side side;
    private int quantity;
    private final double price; // -1.0 indicates market order

    public Order(long orderId, Side side, int quantity, double price) {
        this.orderId = orderId;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
    }

    public long getOrderId() { return orderId; }
    public Side getSide() { return side; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public boolean isMarketOrder() {
        return price == -1.0;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", side=" + side +
                ", quantity=" + quantity +
                ", price=" + (isMarketOrder() ? "MARKET" : price) +
                '}';
    }
}

