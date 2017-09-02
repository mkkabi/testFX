
package com.mycompany.mavenproject1;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewScene extends Scene{
	Group root1;
	Scene scene;
	Button go1;
	
	public NewScene(Parent root) {
		super(root);
		root1 = new Group();
		scene = new Scene(root1, 300, 250);
		go1 = new Button();
		
		MainApp.stage.setScene(scene);
		root1.getChildren().addAll(new TextField("aaaaaaa"));
	}
	
	
	
}
