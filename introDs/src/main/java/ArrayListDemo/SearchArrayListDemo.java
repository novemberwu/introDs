package ArrayListDemo;

import java.util.ArrayList;
import java.util.List;

public class SearchArrayListDemo {

    public static void printSearchResult(int index, int value){
        if( index >=0)
            System.out.println("the index of " + value +" is " + index);
        else
            System.out.println("the value "+ value + " is not found");
    }

    public static void print(ArrayList<Integer> list){
        System.out.println("List is : ");
       for(Integer i : list){
           System.out.print(i);
           System.out.print(" ");
       }
       System.out.println();
    }

    public static void main(String[] args){
        Integer[] array = new Integer[]{ 11, 34, 543, 568, 98, 12};
        ArrayList<Integer> arrayList =  new ArrayList<>(List.of(array));

        int value = 4;

        int index = arrayList.indexOf(value);
        SearchArrayListDemo.printSearchResult(index, value);

        SearchArrayListDemo.print(arrayList);


        arrayList.add(2, 22);
        SearchArrayListDemo.print(arrayList);

        arrayList.remove(0);
        SearchArrayListDemo.print(arrayList);



    }
 }
