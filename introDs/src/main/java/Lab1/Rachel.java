package Lab1;

public class Rachel implements Lab1Homework{


    public void homework(String[] args){
        if(args.length != 3){
            return;
        }
        String output = "Hi " + args[2] +", " + args[1] + " and " + args[0];
        System.out.println(output);
    }

    public static void main(String[] args){
        Rachel r = new Rachel();
        r.homework(args);
    }
}
