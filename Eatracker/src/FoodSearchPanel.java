/*
 * Author: Farryl
 * 
 * This class creates a panel that allows the user to search for a food and add it to their menu.
 * 
 */

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class FoodSearchPanel extends JPanel {

	// Displays the prompt “Search for a Food”
	private JLabel promptLabel;

	// Allows the user to type in a food item
	private JTextField searchBox;

	// Button which processes the search
	private JButton searchButton;

	// Shows the user that the program is loading
	private JLabel loadLabel;

	// Displays the header for each column
	private ArrayList<JLabel> headerLabel;

	// Displays each food item’s name
	private ArrayList<JLabel> foodLabel;

	// Allows the user to input a quantity
	private ArrayList<JTextField> quantityBox;

	// Allows the user to select a serving size
	private ArrayList<JComboBox> sizeList;

	// Allows the user to add the selected food to the daily menu
	private ArrayList<JComboBox> addList;

	// Allows the user to scroll up or down
	private JScrollPane scrollPane;

	private JPanel resultsPanel;

	// Stores the food search results
	private ArrayList<Food> searchResult = new ArrayList<Food>();

	// FoodSearchPanel constructor
	public FoodSearchPanel() {

		panelSetup();
		objectSetup();

	}

	// Setup panel
	public void panelSetup() {

		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setLayout(null);
		setBackground(Color.decode("#F2FCFF"));

		// Set size of panel relative to size of other panels on screen
		setBounds(FoodTracker.foodTrackerGUI.menuPanel.getWidth(),
				FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight()
						+ FoodTracker.foodTrackerGUI.foodPanel.getHeight(),
				FoodTrackerGUI.LENGTH - FoodTracker.foodTrackerGUI.menuPanel.getWidth(),
				FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight()
						- FoodTracker.foodTrackerGUI.foodPanel.getHeight());

	}

	// Setup panel objects
	public void objectSetup() {

		// Setup prompt label
		promptLabel = new JLabel("Search for a Food: ");
		promptLabel.setFont(new Font("Arial", Font.BOLD, 24));
		promptLabel.setForeground(Color.BLACK);
		promptLabel.setBounds(20, 10, 270, 50);
		add(promptLabel);

		// Setup search box
		searchBox = new JTextField();
		searchBox.setForeground(Color.BLACK);
		searchBox.setBackground(Color.WHITE);
		searchBox.setCaretColor(Color.BLACK);
		searchBox.setSelectionColor(Color.GRAY);
		searchBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		searchBox.setFont(new Font("Arial", Font.PLAIN, 24));
		searchBox.setBounds(promptLabel.getWidth(), 10, FoodTrackerGUI.LENGTH - promptLabel.getWidth() - 600, 50);
		searchBox.setEditable(true);
		add(searchBox);

		// Setup search button
		searchButton = new JButton("Search");
		searchButton.setFont(new Font("Arial", Font.BOLD, 24));
		searchButton.setBounds(40 + promptLabel.getWidth() + searchBox.getWidth(), 10, 200, 50);
		searchButton.setBackground(Color.WHITE);
		searchButton.setForeground(Color.BLACK);
		searchButton.setFocusPainted(false);
		searchButton.setVisible(true);
		searchButton.addActionListener(new ActionListener() {

			// Show search results when "Search" button is clicked
			public void actionPerformed(ActionEvent e) {

				if (searchBox.getText().isEmpty() == false) {

					new Thread() {

						public void run() {

							// Show loading label
							loadLabel.setVisible(true);
							repaint();

						}

					}.start();

					// Clear current results
					searchResult.clear();

					try {

						// Open FOOD NAME text file
						Scanner scanner = new Scanner(new File("src/Data Files/FOOD NAME.txt"));
						scanner.useDelimiter(",");

						// Skip the first line
						scanner.nextLine();

						// Search entire file for corresponding items
						while (scanner.hasNext()) {

							scanner.nextLine();

							// Store the current item's ID
							int foodID = Integer.valueOf(scanner.next());

							scanner.next();

							// Store the current item's food group ID
							int foodGroupID = Integer.valueOf(scanner.next());

							scanner.next();

							// Store the current item's name
							String foodName = scanner.next();
							foodName = foodName.replaceAll("[0-9]", "");

							// If search result matches, add to list
							if (foodName.toLowerCase().contains(searchBox.getText().toLowerCase())) {

								searchResult.add(new Food(foodID, foodName, getFoodGroup(foodGroupID)));
								getSize(searchResult.get(searchResult.size() - 1));

							}

						}

						// Close file and display results
						scanner.close();
						displayResults();

					} catch (FileNotFoundException e1) {

						System.out.println("File not found");

					}

				}

			}

		});
		add(searchButton);

		// Setup load label
		loadLabel = new JLabel("Loading...");
		loadLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		loadLabel.setForeground(Color.BLACK);
		loadLabel.setBounds(60 + promptLabel.getWidth() + searchBox.getWidth() + searchButton.getWidth(), 10, 100, 50);
		loadLabel.setVisible(false);
		add(loadLabel);

		// Create result panel and set size of panel relative to size of other panels
		resultsPanel = new JPanel();
		resultsPanel.setPreferredSize(
				new Dimension(FoodTrackerGUI.LENGTH - FoodTracker.foodTrackerGUI.menuPanel.getWidth() - 50,
						FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight()
								- FoodTracker.foodTrackerGUI.foodPanel.getHeight() - getHeight()));
		resultsPanel.setLayout(null);
		resultsPanel.setBackground(Color.WHITE);

		// Setup scroll pane
		scrollPane = new JScrollPane(resultsPanel);
		scrollPane.setBounds(0, 120, getWidth() - 50, getHeight() - 100);
		scrollPane.setPreferredSize(new Dimension(getWidth() - 50, getHeight() - 100));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setBounds(scrollPane.getWidth(), 0, 50, getHeight() - 40);
		scrollPane.getVerticalScrollBar().setForeground(Color.BLACK);
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(scrollPane.getVerticalScrollBar());
		add(scrollPane);

		// Setup header labels
		headerLabel = new ArrayList<JLabel>();
		headerLabel.add(new JLabel("Food Item"));
		headerLabel.get(0).setBounds(20, 70, 200, 50);
		headerLabel.add(new JLabel("Quanity"));
		headerLabel.get(1).setBounds(630, 70, 200, 50);
		headerLabel.add(new JLabel("Size"));
		headerLabel.get(2).setBounds(800, 70, 200, 50);
		headerLabel.add(new JLabel("Add"));
		headerLabel.get(3).setBounds(1000, 70, 200, 50);

		for (int index = 0; index < headerLabel.size(); index++) {

			headerLabel.get(index).setFont(new Font("Arial", Font.PLAIN, 20));
			headerLabel.get(index).setForeground(Color.BLACK);
			add(headerLabel.get(index));

		}

		foodLabel = new ArrayList<JLabel>();
		quantityBox = new ArrayList<JTextField>();
		sizeList = new ArrayList<JComboBox>();
		addList = new ArrayList<JComboBox>();
		displayResults();

	}

	// Display search results based on user's input
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void displayResults() {

		// Remove currently displayed results
		for (JLabel currentLabel : foodLabel) {

			currentLabel.setVisible(false);
			resultsPanel.remove(currentLabel);

		}

		for (int index = 0; index < quantityBox.size(); index++) {

			quantityBox.get(index).setVisible(false);
			resultsPanel.remove(quantityBox.get(index));

			sizeList.get(index).setVisible(false);
			resultsPanel.remove(sizeList.get(index));

			addList.get(index).setVisible(false);
			resultsPanel.remove(addList.get(index));

		}

		foodLabel.clear();
		quantityBox.clear();
		sizeList.clear();
		addList.clear();
		resultsPanel.repaint();

		// Setup panel objects and add to scroll pane viewport
		for (int index = 0; index < searchResult.size(); index++) {

			// Create and setup label for displaying food name
			foodLabel.add(new JLabel(searchResult.get(index).getName()));
			foodLabel.get(index).setFont(new Font("Arial", Font.PLAIN, 20));
			foodLabel.get(index).setForeground(Color.BLACK);
			foodLabel.get(index).setBounds(50, 70 * index, 600, 50);
			foodLabel.get(index).setVisible(true);
			resultsPanel.add(foodLabel.get(index));

			// Create and setup text area for quantity
			quantityBox.add(new JTextField());
			quantityBox.get(index).setForeground(Color.BLACK);
			quantityBox.get(index).setBackground(Color.WHITE);
			quantityBox.get(index).setCaretColor(Color.BLACK);
			quantityBox.get(index).setSelectionColor(Color.GRAY);
			quantityBox.get(index).setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			quantityBox.get(index).setFont(new Font("Arial", Font.PLAIN, 20));
			quantityBox.get(index).setBounds(650, 5 + 70 * index, 30, 30);
			quantityBox.get(index).setEditable(true);
			resultsPanel.add(quantityBox.get(index));

			// Create and setup combo box for size measure
			sizeList.add(new JComboBox());
			for (String size : searchResult.get(index).getSize())
				sizeList.get(index).addItem(size);
			sizeList.get(index).setBounds(750, 5 + 70 * index, 150, 30);
			resultsPanel.add(sizeList.get(index));

			// Create and setup combo box for adding to user's menu
			addList.add(new JComboBox());
			addList.get(index).addItem("");
			addList.get(index).addItem("Breakfast");
			addList.get(index).addItem("Lunch");
			addList.get(index).addItem("Dinner");
			addList.get(index).addItem("AM Snack");
			addList.get(index).addItem("PM Snack");
			addList.get(index).setBounds(950, 5 + 70 * index, 150, 30);
			addList.get(index).addActionListener(new ActionListener() {

				// When an item is selected, add it to user's menu
				public void actionPerformed(ActionEvent e) {

					int index = addList.indexOf(e.getSource());

					if (quantityBox.get(index).getText().matches("[0-9]+")) {

						// Set the nutrients, quantity, and measure of the food
						getNutrients(searchResult.get(index));
						searchResult.get(index).setQuantity(Integer.valueOf(quantityBox.get(index).getText()));
						searchResult.get(index).setSetMeasure(String.valueOf(sizeList.get(index).getSelectedItem()));

						// Add it to the user's menu based on user's selection
						if (String.valueOf(addList.get(index).getSelectedItem()).equals("Breakfast")) {

							UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay].getBreakfast()
									.add(searchResult.get(index));
//							UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay]
//									.updateFood(UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay]
//											.getPartialMenu(0));
							FoodTracker.foodTrackerGUI.foodPanel.addButton(0);
							FoodTracker.foodTrackerGUI.foodPanel.updateButton(0);

						} else if (String.valueOf(addList.get(index).getSelectedItem()).equals("Lunch")) {

							UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay].getLunch()
									.add(searchResult.get(index));
//							UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay]
//									.updateFood(UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay]
//											.getPartialMenu(1));
							FoodTracker.foodTrackerGUI.foodPanel.addButton(1);
							FoodTracker.foodTrackerGUI.foodPanel.updateButton(1);

						} else if (String.valueOf(addList.get(index).getSelectedItem()).equals("Dinner")) {

							UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay].getDinner()
									.add(searchResult.get(index));
//							UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay]
//									.updateFood(UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay]
//											.getPartialMenu(2));
							FoodTracker.foodTrackerGUI.foodPanel.addButton(2);
							FoodTracker.foodTrackerGUI.foodPanel.updateButton(2);

						} else if (String.valueOf(addList.get(index).getSelectedItem()).equals("AM Snack")) {

							UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay].getAmSnack()
									.add(searchResult.get(index));
//							UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay]
//									.updateFood(UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay]
//											.getPartialMenu(3));
							FoodTracker.foodTrackerGUI.foodPanel.addButton(3);
							FoodTracker.foodTrackerGUI.foodPanel.updateButton(3);

						} else if (String.valueOf(addList.get(index).getSelectedItem()).equals("PM Snack")) {

							UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay].getPmSnack()
									.add(searchResult.get(index));
//							UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay]
//									.updateFood(UserOptionsPanel.getUser().getDailyMenu()[HistoryPanel.currentDay]
//											.getPartialMenu(4));
							FoodTracker.foodTrackerGUI.foodPanel.addButton(4);
							FoodTracker.foodTrackerGUI.foodPanel.updateButton(4);

						}

						UserOptionsPanel.getUser().updateNutrients();

					}

				}

			});
			resultsPanel.add(addList.get(index));

		}

		// Create and setup label for displaying end of results
		foodLabel.add(new JLabel("End of results"));
		foodLabel.get(foodLabel.size() - 1).setFont(new Font("Arial", Font.PLAIN, 20));
		foodLabel.get(foodLabel.size() - 1).setForeground(Color.BLACK);
		foodLabel.get(foodLabel.size() - 1).setBounds(50, 70 * (foodLabel.size() - 1), 600, 50);
		foodLabel.get(foodLabel.size() - 1).setVisible(true);
		resultsPanel.add(foodLabel.get(foodLabel.size() - 1));

		// Set size of results panel
		resultsPanel.setPreferredSize(
				new Dimension(FoodTrackerGUI.LENGTH - FoodTracker.foodTrackerGUI.menuPanel.getWidth() - 50,
						FoodTrackerGUI.WIDTH - FoodTracker.foodTrackerGUI.userOptionsPanel.getHeight()
								- FoodTracker.foodTrackerGUI.foodPanel.getHeight() - getHeight()
								+ 71 * searchResult.size()));

		loadLabel.setVisible(false);
		scrollPane.revalidate();
		repaint();

	}

	// Find the sizes of a food
	public void getSize(Food item) {

		try {

			// Open CONVERSION FACTOR text file
			Scanner scanner = new Scanner(new File("src/Data Files/CONVERSION FACTOR.txt"));
			scanner.useDelimiter(",");

			// Search file for corresponding food ID
			while (scanner.hasNext()) {

				scanner.nextLine();

				// Store the food ID in the file
				int foodID = Integer.valueOf(scanner.next());

				// If there's a match, get measure ID and add corresponding measure size to item
				// (unless it is blank)
				if (item.getId() == foodID) {

					int measureID = Integer.valueOf(scanner.next());
					String measure = getMeasure(measureID);

					if (measure.equals(" ") == false)
						item.getSize().add(measure);

					// Break out of loop if food item's ID has already been passed over
				} else if (item.getId() < foodID)
					break;

				// If there's no match, skip to the next line
				else
					scanner.nextLine();

			}

			// If there are no sizes written in files, set size to 1 serving
			if (item.getSize().size() == 0)
				item.getSize().add("1 serving");

			scanner.close();

		} catch (FileNotFoundException e1) {

			System.out.println("File not found");

		}

	}

	// Find the measure size for a food given the measure ID
	public String getMeasure(int measureID) {

		String measureName = " ";

		try {

			// Open MEASURE NAME text file
			Scanner scanner = new Scanner(new File("src/Data Files/MEASURE NAME.txt"));
			scanner.useDelimiter(",");

			// Skip the first line
			scanner.nextLine();

			// Search for corresponding measure ID
			while (scanner.hasNext()) {

				// Store the measure ID in the file
				int id = Integer.valueOf(scanner.next());

				// When found, store the measure name
				if (measureID == id) {

					measureName = scanner.next();
					measureName = measureName.replace(String.valueOf(id + 1), "");
					break;

					// If there's no match, skip to the next line
				} else
					scanner.nextLine();

			}

			scanner.close();

		} catch (FileNotFoundException e1) {

			System.out.println("File not found");

		}

		return measureName;

	}

	// // Find the food group of a food (unused due to inefficiency)
	// public int getFoodGroup(int foodGroupID) {
	//
	// String foodGroup = "";
	//
	// try {
	//
	// // Open FOOD GROUP text file
	// Scanner scanner = new Scanner(new File("src/Data Files/FOOD GROUP.txt"));
	// scanner.useDelimiter(",");
	//
	// // Skip the first line
	// scanner.nextLine();
	//
	// // Search for corresponding food group ID
	// while (scanner.hasNext()) {
	//
	// int id = Integer.valueOf(scanner.next());
	//
	// // If there's a match, store the food group
	// if (foodGroupID == id) {
	//
	// scanner.next();
	// foodGroup = scanner.next();
	// scanner.close();
	// break;
	//
	// // If there's no match, skip to the next line
	// } else
	// scanner.nextLine();
	//
	// }
	//
	// scanner.close();
	//
	// } catch (FileNotFoundException e1) {
	//
	// System.out.println("File not found");
	//
	// }
	//
	// // Classify each food group as either fruits/vegetables (0), protein(1),
	// // grains (2), or otherwise (3)
	// if (foodGroup.contains("Fruits and fruit juices") ||
	// foodGroup.contains("Vegetables and Vegetable Products"))
	// return 0;
	// else if (foodGroup.contains("Dairy and Egg Products") ||
	// foodGroup.contains("Poultry Products")
	// || foodGroup.contains("Sausages and Luncheon meats") ||
	// foodGroup.contains("Pork Products")
	// || foodGroup.contains("Nuts and Seeds") || foodGroup.contains("Beef
	// Products")
	// || foodGroup.contains("Finfish and Shellfish Products")
	// || foodGroup.contains("Legumes and Legume Products") ||
	// foodGroup.contains("Lamb. Veal and Game"))
	// return 1;
	// else if (foodGroup.contains("Breakfast cereals") ||
	// foodGroup.contains("Cereals. Grains and Pasta"))
	// return 2;
	// else
	// return 3;
	//
	// }

	// Find the food group of a food (more efficient as it does not use the FOOD
	// GROUP data file)
	public int getFoodGroup(int foodGroupID) {

		// Classify each food group as either fruits/vegetables (0), protein(1),
		// grains (2), or otherwise (3)
		if (foodGroupID == 9 || foodGroupID == 11)
			return 0;
		else if (foodGroupID == 1 || foodGroupID == 5 || foodGroupID == 7 || foodGroupID == 10 || foodGroupID == 12
				|| foodGroupID == 13 || foodGroupID == 15 || foodGroupID == 16 || foodGroupID == 17)
			return 1;
		else if (foodGroupID == 8 || foodGroupID == 20)
			return 2;
		else
			return 3;

	}

	// Find the nutrient values of a food
	public void getNutrients(Food item) {

		try {

			// Open NUTRIENT AMOUNT text file
			Scanner scanner = new Scanner(new File("src/Data Files/NUTRIENT AMOUNT.txt"));
			scanner.useDelimiter(",");

			// Search for corresponding food group ID
			while (scanner.hasNext()) {

				scanner.nextLine();

				// Store the food ID in the file
				int foodID = Integer.valueOf(scanner.next());

				// If the food item's ID matches the ID in the file, set the food item's
				// nutrients
				if (item.getId() == foodID) {

					// Store the nutrient ID and value
					int nutrientID = Integer.valueOf(scanner.next());
					double nutrientValue = Double.valueOf(scanner.next());

					// Set the nutrient value for the corresponding nutrient
					if (nutrientID == 208)
						item.getNutrients()[0] = nutrientValue; // Calories
					else if (nutrientID == 204)
						item.getNutrients()[1] = nutrientValue; // Fat
					else if (nutrientID == 606)
						item.getNutrients()[2] = nutrientValue; // Saturated fat
					else if (nutrientID == 605)
						item.getNutrients()[3] = nutrientValue; // Trans fat
					else if (nutrientID == 601)
						item.getNutrients()[4] = nutrientValue; // Cholesterol
					else if (nutrientID == 307)
						item.getNutrients()[5] = nutrientValue; // Sodium
					else if (nutrientID == 306)
						item.getNutrients()[6] = nutrientValue; // Potassium
					else if (nutrientID == 205)
						item.getNutrients()[7] = nutrientValue; // Carbohydrate
					else if (nutrientID == 291)
						item.getNutrients()[8] = nutrientValue; // Fibre
					else if (nutrientID == 269)
						item.getNutrients()[9] = nutrientValue; // Sugars
					else if (nutrientID == 203)
						item.getNutrients()[10] = nutrientValue; // Protein

					// Vitamin A (not in file)

					else if (nutrientID == 401)
						item.getNutrients()[12] = nutrientValue; // Vitamin C
					else if (nutrientID == 301)
						item.getNutrients()[13] = nutrientValue; // Calcium
					else if (nutrientID == 303)
						item.getNutrients()[14] = nutrientValue; // Iron
					else if (nutrientID == 324)
						item.getNutrients()[15] = nutrientValue; // Vitamin D

					// Vitamin E (not in file)

					else if (nutrientID == 404)
						item.getNutrients()[17] = nutrientValue; // Thiamin
					else if (nutrientID == 405)
						item.getNutrients()[18] = nutrientValue; // Riboflavin
					else if (nutrientID == 409)
						item.getNutrients()[19] = nutrientValue; // Niacin
					else if (nutrientID == 815)
						item.getNutrients()[20] = nutrientValue; // Folate

					// Vitamin B6 (not in file)

					else if (nutrientID == 874)
						item.getNutrients()[22] = nutrientValue; // Vitamin B12

					// Break out of loop if food item's ID has already been passed over
				} else if (item.getId() < foodID)
					break;

				// If there's no match, skip to the next line
				else
					scanner.nextLine();

			}

			scanner.close();

		} catch (FileNotFoundException e1) {

			System.out.println("File not found");

		}

	}

}