package quizRendering;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Created by TIMBULI REMUS K@puc!n on 17-May-16.
 */
public class QuizMain extends Application {

    // Stage variables--------------------------------------------------------------------------------------------------
    private Stage stage;
    private final Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private final Pane pane = new Pane();
    private final Scene scene = new Scene(pane, bounds.getWidth() / 2, bounds.getHeight() / 2);
    //------------------------------------------------------------------------------------------------------------------

    // Main method------------------------------------------------------------------------------------------------------
    public static void main(String[] args){
        Application.launch(args);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Start method-----------------------------------------------------------------------------------------------------
    public void start(Stage stage){
        this.stage = stage;
        layoutSetup();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Stage layout setup-----------------------------------------------------------------------------------------------
    private void layoutSetup(){
        stage.setTitle("Quiz Maker");
        stage.setScene(scene);
        stage.show();
    }
    //------------------------------------------------------------------------------------------------------------------
}
