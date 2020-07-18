import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Melissa 


@SuppressWarnings("serial")
public class NutrientsPanel extends JPanel {

	private JLabel[] titlesLabel = new JLabel[4]; // column titles
	private JLabel[] nutrientLabel = new JLabel[23]; // types of nutrients
	private JLabel[] unitLabel = new JLabel[23]; // unit of measurement for nutrients
	private JLabel[] userIntake = new JLabel[23]; // percent recommended intake
	private JLabel[] recLabel = new JLabel[23];
	DailyMenu[] dMenu = UserOptionsPanel.getUser().getDailyMenu();
	
	
	// NutrientsPanel constructor
	public NutrientsPanel() {

		
		panelSetup();
		objectSetup();
		//refresh when button clicked or food items added
				repaint();
	}

	// Setup panel
	public void panelSetup() {
		setBounds(FoodTrackerGUI.LENGTH/9 +50, 120, FoodTrackerGUI.LENGTH-FoodTrackerGUI.LENGTH/9 - 50, FoodTrackerGUI.WIDTH-300);
		setLayout(null);
		setBackground(Color.PINK);
		setVisible(true);
	}

	// Setup panel objects
	public void objectSetup() {

		
        
		// first row (titles)
		titlesLabel[0] = new JLabel("Nutrient");
		titlesLabel[1] = new JLabel("Units");
		titlesLabel[2] = new JLabel("Today's Intake");
		titlesLabel[3] = new JLabel("Recommended Intake");
		
	
		// nutrient column
		nutrientLabel[0] = new JLabel("Calories");
		nutrientLabel[1] = new JLabel("Fat");
		nutrientLabel[2] = new JLabel("Saturated Fat");
		nutrientLabel[3] = new JLabel("Trans Fat");
		nutrientLabel[4] = new JLabel("Cholesterol");
		nutrientLabel[5] = new JLabel("Sodium");
		nutrientLabel[6] = new JLabel("Potassium");
		nutrientLabel[7] = new JLabel("Carbohydrate");
		nutrientLabel[8] = new JLabel("Fibre");
		nutrientLabel[9] = new JLabel("Sugars");
		nutrientLabel[10] = new JLabel("Protein");
		nutrientLabel[11] = new JLabel("Vitamin A");
		nutrientLabel[12] = new JLabel("Vitamin C");
		nutrientLabel[13] = new JLabel("Calcium");
		nutrientLabel[14] = new JLabel("Iron");
		nutrientLabel[15] = new JLabel("Vitamin D");
		nutrientLabel[16] = new JLabel("Vitamin E");
		nutrientLabel[17] = new JLabel("Thiamin");
		nutrientLabel[18] = new JLabel("Riboflavin");
		nutrientLabel[19] = new JLabel("Niacin");
		nutrientLabel[20] = new JLabel("Folate");
		nutrientLabel[21] = new JLabel("Vitamin B6");
		nutrientLabel[22] = new JLabel("Vitamin B12");
		
		
		//unit column
		unitLabel[0] = new JLabel("kcal");
		unitLabel[1] = new JLabel("g");
		unitLabel[2] = new JLabel("g");
		unitLabel[3] = new JLabel("g");
		unitLabel[4] = new JLabel("mg");
		unitLabel[5] = new JLabel("mg");
		unitLabel[6] = new JLabel("mg");
		unitLabel[7] = new JLabel("g");
		unitLabel[8] = new JLabel("g");
		unitLabel[9] = new JLabel("g");
		unitLabel[10] = new JLabel("g");
		unitLabel[11] = new JLabel("RAE");
		unitLabel[12] = new JLabel("mg");
		unitLabel[13] = new JLabel("mg");
		unitLabel[14] = new JLabel("mg");
		unitLabel[15] = new JLabel("mcg");
		unitLabel[16] = new JLabel("mg");
		unitLabel[17] = new JLabel("mg");
		unitLabel[18] = new JLabel("mg");
		unitLabel[19] = new JLabel("NE");
		unitLabel[20] = new JLabel("DFE");
		unitLabel[21] = new JLabel("mg");
		unitLabel[22] = new JLabel("mcg");
		
		
		
		recLabel[0] = new JLabel ("2200 (Female) 2800 (Male)");
		recLabel[1] = new JLabel("46.8 - 65.4");
		recLabel[2] = new JLabel("13");
		recLabel[3] = new JLabel("2");
		recLabel[4] = new JLabel("200");
		recLabel[5] = new JLabel("1500");
		recLabel[6] = new JLabel("3500-4700");
		recLabel[7] = new JLabel("189.3 - 273.5");
		recLabel[8] = new JLabel("26");
		recLabel[9] = new JLabel("37.5 (Men), 25 (Women)");
		recLabel[10] = new JLabel("47.1 -147.3");
		recLabel[11] = new JLabel("700");
		recLabel[12] = new JLabel("65");
		recLabel[13] = new JLabel("1300");
		recLabel[14] = new JLabel("850");
		recLabel[15] = new JLabel("9.5");
		recLabel[16] = new JLabel("15");
		recLabel[17] = new JLabel("13");
		recLabel[18] = new JLabel("1.05");
		recLabel[19] = new JLabel("1.1");
		recLabel[20] = new JLabel("14");
		recLabel[21] = new JLabel("350");
		recLabel[22] = new JLabel("1.15");
		
		

		
		for (int index =0; index<userIntake.length;index++) {
		
			userIntake[index] = new JLabel(String.valueOf(UserOptionsPanel.getUser().getNutrients()[0][index]));
			System.out.println(String.valueOf(UserOptionsPanel.getUser().getNutrients()[0][index]));
			
		}
		
		// titles row
		for (int xindex = 0; xindex < titlesLabel.length; xindex++) {
			
				titlesLabel[xindex].setFont(new Font("Arial", Font.BOLD, 22));
				titlesLabel[xindex].setBounds(5 + xindex *(FoodTrackerGUI.LENGTH-FoodTrackerGUI.LENGTH/9)/5, 10, 250, 50);
				titlesLabel[xindex].setBackground(Color.WHITE);
				titlesLabel[xindex].setForeground(Color.BLUE);
				titlesLabel[xindex].setVisible(true);
				add(titlesLabel[xindex]);

		}

		// columns
		for (int yindex = 0; yindex < nutrientLabel.length; yindex++) {

			
			nutrientLabel[yindex].setFont(new Font("Arial", Font.BOLD, 18));
			nutrientLabel[yindex].setBounds(10, 50 + yindex *(FoodTrackerGUI.WIDTH-FoodTrackerGUI.WIDTH/9)/13, 250, 50);
			nutrientLabel[yindex].setBackground(Color.WHITE);
			nutrientLabel[yindex].setForeground(Color.BLACK);
			nutrientLabel[yindex].setVisible(true);
			add(nutrientLabel[yindex]);
			

			unitLabel[yindex].setFont(new Font("Arial", Font.BOLD, 18));
			unitLabel[yindex].setBounds(250, 50 + yindex *(FoodTrackerGUI.WIDTH-FoodTrackerGUI.WIDTH/9)/13, 250, 50);
			unitLabel[yindex].setBackground(Color.WHITE);
			unitLabel[yindex].setForeground(Color.BLACK);
			unitLabel[yindex].setVisible(true);
			add(unitLabel[yindex]);
			
						
			
		}
		
		for (int yindex = 0; yindex < userIntake.length; yindex++) {
			
			
			userIntake[yindex].setFont(new Font("Arial", Font.BOLD, 18));
			userIntake[yindex].setBounds(500, 50 + yindex *(FoodTrackerGUI.WIDTH-FoodTrackerGUI.WIDTH/9)/13, 250, 50);
			userIntake[yindex].setBackground(Color.WHITE);
			userIntake[yindex].setForeground(Color.BLACK);
			userIntake[yindex].setVisible(true);
			add(userIntake[yindex]);
			System.out.println(yindex);
			
			recLabel[yindex].setFont(new Font("Arial", Font.BOLD, 18));
			recLabel[yindex].setBounds(750, 50 + yindex *(FoodTrackerGUI.WIDTH-FoodTrackerGUI.WIDTH/9)/13, 250, 50);
			recLabel[yindex].setBackground(Color.WHITE);
			recLabel[yindex].setForeground(Color.BLACK);
			recLabel[yindex].setVisible(true);
			add(recLabel[yindex]);
			System.out.println(yindex);
			
			}

	}
}
