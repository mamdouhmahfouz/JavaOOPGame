package views;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpGameOver {
    public static void display(String title, String message)
     {
         Stage PopUpGameOver =new Stage();

         PopUpGameOver.initModality(Modality.APPLICATION_MODAL);
         PopUpGameOver.setWidth(1000);
         PopUpGameOver.setTitle(title);
         Label label=new Label(message);
         Button Exit=new Button("Close the Game");
         Exit.setOnAction(e-> Platform.exit());

         VBox layout=new VBox();
         layout.getChildren().addAll(label,Exit);

         Scene scene=new Scene(layout);
         PopUpGameOver.setScene(scene);
         PopUpGameOver.initModality(Modality.WINDOW_MODAL);
         PopUpGameOver.initOwner(Main.stage);

         PopUpGameOver.show();
}
}