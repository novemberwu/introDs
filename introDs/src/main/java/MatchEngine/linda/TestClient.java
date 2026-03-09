package MatchEngine.linda;

import MatchEngine.linda.MatchEngine;
import MatchEngine.linda.OrderBook;

public class TestClient {
    public static void main(String[] args) {
        OrderBook orderBook = new OrderBook();
        MatchEngine engine = new MatchEngine(orderBook);

        // Add sample limit orders
        orderBook.addOrder(new OrderBook.Order("S1", OrderBook.Order.Side.SELL, 101.0, 50));
        orderBook.addOrder(new OrderBook.Order("S2", OrderBook.Order.Side.SELL, 103.0, 30));
        orderBook.addOrder(new OrderBook.Order("B1", OrderBook.Order.Side.BUY, 99.0, 40));
        orderBook.addOrder(new OrderBook.Order("B2", OrderBook.Order.Side.BUY, 98.0, 60));

        System.out.println("Initial order book:");
        orderBook.printOrderBook();

        // Send a market BUY order (should hit sells)
        engine.processMarketOrder(new OrderBook.Order("MKT1", OrderBook.Order.Side.BUY, 0.0, 60));

        System.out.println("\nOrder book after market buy:");
        orderBook.printOrderBook();

        // Send a market SELL order (should hit buys)
        engine.processMarketOrder(new OrderBook.Order("MKT2", OrderBook.Order.Side.SELL, 0.0, 70));

        System.out.println("\nOrder book after market sell:");
        orderBook.printOrderBook();
    }
}
