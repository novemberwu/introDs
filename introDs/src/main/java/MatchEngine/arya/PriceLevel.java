package MatchEngine.arya;

import java.util.ArrayDeque;
import java.util.Deque;

public class PriceLevel {
    public double price;
    public Deque<Order> orders = new ArrayDeque<>();
    PriceLevel(double p){price=p;}
}
