package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NewClassUI<N extends NewClass> extends Application{
	public static Label label2;
	
	private N n;
	public void set(N n) { this.n = n; }
  public N get() { return n; }
	
	public NewClassUI(){
		label2 = new Label("test Label from NewClassUI");
	}

public Button but;
	
	public<N> Button getButton(){
		but = new Button("line "+n.getNumber());
		but.setOnAction(new EventHandler<ActionEvent>() {
    @Override 
		public void handle(ActionEvent e) {
         System.out.println("class "+n.getNumber()+" says hi");
				 label2.setText("class "+n.getNumber()+" says hi");
    }
});
		return but;
}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
