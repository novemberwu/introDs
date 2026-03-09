package Tools;

import java.io.File;
import java.util.*;

public class APClassRoomTools {


    private  List<String> files = new ArrayList<>();

    private int[] nameCol = new int[]{4, 5};
    private int earnedCol = 7;
    private int possibleCol = 8;

    private Map<String, Double> scores = new HashMap<>();
    private Map<String , Double > total = new HashMap<>();

    public void printScores(){
        Object[] names = scores.keySet().toArray();
        Arrays.sort(names);

        for(Object name: names){
            System.out.print("\n"+name+ " ");
            System.out.println(scores.get(name.toString()) + " / " + total.get(name) );

        }
    }
    public void calc()throws Exception{
        File f ;

        for(String filePath: files){
            f =  new File(filePath);
            Scanner scanner = new Scanner(f);
            boolean firstLine = true;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(firstLine){
                    firstLine = false;
                    continue;
                }
                String[] cols = line.split(",");
                String name = cols[nameCol[0]] + cols[nameCol[1]];
                System.out.println(name);
                if(!scores.containsKey(name)){
                    scores.put(name, 0.0);
                    total.put(name, 0.0);
                }

                String earned = cols[earnedCol];
                String possible = cols[possibleCol];
                earned = earned.replaceAll("\"", "");
                possible = possible.replaceAll("\"", "");
                //System.out.println("earned: "+ earned +" /possible:" + possible);
                Double earnedPoint = Double.parseDouble(earned);
                Double possiblePoint = Double.parseDouble(possible);
                //System.out.println("earned: "+ earnedPoint +" /possible:" + possiblePoint);

                scores.put(name, scores.get(name)+earnedPoint);
                total.put(name, total.get(name)+possiblePoint);



            }

            scanner.close();
        }

    }
    public APClassRoomTools(List<String> files){

        this.files = files;


    }


    public static void main(String[] args) throws Exception {
        String path ="AP Computer Science A Student Matrix Report for G10_CSA_wuyuan 2025-12-03 16_23_00+08_00.csv";
        String path1 = "AP Computer Science A Student Matrix Report for G10_CSA_wuyuan 2025-12-03 16_22_00+08_00.csv";
        //String path2 = "AP Computer Science A Student Matrix Report for G10_CSA_wuyuan 2025-10-21 10_04_00+08_00.csv";
        List<String> files = new ArrayList<>();
        String base = "/Users/wuyuan/Downloads/";
        files.add(base+path);
        files.add(base+path1);
        //files.add(base+path2);
        APClassRoomTools tools = new APClassRoomTools(files);
        tools.calc();
        tools.printScores();










    }
}
