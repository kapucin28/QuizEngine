package quizContentCreating;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by TIMBULI REMUS K@puc!n on 17-May-16.
 */
public class CreatingQuestions {

    // Managing questions variables-------------------------------------------------------------------------------------
    private String question;
    private static final String path = "Desktop/quiz.dat";  // Any location & filename
    private static RandomAccessFile file;
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public CreatingQuestions(){

    }
    //------------------------------------------------------------------------------------------------------------------

    // Writing questions to file----------------------------------------------------------------------------------------
    private static void writeToFile(String path, String data, int position){
        try {
            file = new RandomAccessFile(path, "rw");
            file.seek(position);
            file.write(data.getBytes());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    // Getters & Setters------------------------------------------------------------------------------------------------
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    //------------------------------------------------------------------------------------------------------------------
}
