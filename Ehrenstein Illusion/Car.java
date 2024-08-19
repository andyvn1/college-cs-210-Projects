// CS210 Assignment #3 "Car"
// Andy Vargas Noesi
//It moves car figures along the screen

import java.awt.*;

public class Car {

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(200, 100);
		panel.setBackground(Color.LIGHT_GRAY);
		Graphics g = panel.getGraphics();
// car body
		g.setColor(Color.BLACK);
		g.fillRect(10, 30, 100, 50);
// wheels
		g.setColor(Color.RED);
		g.fillOval(20, 70, 20, 20);
		g.fillOval(80, 70, 20, 20);
// window
		g.setColor(Color.CYAN);
		g.fillRect(80, 40, 30, 20);



		moveVehicle(panel, g, 10, 30,100, 20,
				80, 70, 20, 80, 40, 30);

	}

	public static void moveVehicle(DrawingPanel panel, Graphics graphics, int bodyXPosition, int bodyYPosition,
								   int bodySize, int wheels1XPosition, int wheels2XPosition, int wheels1And2YPosition,
								   int wheelsSize, int windowXPosition, int windowYPosition, int windowSize){

		//control the units move with the for loop
		for (int i = 0; i <= 170 ; i++) {
			panel.clear();
			bodyXPosition += 10;
			wheels1XPosition += 10;
			wheels2XPosition += 10;
			windowXPosition += 10;


			//redrawing after clearing with different position on the X for all objects
			graphics.setColor(Color.BLACK);
			graphics.fillRect(bodyXPosition, bodyYPosition, bodySize, bodySize / 2);

			graphics.setColor(Color.RED);
			graphics.fillOval(wheels1XPosition, wheels1And2YPosition, wheelsSize, wheelsSize);
			graphics.fillOval(wheels2XPosition, wheels1And2YPosition, wheelsSize, wheelsSize);

			graphics.setColor(Color.CYAN);
			graphics.fillRect(windowXPosition, windowYPosition, windowSize, windowSize - 10);

			//clear images inside the loop
			int seconds = 1;
			panel.sleep(seconds * 1000);

		}


	}

}
