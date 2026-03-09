package MatchEngine.xuantong;

import java.util.PriorityQueue;

// ===== OrderBook Class =====
class OrderBook {
    private final PriorityQueue<Order> bids;
    private final PriorityQueue<Order> asks;

    public OrderBook() {
        // Bids: higher price first. Tie-break by orderId (FIFO)
        bids = new PriorityQueue<>((a, b) -> {
            int cmp = Double.compare(b.getPrice(), a.getPrice());
            if (cmp != 0) return cmp;
            return Long.compare(a.getOrderId(), b.getOrderId());
        });

        // Asks: lower price first. Tie-break by orderId (FIFO)
        asks = new PriorityQueue<>((a, b) -> {
            int cmp = Double.compare(a.getPrice(), b.getPrice());
            if (cmp != 0) return cmp;
            return Long.compare(a.getOrderId(), b.getOrderId());
        });
    }

    public void addOrder(Order order) {
        if (order.isMarketOrder()) {
            throw new IllegalArgumentException("Market orders cannot be added to order book");
        }
        if (order.getSide() == Order.Side.BUY) {
            bids.offer(order);
        } else {
            asks.offer(order);
        }
    }

    public PriorityQueue<Order> getBids() {
        return bids;
    }

    public PriorityQueue<Order> getAsks() {
        return asks;
    }

    public boolean hasBid() {
        return !bids.isEmpty();
    }

    public boolean hasAsk() {
        return !asks.isEmpty();
    }
}
