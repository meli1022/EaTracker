import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class UserOptionsPanel extends JPanel {

	// Stores information on the current user
	private static User user;

	// Displays the user's name
	private JLabel nameLabel;

	// Buttons which allow the user to save or log out
	private JButton[] optionButton;

	// Setters and getters
	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		UserOptionsPanel.user = user;
	}

	// UserOptionsPanel constructor
	public UserOptionsPanel(User user) {

		UserOptionsPanel.user = user;
		panelSetup();
		objectSetup();

	}

	// Setup panel
	public void panelSetup() {

		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		setBorder(border);
		setBounds(0, 0, FoodTrackerGUI.LENGTH, FoodTrackerGUI.WIDTH / 9);
		setBackground(Color.PINK);
		setLayout(null);

	}

	// Setup panel objects
	public void objectSetup() {

		// Setup name label
		nameLabel = new JLabel(getUser().getName());
		nameLabel.setFont(new Font("Arial", Font.BOLD, 32));
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setBounds(FoodTrackerGUI.LENGTH / 16 - 50, FoodTrackerGUI.WIDTH / 45 + 5, 320, 50);
		add(nameLabel);

		// Setup option buttons
		optionButton = new JButton[2];
		optionButton[0] = new JButton("Save");
		optionButton[0].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// TO DO: program "Save" button to save user information

			}

		});
		optionButton[1] = new JButton("Log Out");
		optionButton[1].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// TO DO: program "Log Out" button to return to login menu

			}

		});

		for (int index = 0; index < optionButton.length; index++) {

			optionButton[index].setFont(new Font("Arial", Font.BOLD, 32));
			optionButton[index].setBounds(5 * FoodTrackerGUI.LENGTH / 8 + 220 * index, FoodTrackerGUI.WIDTH / 45, 200,
					50);
			optionButton[index].setBackground(Color.WHITE);
			optionButton[index].setForeground(Color.BLACK);
			optionButton[index].setFocusPainted(false);
			// optionButton[index].setOpaque(false);
			// optionButton[index].setContentAreaFilled(false);
			// optionButton[index].setBorderPainted(false);
			add(optionButton[index]);

		}

	}

}