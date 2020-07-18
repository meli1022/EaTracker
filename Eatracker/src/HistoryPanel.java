import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class HistoryPanel extends JPanel {

	// Stores the current day
	public static int currentDay;

	// Displays the screen title
	private JLabel title;

	// Displays the current date
	private JLabel date;

	// Prompts the user to enter the date
	private JLabel prompt;

	// Allows the user to enter the date
	private JTextField[] dateBox;

	// Displays the slashes for the date
	private JLabel slash;

	// Allows the user to confirm the date
	private JButton optionButton;

	// Gives the user notice on the confirmation of date change
	private JLabel notice;

	// HistoryPanel constructor
	public HistoryPanel() {

		panelSetup();
		objectSetup();

	}

	// Setup panel
	public void panelSetup() {

		setBounds(FoodTracker.foodTrackerGUI.menuPanel.getWidth(),
				FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight(),
				FoodTrackerGUI.LENGTH - FoodTracker.foodTrackerGUI.menuPanel.getWidth(),
				FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight());
		setBackground(Color.decode("#F2FCFF"));
		setLayout(null);

	}

	// Setup panel objects
	public void objectSetup() {

		// Setup title label
		title = new JLabel("History");
		title.setFont(new Font("Arial", Font.BOLD, 32));
		title.setBounds(30, 20, 200, 50);
		add(title);

		// Setup date label
		date = new JLabel(String.format("The current date is %s", Date.numToDate(currentDay).format()));
		date.setFont(new Font("Arial", Font.PLAIN, 24));
		date.setBounds(30, 100, 400, 50);
		add(date);

		// Setup prompt label
		prompt = new JLabel("Select a date (MM/DD/YYYY): ");
		prompt.setFont(new Font("Arial", Font.PLAIN, 24));
		prompt.setBounds(30, 180, 400, 50);
		add(prompt);

		// Setup date text boxes
		dateBox = new JTextField[3];

		for (int index = 0; index < dateBox.length; index++) {

			dateBox[index] = new JTextField();
			dateBox[index].setForeground(Color.BLACK);
			dateBox[index].setBackground(Color.WHITE);
			dateBox[index].setCaretColor(Color.BLACK);
			dateBox[index].setSelectionColor(Color.GRAY);
			dateBox[index].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			dateBox[index].setFont(new Font("Arial", Font.PLAIN, 24));
			dateBox[index].setBounds(30 + 80 * index, 240, 40, 40);
			dateBox[index].setEditable(true);
			add(dateBox[index]);

		}
		dateBox[2].setBounds(190, 240, 100, 40);

		// Setup slash label
		slash = new JLabel("      /       /");
		slash.setFont(new Font("Arial", Font.PLAIN, 36));
		slash.setBounds(25, 240, 300, 50);
		add(slash);

		// Setup option button
		optionButton = new JButton("Confirm");
		optionButton.setFont(new Font("Arial", Font.PLAIN, 24));
		optionButton.setBounds(30, 320, 150, 40);
		optionButton.setBackground(Color.WHITE);
		optionButton.setForeground(Color.BLACK);
		optionButton.setFocusPainted(false);
		optionButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Check if the date entered is a valid date
				if (dateBox[0].getText().matches("[0-9]+") && dateBox[1].getText().matches("[0-9]+")
						&& dateBox[2].getText().matches("[0-9]+")
						&& Date.checkValid(Integer.valueOf(dateBox[1].getText()), Integer.valueOf(dateBox[0].getText()),
								Integer.valueOf(dateBox[2].getText()))) {

					// Set the new current day
					currentDay = Date.dayNum(new Date(Integer.valueOf(dateBox[1].getText()),
							Integer.valueOf(dateBox[0].getText()), Integer.valueOf(dateBox[2].getText())));
					date.setText(String.format("The current date is %s", Date.numToDate(currentDay).format()));
					
					// Give the user notice on whether the date has changed
					notice.setText("Date changed!");
					notice.setVisible(true);
					
					// Otherwise, tell the user that the date is invalid
				}else {
					
					notice.setText("Invalid date; only dates between 01/01/2019 to 12/31/2019 are valid.");
					notice.setVisible(true);
					
				}

			}

		});
		add(optionButton);
		
		//Setup notice label
		notice = new JLabel(" ");
		notice.setFont(new Font("Arial", Font.PLAIN, 24));
		notice.setBounds(30, 400, 1000, 50);
		notice.setVisible(false);
		add(notice);
		

	}

}