package MatchEngine.youyi;


import java.util.*;

public class OrderBook {
    // Highest buy first, lowest sell first
    private final PriorityQueue<Order> buyOrders;
    private final PriorityQueue<Order> sellOrders;

    public OrderBook() {
        buyOrders = new PriorityQueue<>((a, b) -> Double.compare(b.getPrice(), a.getPrice()));
        sellOrders = new PriorityQueue<>(Comparator.comparingDouble(Order::getPrice));
    }

    public void addOrder(Order order) {
        if (order.getType() == Order.Type.BUY) {
            buyOrders.add(order);
        } else {
            sellOrders.add(order);
        }
    }

    public PriorityQueue<Order> getBuyOrders() { return buyOrders; }
    public PriorityQueue<Order> getSellOrders() { return sellOrders; }

    public void printBook() {
        System.out.println("=== Order Book ===");
        System.out.println("Buy Orders:");
        buyOrders.forEach(System.out::println);
        System.out.println("Sell Orders:");
        sellOrders.forEach(System.out::println);
        System.out.println("==================");
    }
}
