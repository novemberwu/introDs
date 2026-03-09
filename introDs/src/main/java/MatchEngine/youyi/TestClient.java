package MatchEngine.youyi;

public class TestClient {
    public static void main(String[] args) {
        OrderBook book = new OrderBook();
        MatchEngine engine = new MatchEngine(book);

        // Add some existing limit orders
        book.addOrder(new Order("S1", Order.Type.SELL, 101.0, 5));
        book.addOrder(new Order("S2", Order.Type.SELL, 102.0, 10));
        book.addOrder(new Order("S3", Order.Type.SELL, 101.0, 5));

        book.addOrder(new Order("B1", Order.Type.BUY, 99.0, 8));
        book.addOrder(new Order("B2", Order.Type.BUY, 98.5, 6));

        book.printBook();

        // Incoming market order
        Order marketBuy = new Order("M1", Order.Type.BUY, 102.0, 8);
        engine.match(marketBuy);

        book.printBook();

        // Another one
        Order marketSell = new Order("M2", Order.Type.SELL, 99.0, 10);
        engine.match(marketSell);

        book.printBook();
    }
}
