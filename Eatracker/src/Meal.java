
/*
 * Author: Farryl
 * 
 * This class creates a custom meal for the user.
 * 
 */

import java.util.ArrayList;

public class Meal {

	// Stores the custom name decided by user
	private String name;

	// Stores the list of foods in the meal
	private ArrayList<Food> foodItem;

	// Meal constructor
	public Meal(String name, ArrayList<Food> foodItem) {

		super();
		this.name = name;
		this.foodItem = foodItem;

	}

	// Setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Food> getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(ArrayList<Food> foodItem) {
		this.foodItem = foodItem;
	}

	// toString
	@Override
	public String toString() {
		return "Meal [name=" + name + ", foodItem=" + foodItem + "]";
	}

}
