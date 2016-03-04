package com.minhhoang.view;

import com.minhhoang.Main;
import com.minhhoang.model.Helper;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ConvertOverviewController {
	
	private Main main;
	
	@FXML
	private Label lblCredit;
	
	@FXML
	private Button btnConvert;
	
	@FXML
	private Button btnSaveAs;
	
	@FXML
	private TextArea txtaDisplay;
	
	
	public ConvertOverviewController() {	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void convert() {
		String[] allEmails = Helper.getEmail(txtaDisplay.getText());
		String[] allLinks = Helper.convertToHtml(allEmails);
		txtaDisplay.setText("");
		for (String link : allLinks) {
			txtaDisplay.appendText(link + '\n');
		}
	}
	
	@FXML
	private void saveAs() {
		
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	

}
