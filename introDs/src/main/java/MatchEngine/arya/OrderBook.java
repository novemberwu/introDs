package MatchEngine.arya;

import java.util.ArrayList;
import java.util.List;

public class OrderBook {
    public List<PriceLevel> buys = new ArrayList<>();
    public List<PriceLevel> sells = new ArrayList<>();

    public void add(Order o){
        List<PriceLevel> list = o.type==Order.Type.BUY?buys:sells;
        int idx = find(list,o.price,o.type==Order.Type.BUY);
        PriceLevel lvl;
        if(idx<list.size() && list.get(idx).price==o.price) lvl=list.get(idx);
        else {lvl=new PriceLevel(o.price); list.add(idx,lvl);}
        lvl.orders.add(o);
    }

    int find(List<PriceLevel> list,double p,boolean buy){
        int l=0,r=list.size();
        while(l<r){
            int m=(l+r)/2;
            if((buy?list.get(m).price>p:list.get(m).price<p)) l=m+1;
            else r=m;
        }
        return l;
    }

    public PriceLevel bestBuy(){return buys.isEmpty()?null:buys.get(0);}
    public PriceLevel bestSell(){return sells.isEmpty()?null:sells.get(0);}
    public void clean(List<PriceLevel> list){if(!list.isEmpty()&&list.get(0).orders.isEmpty())list.remove(0);}
}