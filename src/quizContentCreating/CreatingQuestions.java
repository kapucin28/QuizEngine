package quizContentCreating;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by TIMBULI REMUS K@puc!n on 17-May-16.
 */
public class CreatingQuestions {

    // Managing questions variables-------------------------------------------------------------------------------------
    private String question;
    private static byte[] bytes;
    private static final String path = "Desktop/quiz.dat";  // Any location & filename
    private static RandomAccessFile file;
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public CreatingQuestions(){
        quizQuestions();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Writing questions to file method---------------------------------------------------------------------------------
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

    // Reading questions method-----------------------------------------------------------------------------------------
    private static byte[] readFromFile(String path, int position, int size){
        try {
            file = new RandomAccessFile(path, "r");
            file.seek(position);
            bytes = new byte[size];
            file.read(bytes);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
    //------------------------------------------------------------------------------------------------------------------

    // Questions--------------------------------------------------------------------------------------------------------
    private void quizQuestions(){
        writeToFile(path, "1 = 1", 0);
        writeToFile(path, "1 != 1", 6);
        writeToFile(path, "Java = programming language", 13);
        writeToFile(path, "Java != programming language", 41);
        writeToFile(path, "This is a cool app", 69);
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
