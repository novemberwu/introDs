package Lab1;

public class Homework1 {
    public static void main(String[] args) {
        // Check if exactly 2 arguments are provided
        if (args.length != 2) {
            System.out.println("Error: Please provide exactly 2 integer arguments");
            System.out.println("Usage: java Homework <integer1> <integer2>");
            return;
        }
        
        try {
            // Parse the two integer arguments
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            
            // Check if the integers can be evenly divided
            boolean canDivideEvenly = canEvenlyDivide(num1, num2);
            
            // Print the result
            System.out.println(canDivideEvenly);
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Please provide valid integer arguments");
            System.out.println("Usage: java Homework <integer1> <integer2>");
        }
    }
    
    /**
     * Determines if two integers can be evenly divided
     * @param dividend the number to be divided
     * @param divisor the number to divide by
     * @return true if dividend can be evenly divided by divisor, false otherwise
     */
    public static boolean canEvenlyDivide(int dividend, int divisor) {
        // Check for division by zero
        if (divisor == 0) {
            return false;
        }
        
        // Check if the division results in no remainder
        return dividend % divisor == 0;
    }
    
    // Interface method implementation (if needed for lab structure)
    public void homework(String[] args) {
        main(args);
    }
}
