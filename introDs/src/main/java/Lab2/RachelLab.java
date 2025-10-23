package Lab2;

public class RachelLab implements  Homework{

    public int max(int a, int b){
      long la = (long)a;
      long lb = (long)b;
      long result = (la + lb + Math.abs(la - lb)) / 2;

      int[] array = new int[300];
       System.out.println("Max is "+ result);
       return (int)result;


    }


    public double areaTriangle(String[] args){
        if (args.length < 3){
            throw new IllegalArgumentException("Invalid input. 3 arguments are expected");
        }

        Double a , b, c;
        a = Double.parseDouble(args[0]);
        b = Double.parseDouble(args[1]);
        c = Double.parseDouble(args[2]);

        boolean valid =validTriangle(a, b, c);
        //sqrt(s(s-a)(s-b)(s-c)), where s = (a + b + c) / 2.
        double s = (a + b + c)/2;
        double area = Math.sqrt(s * (s -a ) * (s-b) * (s-c));
        return area;

    }

    private boolean validTriangle(Double a, Double b, Double c) {
        return true;
    }

    public boolean isPalindrome(String str){
        if(str== null || str.length()==0)
            return true;
        String lower = str.toLowerCase();
        String normalized = lower.replaceAll("[^a-zA-Z]", "");
        int left = 0;
        int right = normalized.length()-1;
        while(left <= right){
            if(normalized.charAt(left) != normalized.charAt(right)){
                break;
            }else{
                left++;
                right--;
            }
        }
        return left > right;
    }


    public static void main(String[] args){
        RachelLab lab = new RachelLab();
        int result = lab.max(Integer.MAX_VALUE, Integer.MAX_VALUE-1);
        System.out.println(result);
    }
}
