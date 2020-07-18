/*
 * Author: Farryl
 * 
 * This class stores information on the user's food intake for the day.
 * 
 */

import java.util.ArrayList;

public class DailyMenu {

	// Stores the user's breakfast for the day
	private ArrayList<Food> breakfast;

	// Stores the user's lunch for the day
	private ArrayList<Food> lunch;

	// Stores the user's dinner for the day
	private ArrayList<Food> dinner;

	// Stores the user's AM snack for the day
	private ArrayList<Food> amSnack;

	// Stores the user's PM snack for the day
	private ArrayList<Food> pmSnack;

	// Stores the user's supplement intake for the day
	private ArrayList<Food> supplements;

	// DailyMenu constructor
	public DailyMenu(ArrayList<Food> breakfast, ArrayList<Food> lunch, ArrayList<Food> dinner, ArrayList<Food> amSnack,
			ArrayList<Food> pmSnack, ArrayList<Food> supplements) {

		super();
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.amSnack = amSnack;
		this.pmSnack = pmSnack;
		this.supplements = supplements;

	}

	// Overloaded DailyMenu constructor
	public DailyMenu() {

		super();
		breakfast = new ArrayList<Food>();
		lunch = new ArrayList<Food>();
		dinner = new ArrayList<Food>();
		amSnack = new ArrayList<Food>();
		pmSnack = new ArrayList<Food>();
		supplements = new ArrayList<Food>();

	}

	// Setters and getters
	public ArrayList<Food> getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(ArrayList<Food> breakfast) {
		this.breakfast = breakfast;
	}

	public ArrayList<Food> getLunch() {
		return lunch;
	}

	public void setLunch(ArrayList<Food> lunch) {
		this.lunch = lunch;
	}

	public ArrayList<Food> getDinner() {
		return dinner;
	}

	public void setDinner(ArrayList<Food> dinner) {
		this.dinner = dinner;
	}

	public ArrayList<Food> getAmSnack() {
		return amSnack;
	}

	public void setAmSnack(ArrayList<Food> amSnack) {
		this.amSnack = amSnack;
	}

	public ArrayList<Food> getPmSnack() {
		return pmSnack;
	}

	public void setPmSnack(ArrayList<Food> pmSnack) {
		this.pmSnack = pmSnack;
	}

	public ArrayList<Food> getSupplements() {
		return supplements;
	}

	public void setSupplements(ArrayList<Food> supplements) {
		this.supplements = supplements;
	}
	
	// Returns part of the daily menu given an index
	// 0 - breakfast, 1 - lunch, 2 - dinner, 3 - AM snack, 4 - PM snack, 5 - supplements
	public ArrayList<Food> getPartialMenu(int index){
		
		switch(index) {
		
		case 0: return getBreakfast();
		
		case 1: return getLunch();
		
		case 2: return getDinner();
		
		case 3: return getAmSnack();
		
		case 4: return getPmSnack();
		
		case 5: return getSupplements();
		
		}
		
		// Return breakfast by default
		return getBreakfast();
		
	}

	// toString
	@Override
	public String toString() {
		return "DailyMenu [breakfast=" + breakfast + ", lunch=" + lunch + ", dinner=" + dinner + ", amSnack=" + amSnack
				+ ", pmSnack=" + pmSnack + ", supplements=" + supplements + "]";
	}

}