package MatchEngine.arya;

import MatchEngine.arya.Order;
import MatchEngine.arya.OrderBook;








public class MatchEngine {
    OrderBook book=new OrderBook();

    void process(Order o){
        if(o.type==Order.Type.BUY){
            while(o.qty>0 && book.bestSell()!=null && book.bestSell().price<=o.price){
                Order s=book.bestSell().orders.peek();
                int t=Math.min(o.qty,s.qty);
                o.qty-=t; s.qty-=t;
                if(s.qty==0) book.bestSell().orders.poll();
                book.clean(book.sells);
            }
            if(o.qty>0) book.add(o);
        } else {
            while(o.qty>0 && book.bestBuy()!=null && book.bestBuy().price>=o.price){
                Order b=book.bestBuy().orders.peek();
                int t=Math.min(o.qty,b.qty);
                o.qty-=t; b.qty-=t;
                if(b.qty==0) book.bestBuy().orders.poll();
                book.clean(book.buys);
            }
            if(o.qty>0) book.add(o);
        }
    }
}



