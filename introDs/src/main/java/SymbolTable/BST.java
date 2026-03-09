package SymbolTable;

public class BST <Key extends Comparable<Key>, Value> {
    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        public Node(Key key , Value value){
            this.key = key;
            this.val = value;
        }
    }

    private Node root;

    /** constructor**
     *
     */
    public BST(){}

    /** insert key-value into BST
     * if the key already exists, overwrite its old value with new value
     * @param key
     * @param value
     */
    public void put(Key key, Value value){
       this.root =  put(this.root, key, value);
    }

    private Node put(Node node, Key key, Value value){
        //base case
        if(node == null) node = new Node(key, value);
        else{
            //base case
            int cmp = key.compareTo(node.key);
            if( cmp == 0){
                node.val = value;
            }else if( cmp < 0){
                node.left = put(node.left,key, value);
            }else{
                node.right = put(node.right, key, value);
            }
        }


        return node;

    }

    /** get the value provide the key,return null if key does not exist
     *
     * @param key
     * @return
     */

    public Value get(Key key){
        Node x = this.root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp == 0) return x.val;
            else if (cmp < 0) x = x.left;
            else x = x.right;
        }
        return  null;
    }


    /** check whether the BST contains a key
     *
     * @param key
     * @return
     */
    public boolean contains(Key key){

        return get(key) != null;

    }

    /** remove the key- value from the BST
     *
     * @param key
     */
    public void delete(Key key){

    }

    /** check whether the BST is empty
     *
     * @return
     */
    public boolean isEmpty(){
       return this.root == null;
    }

    /** Get the largest key less than or equal to key
     *
     * @param key
     * @return
     */
    public Key floor(Key key){
        return null;
    }

    /** Get the smallest key greater than or equal to key
     *
     * @param key
     * @return
     */
    public Key ceiling(Key key){
        return null;
    }

    /** number of keys in the BST
     *
     * @return
     */
    public int size(){
        return 0;
    }

    /** number of keys less than key
     *
     * @param key
     * @return
     */
    public int rank(Key key){
        return -1;

    }

    /** key of rank k
     *
     * @param k
     * @return
     */
    public Key select(int k){
        return null;
    }
}
