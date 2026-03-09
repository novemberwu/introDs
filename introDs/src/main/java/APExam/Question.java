package APExam;

public class Question {
    private String prompt;
    private String[] options;
    private int correctAnswerIndex; // 0 for A, 1 for B, etc.
    private String explanation;

    public Question(String prompt, String[] options, int correctAnswerIndex, String explanation) {
        this.prompt = prompt;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.explanation = explanation;
    }

    public boolean checkAnswer(int input) {
        return input == correctAnswerIndex;
    }

    public void display() {
        System.out.println("\n" + prompt);
        char letter = 'A';
        for (String option : options) {
            System.out.println(letter + ") " + option);
            letter++;
        }
    }

    public String getExplanation() {
        return explanation;
    }
}