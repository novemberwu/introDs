package SymbolTable;

public class BST <Key extends Comparable<Key>, Value> {
    private  class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public BST(){}
    public void put(Key key, Value value){

        put(root, key,value);

    }

    private Node put(Node node , Key key, Value value){
        if( node == null) node = new Node(key, value);

        int cmp = key.compareTo(node.key);
        if(cmp == 0) node.value = value;
        else if( cmp < 0) put(node.left, key,value);
        else put (node.right, key,value);
        return node;
    }

    public Value get(Key key){
        Node x = root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp == 0) return x.value;
            else if(cmp < 0 ) x = x.left;
            else x = x.right;

        }
        return null;
    }



    public boolean contains(Key key){

        return get(key) != null;

    }
    public void delete(Key key){

    }

    public boolean isEmpty(){
        return root == null;
    }
}
