package MatchEngine.qingwen;

import MatchEngine.qingwen.Order;

import java.util.*;

public class OrderBook {

    private NavigableMap<Double, Queue<Order>> bids;
    private NavigableMap<Double, Queue<Order>> asks;

    public OrderBook() {
        this.bids = new TreeMap<>(Collections.reverseOrder());
        this.asks = new TreeMap<>();
    }

    public void addOrder(Order order) {
        NavigableMap<Double, Queue<Order>> sideMap = (order.getSide().equals("BUY")) ? bids : asks;

        Queue<Order> priceLevelQueue = sideMap.computeIfAbsent(order.getPrice(), k -> new LinkedList<>());
        priceLevelQueue.add(order);
    }

    public NavigableMap<Double, Queue<Order>> getBids() {
        return bids;
    }

    public NavigableMap<Double, Queue<Order>> getAsks() {
        return asks;
    }

    public void printBook() {
        System.out.println("--- ORDER BOOK ---");

        System.out.println(" ASKS (SELL):");
        for (Map.Entry<Double, Queue<Order>> entry : asks.descendingMap().entrySet()) {
            System.out.printf("  Price: %.2f, Orders: %s\n", entry.getKey(), entry.getValue());
        }

        System.out.println(" ----------------");

        System.out.println(" BIDS (BUY):");
        for (Map.Entry<Double, Queue<Order>> entry : bids.entrySet()) {
            System.out.printf("  Price: %.2f, Orders: %s\n", entry.getKey(), entry.getValue());
        }
        System.out.println("--------------------\n");
    }
}