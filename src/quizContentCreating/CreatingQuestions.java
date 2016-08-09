package quizContentCreating;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by TIMBULI REMUS K@puc!n on 17-May-16.
 *
 *      This is the class that creates the questions
 */
public class CreatingQuestions {

    // Managing questions variables-------------------------------------------------------------------------------------
    private String question;
    private static final String path = "D:/Downloads/quiz.dat";  // Any location & filename
    private static RandomAccessFile file;
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public CreatingQuestions() {
        quizQuestions();
        try {
            readQuestions();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    // Writing questions to file method---------------------------------------------------------------------------------
    private static void writeToFile(String path, String data, int position) {
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
    private static byte[] readFromFile(String path, int position, int size) throws IOException {
        file = new RandomAccessFile(path, "r");
        file.seek(position);
        byte[] bytes = new byte[size];
        file.read(bytes);
        file.close();
        return bytes;
    }
    //------------------------------------------------------------------------------------------------------------------

    // Questions--------------------------------------------------------------------------------------------------------
    private void quizQuestions() {
        writeToFile(path, "1 = 1", 0);
        writeToFile(path, "1 != 1", 6);
        writeToFile(path, "Java = programming language", 13);
        writeToFile(path, "Java != programming language", 41);
        writeToFile(path, "This is a cool app", 69);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Reading questions method-----------------------------------------------------------------------------------------
    private void readQuestions() throws IOException {
        String[] questions = new String[]{new String(readFromFile(path, 0, 5)),
                new String(readFromFile(path, 6, 6)),
                new String(readFromFile(path, 13, 27)),
                new String(readFromFile(path, 41, 28)),
                new String(readFromFile(path, 69, 18))
        };
        question = questions[(int) (Math.random() * 5)];
    }
    //------------------------------------------------------------------------------------------------------------------

    // Getters & Setters------------------------------------------------------------------------------------------------
    public String getQuestion() {
        return question;
    }
    //------------------------------------------------------------------------------------------------------------------
}
