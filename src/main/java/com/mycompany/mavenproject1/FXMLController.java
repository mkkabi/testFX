package com.mycompany.mavenproject1;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLController extends Application implements Initializable  {
	Stage primaryStage;
	public static ObjectOutputStream saver;
	public static ObjectInputStream loader;
    
    @FXML
    private Label label;
		@FXML
		private TextArea text;
		@FXML
		private Button imageButton1;
		@FXML
		private AnchorPane linesPane;
		@FXML
		private TextArea textForClass;
    
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
				//text.setText("clicked \n");
				text.appendText("adsfasdf");
    }

		boolean buttonPressed = false;

    @FXML
		private void showSomeLines(){
			double x = 0;	
			int y = 1;
			linesPane.getChildren().clear();
			for (NewClass obj : NewClass.objects){
				NewClassUI ui = new NewClassUI();
				ui.set(obj);
				Button but2 = ui.getButton();
				but2.setLayoutY(x);
				linesPane.getChildren().add(but2);
				y++; x += 26.0;
			}
			Label label = NewClassUI.label2;
			label.setLayoutY(x+30);
			linesPane.getChildren().add(label);
		}

		@FXML
		private void restoreClasses() throws IOException, ClassNotFoundException{
			loader = new ObjectInputStream(new FileInputStream("saves.txt"));
			Object obj1 = null;
			int x = 0;
			while(true){
				x++;
				try{
			NewClass obj = (NewClass)loader.readObject();
			NewClass.objects.add(obj);
			System.out.println("restore method called");
				}catch(EOFException e){
				label.setText("restored all " +x+ " classes" );
					System.out.println("restored all " +(x-1)+ " classes");
					loader.close();
				}
		}
		}
		
		@FXML
		private void saveClasses() throws IOException, ClassNotFoundException, Exception{
			saver = new ObjectOutputStream(new FileOutputStream(new File("saves.txt")));
			for (NewClass obj : NewClass.objects){
			saver.writeObject(obj);
				System.out.println("save method called");
			}
			saver.close();

		}
		
		@FXML
		private void createNewClass() throws IOException{
			System.out.println(Integer.parseInt(textForClass.getText()));
			try{
			new NewClass(Integer.parseInt(textForClass.getText()));
			}catch(Error e){System.out.println(e);}
		}
		
		@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root2 = FXMLLoader.load(getClass().getResource("/fxml/Scene2.fxml"));
        
//			primaryStage.getScene().getWindow();
        Scene scene2 = new Scene(root2);
        scene2.getStylesheets().add("/styles/scene2.css");
        
				
        //stage.setTitle("JavaFX and Maven");
        primaryStage.setScene(scene2);
        primaryStage.show();
	}
}
