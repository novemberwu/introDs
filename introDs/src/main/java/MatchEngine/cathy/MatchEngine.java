package MatchEngine.cathy;

public class MatchEngine {
    private final OrderBook orderBook;

    public MatchEngine(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public void processMarketOrder(Order marketOrder) {
        if (marketOrder.getType() == Order.Type.BUY) {
            matchBuyOrder(marketOrder);
        } else {
            matchSellOrder(marketOrder);
        }
    }

    private void matchBuyOrder(Order buyOrder) {
        var sellOrders = orderBook.getSellOrders();

        while (!sellOrders.isEmpty() && buyOrder.getQuantity() > 0) {
            Order bestSell = sellOrders.peek();
            // BUY can only happen if price >= best sell
            if (buyOrder.getPrice() >= bestSell.getPrice()) {
                int tradeQty = Math.min(buyOrder.getQuantity(), bestSell.getQuantity());
                System.out.printf("TRADE: BUY %d @ %.2f%n", tradeQty, bestSell.getPrice());

                buyOrder.setQuantity(buyOrder.getQuantity() - tradeQty);
                bestSell.setQuantity(bestSell.getQuantity() - tradeQty);

                if (bestSell.getQuantity() == 0) sellOrders.poll();
            } else {
                break;
            }
        }

        if (buyOrder.getQuantity() > 0)
            orderBook.addOrder(buyOrder);
    }

    private void matchSellOrder(Order sellOrder) {
        var buyOrders = orderBook.getBuyOrders();

        while (!buyOrders.isEmpty() && sellOrder.getQuantity() > 0) {
            Order bestBuy = buyOrders.peek();
            if (sellOrder.getPrice() <= bestBuy.getPrice()) {
                int tradeQty = Math.min(sellOrder.getQuantity(), bestBuy.getQuantity());
                System.out.printf("TRADE: SELL %d @ %.2f%n", tradeQty, bestBuy.getPrice());

                sellOrder.setQuantity(sellOrder.getQuantity() - tradeQty);
                bestBuy.setQuantity(bestBuy.getQuantity() - tradeQty);

                if (bestBuy.getQuantity() == 0) buyOrders.poll();
            } else {
                break;
            }
        }

        if (sellOrder.getQuantity() > 0)
            orderBook.addOrder(sellOrder);
    }
}
