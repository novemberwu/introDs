package APExam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class APCSAPracticeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> quizBank = new ArrayList<>();

        // --- Add AP CSA style questions here ---
        // 1. Load questions from the Markdown file
        try {
            File file = new File("src/main/java/APExam/question.md");
            Scanner fileScanner = new Scanner(file);

            String text = "";
            ArrayList<String> options = new ArrayList<>();
            int correctIndex = 0;
            String explanation = "";

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();

                if (line.startsWith("Q: ")) {
                    text = line.substring(3);
                    options.clear(); // Reset options for new question
                } else if (line.matches("^[0-3]\\) .*")) {
                    // Matches "0) text", "1) text", etc.
                    options.add(line.substring(3));
                } else if (line.startsWith("Correct: ")) {
                    correctIndex = Integer.parseInt(line.substring(9));
                } else if (line.startsWith("Explanation: ")) {
                    explanation = line.substring(13);
                } else if (line.equals("---")) {
                    // End of a question block, add to list
                    quizBank.add(new Question(text, options.toArray(new String[0]), correctIndex, explanation));
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: questions.md file not found!");
            return;
        }

        quizBank.add(new Question(
                "Which of these correctly declares an ArrayList of Integers?",
                new String[]{
                        "ArrayList<int> list = new ArrayList<>();",
                        "List<Integer> list = new ArrayList<Integer>();",
                        "ArrayList[Integer] list = new ArrayList();",
                        "int[] list = new ArrayList();"
                },
                1,
                "Explanation: ArrayLists must use Wrapper classes (Integer) and not primitives (int)."
        ));

        // --- Game Logic ---
        int score = 0;
        System.out.println("Welcome to the AP CSA Practice Quiz!");
        System.out.println("-----------------------------------");

        for (Question q : quizBank) {
            q.display();
            System.out.print("Your answer (A, B, C, or D): ");
            String input = scanner.next().toUpperCase();
            int choiceIndex = input.charAt(0) - 'A';

            if (q.checkAnswer(choiceIndex)) {
                System.out.println("CORRECT!");
                score++;
            } else {
                System.out.println("WRONG.");
                System.out.println(q.getExplanation());
            }
        }

        System.out.println("\n-----------------------------------");
        System.out.println("Final Score: " + score + "/" + quizBank.size());
        System.out.println("Keep studying!");
        scanner.close();
    }
}