package Lec.ArrayListDemo;

import java.util.ArrayList;

public class Item {
    private double price;
    private String name;

    public Item (double price, String name){
        this.price = price;
        this.name = name;
    }


    public  static void main(String[] args){
        Item keyboard1 = new Item(124d, "cheap keyboard");
        Item keyboard2 = new Item(556d, "expensive keyboard");
        ArrayList<Item> list = new ArrayList<>(2);
        list.add(keyboard1);
        list.add(keyboard2);
        System.out.println("keyboard1: " + keyboard1);
        System.out.println("keyboard2: " + keyboard2);
        for(int i = 0 ; i < list.size(); i ++){
            System.out.println("list" + i + ": " +list.get(i));
        }
        System.out.println("list: "+ list);


    }
}
