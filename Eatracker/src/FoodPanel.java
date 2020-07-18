import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class FoodPanel extends JPanel implements ActionListener {

	private JPanel[] innerPanel = new JPanel[6];

	// labels to display different types of meals in a day
	private JLabel[] mealType = new JLabel[6];

	// JButton for each of the food items in one day's daily menu
	// private JButton[][] foodList = new JButton[6][10];
	private ArrayList<JButton>[] foodList = new ArrayList[6];

	// for how many days the users has stored information, there will be that number
	// of menu size
	DailyMenu[] dMenu = UserOptionsPanel.getUser().getDailyMenu();

	// allow the user to scroll through the panel
	private JScrollPane[] scrollPane = new JScrollPane[6];

	private int buttonLength = 378;
	private int buttonWidth = 50;

	// FoodPanel constructor
	public FoodPanel() {

		panelSetup();
		objectSetup();

		// refresh when button clicked or food items added
		repaint();

	}

	// Setup panel
	public void panelSetup() {

		// set the starting position to attaching the left-side menu
		setBounds(FoodTracker.foodTrackerGUI.menuPanel.getWidth(),
				FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight(),
				FoodTrackerGUI.LENGTH - FoodTracker.foodTrackerGUI.menuPanel.getWidth(),
				FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight() - 400);
		setLayout(null);

		for (int i = 0; i < innerPanel.length; i++) {
			innerPanel[i] = new JPanel();
			innerPanel[i].setBounds(0, 0, (FoodTrackerGUI.LENGTH * 7 / 8) / 3,
					(FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight() - 300) / 2);

			innerPanel[i].setBackground(Color.WHITE);
			innerPanel[i].setLayout(null);
			innerPanel[i].setVisible(true);
		}
	}

	// Setup panel objects
	public void objectSetup() {

		// label set for default Daily Menu for Day 0 (can be modified later)
		// setup the labels for displaying titles for daily food items

		mealType[0] = new JLabel("Breakfast");
		mealType[1] = new JLabel("Lunch");
		mealType[2] = new JLabel("Dinner");
		mealType[3] = new JLabel("A.M. Snack");
		mealType[4] = new JLabel("P.M. Snack");
		mealType[5] = new JLabel("Supplements");

		for (int i = 0; i < mealType.length; i++) {

			mealType[i].setFont(new Font("Arial", Font.PLAIN, 20));
			mealType[i].setForeground(Color.BLACK);
			mealType[i].setBounds(0, 0, 378, 50);
			mealType[i].setVisible(true);
			innerPanel[i].add(mealType[i]);
		}

		// initialize the arrayList for JButtons
		for (int i = 0; i < 6; i++) {
			foodList[i] = new ArrayList<JButton>();
		}

		// initiate the buttons for the inner panels
		removeButton();

		scrollPaneSetup();

	}

	// updates the display of the panel and rearrange the buttons
	public void addButton(int index) {
		JButton tempButton = null;

		int i = dMenu[HistoryPanel.currentDay].getPartialMenu(index).size() - 1;
		// initiate the name with quantity and food group of each item
		tempButton = new JButton(dMenu[HistoryPanel.currentDay].getPartialMenu(index).get(i).getQuantity() + " "
				+ dMenu[HistoryPanel.currentDay].getPartialMenu(index).get(i).getSize() + " "
				+ dMenu[HistoryPanel.currentDay].getPartialMenu(index).get(i).getName() + ", "
				+ dMenu[HistoryPanel.currentDay].getPartialMenu(index).get(i).getFoodGroup());
		tempButton.setBounds(0, UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay].getPartialMenu(index).size() * 50,
				buttonLength, buttonWidth);

		tempButton.setFont(new Font("Arial", Font.BOLD, 18));

		tempButton.setBackground(Color.WHITE);
		tempButton.setForeground(Color.BLACK);
		tempButton.setFocusPainted(false);
		tempButton.setVisible(true);
		// remove an item from the current selection if the they are clicked
		tempButton.addActionListener(this);

		foodList[index].add(tempButton);
		int j = foodList[index].size() - 1;
		innerPanel[index].add(foodList[index].get(j));

		updatesPreferredSize();
		repaint();
	}

	// Update the buttons for a specified meal type
	public void updateButton(int index) {

		// For each button in foodList arrayList
		for (int i = 0; i < UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay].getPartialMenu(index).size(); i++) {

			foodList[index].get(i).setBounds(0, 50 + i * 50, buttonLength, buttonWidth);

		}

	}

	// this methods creates the buttons on the inner panels when it is called
	public void removeButton() {
		// get the day # to access the daily menu of a specific day
		// initiate buttons for food items
		for (int k = 0; k < dMenu.length; k++) {
			for (int index = 0; index < 6; index++) {

				for (int i = 0; i < dMenu[k].getPartialMenu(index).size(); i++) {

					// initiate the name with quantity and food group of each item
					JButton tempButton = new JButton(dMenu[HistoryPanel.currentDay].getPartialMenu(index).get(i).getQuantity() + " "
							+ dMenu[HistoryPanel.currentDay].getPartialMenu(index).get(i).getSize() + " "
							+ dMenu[HistoryPanel.currentDay].getPartialMenu(index).get(i).getName() + ", "
							+ dMenu[HistoryPanel.currentDay].getPartialMenu(index).get(i).getFoodGroup());

					// cycles through number of days in the menu, then number of items in the whole
					// list, then cycles through each item in the list
					tempButton.setFont(new Font("Arial", Font.BOLD, 18));
					tempButton.setBounds(0, 50 + 50 * i, buttonLength, buttonWidth);
					tempButton.setBackground(Color.WHITE);
					tempButton.setForeground(Color.BLACK);
					tempButton.setFocusPainted(false);
					tempButton.setVisible(true);

					// remove an item from the current selection if the they are clicked
					tempButton.addActionListener(this);

					foodList[index].add(tempButton);
					innerPanel[index].add(foodList[index].get(i));
				}

			}
		}
		repaint();
	}

	// this method updates the position of the scroll pane and scroll bar for the
	// add button function
	public void scrollPaneSetup() {
		
		// Setup scroll pane
		for (int i = 0; i < scrollPane.length; i++) {
			scrollPane[i] = new JScrollPane(innerPanel[i]);
			if (i < 3) {
				scrollPane[i].setBounds(i * (FoodTrackerGUI.LENGTH * 7 / 8) / 3, 0, (FoodTrackerGUI.LENGTH * 7 / 8) / 3,
						(FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight() - 300) / 2);
			} else {
				scrollPane[i].setBounds((i - 3) * (FoodTrackerGUI.LENGTH * 7 / 8) / 3,
						(FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight() - 300) / 2,
						(FoodTrackerGUI.LENGTH * 7 / 8) / 3,
						(FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight() - 300) / 2);
			}
			scrollPane[i].setPreferredSize(new Dimension((FoodTrackerGUI.LENGTH * 7 / 8) / 3,
					(FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight() - 300) / 2));
			scrollPane[i].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			/** change the bounds **/
			if (i < 3) {
				scrollPane[i].getVerticalScrollBar().setBounds(
						(FoodTrackerGUI.LENGTH * 7 / 8) / 3 - 20 + i * ((FoodTrackerGUI.LENGTH * 7 / 8) / 3), 0, 20,
						(FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight() - 300) / 2);
			} else {
				scrollPane[i].getVerticalScrollBar().setBounds(
						(FoodTrackerGUI.LENGTH * 7 / 8) / 3 - 20 + (i - 3) * ((FoodTrackerGUI.LENGTH * 7 / 8) / 3),
						(FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight() - 300) / 2, 20,
						(FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight() - 300) / 2);
			}
			scrollPane[i].getVerticalScrollBar().setBackground(Color.WHITE);

			add(scrollPane[i]);
		}
	}

	// updates the preferred size of the panels to allow the user to use the scroll
	// bar function
	public void updatesPreferredSize() {

		for (int i = 0; i < innerPanel.length; i++) {
			innerPanel[i].setPreferredSize(new Dimension(buttonLength,
					2 * buttonWidth * UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay].getPartialMenu(i).size()));
			scrollPane[i].getVerticalScrollBar().revalidate();
		}
	}

	public void actionPerformed(ActionEvent event) {
		// goes through all the types of meals in a day
		for (int i = 0; i < foodList.length; i++) {
			// check for every item in a certain type of meal
			for (int k = 0; k < foodList[i].size(); k++) {

				// if a button is clicked, remove that item from the user's daily menu
				if (event.getSource() == foodList[i].get(k)) {
					foodList[i].get(k).setVisible(false);
					foodList[i].get(k).removeActionListener(this);

					foodList[i].remove(k);
					UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay].getPartialMenu(i).remove(k);

					// this method should relocate the scroll pane in the daily menus
					updatesPreferredSize();

					updateButton(i);
				}
			}
		}

	}
}