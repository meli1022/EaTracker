import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

//Melissa 

@SuppressWarnings("serial")
public class FoodGroupsPanel extends JPanel {

	private JLabel[] resultLabel = new JLabel[4]; // labels for users food group results
	private JLabel[] recLabel = new JLabel[4]; // labels for recommended results
	int userResults;


	//Panel setup
	public FoodGroupsPanel() {

		setBounds(FoodTrackerGUI.LENGTH/9 +50, 120, FoodTrackerGUI.LENGTH-FoodTrackerGUI.LENGTH/9 - 50, FoodTrackerGUI.WIDTH-300);
		setLayout(null);
		setBackground(Color.PINK);
		setVisible(true);
	}

	public void paintComponent(Graphics g) {

		userResults = Food.getFoodGroup();
		
		System.out.println(userResults);
		
		//titles
		resultLabel[0] = new JLabel("Today's Results");
		resultLabel[1] = new JLabel("Fruits and Vegetable");
		resultLabel[2] = new JLabel("Whole Grains");
		resultLabel[3] = new JLabel("Proteins");

		recLabel[0] = new JLabel("Recommended");
		recLabel[1] = new JLabel("Fruits and Vegetable = 50% (Green)");
		recLabel[2] = new JLabel("Whole Grains = 25% (Blue)");
		recLabel[3] = new JLabel("Proteins = 25% (Red)");




		for (int yindex = 0; yindex < resultLabel.length; yindex++) {

			// Labels for users result's in each food group category
			resultLabel[yindex].setFont(new Font("Arial", Font.BOLD, 18));
			resultLabel[yindex].setBounds(10, 50 + yindex *(FoodTrackerGUI.WIDTH-FoodTrackerGUI.WIDTH/9)/14, 250, 50);
			resultLabel[yindex].setBackground(Color.WHITE);
			resultLabel[yindex].setForeground(Color.BLACK);
			resultLabel[yindex].setVisible(true);
			add(resultLabel[yindex]);

			// Labels for recommended food group results
			recLabel[yindex].setFont(new Font("Arial", Font.BOLD, 18));
			recLabel[yindex].setBounds(10, 250 + yindex *(FoodTrackerGUI.WIDTH -FoodTrackerGUI.WIDTH/9 )/14, 350, 50);
			recLabel[yindex].setBackground(Color.WHITE);
			recLabel[yindex].setForeground(Color.BLACK);
			recLabel[yindex].setVisible(true);
			add(recLabel[yindex]);

		}




		Graphics2D g2 = (Graphics2D) g;

		Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
		Arc2D.Float arc2 = new Arc2D.Float(Arc2D.PIE);

		arc.setFrame(800, 240, 200, 200);
		arc2.setFrame(800, 10, 200, 200);


		arc.setAngleStart(0);
		arc.setAngleExtent(90);
		g2.setColor(Color.gray);
		g2.draw(arc);
		g2.setColor(Color.red);
		g2.fill(arc);


		arc.setAngleStart(90);
		arc.setAngleExtent(90);
		g2.setColor(Color.gray);
		g2.draw(arc);
		g2.setColor(Color.blue);
		g2.fill(arc);


		arc.setAngleStart(180);
		arc.setAngleExtent(180);
		g2.setColor(Color.gray);
		g2.draw(arc);
		g2.setColor(Color.green);
		g2.fill(arc);


		arc2.setAngleStart(0);
		arc2.setAngleExtent(90);
		g2.setColor(Color.gray);
		g2.draw(arc2);
		g2.setColor(Color.red);
		g2.fill(arc2);


		arc2.setAngleStart(90);
		arc2.setAngleExtent(90);
		g2.setColor(Color.gray);
		g2.draw(arc2);
		g2.setColor(Color.blue);
		g2.fill(arc2);


		arc2.setAngleStart(180);
		arc2.setAngleExtent(180);
		g2.setColor(Color.gray);
		g2.draw(arc2);
		g2.setColor(Color.green);
		g2.fill(arc2);
	}





}