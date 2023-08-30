package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {


    public static void main(String[] args)  {
        System.out.println("Hello world!");
        launch(TicTacToeApplication.class);
    }
    private Board board;
    private Menu menu;
    private Player player = new Player();
    private Label turn = new Label("");

    @Override
    public void start(Stage window) throws Exception {
        BorderPane group = new BorderPane();
        //HBox menu = new HBox();
        //menu.setAlignment(Pos.CENTER);
        Label status =  new Label("X");
        status.setFont(Font.font("Monospaced", 40));
        status.setAlignment(Pos.CENTER);
        //menu.getChildren().add(status);
        Board board = new Board(player, status);
        group.setPrefSize(600, 400);
        group.setCenter(board.getView());
        group.setTop(status);
        group.setAlignment(status, Pos.CENTER);
        
        
        Scene scene = new Scene(group);
        window.setScene(scene);
        window.show();
    }
    
}