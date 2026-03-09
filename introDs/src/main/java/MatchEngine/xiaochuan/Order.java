package MatchEngine.xiaochuan;

public class Order {
    private String orderId;
    private int quantity;
    private double price;
    private int orderType; // 1: buy 2: sell

    public Order(String orderId, int quantity, double price, int orderType) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
        this.orderType = orderType;
    }

    public String getOrderId() {
        return orderId;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public int getOrderType() {
        return orderType;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }

}
