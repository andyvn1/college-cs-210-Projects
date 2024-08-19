// CS210 Assignment #6 "baby names"
// Andy Vargas Noesi
/* The program would read user input about a name and find the name on a list of names in a file with information about
how popular is that name on certain years. This information would be printed it, and output would be generated with file
name being the name that user input.txt */

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class BabyNames {

    public static String BABY_NAME;
    public static int NINETEEN20;
    public static int NINETEEN30;
    public static int NINETEEN40;
    public static int NINETEEN50;
    public static int NINETEEN60;
    public static int NINETEEN70;
    public static int NINETEEN80;
    public static int NINETEEN90;
    public static int TWO_THOUSAND;
    public static boolean FOUND_NAME = false;

    // grab input from user to select the name and info from the txt file.
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("names.txt"));
        Scanner console = new Scanner(System.in);
        System.out.println("**Popularity of a baby name since year 1920**");
        System.out.print("name? ");
        String name = console.next();
        while (input.hasNextLine() && !FOUND_NAME){
            String line = input.nextLine();
            findName(name, line);
        }
        if (!FOUND_NAME){
            System.out.println("name not found");
        }else {
            printRecord(NINETEEN20, NINETEEN30, NINETEEN40, NINETEEN50, NINETEEN60, NINETEEN70, NINETEEN80, NINETEEN90,
                    TWO_THOUSAND);
            createBabyNameFile(BABY_NAME, NINETEEN20, NINETEEN30, NINETEEN40, NINETEEN50, NINETEEN60, NINETEEN70,
                    NINETEEN80, NINETEEN90, TWO_THOUSAND);
        }
    }
    // find the name in the names.txt file
    public static void findName(String name, String line) {
        Scanner lineScan = new Scanner(line);
        String babyName = lineScan.next();
        if (babyName.equalsIgnoreCase(name)) {
            FOUND_NAME = true;
            BABY_NAME = babyName;
            NINETEEN20 = lineScan.nextInt();
            NINETEEN30 = lineScan.nextInt();
            NINETEEN40 = lineScan.nextInt();
            NINETEEN50 = lineScan.nextInt();
            NINETEEN60 = lineScan.nextInt();
            NINETEEN70 = lineScan.nextInt();
            NINETEEN80 = lineScan.nextInt();
            NINETEEN90 = lineScan.nextInt();
            TWO_THOUSAND = lineScan.nextInt();
        }
    }
    // print the record with all information about the name
    public static void printRecord(int nineTeen20, int nineTeen30, int nineTeen40, int nineTeen50, int nineTeen60,
                                   int nineTeen70, int nineTeen80, int nineTeen90, int twoThousand) {
        System.out.println("1920: " + nineTeen20);
        System.out.println("1930: " + nineTeen30);
        System.out.println("1940: " + nineTeen40);
        System.out.println("1950: " + nineTeen50);
        System.out.println("1960: " + nineTeen60);
        System.out.println("1970: " + nineTeen70);
        System.out.println("1980: " + nineTeen80);
        System.out.println("1990: " + nineTeen90);
        System.out.println("2000: " + twoThousand);
    }
    //create the file with all the information about the name
    public static void createBabyNameFile(String name, int nineTeen20, int nineTeen30, int nineTeen40, int nineTeen50,
                                          int nineTeen60, int nineTeen70, int nineTeen80, int nineTeen90,
                                          int twoThousand) throws FileNotFoundException {
        PrintStream out = new PrintStream(name + ".txt");
        out.println(name + ",");
        out.println("1920: " + nineTeen20);
        out.println("1930: " + nineTeen30);
        out.println("1940: " + nineTeen40);
        out.println("1950: " + nineTeen50);
        out.println("1960: " + nineTeen60);
        out.println("1970: " + nineTeen70);
        out.println("1980: " + nineTeen80);
        out.println("1990: " + nineTeen90);
        out.println("2000: " + twoThousand);
    }
    //trying to draw with Drawing Panel but could not graph the points on a line.

//    public static void drawingGraph(String name, int nineTeen20, int nineTeen30, int nineTeen40, int nineTeen50,
//                                    int nineTeen60, int nineTeen70, int nineTeen80, int nineTeen90,
//                                    int twoThousand){
//        int panelWidth = 360;
//
//        DrawingPanel panel = new DrawingPanel(panelWidth, 400);
//        Graphics g = panel.getGraphics();
//        g.setColor(Color.BLACK);
//
//        g.drawString(name, (panelWidth / 2) - 8, 10);
//
//        int yearLabelStartX = 5;
//        int year = 1920;
//        for (int i = 1; i <= 9 ; i++) {
//            g.drawString(year + "", yearLabelStartX, 390);
//            year += 10;
//            yearLabelStartX += 40;
//        }
//
//        int horizontalLineYOneAndTwo = 50;
//        for (int i = 1; i <= 2 ; i++) {
//            g.drawLine(0, horizontalLineYOneAndTwo, panelWidth, horizontalLineYOneAndTwo);
//            horizontalLineYOneAndTwo += 320;
//        }
//
//        int verticalLineXOneAndTwo = 40;
//        for (int i = 1; i <= 8 ; i++) {
//            g.drawLine(verticalLineXOneAndTwo, 400, verticalLineXOneAndTwo, 50);
//            verticalLineXOneAndTwo += 40;
//        }
//
//    }

}

