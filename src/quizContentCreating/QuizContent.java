package quizContentCreating;

/**
 * Created by TIMBULI REMUS K@puc!n on 17-May-16.
 *
 *      This class represents the structure of the table content
 */
public class QuizContent {

    // Table content variables------------------------------------------------------------------------------------------
    private String question, answer, result;
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public QuizContent(String question, String answer, String result) {
        this.question = question;
        this.answer = answer;
        this.result = result;
    }
    //------------------------------------------------------------------------------------------------------------------

    // Getters & Setters------------------------------------------------------------------------------------------------
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    //------------------------------------------------------------------------------------------------------------------
}
