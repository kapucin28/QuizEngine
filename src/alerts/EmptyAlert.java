package alerts;

import interfaces.AlertsTitles;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 * Created by TIMBULI REMUS K@puc!n on 29-May-16.
 *
 *      This class represents the empty alert which will popup
 * when the user tries to load an empty file
 */
public class EmptyAlert {

    // Alert variable---------------------------------------------------------------------------------------------------
    private Alert alert = new Alert(Alert.AlertType.WARNING, AlertsTitles.emptyAlertMessage, ButtonType.OK);
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public EmptyAlert() {
        emptyAlert(alert);
    }
    //------------------------------------------------------------------------------------------------------------------

    private void emptyAlert(Alert alert) {
        this.alert = alert;
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initStyle(StageStyle.TRANSPARENT);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            alert.close();
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}
