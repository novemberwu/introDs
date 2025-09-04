package Lab2;

public class RachelLab implements  Homework{

    public int max(int a, int b){

        return  (a + b + Math.abs(a - b)) / 2;

    }


    public double areaTriangle(double a, double b, double c){

        return -1;

    }
    public boolean isPalindrome(String str){
        return false;
    }


    public static void main(String[] args){
        RachelLab lab = new RachelLab();
        int result = lab.max(Integer.MAX_VALUE, Integer.MAX_VALUE-1);
        System.out.println(result);
    }
}
