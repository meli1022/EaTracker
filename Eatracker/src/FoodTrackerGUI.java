/*
 * This class creates a new window that displays each panel.
 * 
 */

import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class FoodTrackerGUI extends JFrame {

	// Default length of the window
	public static final int LENGTH = 1366;
	
	// Default width of the window
	public static final int WIDTH = 768;
	
	// The screen from which the user must enter their username and password
	public LoginPanel loginPanel;

	// The screen from which the user may sign up with a new username and password
	public SignUpPanel signUpPanel;

	// The toolbar at the top which allows the user to select options such as "Save"
	public UserOptionsPanel userOptionsPanel;

	// The toolbar on the left which allows the user to navigate between screens
	public MenuPanel menuPanel;

	// The screen which shows the user's food intake for the current day
	public FoodPanel foodPanel;

	// The screen which allows the user to search for a food
	public static FoodSearchPanel foodSearchPanel;

	// The screen which allows the user to search for a supplement
	public SupplementSearchPanel supplementSearchPanel;

	// The screen which allows the user to see their custom meals
	public MyMealsPanel myMealsPanel;

	// The screen which allows the user to create a new custom meal
	public NewMealPanel newMealPanel;

	// The screen which shows the user's current food intake based on food group
	public static FoodGroupsPanel foodGroupsPanel;

	// The screen which shows the user's nutrient intake
	public NutrientsPanel nutrientsPanel;

	// The screen which shows the user's calories intake
	public CaloriesPanel caloriesPanel;

	// The screen which shows the user's past food intake
	public HistoryPanel historyPanel;

	// FoodTrackerGUI constructor
	public FoodTrackerGUI() {

		// Set up GUI
		setSize(LENGTH, WIDTH);
		setTitle("FOOD TRACKER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);

		login();
		setVisible(true);

	}

	// Show login screen
	public void login() {

		// Create new login panel and add it to GUI
		loginPanel = new LoginPanel();
		add(loginPanel);

	}

	// Show sign up screen
	public void signUp() {

		// Create new sign up panel and add it to GUI
		signUpPanel = new SignUpPanel();
		add(signUpPanel);

	}

	// Show user options bar
	public void userOptions(User user) {

		// Create new user options panel and add it to GUI
		userOptionsPanel = new UserOptionsPanel(user);
		add(userOptionsPanel);

	}

	// Show menu bar
	public void menu() {

		// Create menu panel and add it to GUI
		menuPanel = new MenuPanel();
		add(menuPanel);

	}

	// Show food panel
	public void food() {

		// Create food panel and add it to GUI
		foodPanel = new FoodPanel();
		add(foodPanel);

	}

	// Show food search panel
	public void foodSearch() {

		// Create food search panel and add it to GUI
		foodSearchPanel = new FoodSearchPanel();
		add(foodSearchPanel);

	}

	// Show supplement search panel
	public void supplementSearch() {

		// Create supplement search panel and add it to GUI
		supplementSearchPanel = new SupplementSearchPanel();
		add(supplementSearchPanel);

	}

	// Show my meals panel
	public void myMeals() {

		// Create my meals panel and add it to GUI
		myMealsPanel = new MyMealsPanel();
		add(myMealsPanel);

	}

	// Show new meal panel
	public void newMeal() {

		// Create new meal panel and add it to GUI
		newMealPanel = new NewMealPanel();
		add(newMealPanel);

	}

	// Show food groups panel
	public void foodGroups() {

		// Create food groups panel and add it to GUI
		foodGroupsPanel = new FoodGroupsPanel();
		add(foodGroupsPanel);

	}

	// Show nutrients panel
	public void nutrients() {

		// Create nutrients panel and add it to GUI
		nutrientsPanel = new NutrientsPanel();
		add(nutrientsPanel);

	}

	// Show calories panel
	public void calories() {

		// Create calories panel and add it to GUI
		caloriesPanel = new CaloriesPanel();
		add(caloriesPanel);

	}

	// Show history panel
	public void history() {

		// Create history panel and add it to GUI
		historyPanel = new HistoryPanel();
		add(historyPanel);

	}
	
	// Show default page upon login
	public void defaultPage() {
		
		userOptions(new User("John Doe", 20.0));
		menu();
		food();
		foodSearch();
		
		// Set currently displayed panel to food panel and food search panel
		ArrayList<JPanel> currentPanel = new ArrayList<JPanel>();
		currentPanel.add(foodPanel);
		currentPanel.add(foodSearchPanel);
		menuPanel.setCurrentPanel(currentPanel);
		
	}

}