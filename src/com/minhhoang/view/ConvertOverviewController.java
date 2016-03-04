package com.minhhoang.view;

import java.io.File;

import com.minhhoang.Main;
import com.minhhoang.model.Helper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class ConvertOverviewController {
	
	private Main main;
	private String[] allEmails, allLinks;
	private static final String FB_NEED_INPUT = "Please a list of emails with each on each new line";
	private static final String FB_SUCCESSFULLY_SAVED = "List of links was saved on file";
	
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
		allEmails = Helper.getEmail(txtaDisplay.getText());
		allLinks = Helper.convertToHtml(allEmails);
		txtaDisplay.setText("");
		for (String link : allLinks) {
			txtaDisplay.appendText(link + '\n');
		}
	}
	
	@FXML
	private void saveAs() {
		if (allLinks != null) {
			FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Image");
            File file = fileChooser.showSaveDialog(main.getStage());
            Helper.saveFile(file.getAbsolutePath(), allLinks);
            lblCredit.setText(FB_SUCCESSFULLY_SAVED);
		}
		else {
			lblCredit.setText(FB_NEED_INPUT);
		}
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	

}
