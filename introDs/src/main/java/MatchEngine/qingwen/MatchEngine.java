package MatchEngine.qingwen;

import java.util.*;

public class MatchEngine {

    private OrderBook orderBook;

    public MatchEngine(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public void processMarketOrder(String incomingSide, long incomingQuantity) {
        if (incomingSide.equals("BUY")) {
            match(orderBook.getAsks(), incomingSide, incomingQuantity);
        } else {
            match(orderBook.getBids(), incomingSide, incomingQuantity);
        }
    }

    private void match(NavigableMap<Double, Queue<Order>> bookSide, String incomingSide, long incomingQuantity) {

        Iterator<Map.Entry<Double, Queue<Order>>> iterator = bookSide.entrySet().iterator();

        while (incomingQuantity > 0 && iterator.hasNext()) {
            Map.Entry<Double, Queue<Order>> bestPriceLevel = iterator.next();
            double price = bestPriceLevel.getKey();
            Queue<Order> ordersAtPrice = bestPriceLevel.getValue();

            while (incomingQuantity > 0 && !ordersAtPrice.isEmpty()) {
                Order restingOrder = ordersAtPrice.peek();
                long restingQuantity = restingOrder.getQuantity();

                if (incomingQuantity < restingQuantity) {
                    System.out.printf("  MATCH: Filled %d of %s at %.2f (from %s)\n",
                            incomingQuantity, incomingSide, price, restingOrder.getOrderId());

                    restingOrder.setQuantity(restingQuantity - incomingQuantity);
                    incomingQuantity = 0;

                } else {
                    System.out.printf("  MATCH: Filled %d of %s at %.2f (wiping %s)\n",
                            restingQuantity, incomingSide, price, restingOrder.getOrderId());

                    incomingQuantity -= restingQuantity;
                    ordersAtPrice.poll();
                }
            }

            if (ordersAtPrice.isEmpty()) {
                iterator.remove();
            }
        }

        if (incomingQuantity > 0) {
            System.out.printf("  WARNING: Market %s order partially unfilled. %d quantity remaining.\n",
                    incomingSide, incomingQuantity);
        }
    }
}