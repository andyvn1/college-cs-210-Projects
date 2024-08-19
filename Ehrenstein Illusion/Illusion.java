// CS210 Assignment #3 "Ehrenstein Illusion"
// Andy Vargas Noesi
//Open a panel where there is yellow circles with specific amount of sub figures

import java.awt.*;

public class Illusion {

    public static void main(String[] args) {
        drawFigures();
    }

    public static void drawFigures() {
        DrawingPanel panel = new DrawingPanel(500, 400);
        panel.setBackground(Color.cyan);

        Graphics g = panel.getGraphics();

        //yellow circle at (0,0) , (120, 10), (250, 50)
        drawFillCircle(g,0,0,90, 3);
        drawFillCircle(g,120,10,90, 3);
        drawFillCircle(g,250,50,80, 5);


        //light grey boxes (350, 20), (10, 120), (240, 160)
        drawFillBox(g, 350, 20, 40, 3, 5);
        drawFillBox(g, 10, 120, 100, 2, 10);
        drawFillBox(g, 240, 160, 50, 4, 5);
    }

    //draw fill circle with sub figures
    public static void drawFillCircle(Graphics graphics,
                                      int xPosition,
                                      int yPosition,
                                      int size,
                                      int circleSubFigure){

        graphics.setColor(Color.yellow);
        graphics.fillOval(xPosition, yPosition, size, size);

        graphics.setColor(Color.black);
        graphics.drawOval(xPosition,yPosition, size, size);

        drawDiamond(graphics, xPosition, yPosition, size);

        drawSubCircles(graphics, xPosition, yPosition, size, circleSubFigure);
    }
    //create the boxes with yellow fill circle depending on how many rows and column
    public static void drawFillBox(Graphics graphics,
                                      int xPosition,
                                      int yPosition,
                                      int size,
                                      int rowsAndColumn,
                                      int circleSubFigure){

        graphics.setColor(Color.lightGray);
        graphics.fillRect(xPosition, yPosition, size * rowsAndColumn, size * rowsAndColumn);

        graphics.setColor(Color.red);
        graphics.drawRect(xPosition,yPosition, size * rowsAndColumn, size * rowsAndColumn);

        for (int column = yPosition; column <= yPosition + (size * (rowsAndColumn - 1)) ; column += size) {
            drawFillCircle( graphics, xPosition, column, size, circleSubFigure);

            for (int rows = xPosition + size; rows <= xPosition + (size * (rowsAndColumn - 1)) ; rows += size) {
            drawFillCircle(graphics, rows, column, size, circleSubFigure);
            }
        }
    }
    //Drawing a diamond on the figure with 4 draw lines
    public static void drawDiamond(Graphics graphics, int xPosition, int yPosition, int size){
        graphics.drawLine(xPosition, yPosition + (size / 2), xPosition + (size / 2), yPosition );
        graphics.drawLine(xPosition + (size / 2), yPosition, xPosition + size, yPosition + (size / 2) );
        graphics.drawLine(xPosition + size, yPosition + (size / 2), xPosition + (size / 2), yPosition + size );
        graphics.drawLine(xPosition + (size / 2), yPosition + size, xPosition, yPosition + (size / 2) );
    }
// method circle circle loops inside for the sub figures on every yellow fill circle
    public static void drawSubCircles(Graphics graphics, int xPosition, int yPosition, int size, int subCircle){

        int numToAdd = (size / subCircle) / 2;
        xPosition = xPosition + (numToAdd * (subCircle - 1));
        yPosition = yPosition + (numToAdd * (subCircle - 1));
        size = size / subCircle;

        for (int i = 0; i < subCircle; i++) {
            graphics.drawOval(xPosition - (numToAdd * i), yPosition - (i * numToAdd), size + (i * size), size + (i * size));
        }
    }
}