package MatchEngine.linda;

public class MatchEngine {
    private final OrderBook orderBook;

    public MatchEngine(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    // Match a market order against the best available opposite side
    public void processMarketOrder(OrderBook.Order marketOrder) {
        System.out.println("\nProcessing market order: " + marketOrder);

        if (marketOrder.side == OrderBook.Order.Side.BUY) {
            matchBuyOrder(marketOrder);
        } else {
            matchSellOrder(marketOrder);
        }
    }

    private void matchBuyOrder(OrderBook.Order marketOrder) {
        while (marketOrder.quantity > 0 && orderBook.getBestSell() != null) {
            OrderBook.Order bestSell = orderBook.getBestSell();
            int tradedQty = Math.min(marketOrder.quantity, bestSell.quantity);

            System.out.printf("Trade executed: BUY %.2f x %d%n", bestSell.price, tradedQty);

            marketOrder.quantity -= tradedQty;
            bestSell.quantity -= tradedQty;

            if (bestSell.quantity == 0)
                orderBook.removeBestSell();
        }

        if (marketOrder.quantity > 0) {
            System.out.println("Unfilled quantity: " + marketOrder.quantity);
        }
    }

    private void matchSellOrder(OrderBook.Order marketOrder) {
        while (marketOrder.quantity > 0 && orderBook.getBestBuy() != null) {
            OrderBook.Order bestBuy = orderBook.getBestBuy();
            int tradedQty = Math.min(marketOrder.quantity, bestBuy.quantity);

            System.out.printf("Trade executed: SELL %.2f x %d%n", bestBuy.price, tradedQty);

            marketOrder.quantity -= tradedQty;
            bestBuy.quantity -= tradedQty;

            if (bestBuy.quantity == 0)
                orderBook.removeBestBuy();
        }

        if (marketOrder.quantity > 0) {
            System.out.println("Unfilled quantity: " + marketOrder.quantity);
        }
    }
}
