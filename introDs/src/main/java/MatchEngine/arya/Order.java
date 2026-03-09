package MatchEngine.arya;

public class Order {
    public  enum Type { BUY, SELL }
    public Type type;
    public double price;
    public int qty;
    Order(Type t, double p, int q) { type=t; price=p; qty=q; }
}
