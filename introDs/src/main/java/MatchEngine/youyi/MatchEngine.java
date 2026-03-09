package MatchEngine.youyi;

public class MatchEngine {
    private final OrderBook orderBook;

    public MatchEngine(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public void match(Order marketOrder) {
        System.out.println("\nIncoming Market Order: " + marketOrder);

        if (marketOrder.getType() == Order.Type.BUY) {
            matchBuyOrder(marketOrder);
        } else {
            matchSellOrder(marketOrder);
        }
    }

    private void matchBuyOrder(Order buyOrder) {
        var sellOrders = orderBook.getSellOrders();

        while (buyOrder.getQuantity() > 0 && !sellOrders.isEmpty()) {
            Order bestSell = sellOrders.peek();
            if (bestSell.getPrice() > buyOrder.getPrice()) break;

            int tradedQty = Math.min(buyOrder.getQuantity(), bestSell.getQuantity());
            System.out.println("Matched: BUY " + tradedQty + " @ " + bestSell.getPrice());

            buyOrder.setQuantity(buyOrder.getQuantity() - tradedQty);
            bestSell.setQuantity(bestSell.getQuantity() - tradedQty);

            if (bestSell.getQuantity() == 0) sellOrders.poll();
        }

        if (buyOrder.getQuantity() > 0) {
            System.out.println("Unfilled buy quantity: " + buyOrder.getQuantity());
            orderBook.addOrder(buyOrder);
        }
    }

    private void matchSellOrder(Order sellOrder) {
        var buyOrders = orderBook.getBuyOrders();

        while (sellOrder.getQuantity() > 0 && !buyOrders.isEmpty()) {
            Order bestBuy = buyOrders.peek();
            if (bestBuy.getPrice() < sellOrder.getPrice()) break;

            int tradedQty = Math.min(sellOrder.getQuantity(), bestBuy.getQuantity());
            System.out.println("Matched: SELL " + tradedQty + " @ " + bestBuy.getPrice());

            sellOrder.setQuantity(sellOrder.getQuantity() - tradedQty);
            bestBuy.setQuantity(bestBuy.getQuantity() - tradedQty);

            if (bestBuy.getQuantity() == 0) buyOrders.poll();
        }

        if (sellOrder.getQuantity() > 0) {
            System.out.println("Unfilled sell quantity: " + sellOrder.getQuantity());
            orderBook.addOrder(sellOrder);
        }
    }
}
