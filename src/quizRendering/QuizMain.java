package quizRendering;

import alerts.ExitAlert;
import interfaces.CQInterface;
import interfaces.Scale;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by TIMBULI REMUS K@puc!n on 17-May-16.
 * <p>
 * This is the main class where the stage and scene
 * are created
 */
public class QuizMain extends Application implements Scale {

    // Stage variables--------------------------------------------------------------------------------------------------
    private Stage stage;
    private final Pane pane = new Pane();
    private final Scene scene = new Scene(pane, SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
    //------------------------------------------------------------------------------------------------------------------

    // Main method------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Application.launch(args);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Start method-----------------------------------------------------------------------------------------------------
    public void start(Stage stage) {
        this.stage = stage;
        layoutSetup();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Stage layout setup-----------------------------------------------------------------------------------------------
    private void layoutSetup() {
        pane.getChildren().add(new QuizMaker());
        scene.getStylesheets().add(getClass().getResource(CQInterface.CSSFile).toExternalForm());
        stage.setTitle(CQInterface.stageTitle);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            e.consume();
            new ExitAlert();
        });
    }
    //------------------------------------------------------------------------------------------------------------------
}
