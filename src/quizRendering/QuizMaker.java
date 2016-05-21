package quizRendering;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import quizContentCreating.QuizContent;

/**
 * Created by TIMBULI REMUS K@puc!n on 17-May-16.
 */
class QuizMaker extends Pane{

    // Score & user actions variables-----------------------------------------------------------------------------------
    private Label score = new Label();
    private Label pointsLabel = new Label("points");
    private final Button newQuiz = new Button("New Quiz");
    private final Button submit = new Button("Submit");
    //------------------------------------------------------------------------------------------------------------------

    // Table variables--------------------------------------------------------------------------------------------------
    private TableView<QuizContent> tableView = new TableView<>();
    private TableColumn<QuizContent, String> questionColumn = new TableColumn<>("Question");
    private TableColumn<QuizContent, String> answerColumn = new TableColumn<>("Answer");
    private TableColumn<QuizContent, String> resultColumn = new TableColumn<>("Result");
    private ObservableList<QuizContent> list = FXCollections.observableArrayList();
    //------------------------------------------------------------------------------------------------------------------

    // Control panes variables------------------------------------------------------------------------------------------
    private final GridPane scorePane = new GridPane();
    private final GridPane quizPane = new GridPane();
    private final GridPane root = new GridPane();
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    QuizMaker(){
        layoutSetup();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Layout setup method----------------------------------------------------------------------------------------------
    private void layoutSetup(){
        root.add(scorePane, 0, 0);
        root.add(quizPane, 0, 1);
        getChildren().add(root);
    }
    //------------------------------------------------------------------------------------------------------------------
}
