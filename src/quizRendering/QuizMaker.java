package quizRendering;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import quizContentCreating.CreatingQuestions;
import quizContentCreating.QuizContent;

import java.io.File;

/**
 * Created by TIMBULI REMUS K@puc!n on 17-May-16.
 */
class QuizMaker extends Pane{

    // Loading quiz content variables-----------------------------------------------------------------------------------
    private Stage fileStage;
    private FileChooser fileChooser;
    private File file;
    private CreatingQuestions creatingQuestions;
    private QuizContent quizContent;
    private String question;
    //------------------------------------------------------------------------------------------------------------------

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
    private final Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private final GridPane scorePane = new GridPane();
    private final GridPane quizPane = new GridPane();
    private final GridPane root = new GridPane();
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    QuizMaker(){
        layoutSetup();
        tableSetup();
        loadQuiz();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Layout setup method----------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    private void layoutSetup(){
        // Table layout-------------------------------------------------------------------------------------------------
        tableView.setItems(list);
        tableView.setPrefHeight(bounds.getHeight() / 2 - 50);
        tableView.setPrefWidth(bounds.getWidth() / 2 - 20);
        tableView.getColumns().addAll(questionColumn, answerColumn, resultColumn);
        //--------------------------------------------------------------------------------------------------------------

        // QuizPane layout----------------------------------------------------------------------------------------------
        quizPane.setPadding(new Insets(0, 10, 0, 10));
        quizPane.setPrefHeight(bounds.getHeight() / 2 - 50);
        quizPane.setPrefWidth(bounds.getWidth() / 2 - 20);
        quizPane.add(tableView, 0, 0);
        //--------------------------------------------------------------------------------------------------------------

        // ScorePane layout---------------------------------------------------------------------------------------------
        scorePane.setPadding(new Insets(5, 100, 0, 200));
        scorePane.setHgap(50);
        scorePane.setPrefWidth(bounds.getWidth() / 2);
        scorePane.setPrefHeight(35);
        scorePane.add(newQuiz, 0, 0);
        scorePane.add(score, 1, 0);
        scorePane.add(pointsLabel, 2, 0);
        scorePane.add(submit, 3, 0);
        //--------------------------------------------------------------------------------------------------------------

        // Root layout--------------------------------------------------------------------------------------------------
        root.setPrefHeight(bounds.getHeight() / 2);
        root.setPrefWidth(bounds.getWidth() / 2);
        root.add(scorePane, 0, 0);
        root.add(quizPane, 0, 1);
        getChildren().add(root);
        //--------------------------------------------------------------------------------------------------------------
    }
    //------------------------------------------------------------------------------------------------------------------

    // Table setup method-----------------------------------------------------------------------------------------------
    private void tableSetup(){
        tableView.setEditable(true);
        answerColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        questionColumn.setCellValueFactory(new PropertyValueFactory<>("question"));
        answerColumn.setCellValueFactory(new PropertyValueFactory<>("answer"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));

        questionColumn.setPrefWidth(465);
        answerColumn.setPrefWidth(100);
        resultColumn.setPrefWidth(100);

        answerColumn.setOnEditCommit(e -> {
            TableColumn.CellEditEvent<QuizContent, String> cellEdit;
            cellEdit = e;
            QuizContent qz = cellEdit.getRowValue();
            qz.setAnswer(cellEdit.getNewValue());
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    // Creating new quiz method-----------------------------------------------------------------------------------------
    private void loadQuiz(){
        list.clear();

    }
    //------------------------------------------------------------------------------------------------------------------
}
