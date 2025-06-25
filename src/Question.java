public class Question {
    private String title;
    private int option1;
    private int option2;
    private int option3;
    private int option4;
    private int correctAnswer;

    public Question(String title, int option1, int option2, int option3, int option4, int correctAnswer) {
        this.title = title;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getOption1() {
        return option1;
    }
    public void setOption1(int option1) {
        this.option1 = option1;
    }
    public int getOption2() {
        return option2;
    }
    public void setOption2(int option2) {
        this.option2 = option2;
    }
    public int getOption3() {
        return option3;
    }
    public void setOption3(int option3) {
        this.option3 = option3;
    }
    public int getOption4() {
        return option4;
    }
    public void setOption4(int option4) {
        this.option4 = option4;
    }
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(int answer) {
        if (answer == this.correctAnswer){
            return true;
        } else {
            return false;
        }
    }
}