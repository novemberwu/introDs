package MatchEngine.qingwen;

public class Testclient {

    public static void main(String[] args) {
        OrderBook book = new OrderBook();
        MatchEngine engine = new MatchEngine(book);

        System.out.println("--- Seeding Order Book ---");

        book.addOrder(new Order("S1", "SELL", 100, 101.00));
        book.addOrder(new Order("S2", "SELL", 75, 102.00));
        book.addOrder(new Order("S3", "SELL", 50, 101.00));

        book.addOrder(new Order("B1", "BUY", 100, 100.00));
        book.addOrder(new Order("B2", "BUY", 25, 99.00));
        book.addOrder(new Order("B3", "BUY", 150, 100.00));

        book.printBook();

        System.out.println(">>> Processing Market BUY order for 175 shares...");
        engine.processMarketOrder("BUY", 175);

        book.printBook();

        System.out.println(">>> Processing Market SELL order for 125 shares...");
        engine.processMarketOrder("SELL", 125);

        book.printBook();
    }
}