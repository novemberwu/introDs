package MatchEngine.xiaochuan;

import java.util.*;

public class OrderBook {
    private TreeMap<Double, Queue<Order>> buyOrders;
    private TreeMap<Double, Queue<Order>> sellOrders;

    public OrderBook() {
        buyOrders = new TreeMap<>(Collections.reverseOrder());
        sellOrders = new TreeMap<>();
    }

    public void addOrder(Order order) {
        if (order.getOrderType() == 1) {
            buyOrders.computeIfAbsent(order.getPrice(), k -> new LinkedList<>()).add(order);
        } else {
            sellOrders.computeIfAbsent(order.getPrice(), k -> new LinkedList<>()).add(order);
        }
    }

    public Queue<Order> getBuyOrdersAtPrice(double price) {
        return buyOrders.getOrDefault(price, new LinkedList<>());
    }

    public Queue<Order> getSellOrdersAtPrice(double price) {
        return sellOrders.getOrDefault(price, new LinkedList<>());
    }

    public Map.Entry<Double, Queue<Order>> getBestBid() {
        return buyOrders.isEmpty() ? null : buyOrders.firstEntry();
    }
    public Map.Entry<Double, Queue<Order>> getBestAsk() {
        return sellOrders.isEmpty() ? null : sellOrders.firstEntry();
    }

    public void removeBidLevel(double price) {
        buyOrders.remove(price);
    }
    public void removeAskLevel(double price) {
        sellOrders.remove(price);
    }

    public static void main(String[] args) {
        OrderBook ob = new OrderBook();
        ob.addOrder(new Order("O1", 100, 10.5, 1));
        ob.addOrder(new Order("O2", 200, 10.0, 2));
        ob.addOrder(new Order("O3", 150, 10.5, 1));
        ob.addOrder(new Order("O4", 250, 9.5, 2));



    }
}
