
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;

import javax.swing.*;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {

	// Label that displays the name of the program
	private JLabel title = new JLabel();

	// Labels that prompt the user to input their username and password
	private JLabel[] promptLabel = new JLabel[2];

	// Text areas for user to input their username and password
	private JTextArea[] inputTextArea = new JTextArea[2];

	// Buttons that allow the user to login or sign up
	private JButton[] optionButton = new JButton[2];

	// LoginPanel constructor
	public LoginPanel() {

		panelSetup();
		objectSetup();
		buttonSetup();

	}

	// Setup panel
	private void panelSetup() {

		setBackground(Color.decode("#C9F1FF"));
		setBounds(0, 0, FoodTrackerGUI.LENGTH, FoodTrackerGUI.WIDTH);
		setLayout(null);

	}

	// Setup panel objects
	private void objectSetup() {

		// Setup title label
		title.setText("Food Tracker");
		title.setFont(new Font("Arial", Font.BOLD, 48));
		title.setForeground(Color.BLACK);
		title.setBounds(FoodTrackerGUI.LENGTH / 2 - 160, FoodTrackerGUI.WIDTH / 9, 320, 50);
		add(title);

		// Setup prompt labels and text areas
		promptLabel[0] = new JLabel("Username: ");
		promptLabel[1] = new JLabel("Password: ");

		for (int index = 0; index < promptLabel.length; index++) {

			promptLabel[index].setFont(new Font("Arial", Font.BOLD, 28));
			promptLabel[index].setForeground(Color.BLACK);
			promptLabel[index].setBounds(FoodTrackerGUI.LENGTH / 4, FoodTrackerGUI.WIDTH / 3 + 80 * index, 180, 50);
			add(promptLabel[index]);

			inputTextArea[index] = new JTextArea();
			inputTextArea[index].setForeground(Color.BLACK);
			inputTextArea[index].setBackground(Color.WHITE);
			inputTextArea[index].setCaretColor(Color.BLACK);
			inputTextArea[index].setSelectionColor(Color.GRAY);
			inputTextArea[index].setFont(new Font("Arial", Font.BOLD, 28));
			inputTextArea[index].setBounds(FoodTrackerGUI.LENGTH / 4 + promptLabel[index].getWidth(),
					FoodTrackerGUI.WIDTH / 3 + 80 * index, FoodTrackerGUI.LENGTH / 2 - promptLabel[index].getWidth(),
					50);
			inputTextArea[index].setEditable(true);
			add(inputTextArea[index]);

		}

	}

	// Setup panel buttons
	private void buttonSetup() {

		// Setup option buttons
		optionButton[0] = new JButton("Login");
		optionButton[1] = new JButton("Sign Up");

		for (int index = 0; index < optionButton.length; index++) {

			optionButton[index].setFont(new Font("Arial", Font.BOLD, 28));
			optionButton[index].setBounds(FoodTrackerGUI.LENGTH / 2 + 200 * index - 200, 2 * FoodTrackerGUI.WIDTH / 3,
					200, 100);
			optionButton[index].setBackground(Color.WHITE);
			optionButton[index].setForeground(Color.BLACK);
			optionButton[index].setFocusPainted(false);
			add(optionButton[index]);

		}

		// Setup login button action listener
		optionButton[0].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// TO DO: program "Login" button to validate username and password
				
				// Set the current date
				int year = Integer.valueOf(String.valueOf(LocalDateTime.now()).substring(0, 4));
				int month = Integer.valueOf(String.valueOf(LocalDateTime.now()).substring(5, 7));
				int day = Integer.valueOf(String.valueOf(LocalDateTime.now()).substring(8, 10));
				HistoryPanel.currentDay = Date.dayNum(new Date(day, month, year));

				FoodTracker.foodTrackerGUI.defaultPage();
				setVisible(false);
				FoodTracker.foodTrackerGUI.remove(FoodTracker.foodTrackerGUI.loginPanel);

			}

		});

		// Setup sign up button action listener
		optionButton[1].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FoodTracker.foodTrackerGUI.signUp();
				setVisible(false);
				FoodTracker.foodTrackerGUI.remove(FoodTracker.foodTrackerGUI.signUpPanel);

			}

		});

	}

}