package Lec.ArrayListDemo;

import java.util.ArrayList;

public class MyArrayList {
    private ArrayList<Integer> data ;

    public MyArrayList(int capacity){
        data = new ArrayList<>(capacity);
    }
}
