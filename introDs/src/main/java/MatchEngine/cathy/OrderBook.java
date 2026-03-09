package MatchEngine.cathy;

import java.util.*;

public class OrderBook {
    private final PriorityQueue<Order> buyOrders =
            new PriorityQueue<>((a, b) -> Double.compare(b.getPrice(), a.getPrice()));
    private final PriorityQueue<Order> sellOrders =
            new PriorityQueue<>(Comparator.comparingDouble(Order::getPrice));

    public void addOrder(Order order) {
        if (order.getType() == Order.Type.BUY)
            buyOrders.add(order);
        else
            sellOrders.add(order);
    }

    public PriorityQueue<Order> getBuyOrders() { return buyOrders; }
    public PriorityQueue<Order> getSellOrders() { return sellOrders; }

    public void printOrderBook() {
        System.out.println("Buy Orders: " + buyOrders);
        System.out.println("Sell Orders: " + sellOrders);
    }
}
