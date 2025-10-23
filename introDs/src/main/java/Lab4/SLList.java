package Lab4;

public class SLList {
    static private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;
    private int size;

    public SLList(int x) {
        this.first = new IntNode(x, null);
    }

    public void addFirst(int x) {
        /*TODO 1*/
    }

    public int getFirst() {
        /*TODO 2*/
        return -1;
    }

    public int size() {
        /*TODO 3*/
        return -1;
    }

    public void addLast(int x) {
        /*TODO 4*/
    }





    public int size2(){
        return  size2Iml(this.first);

    }
    private int size2Iml(IntNode l){
        if(l.next == null) return 1;

        return size2Iml(l.next)+1;

    }







    // java visualization
    // https://cscircles.cemc.uwaterloo.ca/java_visualize/#code=public+class+SLList+%7B%0A++++static+private+class+IntNode+%7B%0A++++++++public+int+item%3B%0A++++++++public+IntNode+next%3B%0A%0A++++++++public++IntNode(int+item,+IntNode+next)%7B%0A++++++++++++this.item+%3D+item%3B%0A++++++++++++this.next+%3D+next%3B%0A++++++++%7D%0A++++%7D%0A++++private+IntNode+first%3B%0A++++private+int+size+%3B%0A++++public+SLList(int+x)%7B%0A++++++++this.first+%3D+new+IntNode(x,+null)%3B%0A++++++++size+%3D1%3B%0A%0A++++%7D%0A%0A++++public+void+addFirst(int+x)%7B%0A++++++++size+%2B%3D1%3B%0A++++++++this.first+%3D+new+IntNode(x,+this.first)%3B%0A++++%7D%0A%0A++++//+size%0A++++public+int+size()%7B%0A++++++++return+size%3B%0A%0A++++%7D%0A%0A++++public+int+size2()%7B%0A++++++++return++size2Iml(this.first)%3B%0A%0A++++%7D%0A++++private+int+size2Iml(IntNode+l)%7B%0A++++++++if(l.next+%3D%3D+null)+return+1%3B%0A%0A++++++++return+size2Iml(l.next)%2B1%3B%0A%0A++++%7D%0A+++public+int+getFirst()%7B%0A++++++++return+this.first.item%3B%0A%0A++++%7D%0A+++public+static+void+main(String%5B%5D+args)%7B%0A++++++++SLList+s+%3D+new+SLList(10)%3B%0A%0A++++++++System.out.println(%22First+item%3A%22%2Bs.getFirst())%3B%0A%0A++++++++//s.addLast(15)%3B%0A%0A++++++++System.out.println(%22First+item%3A%22%2Bs.getFirst())%3B%0A%0A++++++++s.addFirst(5)%3B%0A%0A++++++++System.out.println(s.size())%3B%0A%0A%0A++++%7D%0A%7D&mode=display&curInstr=39
    public static void main(String[] args){
        SLList s = new SLList(10);

        System.out.println("First item:"+s.getFirst());

        s.addLast(15);

        System.out.println("First item:"+s.getFirst());

        s.addFirst(5);

        System.out.println(s.size());


    }
}
