package views;
import java.awt.FontFormatException;
import java.awt.Rectangle;
import java.awt.Window;










import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import model.characters.Hero;
import javafx.scene.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HeroSelection {
	  private final Scene heroSelection;
	Button b1,b2,b3,b4,b5,b6,b7,b8;
	Text t1, t2, t3,t4,t5, t6, t7, t8;
	Label type, maxHp, ad, maxactions, type1, maxHp1, ad1, maxactions1;
	
	Button s1, s2,s3,s4,s5,s6,s7,s8;
	public void pickingHero(){
		String sound = "res/pickingHero.wav";
		Media sound1 = new Media(Paths.get(sound).toUri().toString());
			MediaPlayer click = new MediaPlayer(sound1);
			click.play();

		}
	
	public HeroSelection(){
		AnchorPane heroSelect = new AnchorPane();
		GridPane heroGrid = new GridPane();
		VBox text = new VBox(75.0);
		VBox text1 = new VBox(75.0);
		 heroSelection = new Scene(heroSelect);
		Image heroSelectBG = new Image("the-last-of-us-8bit-5r.jpg");
		ImageView imageViewBG = new ImageView(heroSelectBG);
		//stage.setTitle("The Last of Us: Legacy");
		imageViewBG.setFitWidth(1920);
		Label text2 = new Label();
		text2.setFont(Font.font("Verdana", 100));
		AnchorPane.setTopAnchor(text2, 50.0);
		AnchorPane.setLeftAnchor(text2, 50.0);
		imageViewBG.setPreserveRatio(true);
		ImageView title = new ImageView("game text.png");
		AnchorPane.setBottomAnchor(title, 50.0);
		AnchorPane.setRightAnchor(title, 50.0);
		Button back = new Button("Back");
	back.setMaxSize(220, 220);
		AnchorPane.setBottomAnchor(back, 300.0);
		AnchorPane.setRightAnchor(back, 650.0);
	//test button for start
		s8 = new Button("Start");
		
					s8.setMaxSize(220, 220);
					AnchorPane.setBottomAnchor(s8, 450.0);
					AnchorPane.setRightAnchor(s8, 650.0);
					s8.setOnAction(e->{
						//Main.stage.setScene(new Gameplay().getGameScene());
						//Main.stage.setFullScreen(true);
					});
				
		
	//labels without numbers
		type = new Label("Hero Type");
		type.setFont(Font.font("Verdana", 50));
		maxHp = new Label("Maximum HP");
		maxHp.setFont(Font.font("Verdana", 50));;
		ad = new Label("Attack Damage");
		ad.setFont(Font.font("Verdana", 50));
		maxactions = new Label("Maximum Actions");
		maxactions.setFont(Font.font("Verdana", 50));
		type1 = new Label();
		type1.setFont(Font.font("Verdana", 50));
		type1.setTextFill(Color.RED);
		maxHp1 = new Label();
		maxHp1.setFont(Font.font("Verdana", 50));
		maxHp1.setTextFill(Color.RED);
		ad1 = new Label();
		ad1.setFont(Font.font("Verdana", 50));
		ad1.setTextFill(Color.RED);
		maxactions1 = new Label();
		maxactions1.setFont(Font.font("Verdana", 50));
		maxactions1.setTextFill(Color.RED);
		text.getChildren().addAll(type, maxHp, ad, maxactions);
		text1.getChildren().addAll(type1, maxHp1, ad1, maxactions1);
		AnchorPane.setLeftAnchor(text, 1050.0);
		AnchorPane.setBottomAnchor(text, 600.0);
		AnchorPane.setLeftAnchor(text1, 1050.0);
		AnchorPane.setBottomAnchor(text1, 550.0);
		
		
		AnchorPane.setBottomAnchor(heroGrid, 300.0);
		AnchorPane.setLeftAnchor(heroGrid, 20.0);
		
		
		//joel
		b1 = new Button();
		ImageView joel = new ImageView("joel-removebg-preview.png");
		joel.preserveRatioProperty();
		joel.setFitHeight(220);
		joel.setFitWidth(200);
		b1.setGraphic(joel);
		b1.setBackground(null);
		b1.setMaxSize(220, 220);

		//ellie
		b2 = new Button();
		ImageView ellie = new ImageView("ellie.png");
		ellie.preserveRatioProperty();
		ellie.setFitHeight(200);
		ellie.setFitWidth(200);
		b2.setGraphic(ellie);
		b2.setBackground(null);
		b2.setMaxSize(220, 220);		
			
		//tess
		b3 = new Button();
		ImageView tess = new ImageView("tess.png");
		tess.preserveRatioProperty();
		tess.setFitHeight(200);
		tess.setFitWidth(200);
		b3.setGraphic(tess);
		b3.setBackground(null);
		b3.setMaxSize(220, 220);	
		//riley
			b4 = new Button();
			ImageView riley = new ImageView("riley1.png");
			riley.preserveRatioProperty();
			riley.setFitHeight(200);
			riley.setFitWidth(150);
			b4.setGraphic(riley);
			b4.setBackground(null);
			b4.setMaxSize(220, 220);	
			//tommy
			b5 = new Button();
			ImageView tommy = new ImageView("tommy.png");
			tommy.preserveRatioProperty();
			tommy.setFitHeight(200);
			tommy.setFitWidth(170);
			b5.setGraphic(tommy);
			b5.setBackground(null);
			b5.setMaxSize(220, 220);
			//bill
			b6 = new Button();
			ImageView bill = new ImageView("bill1.png");
			bill.preserveRatioProperty();
			bill.setFitHeight(200);
			bill.setFitWidth(150);
			b6.setGraphic(bill);
			b6.setBackground(null);
			b6.setMaxSize(220, 220);
			//david
			b7 = new Button();
			ImageView david = new ImageView("david1.png");
			david.preserveRatioProperty();
			david.setFitHeight(200);
			david.setFitWidth(140);
			b7.setGraphic(david);
			b7.setBackground(null);
			b7.setMaxSize(220, 220);
			//henry
			b8 = new Button();
			ImageView henry = new ImageView("henry1.png");
			henry.preserveRatioProperty();
			henry.setFitHeight(220);
			henry.setFitWidth(200);
			b8.setGraphic(henry);
			b8.setBackground(null);
			b8.setMaxSize(220, 220);

		//button clicked
			b1.setOnMousePressed(event ->{
			text2.setText("Joel Miller");
			type1.setText("Hero");
			maxHp1.setText("140");
			ad1.setText("30");
			maxactions1.setText("5");
			
			b1.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(10), Insets.EMPTY)));
			
//			s1 = new Button("Start");
	//
//			s1.setMaxSize(220, 220);
//			AnchorPane.setBottomAnchor(s1, 450.0);
//			AnchorPane.setRightAnchor(s1, 650.0);
//			heroSelect.getChildren().add(s1);
			pickingHero();
			
			});
			b2.setOnMousePressed(event ->{
				text2.setText("Ellie Williams");
				type1.setText("Medic");
				maxHp1.setText("110");
				ad1.setText("15");
				maxactions1.setText("6");
				
				b2.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(10), Insets.EMPTY)));
				//s2  = new Button("Start");

//				s2.setMaxSize(220, 220);
//				AnchorPane.setBottomAnchor(s2, 450.0);
//				AnchorPane.setRightAnchor(s2, 650.0);
//				heroSelect.getChildren().add(s2);
				pickingHero();
				
				});
			b3.setOnMousePressed(event ->{
				text2.setText("Tess");
				type1.setText("Explorer");
				maxHp1.setText("80");
				ad1.setText("20");
				maxactions1.setText("6");
				
				b3.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(10), Insets.EMPTY)));
				//s3 = new Button("Start");

//				s3.setMaxSize(220, 220);
//				AnchorPane.setBottomAnchor(s3, 450.0);
//				AnchorPane.setRightAnchor(s3, 650.0);
//				heroSelect.getChildren().add(s3);
				
				pickingHero();
				});
			b4.setOnMousePressed(event ->{
				text2.setText("Riley Abel");
				type1.setText("Explorer");
				maxHp1.setText("90");
				ad1.setText("25");
				maxactions1.setText("5");
				
				b4.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(10), Insets.EMPTY)));
				
				
				//s4 = new Button("Start");

//				s4.setMaxSize(220, 220);
//				AnchorPane.setBottomAnchor(s4, 450.0);
//				AnchorPane.setRightAnchor(s4, 650.0);
//				heroSelect.getChildren().add(s4);
				pickingHero();
				});
			b5.setOnMousePressed(event ->{
				text2.setText("Tommy Miller");
				type1.setText("Explorer");
				maxHp1.setText("95");
				ad1.setText("25");
				maxactions1.setText("5");
				
				b5.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(10), Insets.EMPTY)));
				
				
				//s5 = new Button("Start");

//				s5.setMaxSize(220, 220);
//				AnchorPane.setBottomAnchor(s5, 450.0);
//				AnchorPane.setRightAnchor(s5, 650.0);
//				heroSelect.getChildren().add(s5);
				pickingHero();
				});
			b6.setOnMousePressed(event ->{
				text2.setText("David");
				type1.setText("Medic");
				maxHp1.setText("100");
				ad1.setText("10");
				maxactions1.setText("7");
				
				b6.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(10), Insets.EMPTY)));
				
				
//				s6 = new Button("Start");
	//
//				s6.setMaxSize(220, 220);
//				AnchorPane.setBottomAnchor(s6, 450.0);
//				AnchorPane.setRightAnchor(s6, 650.0);
//				heroSelect.getChildren().add(s6);
				pickingHero();
				});
			b7.setOnMousePressed(event ->{
				text2.setText("Henry Burell");
				type1.setText("Fighter");
				maxHp1.setText("150");
				ad1.setText("35");
				maxactions1.setText("4");
				
				b7.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(10), Insets.EMPTY)));
				
				
//				s7 = new Button("Start");
	//
//				s7.setMaxSize(220, 220);
//				AnchorPane.setBottomAnchor(s7, 450.0);
//				AnchorPane.setRightAnchor(s7, 650.0);
//				heroSelect.getChildren().add(s7);
				pickingHero();
				});
			b8.setOnMousePressed(event ->{
				text2.setText("Joel Miller");
				type1.setText("Medic");
				maxHp1.setText("105");
				ad1.setText("15");
				maxactions1.setText("6");
				
				b8.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(10), Insets.EMPTY)));
				
				
//				s8 = new Button("Start");
	//
//				s8.setMaxSize(220, 220);
//				AnchorPane.setBottomAnchor(s8, 450.0);
//				AnchorPane.setRightAnchor(s8, 650.0);
//				heroSelect.getChildren().add(s8);
				pickingHero();
				});
			//button release
			b1.setOnMouseReleased(event->{
				b1.setBackground(null);
			});
			
			b2.setOnMouseReleased(event->{
				b2.setBackground(null);
			});
			b3.setOnMouseReleased(event->{
				b3.setBackground(null);
			});
			b4.setOnMouseReleased(event->{
				b4.setBackground(null);
			});
			b5.setOnMouseReleased(event->{
				b5.setBackground(null);
			});
			b6.setOnMouseReleased(event->{
				b6.setBackground(null);
			});
			b7.setOnMouseReleased(event->{
				b7.setBackground(null);
			});
			b8.setOnMouseReleased(event->{
				b8.setBackground(null);
			});
		
			

			
			
			
		heroGrid.setVgap(50.0);
		heroGrid.setHgap(30.0);
		heroGrid.add(b1, 0, 0, 1, 1);
		heroGrid.add(b2, 1, 0, 1, 1);
		heroGrid.add(b3, 2, 0, 1, 1);
		heroGrid.add(b4, 3, 0, 1, 1);
		heroGrid.add(b5, 0, 1, 1, 1);
		heroGrid.add(b6, 1, 1, 1, 1);
		heroGrid.add(b7, 2, 1, 1, 1);
		heroGrid.add(b8, 3, 1, 1, 1);
		
		heroSelect.getChildren().addAll(imageViewBG, text2, heroGrid, text, text1, title, back, s8);
//		stage.setFullScreen(true);
//		stage.setScene(heroSelection);
//		stage.show();
	}
	public  Scene getHeroSelection(){
		return heroSelection;
	}
	
	}

