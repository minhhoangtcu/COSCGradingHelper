package com.minhhoang;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // import classes for event handling

public class Lab5ExperimentCode extends JApplet implements ActionListener {
	
	JLabel label1 = new JLabel("Testing");
	JLabel idLabel = new JLabel("ID Number", Label.RIGHT);
	JTextField id = new JTextField(10);
	JCheckBox probation = new JCheckBox("Probation?");
	JButton cancel = new JButton("CLEAR");
	JButton display = new JButton("DISPLAY");
	JTextField grade1tf = new JTextField(10);
	JTextField grade2tf = new JTextField(10);
	JLabel grade1l = new JLabel("grade 1");
	JLabel grade2l = new JLabel("grade 2");

	Font myFont = new Font("Times", Font.ITALIC, 14);
	DefaultListModel myModel = new DefaultListModel();
	JList myList = new JList(myModel);
	JComboBox myChoice = new JComboBox();
	JPanel panelTop = new JPanel(new GridLayout(1, 4));
	JPanel panelCenter = new JPanel(new GridLayout(2, 1));
	JPanel panelBottom = new JPanel(new GridLayout(1, 1));
	JPanel panelWest = new JPanel(new GridLayout(4, 1));
	JPanel pDisplay = new JPanel();
	JLabel pLabel = new JLabel("Results", JLabel.CENTER);
	JLabel averageL = new JLabel("Average", JLabel.CENTER);
	JTextField averageTf = new JTextField();

	public void init() {
		System.out.println(" At Method init");
		setLayout(new BorderLayout());
		// set applet's backgound color and size
		cancel.setForeground(Color.red);
		display.setForeground(Color.blue);
		panelTop.setBackground(Color.cyan);
		panelCenter.setBackground(Color.green);
		panelWest.setBackground(Color.magenta);
		setSize(500, 200);

		// set properties of individual widgets
		label1.setForeground(Color.red);
		label1.setFont(myFont);
		label1.setSize(80, 40);
		label1.setLocation(200, 200);

		idLabel.setForeground(Color.blue);
		idLabel.setFont(myFont);

		// add items to List widget
		myList.setBackground(Color.green);

		addItemsToWidgetsX();
		// add Widgets to JPanels to JApplet
		panelTop.add(label1);
		panelTop.add(probation);
		panelTop.add(idLabel);
		panelTop.add(id);
		panelWest.add(grade1l);
		panelWest.add(grade1tf);
		panelWest.add(grade2l);
		panelWest.add(grade2tf);
		panelCenter.add(myList);
		panelCenter.add(myChoice);
		panelBottom.add(display);
		panelBottom.add(cancel);

		// add JPanels to JApplet
		add(panelTop, BorderLayout.NORTH);
		add(panelCenter, BorderLayout.CENTER);
		add(panelWest, BorderLayout.WEST);
		add(panelBottom, BorderLayout.SOUTH);
		// add item listeners
		cancel.addActionListener(this);
		display.addActionListener(this);

	}

	public void addItemsToWidgetsX() {
		System.out.println(" At Method addItemToWidgets");
		// add items to model of the List widget
		myModel.addElement("Math");
		myModel.addElement("Business");
		myModel.addElement("Biology");
		myModel.addElement("Chemistry");
		// add items to Choice widget
		myChoice.addItem("Soccer");
		myChoice.addItem("Football");
		myChoice.addItem("Baseball");
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(" At Method action Performed");
		String whichButton = e.getActionCommand();
		if (whichButton.equals("DISPLAY"))
			displayData();
		if (whichButton.equals("CLEAR"))
			clearAll();
		validate();

	}

	public void displayData() {
		System.out.println(" At Method Display Data");
		String sport, course, probationString; // local variables
		boolean inProbation; // local boolean
		pDisplay = new JPanel(new GridLayout(4, 1));
		pDisplay.add(pLabel, BorderLayout.NORTH);
		pDisplay.setBackground(Color.yellow);
		// get values from Checkbox,JList and JComboBox
		course = (String) myList.getSelectedValue();
		sport = (String) myChoice.getSelectedItem();
		inProbation = probation.isSelected();
		if (inProbation)
			probationString = " study hard ";
		else
			probationString = " your OK ";
		JTextField textDisplay = new JTextField(course + " and " + sport + probationString);
		averageTf.setText(computeAverage());
		pDisplay.add(textDisplay);
		pDisplay.add(averageL);
		pDisplay.add(averageTf);
		add("East", pDisplay);
	}

	public void clearAll() {
		System.out.println(" At Method clear All");
		myChoice.setSelectedIndex(0);
		myList.setSelectedIndex(0);
		probation.setSelected(false);
		grade1tf.setText("");
		grade2tf.setText("");
		remove(pDisplay);
	}

	public String computeAverage() {
		System.out.println(" At Method compute average");
		double value1 = Double.parseDouble(grade1tf.getText());
		double value2 = Double.parseDouble(grade2tf.getText());
		String result = "" + (value1 + value2) / 2;
		return result;
	}

}
