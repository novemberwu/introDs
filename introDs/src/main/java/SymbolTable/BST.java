package SymbolTable;

public class BST <Key extends Comparable<Key>, Value> {


    public BST(){}
    public void put(Key key, Value value){


    }



    public Value get(Key key){
        return  null;
    }



    public boolean contains(Key key){

        return get(key) != null;

    }
    public void delete(Key key){

    }

    public boolean isEmpty(){
       return false;
    }

    public Key floor(Key key){
        return null;
    }

    public Key ceiling(Key key){
        return null;
    }

    public int size(){
        return 0;
    }

    public int rank(Key key){
        return -1;

    }

    public Key select(int k){
        return null;
    }
}
