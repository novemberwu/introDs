package Lec.LinkedListDemo;

public class SList {

    class IntNode {
        public int number;
        public IntNode next;

        public IntNode(int x, IntNode head) {
            this.number = x;
            this.next = head;
        }
    }

    IntNode head;

    public SList (int x ){
        this.head = new IntNode(x, null);
        this.head.number = x;
    }



    public int index(int value){
        IntNode p = this.head;
        int index = 0;
        while (p != null){
            if(p.number == value){
                break;
            }
            p = p.next;
            index++;
        }

        if(p == null) index = -1;
        return index;

    }

    public int size ( ) {
        IntNode p = head;
        int size = 0 ;
        while ( p != null) {
            size ++;
            p = p.next;
        }
        return size;
    }

    public void addFirst(int x) {
        head = new IntNode (x, head);
    }

    public void insert ( int pos, int value){
        IntNode prev = null;
        IntNode p = head;
        int cur = 0;
        while(cur < pos && p != null) {
            prev = p;
            p = p.next;
            cur ++;
        }
        if(cur < pos && p == null) throw new IndexOutOfBoundsException();
        if(prev == null){
            this.addFirst(value);
        }else{
            prev.next = new IntNode(value, p);

        }
    }

    public void traverse(){
        IntNode p = this.head;
        while(p!=null){
            System.out.print(p.number + " -");
            p = p.next;
        }
        System.out.println();
    }


    public static void main(String[] args){
        SList l = new SList(1);
        l.addFirst(2);
        l.addFirst(3);
        l.addFirst(5);
        int index = l.index(99);
        l.traverse();
        System.out.println("search 99 in the list, return : " + index);
        index = l.index(5);
        System.out.println("search 5 in the list, return : "+ index);
        index = l.index(1);
        System.out.println("search 1 in the list, return : "+ index);

        l.insert(4, 4);
        l.traverse();



    }



}


