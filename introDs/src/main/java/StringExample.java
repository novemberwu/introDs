
//j a v a j u n g l e
//0 1 2 3 4 5 6 7 8 9
public class StringExample {
    public static void main(String[] arg){
        String a = new String("javajungle");

        System.out.println(a.length()); //4
        System.out.println(a.charAt(2));// v
        System.out.println(a.substring(1,4)); // ava
        System.out.println(a.substring(1));// ava
        System.out.println(a.indexOf("j"));//0
        System.out.println(a.indexOf("vaa"));//-1
        System.out.println(a.indexOf("ava"));//1
        // 找到第二个a
        int firstAIndex = a.indexOf("a");
        int secondAIndex = a.indexOf("a", firstAIndex+1);

        System.out.println(secondAIndex);

        // 找到第二个j
        int firstIndex = a.indexOf("j");// 找到第一个j
        int secondIndex = a.indexOf("j",firstIndex+1);
        System.out.println(secondIndex);


    }
}
