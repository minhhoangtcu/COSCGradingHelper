package com.minhhoang;

/******************************************************************
 * Modified from the TextBook 
/*******************************************************************/
import java.awt.*;

import javax.swing.*;

public class Lab4ExperimentCode extends JApplet {
	JButton home, join, faq, contact;
	Image img;
	JLabel title, logo, copyright, ntbkImg, ntbkDesc, infoSheets, welcomeMsg;
	JLabel basket;
	Color tanColor = new Color(204, 153, 51);
	Color darkColor = new Color(51, 17, 0);
	Color bkgrdColor = new Color(17, 8, 0);
	JPanel leftside, top, center, welcomePanel, separator, freeNotebook;

	// define a pop up frame
	JFrame popUpFrame = new JFrame("Pop UP Frame");

	public void init() {
		setLayout(new BorderLayout());
		setSize(700, 550);
		doTitle();
		doLeftSide();
		doBottom();
		doCenter();
		createFrame();
	}

	public void setupButton(JButton b) { // set view of the buttons
//		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		b.setForeground(tanColor);
		leftside.add(b);
	}

	public void doTitle() {
		img = getImage(getCodeBase(), "Images/coffeeLogoMetal.png");
		logo = new JLabel(new ImageIcon(img));
		img = getImage(getCodeBase(), "Images/logoName.png");
		title = new JLabel(new ImageIcon(img));
		top = new JPanel(new FlowLayout());
		top.add(logo);
		top.add(title);
		top.setBackground(tanColor);
		add(top, BorderLayout.NORTH);

	}

	public void doLeftSide() {
		// left side menu

		leftside = new JPanel(new GridLayout(5, 1));
		leftside.setBackground(darkColor);
		home = new JButton("Home");
		join = new JButton("Join the Club");
		faq = new JButton("FAQ");
		contact = new JButton("Contact Us");
		setupButton(home);
		setupButton(join);
		setupButton(faq);
		setupButton(contact);
		basket = new JLabel(new ImageIcon(getImage(getCodeBase(), "Images/coffeeBasket.png")));
		leftside.add(basket);
		add(leftside, BorderLayout.WEST);
	}

	public void doBottom() { // String can go across multiple lines: use + to
		// append
		copyright = new JLabel("<HTML>(c) 2008 by CoffeeClubOfTheWorld.com." + "  All Rights Reserved.", JLabel.CENTER);
		copyright.setForeground(tanColor);
		copyright.setOpaque(true);
		copyright.setBackground(darkColor);
		add(copyright, BorderLayout.SOUTH);
	}

	public void doCenter() {
		center = new JPanel(new BorderLayout());
		center.setBackground(tanColor);
		// add dark separator as blank colored panel in NORTH of center panel
		separator = new JPanel();
		separator.setBackground(darkColor);
		separator.setPreferredSize(new Dimension(10, 20));
//		separator.setPreferredSize(new Dimension(40, 40));
		center.add(separator, BorderLayout.NORTH);

		welcomePanel = new JPanel(new FlowLayout());
		welcomePanel.setOpaque(false);
		welcomeMsg = new JLabel("<html><center>" + "<H2>Welcome to our Coffee of the Month Club! </h2>"
				+ "<HR WIDTH=80%><I>Our coffee club is not just gourmet coffee - "
				+ "<BR>it's an immersion of experience. <HR WIDTH=80%><BR>"
				+ "We personally select gourmet coffees from around the world. <BR>"
				+ "</CENTER>Each month a freshly roasted coffee is sent to your door"
				+ "<BR>along with information sheets and other goodies." + "<BR><BR>Each month we send you:"
				+ "<UL><LI>A 12-oz. bag of fresh coffee beans" + "<LI>Information sheets about the coffee and region"
				+ "<LI>Regional gift (e.g., spices, nuts, chocolates, teas)"
				+ "</UL><BR><B>FREE SHIPPING!</B><BR><BR>");
		welcomeMsg.setForeground(darkColor);
		welcomePanel.add(welcomeMsg);
		// create the bottom free notebook offer
		freeNotebook = new JPanel(new GridLayout(1, 3));
		freeNotebook.setOpaque(false);
		ntbkImg = new JLabel(new ImageIcon(getImage(getCodeBase(), "Images/ntbk.png")));
		ntbkDesc = new JLabel("<HTML><CENTER>Buy NOW and receive<BR> a FREE "
				+ "<BR>leather binder <BR>for collecting the fact sheets!");
		infoSheets = new JLabel(new ImageIcon(getImage(getCodeBase(), "Images/InfoSheets.gif")));
		freeNotebook.add(ntbkImg);
		freeNotebook.add(ntbkDesc);
		freeNotebook.add(infoSheets);
		welcomePanel.add(freeNotebook, BorderLayout.SOUTH);
		center.add(welcomePanel, BorderLayout.CENTER);
		add(center, BorderLayout.CENTER);
	}

	// Method to create a Pop Up Frame
	public void createFrame() {
		System.out.println(" At Method create Frame");

		popUpFrame.setBackground(Color.cyan);
		popUpFrame.setSize(100, 100);
		popUpFrame.setBounds(150, 150, 200, 200);
		JPanel pDisplay = new JPanel(new GridLayout(3, 1));
		JLabel pLabel = new JLabel("A new Label", JLabel.CENTER);
		JButton pButton = new JButton("Pop Up Button");
		JCheckBox pCheckBox = new JCheckBox("Check Something");

		pDisplay.add(pLabel);
		pDisplay.add(pButton);
		pDisplay.add(pCheckBox);
		popUpFrame.add(pDisplay);
		popUpFrame.setVisible(true);
	}

}
