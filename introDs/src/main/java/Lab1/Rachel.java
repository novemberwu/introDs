package Lab1;

public class Rachel implements Homework {


    public void homework(String[] args){
        if(args.length != 3){
            return;
        }
        String output = "Hi " + args[2] ;
        System.out.println(output);
    }
}
