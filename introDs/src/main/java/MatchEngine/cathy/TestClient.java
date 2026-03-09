package MatchEngine.cathy;

public class TestClient {
    public static void main(String[] args) {
        OrderBook book = new OrderBook();
        MatchEngine engine = new MatchEngine(book);

        book.addOrder(new Order(1, Order.Type.SELL, 100.0, 5));
        book.addOrder(new Order(2, Order.Type.SELL, 101.0, 5));
        book.addOrder(new Order(3, Order.Type.BUY, 99.0, 5));

        System.out.println("=== Initial Order Book ===");
        book.printOrderBook();

        System.out.println("\n=== New BUY order (price=102, qty=8) ===");
        engine.processMarketOrder(new Order(4, Order.Type.BUY, 102.0, 8));

        System.out.println("\n=== Final Order Book ===");
        book.printOrderBook();
    }
}
