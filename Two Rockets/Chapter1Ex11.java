// CS210 Assignment #1 "Hello CS210"
// Andy Vargas Noesi
//This program print two rockets

public class Chapter1Ex11 {
    public static void main(String[] args) {
        twoRockets();

    }
    //Draw with the convictions of all rocket parts
    public static void twoRockets(){
        coneHeads();
        pairOfBoxes();
        countryLabels();
        pairOfBoxes();
        coneHeads();
    }
    //Draw two cones
    public static void coneHeads() {
        System.out.println("   /\\       /\\");
        System.out.println("  /  \\     /  \\");
        System.out.println(" /    \\   /    \\");
    }
    //Draw two pair of boxes
    public static void pairOfBoxes(){
        System.out.println("+------+ +------+");
        System.out.println("|      | |      |");
        System.out.println("|      | |      |");
        System.out.println("+------+ +------+");
    }
    //Draw two pair of the United States label for the rocket
    public static void countryLabels(){
        System.out.println("|United| |United|");
        System.out.println("|States| |States|");
    }

}