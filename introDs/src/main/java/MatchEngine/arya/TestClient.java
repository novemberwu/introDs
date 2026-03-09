package MatchEngine.arya;

public class TestClient {
    public static void main(String[] a){
        MatchEngine e=new MatchEngine();
        e.book.add(new Order(Order.Type.SELL,100,5));
        e.book.add(new Order(Order.Type.SELL,101,3));
        e.book.add(new Order(Order.Type.BUY,99,4));
        e.book.add(new Order(Order.Type.BUY,98,2));
        e.process(new Order(Order.Type.BUY,101,6));
    }
}
