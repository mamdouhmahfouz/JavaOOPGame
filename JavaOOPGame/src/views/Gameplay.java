package views;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.print.attribute.standard.RequestingUserName;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

import org.hamcrest.core.Is;



//import com.sun.javafx.scene.control.MultiplePropertyChangeListenerHandler;

import engine.Game;
import model.characters.Direction;
import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Zombie;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.Cell;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;
import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.StageStyle;
import model.world.*;

public class Gameplay {
public Game game;

static GridPane grid;
static BorderPane borderPane;
private final Scene gameScene;
public static ArrayList<Hero> availableHeroes;
public static ArrayList<Hero> heroes;
public static ArrayList<Zombie> zombies;
Hero h, hovered;
VBox leftLayout;
model.world.Cell [] [] map;
Label stats, stats1;
VBox picAdd;
Button b;
public void updateMap(){
	grid.getChildren().clear();
	for(int i = 0; i<map.length; i++){
		for(int j = 0; j<map.length; j++){
			Button b = new Button();
			b.setMinSize(75, 65);
			grid.add(b, j, map.length-1-i);
//			Node buttonLoop = grid.getChildren().get(i*15+j);
//			if (buttonLoop instanceof Button){
//				b = (Button)buttonLoop;
			
			if(map [i][j].isVisible() == false){
				b.setStyle("-fx-background-color: grey;");
			}
			
			else if (map[i][j] instanceof CharacterCell && ((CharacterCell)map[i][j]).getCharacter()instanceof Hero){
				Hero hh;
				 hovered = (Hero) ((CharacterCell)map[i][j]).getCharacter();
				hh = (Hero) ((CharacterCell)map[i][j]).getCharacter();
				ImageView hero = new ImageView(hh.getName()+".png");
				hero.preserveRatioProperty();
				hero.setFitHeight(50);
				hero.setFitWidth(50);
				b.setGraphic(hero);
				b.setOnMouseMoved(e->{
					hovered = hh;
					stats1.setText("Name: "+hovered.getName()+"\n" +
							"Hero Type: "+ hovered.getType() +"\n" +
							"Current HP: " + hovered.getCurrentHp()+ "\n"+
							"Attack Damage: " + hovered.getAttackDmg() + "\n"+
							"Max Action Points: " + hovered.getMaxActions() + "\n");
				});
				b.setOnMouseExited(e->{
					stats1.setText(null);
				});
				b.setOnAction(event->{
					setH(hh);
					stats.setText("PLAYING AS: " +"\n" +
							"Name: "+h.getName()+"\n" +
							"Hero Type: "+ h.getType() +"\n" +
								"Current HP: " + h.getCurrentHp()+ "\n"+
								"Attack Damage: " + h.getAttackDmg() + "\n"+
								"Action Points: " + h.getActionsAvailable() + "\n"+
								"Amount of Supplies: "+ h.getSupplyInventory().size() + "\n" +
								 "Amount of Vaccines: "+ h.getVaccineInventory().size() + "\n");
				});
				
			}
			
			else if (map[i][j] instanceof CharacterCell && ((CharacterCell)map[i][j]).getCharacter()instanceof Zombie){
				ImageView zombie = new ImageView("zombie2.png");
				zombie.preserveRatioProperty();
				zombie.setFitHeight(48);
				zombie.setFitWidth(48);
				b.setGraphic(zombie);
		}
			else if(map[i][j] instanceof CollectibleCell && ((CollectibleCell)map[i][j]).getCollectible() instanceof Vaccine){
				ImageView vaccine = new ImageView("vaccine.png");
				vaccine.preserveRatioProperty();
				vaccine.setFitHeight(48);
				vaccine.setFitWidth(48);
				b.setGraphic(vaccine);
			}
			else if(map[i][j] instanceof CollectibleCell && ((CollectibleCell)map[i][j]).getCollectible() instanceof Supply){
				ImageView supply = new ImageView("pizza.png");
				supply.preserveRatioProperty();
				supply.setFitHeight(48);
				supply.setFitWidth(48);
				b.setGraphic(supply);
			}
			else if(map[i][j] instanceof TrapCell){
				//make it invisible
				b.setText(null);
			}
	
	}
	if(Game.checkWin() == true){
		PopUpGameOver.display(null, "CONGRATS, YOU WON!");
	}
	else if(Game.checkWin()==false &&Game.checkGameOver()==true){
		PopUpGameOver.display(null, "YOU LOST");
	}
	}
	//borderPane.getChildren().add(grid);
	}


	public Gameplay() {
//updateMap();
		borderPane = new BorderPane();
		//borderPane.setCenter(grid);
		h = Game.availableHeroes.get(Main.getCount());
		Game.startGame(h);
	
		map = Game.getMap();
		grid = new GridPane();
		for(int i = 0; i<map.length; i++){
			for(int j = 0; j<map.length; j++){
				 b = new Button();
				b.setMinSize(75, 65);
				grid.add(b, j, map.length-1-i);
				
				if(map [i][j].isVisible() == false){
					b.setStyle("-fx-background-color: grey;");
				}
				
				else if (map[i][j] instanceof CharacterCell && ((CharacterCell)map[i][j]).getCharacter()instanceof Hero){
					ImageView hero = new ImageView(h.getName()+".png");
					hero.preserveRatioProperty();
					hero.setFitHeight(50);
					hero.setFitWidth(50);
					b.setGraphic(hero);
					b.setOnMouseMoved(e->{
						stats1.setText("Name: "+h.getName()+"\n" +
								"Hero Type: "+ h.getType() +"\n" +
								"Current HP: " + h.getCurrentHp()+ "\n"+
								"Attack Damage: " + h.getAttackDmg() + "\n"+
								"Max Action Points: " + h.getMaxActions() + "\n");
					});
					b.setOnMouseExited(e->{
						stats1.setText(null);
					});
					b.setOnAction(event->{
						System.out.println(h.getName());
		
					});
				}
				
				else if (map[i][j] instanceof CharacterCell && ((CharacterCell)map[i][j]).getCharacter()instanceof Zombie){
					ImageView zombie = new ImageView("zombie2.png");
					zombie.preserveRatioProperty();
					zombie.setFitHeight(48);
					zombie.setFitWidth(48);
					b.setGraphic(zombie);
			}
				else if(map[i][j] instanceof CollectibleCell && ((CollectibleCell)map[i][j]).getCollectible() instanceof Vaccine){
					ImageView vaccine = new ImageView("vaccine.png");
					vaccine.preserveRatioProperty();
					vaccine.setFitHeight(48);
					vaccine.setFitWidth(48);
					b.setGraphic(vaccine);
				}
				else if(map[i][j] instanceof CollectibleCell && ((CollectibleCell)map[i][j]).getCollectible() instanceof Supply){
					ImageView supply = new ImageView("pizza.png");
					supply.preserveRatioProperty();
					supply.setFitHeight(48);
					supply.setFitWidth(48);
					b.setGraphic(supply);
				}
				else if(map[i][j] instanceof TrapCell){
					b.setText(null);
				}
		}
		}
		
		
		grid.setAlignment(Pos.CENTER);
		
		
		
		VBox rightLayout = new VBox(20);
		//Button move = new Button("move");
		Button attack = new Button("attack");
		Button cure = new Button("cure");
		Button specialAction = new Button ("special action");
		Button endTurn = new Button("end turn");
		gameScene = new Scene(borderPane);
		//move
		 gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				switch(event.getCode()){
				case UP: try{
					h.move(Direction.UP);
				}
				catch(NotEnoughActionsException e){
				PopUp.display("Not Enough Actions Exception", "YOU DO NOT HAVE ENOUGH ACTION POINTS!");
				}
				catch(MovementException e){
					PopUp.display("movement exception", "YOU CANNOT MOVE HERE!");
				} break;
				case LEFT: try{
					h.move(Direction.LEFT);
				}
				catch(NotEnoughActionsException e){
					PopUp.display("Not Enough Actions Exception", "YOU DO NOT HAVE ENOUGH ACTION POINTS!");
				}
				catch(MovementException e){
					PopUp.display("movement exception", "YOU CANNOT MOVE HERE!");
				} break;
				case RIGHT: try{
					h.move(Direction.RIGHT);
				}
				catch(NotEnoughActionsException e){
					PopUp.display("Not Enough Actions Exception", "YOU DO NOT HAVE ENOUGH ACTION POINTS!");
				}
				catch(MovementException e){
					PopUp.display("movement exception", "YOU CANNOT MOVE HERE!");
				} break;
				case DOWN: try{
					h.move(Direction.DOWN);
				}
				catch(NotEnoughActionsException e){
					PopUp.display("Not Enough Actions Exception", "YOU DO NOT HAVE ENOUGH ACTION POINTS!");
				}
				catch(MovementException e){
					PopUp.display("movement exception", "YOU CANNOT MOVE HERE!");
				} break;
				case W: h.setTarget((((CharacterCell) (map)[h.getLocation().x+1][h.getLocation().y]).getCharacter()));
				break;
				case A: h.setTarget((((CharacterCell) (map)[h.getLocation().x][h.getLocation().y-1]).getCharacter()));
				break;
				case S: h.setTarget((((CharacterCell) (map)[h.getLocation().x-1][h.getLocation().y]).getCharacter()));
				break;
				case D: h.setTarget((((CharacterCell) (map)[h.getLocation().x][h.getLocation().y+1]).getCharacter()));
				break;
				case R: h.setTarget((((CharacterCell) (map)[h.getLocation().x+1][h.getLocation().y-1]).getCharacter()));
				break;
				case T: h.setTarget((((CharacterCell) (map)[h.getLocation().x+1][h.getLocation().y+1]).getCharacter()));
				break;
				case F: h.setTarget((((CharacterCell) (map)[h.getLocation().x-1][h.getLocation().y-1]).getCharacter()));
				break;
				case G: h.setTarget((((CharacterCell) (map)[h.getLocation().x-1][h.getLocation().y+1]).getCharacter())); 
				break;
				case Q : h.setTarget((((CharacterCell) (map)[h.getLocation().x][h.getLocation().y]).getCharacter()));
				break;
				default:
					break;
				
				}
				stats.setText("PLAYING AS: " +"\n" +
						"Name: "+h.getName()+"\n" +
						"Hero Type: "+ h.getType() +"\n" +
							"Current HP: " + h.getCurrentHp()+ "\n"+
							"Attack Damage: " + h.getAttackDmg() + "\n"+
							"Action Points: " + h.getActionsAvailable() + "\n"+
							"Amount of Supplies: "+ h.getSupplyInventory().size() + "\n" +
							 "Amount of Vaccines: "+ h.getVaccineInventory().size() + "\n");
				updateMap(); 
			}
		});
		
	
		//end turn
		endTurn.setOnAction(e->{
			try {Game.endTurn();
				
			} catch(NotEnoughActionsException e1){
				PopUp.display("Not Enough Actions Exception", "YOU DO NOT HAVE ENOUGH ACTION POINTS!");
			}
			catch (InvalidTargetException e1) {
				PopUp.display("Invalid Target", "YOU ARE PICKING AN INVALID TARGET, PICK A VALID TARGET!");
			}
			updateMap();
			
			stats.setText("PLAYING AS: " +"\n" +
					"Name: "+h.getName()+"\n" +
					"Hero Type: "+ h.getType() +"\n" +
						"Current HP: " + h.getCurrentHp()+ "\n"+
						"Attack Damage: " + h.getAttackDmg() + "\n"+
						"Action Points: " + h.getActionsAvailable() + "\n"+
						"Amount of Supplies: "+ h.getSupplyInventory().size() + "\n" +
						 "Amount of Vaccines: "+ h.getVaccineInventory().size() + "\n");
			
		});
		//attack
		attack.setOnAction(e->{
			try {
				h.attack();
			} catch (InvalidTargetException e1) {
				PopUp.display("Invalid Target", "YOU ARE PICKING AN INVALID TARGET, PICK A VALID TARGET!");
			}
			catch(NotEnoughActionsException e1){
				PopUp.display("Not Enough Actions Exception", "YOU DO NOT HAVE ENOUGH ACTION POINTS!");
			}
			updateMap();
			stats.setText("PLAYING AS: " +"\n" +
					"Name: "+h.getName()+"\n" +
					"Hero Type: "+ h.getType() +"\n" +
						"Current HP: " + h.getCurrentHp()+ "\n"+
						"Attack Damage: " + h.getAttackDmg() + "\n"+
						"Action Points: " + h.getActionsAvailable() + "\n"+
						"Amount of Supplies: "+ h.getSupplyInventory().size() + "\n" +
						 "Amount of Vaccines: "+ h.getVaccineInventory().size() + "\n");
		});
		//cure
		cure.setOnAction(e->{
			try {
				h.cure();
				
			} catch (InvalidTargetException e1) {
				PopUp.display("Invalid Target", "YOU ARE PICKING AN INVALID TARGET, PICK A VALID TARGET!");
			}
			catch(NotEnoughActionsException e1){
				PopUp.display("Not Enough Actions Exception", "YOU DO NOT HAVE ENOUGH ACTION POINTS!");
			}
			catch(NoAvailableResourcesException e1){
				PopUp.display("No Avaialable Resources Exception", "YOU DO NOT HAVE ENOUGH RESOURCES!");
			}
			updateMap();
			stats.setText("PLAYING AS: " +"\n" +
					"Name: "+h.getName()+"\n" +
					"Hero Type: "+ h.getType() +"\n" +
						"Current HP: " + h.getCurrentHp()+ "\n"+
						"Attack Damage: " + h.getAttackDmg() + "\n"+
						"Action Points: " + h.getActionsAvailable() + "\n"+
						"Amount of Supplies: "+ h.getSupplyInventory().size() + "\n" +
						 "Amount of Vaccines: "+ h.getVaccineInventory().size() + "\n");
		});
		
		//special action
		specialAction.setOnAction(e->{
			try {
				h.useSpecial();
				if(h instanceof Explorer){

					for(int x = 0; x<map.length; x++){
						for(int y= 0; y<map.length; y++){
							if(map[x][y] instanceof TrapCell){
								Button T = new Button("TRAP");
							}
						}
						}
			}
			}
			catch (InvalidTargetException e1) {
				PopUp.display("Invalid Target", "YOU ARE PICKING AN INVALID TARGET, PICK A VALID TARGET!");
			}
				catch(NoAvailableResourcesException e1){
					PopUp.display("No Avaialable Resources Exception", "YOU DO NOT HAVE ENOUGH RESOURCES!");
				}
				updateMap();
				stats.setText("PLAYING AS: " +"\n" +
						"Name: "+h.getName()+"\n" +
						"Hero Type: "+ h.getType() +"\n" +
							"Current HP: " + h.getCurrentHp()+ "\n"+
							"Attack Damage: " + h.getAttackDmg() + "\n"+
							"Action Points: " + h.getActionsAvailable() + "\n"+
							"Amount of Supplies: "+ h.getSupplyInventory().size() + "\n" +
							 "Amount of Vaccines: "+ h.getVaccineInventory().size() + "\n");
			});
	//////////////////////////////////	
		//left avlbl heroes button
		leftLayout = new VBox(200);
		stats = new Label();
		stats1 = new Label();
		stats.setText("PLAYING AS: " +"\n" +
				"Name: "+h.getName()+"\n" +
				"Hero Type: "+ h.getType() +"\n" +
					"Current HP: " + h.getCurrentHp()+ "\n"+
					"Attack Damage: " + h.getAttackDmg() + "\n"+
					"Action Points: " + h.getActionsAvailable() + "\n"+
					"Amount of Supplies: "+ h.getSupplyInventory().size() + "\n" +
					 "Amount of Vaccines: "+ h.getVaccineInventory().size() + "\n");
		leftLayout.getChildren().addAll(stats, stats1);
		 picAdd = new VBox(50);
		// leftLayout.getChildren().add(picAdd);
		rightLayout.getChildren().addAll(attack,cure,  specialAction, endTurn);
		
		borderPane.setRight(rightLayout);
		borderPane.setLeft(leftLayout);
		borderPane.setCenter(grid);
		
		 
		}


	public Hero getH(){
		return h;
	}
	public void setH(Hero newH){
		h = newH;
	}

	public Scene getGameScene(){
		return gameScene;
	}
}
