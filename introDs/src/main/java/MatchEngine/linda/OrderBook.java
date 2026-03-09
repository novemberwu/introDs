package MatchEngine.linda;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderBook {
    private final PriorityQueue<Order> buyOrders;  // Max-heap for buys
    private final PriorityQueue<Order> sellOrders; // Min-heap for sells

    public OrderBook() {
        buyOrders = new PriorityQueue<>((a, b) -> Double.compare(b.price, a.price)); // highest first
        sellOrders = new PriorityQueue<>(Comparator.comparingDouble(a -> a.price));  // lowest first
    }

    public void addOrder(Order order) {
        if (order.side == Order.Side.BUY) {
            buyOrders.add(order);
        } else {
            sellOrders.add(order);
        }
    }

    public Order getBestBuy() {
        return buyOrders.peek();
    }

    public Order getBestSell() {
        return sellOrders.peek();
    }

    public void removeBestBuy() {
        buyOrders.poll();
    }

    public void removeBestSell() {
        sellOrders.poll();
    }

    public void printOrderBook() {
        System.out.println("=== BUY ORDERS ===");
        buyOrders.forEach(System.out::println);
        System.out.println("=== SELL ORDERS ===");
        sellOrders.forEach(System.out::println);
    }

    // Inner class for simplicity
    public static class Order {
        enum Side {BUY, SELL}

        String id;
        Side side;
        double price;
        int quantity;

        public Order(String id, Side side, double price, int quantity) {
            this.id = id;
            this.side = side;
            this.price = price;
            this.quantity = quantity;
        }

        public String toString() {
            return String.format("[%s] %s %.2f x %d", id, side, price, quantity);
        }
    }
}
