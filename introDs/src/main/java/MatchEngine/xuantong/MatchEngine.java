package MatchEngine.xuantong;

import java.util.ArrayList;
import java.util.List;

// ===== MatchEngine Class =====
class MatchEngine {
    private final OrderBook orderBook;
    private long nextOrderId = 1;

    public MatchEngine() {
        this.orderBook = new OrderBook();
    }

    public List<String> submitOrder(Order.Side side, int quantity, double price) {
        List<String> executions = new ArrayList<>();
        Order order = new Order(nextOrderId++, side, quantity, price);

        if (order.isMarketOrder()) {
            executeMarketOrder(order, executions);
        } else {
            orderBook.addOrder(order);
        }
        return executions;
    }

    private void executeMarketOrder(Order marketOrder, List<String> executions) {
        if (marketOrder.getSide() == Order.Side.BUY) {
            while (marketOrder.getQuantity() > 0 && orderBook.hasAsk()) {
                Order bestAsk = orderBook.getAsks().peek();
                if (bestAsk == null) break;

                int matchedQty = Math.min(marketOrder.getQuantity(), bestAsk.getQuantity());
                executions.add("MATCH: Buy " + matchedQty + " @ " + bestAsk.getPrice() +
                        " with Order ID " + bestAsk.getOrderId());

                marketOrder.reduceQuantity(matchedQty);
                bestAsk.reduceQuantity(matchedQty);

                if (bestAsk.getQuantity() == 0) {
                    orderBook.getAsks().poll();
                }
            }
            if (marketOrder.getQuantity() > 0) {
                executions.add("UNFILLED: Market buy order remaining: " + marketOrder.getQuantity());
            }

        } else if (marketOrder.getSide() == Order.Side.SELL) {
            while (marketOrder.getQuantity() > 0 && orderBook.hasBid()) {
               Order bestBid = orderBook.getBids().peek();
                if (bestBid == null) break;

                int matchedQty = Math.min(marketOrder.getQuantity(), bestBid.getQuantity());
                executions.add("MATCH: Sell " + matchedQty + " @ " + bestBid.getPrice() +
                        " with Order ID " + bestBid.getOrderId());

                marketOrder.reduceQuantity(matchedQty);
                bestBid.reduceQuantity(matchedQty);

                if (bestBid.getQuantity() == 0) {
                    orderBook.getBids().poll();
                }
            }
            if (marketOrder.getQuantity() > 0) {
                executions.add("UNFILLED: Market sell order remaining: " + marketOrder.getQuantity());
            }
        }
    }
}
