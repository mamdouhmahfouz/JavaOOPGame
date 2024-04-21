package views;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class PopUp {
	


	    public static void display(String title, String message)
	    {
	        Stage PopUp=new Stage();

	        PopUp.initModality(Modality.APPLICATION_MODAL);
	        PopUp.setWidth(1000);
	        PopUp.setTitle(title);
	        Label label=new Label(message);
	        Button GoBack=new Button("CLOSE THE MESSAGE");
	        GoBack.setOnAction(e-> PopUp.close());

	        VBox layout=new VBox();
	        layout.getChildren().addAll(label,GoBack);

	        Scene scene=new Scene(layout);
	        PopUp.setScene(scene);
	         PopUp.initModality(Modality.WINDOW_MODAL);
	        PopUp.initOwner(Main.stage);
	       
	        PopUp.show();
}
}