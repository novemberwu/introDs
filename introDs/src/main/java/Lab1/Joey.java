package Lab1;

public class Joey implements Homework{
    public static void main(String[] args) {
        if (args.length != 3) {
            return;
        }
        else {
            System.out.println("Hi " + args[2] + ", " + args[1] + " and " + args[0]);
        }
    }

    public void homework(String[] args){
        if (args.length != 3) {
            return;
        }
        else {
            System.out.println("Hi " + args[2] + ", " + args[1] + " and " + args[0]);
        }

    }
}