package quizRendering;

import alerts.EmptyAlert;
import interfaces.CQInterface;
import interfaces.Scale;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import quizContentCreating.CreatingQuestions;
import quizContentCreating.QuizContent;

import java.io.File;

/**
 * Created by TIMBULI REMUS K@puc!n on 17-May-16.
 *
 *      This class represents the GUI structure and
 * user content managing
 */
class QuizMaker extends Pane implements Scale{

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
    private Label pointsLabel = new Label(CQInterface.pointsLabel);
    private final Button newQuiz = new Button(CQInterface.newQuiz);
    private final Button submit = new Button(CQInterface.submit);
    //------------------------------------------------------------------------------------------------------------------

    // Table variables--------------------------------------------------------------------------------------------------
    private TableView<QuizContent> tableView = new TableView<>();
    private TableColumn<QuizContent, String> questionColumn = new TableColumn<>(CQInterface.questionColumn);
    private TableColumn<QuizContent, String> answerColumn = new TableColumn<>(CQInterface.answerColumn);
    private TableColumn<QuizContent, String> resultColumn = new TableColumn<>(CQInterface.resultColumn);
    private ObservableList<QuizContent> list = FXCollections.observableArrayList();
    //------------------------------------------------------------------------------------------------------------------

    // Control panes variables------------------------------------------------------------------------------------------
    private final GridPane scorePane = new GridPane();
    private final GridPane quizPane = new GridPane();
    private final GridPane root = new GridPane();
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    QuizMaker() {
        layoutSetup();
        tableSetup();
        loadQuiz();
        submitAnswers();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Layout setup method----------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    private void layoutSetup() {
        // Table layout-------------------------------------------------------------------------------------------------
        tableView.setItems(list);
        tableView.setPrefHeight(SCREEN_HEIGHT / 2 - 50);
        tableView.setPrefWidth(SCREEN_WIDTH / 2 - 20);
        tableView.getColumns().addAll(questionColumn, answerColumn, resultColumn);
        //--------------------------------------------------------------------------------------------------------------

        // QuizPane layout----------------------------------------------------------------------------------------------
        quizPane.setPadding(new Insets(0, 10, 0, 10));
        quizPane.setPrefHeight(SCREEN_HEIGHT / 2 - 50);
        quizPane.setPrefWidth(SCREEN_WIDTH / 2 - 20);
        quizPane.add(tableView, 0, 0);
        //--------------------------------------------------------------------------------------------------------------

        // ScorePane layout---------------------------------------------------------------------------------------------
        scorePane.setPadding(new Insets(5, 100, 0, 200));
        scorePane.setHgap(50);
        scorePane.setPrefWidth(SCREEN_WIDTH / 2);
        scorePane.setPrefHeight(35);
        scorePane.add(newQuiz, 0, 0);
        scorePane.add(score, 1, 0);
        scorePane.add(pointsLabel, 2, 0);
        scorePane.add(submit, 3, 0);
        //--------------------------------------------------------------------------------------------------------------

        // Root layout--------------------------------------------------------------------------------------------------
        root.setPrefHeight(SCREEN_HEIGHT / 2);
        root.setPrefWidth(SCREEN_WIDTH / 2);
        root.add(scorePane, 0, 0);
        root.add(quizPane, 0, 1);
        getChildren().add(root);
        //--------------------------------------------------------------------------------------------------------------
    }
    //------------------------------------------------------------------------------------------------------------------

    // Table setup method-----------------------------------------------------------------------------------------------
    private void tableSetup() {
        tableView.setEditable(true);
        answerColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        questionColumn.setCellValueFactory(new PropertyValueFactory<>(CQInterface.questionCellValue));
        answerColumn.setCellValueFactory(new PropertyValueFactory<>(CQInterface.answerCellValue));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>(CQInterface.resultCellValue));

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
    private void loadQuiz() {
        newQuiz.setOnAction(e -> {
            list.clear();
            fileStage = new Stage();
            fileChooser = new FileChooser();
            file = fileChooser.showOpenDialog(fileStage);
            if (file != null) {
                try {
                    for (int i = 0; i < 10; i++) {
                        creatingQuestions = new CreatingQuestions();
                        quizContent = new QuizContent("", "", "");
                        question = creatingQuestions.getQuestion();
                        quizContent.setQuestion(question);
                        tableView.getItems().add(quizContent);
                    }
                } catch (Exception em) {
                    new EmptyAlert();
                }
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    // Submit method----------------------------------------------------------------------------------------------------
    private void submitAnswers() {
        submit.setOnAction(e -> {
            IntegerProperty x = new SimpleIntegerProperty(0);
            for (QuizContent q : list) {
                if (q.getQuestion().contains("1 = 1") && q.getAnswer().equals("true")) {
                    x.set(x.get() + 1);
                    score.setText(Integer.toString(x.get()));
                }
                if (q.getQuestion().contains("1 = 1") && !q.getAnswer().equals("true")) {
                    q.setResult("true");
                }
                if (q.getQuestion().contains("1 != 1") && q.getAnswer().equals("false")) {
                    x.set(x.get() + 1);
                    score.setText(Integer.toString(x.get()));
                }
                if (q.getQuestion().contains("1 != 1") && !q.getAnswer().equals("false")) {
                    q.setResult("true");
                }
                if (q.getQuestion().contains("Java = programming language") && q.getAnswer().equals("true")) {
                    x.set(x.get() + 1);
                    score.setText(Integer.toString(x.get()));
                }
                if (q.getQuestion().contains("Java = programming language") && !q.getAnswer().equals("true")) {
                    q.setResult("true");
                }
                if (q.getQuestion().contains("Java != programming language") && q.getAnswer().equals("false")) {
                    x.set(x.get() + 1);
                    score.setText(Integer.toString(x.get()));
                }
                if (q.getQuestion().contains("Java != programming language") && !q.getAnswer().equals("false")) {
                    q.setResult("true");
                }
                if (q.getQuestion().contains("This is a cool app") && q.getAnswer().equals("true")) {
                    x.set(x.get() + 1);
                    score.setText(Integer.toString(x.get()));
                }
                if (q.getQuestion().contains("This is a cool app") && !q.getAnswer().equals("true")) {
                    q.setResult("true");
                }
                tableView.refresh();
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------
}
