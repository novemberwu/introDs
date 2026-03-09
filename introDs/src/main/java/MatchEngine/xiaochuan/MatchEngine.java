package MatchEngine.xiaochuan;

import java.util.Map;
import java.util.Queue;

public class MatchEngine {
    private OrderBook orders;
    double lastTradedPrice;
    public MatchEngine(OrderBook orders){
        this.orders = orders;
    }

    public void processOrders() {
        while (true) {
            Map.Entry<Double, Queue<Order>> bestBidEntry = orders.getBestBid();
            Map.Entry<Double, Queue<Order>> bestAskEntry = orders.getBestAsk();
            if (bestBidEntry == null || bestAskEntry == null) break;

            double bestBidPrice = bestBidEntry.getKey();
            double bestAskPrice = bestAskEntry.getKey();

            if (bestBidPrice < bestAskPrice) break;

            Queue<Order> bidQ = bestBidEntry.getValue();
            Queue<Order> askQ = bestAskEntry.getValue();

            Order buyOrder = bidQ.peek();
            Order sellOrder = askQ.peek();
            if (buyOrder == null) { orders.removeBidLevel(bestBidPrice); continue; }
            if (sellOrder == null) { orders.removeAskLevel(bestAskPrice); continue; }

            int tradeQuantity = Math.min(buyOrder.getQuantity(), sellOrder.getQuantity());
            double execPrice = sellOrder.getPrice();
            lastTradedPrice = execPrice;
            System.out.println("Exec " + tradeQuantity + " u at p " + execPrice
                    + " (buy: " + buyOrder.getOrderId() + " sell: " + sellOrder.getOrderId() + ")");

            int buyRemain = buyOrder.getQuantity() - tradeQuantity;
            int sellRemain = sellOrder.getQuantity() - tradeQuantity;

            if (buyRemain == 0) {
                bidQ.poll();
            } else {
                buyOrder.setQuantity(buyRemain);
            }

            if (sellRemain == 0) {
                askQ.poll();
            } else {
                sellOrder.setQuantity(sellRemain);
            }

            if (bidQ.isEmpty()) {
                orders.removeBidLevel(bestBidPrice);
            }
            if (askQ.isEmpty()) {
                orders.removeAskLevel(bestAskPrice);
            }
        }
    }

    public double getPrice(){
        return lastTradedPrice;
    }


}
