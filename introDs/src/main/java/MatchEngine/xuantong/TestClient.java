package MatchEngine.xuantong;

import java.util.List;

// ===== TestClient (Main Class) =====
public class TestClient {
    public static void main(String[] args) {
        MatchEngine engine = new MatchEngine();

        // Add limit orders to populate the book
        System.out.println("Adding limit orders to order book...");
        engine.submitOrder(Order.Side.SELL, 10, 100.0);  // Order ID 1
        engine.submitOrder(Order.Side.SELL, 5, 101.0);   // Order ID 2
        engine.submitOrder(Order.Side.BUY, 8, 99.0);     // Order ID 3
        engine.submitOrder(Order.Side.BUY, 15, 98.5);    // Order ID 4

        System.out.println("\n--- Submitting MARKET BUY order for 12 shares ---");
        List<String> results1 = engine.submitOrder(Order.Side.BUY, 12, -1.0);
        results1.forEach(System.out::println);

        System.out.println("\n--- Submitting MARKET SELL order for 20 shares ---");
        List<String> results2 = engine.submitOrder(Order.Side.SELL, 20, -1.0);
        results2.forEach(System.out::println);
    }
}
