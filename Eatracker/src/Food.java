/*
 * Author: Farryl
 * 
 * This class stores information on a given food and retains that information for use by the program.
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Food {

	// Stores the ID of the food
	private int id;

	// Stores the name of the food
	private String name;

	// Stores the quantity of the food as an integer
	private int quantity;

	// Stores measurement size (e.g. mL, g, serving, etc.) for each available
	// measurement size (may have multiple sizes)
	private ArrayList<String> size;

	// Stores the set measure of the food (as selected by user)
	private String setMeasure;

	// Stores the food group to which the food belongs
	// 0 for fruits/vegetable, 1 for protein, 2 for grains, 3 for unclassifiable
	private static int foodGroup;

	// Stores the amount of nutrient provided by food, for each nutrient
	private double[] nutrients;

	// Food constructor
	public Food(int id, String name, int quantity, ArrayList<String> size, String setMeasure, int foodGroup,
			double[] nutrients) {

		super();
		this.id = id;
		this.name = name;
		setQuantity(quantity);
		this.size = size;
		this.setMeasure = setMeasure;
		setFoodGroup(foodGroup);
		this.nutrients = nutrients;

	}

	// Overloaded Food constructor
	public Food(int id, String name, int foodGroup) {

		super();
		this.id = id;
		this.name = name;
		size = new ArrayList<String>();
		setMeasure = "1 serving";
		setFoodGroup(foodGroup);

		// 0 for calories, 1 for fat, 2 for saturated fat, 3 for trans fat, 4 for
		// cholesterol, 5 for sodium, 6 for potassium, 7 for carbohydrate, 8 for fibre,
		// 9 for sugars, 10 for protein, 11 for vitamin A, 12 for vitamin C, 13 for
		// calcium, 14 for iron, 15 for vitamin D, 16 for vitamin E, 17 for thiamin, 18
		// for riboflavin, 19 for niacin, 20 for folate, 21 for vitamin B6, 22 for
		// vitamin B12
		nutrients = new double[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	}

	// Setters and getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {

		// Default quantity 0
		if (quantity >= 0)
			this.quantity = quantity;
		else
			this.quantity = 0;

	}

	public ArrayList<String> getSize() {
		return size;
	}

	public void setSize(ArrayList<String> size) {
		this.size = size;
	}

	public String getSetMeasure() {
		return setMeasure;
	}

	public void setSetMeasure(String setMeasure) {
		this.setMeasure = setMeasure;
	}

	public static int getFoodGroup() {
		return foodGroup;
	}

	public void setFoodGroup(int foodGroup) {

		// Default food group 0
		if (foodGroup >= 0 && foodGroup <= 3)
			this.foodGroup = foodGroup;
		else
			this.foodGroup = 3;

	}

	public double[] getNutrients() {
		return nutrients;
	}

	public void setNutrients(double[] nutrients) {
		this.nutrients = nutrients;
	}

	// toString
	@Override
	public String toString() {
		return "Food [name=" + name + ", quantity=" + quantity + ", size=" + size + ", foodGroup=" + foodGroup
				+ ", nutrients=" + Arrays.toString(nutrients) + "]";
	}

}