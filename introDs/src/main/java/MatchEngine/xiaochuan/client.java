package MatchEngine.xiaochuan;

public class client {
    public static void main(String[] args) {
        OrderBook ob = new OrderBook();
        ob.addOrder(new Order("O1", 100, 10.0, 1));
        ob.addOrder(new Order("O2", 200, 10.5, 2));
        ob.addOrder(new Order("O3", 150, 10.0, 1));
        ob.addOrder(new Order("O4", 80, 11.5, 2));

        MatchEngine me = new MatchEngine(ob);
        me.processOrders();


    }
}
