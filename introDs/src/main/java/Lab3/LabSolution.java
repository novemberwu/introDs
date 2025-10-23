package Lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LabSolution implements Homework{


    public static void main(String[]args){
        LabSolution solution = new LabSolution();
        Double value = solution.getFxRate("08/02/2025");
        System.out.println(value);

        solution.readFromFile("USD_CNY_FX.csv");
    }
    @Override
    public void readFromFile(String filePath) {
        Scanner sc = null;

        try {
            // initialize scanner to read from a file
            File f = new  File(filePath);
             sc =  new Scanner(f);
            // read from scanner until nothing left
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            // handle the file not found error
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException("The file value does not meet predefined format");
        }
        finally {
            // close the scanner to prevent resource leak
            if(sc != null){
                sc.close();
            }
        }

    }



    @Override
    public Double getFxRate(String date) {
        Scanner sc = null;
        Double result = null;

        try {
            // initialize scanner to read from a file
            sc = new Scanner(new File("src/main/java/Lab3/USD_CNY_FX.csv"));
            // read from scanner until nothing left
            while (sc.hasNext()) {
                String rateStr = sc.next();
                String[] values = rateStr.split(",");
                if(values.length == 2){
                    if(values[0].trim().equals(date)){
                        result  = Double.parseDouble(values[1]);
                        break;
                    }
                }else{
                    continue;
                }

            }
        } catch (FileNotFoundException e) {
            // handle the file not found error
            throw new RuntimeException(e);
        }catch (NumberFormatException e){
            throw new RuntimeException("The file value does not meet predefined format");
        }
        finally {
            // close the scanner to prevent resource leak
            if(sc != null){
                sc.close();
            }
        }
        return result;
    }
}
