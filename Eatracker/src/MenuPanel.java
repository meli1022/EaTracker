import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

//Melissa 


@SuppressWarnings("serial")
public class MenuPanel extends JPanel {

	// Buttons which allow the user to navigate between different screens
	private JButton[] sidebarButtons = new JButton[7];
	
	// Stores the panel(s) the user is currently on
	private ArrayList<JPanel> currentPanel = new ArrayList<JPanel>();

	// Setters and getters
	public ArrayList<JPanel> getCurrentPanel() {
		return currentPanel;
	}

	public void setCurrentPanel(ArrayList<JPanel> currentPanel) {
		this.currentPanel = currentPanel;
	}

	// MenuPanel constructor
	public MenuPanel() {

		panelSetup();
		buttonSetup();
	}

	// Setup MenuPanel buttons
	
	//Food Button
	private void buttonSetup() {

		sidebarButtons[0] = new JButton("Food");
		sidebarButtons[0].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				hideCurrentPanel();
				FoodTracker.foodTrackerGUI.food();
				FoodTracker.foodTrackerGUI.foodSearch();
				currentPanel.add(FoodTracker.foodTrackerGUI.foodPanel);
				currentPanel.add(FoodTracker.foodTrackerGUI.foodSearchPanel);

			}

		});
		
		//Supplements Button
		sidebarButtons[1] = new JButton("Supplements");
		sidebarButtons[1].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				hideCurrentPanel();
				FoodTracker.foodTrackerGUI.food();
				FoodTracker.foodTrackerGUI.supplementSearch();
				currentPanel.add(FoodTracker.foodTrackerGUI.foodPanel);
				currentPanel.add(FoodTracker.foodTrackerGUI.supplementSearchPanel);

			}

		});
		
		//My Meals Button
		sidebarButtons[2] = new JButton("My Meals");
		sidebarButtons[2].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				hideCurrentPanel();
				FoodTracker.foodTrackerGUI.myMeals();
				currentPanel.add(FoodTracker.foodTrackerGUI.myMealsPanel);

			}

		});
		
		//Food Groups Button
		sidebarButtons[3] = new JButton("Food Groups");
		sidebarButtons[3].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				hideCurrentPanel();
				FoodTracker.foodTrackerGUI.foodGroups();
				currentPanel.add(FoodTracker.foodTrackerGUI.foodGroupsPanel);

			}

		});
		
		//Nutrients Button
		sidebarButtons[4] = new JButton("Nutrients");
		sidebarButtons[4].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				hideCurrentPanel();
				FoodTracker.foodTrackerGUI.nutrients();
				currentPanel.add(FoodTracker.foodTrackerGUI.nutrientsPanel);

			}

		});
		
		//Calories Button
		sidebarButtons[5] = new JButton("Calories");
		sidebarButtons[5].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				hideCurrentPanel();
				FoodTracker.foodTrackerGUI.calories();
				currentPanel.add(FoodTracker.foodTrackerGUI.caloriesPanel);

			}

		});
		//History Button
		sidebarButtons[6] = new JButton("History");
		sidebarButtons[6].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				hideCurrentPanel();
				FoodTracker.foodTrackerGUI.history();
				currentPanel.add(FoodTracker.foodTrackerGUI.historyPanel);

			}

		});

		// Button properties
		for (int index = 0; index < sidebarButtons.length; index++) {
			sidebarButtons[index].setFont(new Font("Arial", Font.BOLD, 24));
			sidebarButtons[index].setBounds(0, (FoodTrackerGUI.WIDTH - 100) * index / 8 + 100,
					FoodTrackerGUI.LENGTH / 8, (FoodTrackerGUI.WIDTH - 100) / 8);
			sidebarButtons[index].setBackground(Color.WHITE);
			sidebarButtons[index].setForeground(Color.BLACK);
			sidebarButtons[index].setFocusPainted(false);
			sidebarButtons[index].setVisible(true);
			add(sidebarButtons[index]);

		}

	}

	// Setup panel
	public void panelSetup() {

		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		setBorder(border);
		setBounds(0, 0, FoodTrackerGUI.LENGTH / 8, FoodTrackerGUI.WIDTH);
		setLayout(null);
		setVisible(true);

	}

	// Hide currently displayed panel
	public void hideCurrentPanel() {
		
		for(JPanel panel : currentPanel) {
			
			panel.setVisible(false);
			FoodTracker.foodTrackerGUI.remove(panel);
			
		}
		
		currentPanel.clear();
		
	}
	
}