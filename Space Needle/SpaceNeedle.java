// CS210 Assignment #2 "Space Needle"
// Andy Vargas Noesi
//Printing of the space needle using for loop

public class SpaceNeedle {

    public static int SIZE = 4;

    public static void main(String[] args) {
        drawSpaceNeedle();
    }

    public static void drawSpaceNeedle() {
        needle();
        topHalfPlate();
        plateDivider();
        bottomHalfPlate();
        needle();
        stem();
        topHalfPlate();
        plateDivider();
    }
    // It would create the top and bottom part of the head of the building Space Needle
    public static void needle() {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 0; j <= (SIZE * 3) + 2 ; j++) {
                System.out.print(" ");
            }
                System.out.println("||");
        }

    }
    //Is use twice on the upper part and bottom part that is why to and bottom are separated
    public static void topHalfPlate() {
        for (int line = 0; line < SIZE; line++) {
            for (int j = 1; j <= SIZE - line ; j++) {
                System.out.print("   ");
            }
            System.out.print("__/");
            for (int j = 1; j <= 3 * line ; j++) {
                System.out.print(":");
            }
            System.out.print("||");
            for (int j = 1; j <= 3 * line ; j++) {
                System.out.print(":");
            }
            System.out.println("\\__");
        }
    }
    //Is use twice on the upper part and bottom part after the TopHalPlate
    public static void plateDivider(){
        for (int i = 1; i <= 3; i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        for (int i = 1; i <= SIZE * 6; i++) {
            System.out.print("\"");
        }
        System.out.println("|");
    }

    public static void bottomHalfPlate(){
        for (int line = 1; line <= SIZE; line++) {
            for (int i = 1; i < line * 2 + 2 ; i++) {
                System.out.print(" ");
            }
            System.out.print("\\_/");
            for (int j = 1; j <= -2 * line + (SIZE * 3); j++) {
                System.out.print("\\/");
            }
            System.out.println("\\_/");
        }
    }
    //It would generate the stem of the building, the middle part
    public static void stem(){
        for (int line = 1; line <= SIZE * SIZE; line++) {
            for (int i = 0; i < 2 * SIZE + 4; i++) {
                System.out.print(" ");
            }
            System.out.print("|");
            percentageSymbol();
            System.out.print("||");
            percentageSymbol();
            System.out.println("|");
        }
    }
// It would generate the percentage symbol according to the value given in SIZE
    public static void percentageSymbol(){
        for (int i = 1; i <= SIZE - 2; i++) {
            System.out.print("%");
        }
    }

}
