/*
 * Author: Farryl
 * 
 * This class stores information on the user and retains that information for use by the program.
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;

public class User {

	// Stores the user's name
	private String name;

	// Stores the user's body mass index
	private double bmi;

	// Stores user’s daily food intake, as the user inputs, for each day
	private DailyMenu[] dailyMenu;

	// Stores user’s nutrient intake for each day, for each nutrient
	private double[][] nutrients;

	// Stores user’s custom meals
	private ArrayList<Meal> meals;

	// User constructor
	public User(String name, double bmi, DailyMenu[] dailyMenu, double[][] nutrients, ArrayList<Meal> meals) {

		super();
		this.name = name;
		this.bmi = bmi;
		this.dailyMenu = dailyMenu;
		this.nutrients = nutrients;
		this.meals = meals;

	}
	
	// Overloaded User constructor
	public User(String name, double bmi) {
		
		super();
		this.name = name;
		this.bmi = bmi;
		dailyMenu = new DailyMenu[1];
		dailyMenu[0] = new DailyMenu();
		nutrients = new double[1][];

		// 0 for calories, 1 for fat, 2 for saturated fat, 3 for trans fat, 4 for
		// cholesterol, 5 for sodium, 6 for potassium, 7 for carbohydrate, 8 for fibre,
		// 9 for sugars, 10 for protein, 11 for vitamin A, 12 for vitamin C, 13 for
		// calcium, 14 for iron, 15 for vitamin D, 16 for vitamin E, 17 for thiamin, 18
		// for riboflavin, 19 for niacin, 20 for folate, 21 for vitamin B6, 22 for
		// vitamin B12
		nutrients[0] = new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		this.meals = new ArrayList<Meal>();
		
	}

	// Setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public DailyMenu[] getDailyMenu() {
		return dailyMenu;
	}

	public void setDailyMenu(DailyMenu[] dailyMenu) {
		this.dailyMenu = dailyMenu;
	}

	public double[][] getNutrients() {
		return nutrients;
	}

	public void setNutrients(double[][] nutrients) {
		this.nutrients = nutrients;
	}

	public ArrayList<Meal> getMeals() {
		return meals;
	}

	public void setMeals(ArrayList<Meal> meals) {
		this.meals = meals;
	}
	
	// Updates the user's daily nutrient intake
	public void updateNutrients() {
		
		// Reset current nutrient values to 0
		for(int index = 0; index < nutrients[0].length; index++)
			nutrients[0][index] = 0;
		
		// Get each partial menu from the user's daily menu (e.g. breakfast, lunch, etc.)
		for(int index = 0; index < 5; index++) {
			
			// For each food in the partial menu, get each nutrient
			for(Food currentFood : dailyMenu[0].getPartialMenu(index)) {
				
				// Get the nutrient value for each nutrient and add it to the user's current nutrient amount
				for(int nutrientCount = 0; nutrientCount < currentFood.getNutrients().length; nutrientCount++) {
					
					nutrients[0][nutrientCount] += currentFood.getNutrients()[nutrientCount];
					
				}
				
			}
			
		}
		
	}

	// toString
	@Override
	public String toString() {
		return "User [name=" + name + ", bmi=" + bmi + ", dailyMenu=" + Arrays.toString(dailyMenu) + ", nutrients="
				+ Arrays.toString(nutrients) + ", meals=" + meals + "]";
	}

}