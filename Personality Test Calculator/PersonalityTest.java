// CS210 Assignment #7 "Personality Test"
// Andy Vargas Noesi
/* Program would read from a txt file. This txt file contains the name of the person that took the test and answers from
that test. The program would display the result of how many question answers in the different categories are A and how many
are B from there it gives you the percent B and the type of personality based on the answers.*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class PersonalityTest {

    public static void main(String[] args) throws FileNotFoundException {
        readLines();
    }

    public static void readLines() throws FileNotFoundException {
        Scanner input = new Scanner(new File("personality.txt"));
        System.out.println("** This program reports the results for Keirsey Personality Test **");

        while (input.hasNextLine()) {
            String name = input.nextLine();
            String answer = input.nextLine();

            System.out.println();

            System.out.println(name + ":");
            printReports(answer);
        }
    }

    public static void printReports(String answer) {
        //Creation of arrays with a length of 2. This Array will store the amount of A and B on each respective dimension.
        //BABAAAA will be 1223344
        int[] dimension1 = new int[2];
        int[] dimension2 = new int[2];
        int[] dimension3 = new int[2];
        int[] dimension4 = new int[2];

        //Arrays are all from the same object, and this will update arrays for each dimension
        updatingQuestionArrays(answer, dimension1, dimension2, dimension3, dimension4);

        System.out.println("answers: " + Arrays.toString(answerArrayCreator(dimension1, dimension2, dimension3, dimension4)));
        System.out.println("percent B: " + Arrays.toString(percentArrayCreator(dimension1, dimension2, dimension3, dimension4)));
        System.out.println("type: " + typeFinder(dimension1, dimension2, dimension3, dimension4));
    }

    /*------------------------------------------Method Helpers bellow -----------------------------------------------*/
    //Brain of the program it will analyze line of answer and count all A and B from dimensions 1-4
    public static void updatingQuestionArrays(String answer, int[] question1, int[] question2, int[] question3, int[] question4){
        int j = 0;
        /*While loop would travel through each character index on the line being read until the index is the same
        as the answer of the line being read.*/
        while (j < answer.length()){
            for (int i = 0; i < 7; i++) {   //Analyze the answer in sevens.
                char c = answer.charAt(j);
                if (i == 0) {  //the answer is for the dimension1 Array.
                    counting(question1, c);
                    j++;
                } else if (i == 1 || i == 2) { //the answer is for the dimension2 Array.
                    counting(question2, c);
                    j++;
                } else if (i == 3 || i == 4) { //the answer is for the dimension3 Array.
                    counting(question3, c);
                    j++;
                } else { //the answer is for the dimension4 Array.
                    counting(question4, c);
                    j++;
                }
            }
        }
    }

    //counting method counts the amount of a and c for a specific Array.
    public static void counting(int [] arg , char c){
        if (c == 'A' || c == 'a'){
            arg[0]++;
        } else if (c == 'B' || c == 'b') {
            arg[1]++;
        }
    }

    /* Create Array with the answers how many B and A for each dimension Arrays.The parameters passed here are
    an Array that the 0 indexes contain the amount of A for that group of questions, and the 1 index contains
    the amount of B.*/
    public static String[] answerArrayCreator(int [] argsQuestion1, int [] argsQuestion2, int [] argsQuestion3, int[] argsQuestion4 ) {
        int a = 0;
        int b = 1;
        String[] answer = {argsQuestion1[a] + "A-" + argsQuestion1[b] + "B",
                argsQuestion2[a] + "A-" + argsQuestion2[b] + "B",
                argsQuestion3[a] + "A-" + argsQuestion3[b] + "B",
                argsQuestion4[a] + "A-" + argsQuestion4[b] + "B"};
        return answer;
    }

    /* Create an Array with the percent B of each dimension. The parameters passed here are
    an Array that the 0 indexes contain the amount of A for that dimension, and the 1 index contains
    the amount of B.*/
    public static int [] percentArrayCreator(int [] argsQuestion1, int [] argsQuestion2, int [] argsQuestion3, int[] argsQuestion4 ) {
        int a = 0;
        int b = 1;

        int[] percentB = {(int) Math.round((((argsQuestion1[b] / (double)(argsQuestion1[a] + argsQuestion1[b]))) * 100)),
                (int) Math.round((((argsQuestion2[b] / (double)(argsQuestion2[a] + argsQuestion2[b]))) * 100)),
                (int) Math.round((((argsQuestion3[b] / (double)(argsQuestion3[a] + argsQuestion3[b]))) * 100)),
                (int) Math.round((((argsQuestion4[b] / (double)(argsQuestion4[a] + argsQuestion4[b]))) * 100))};
        return percentB;
    }

    /* Based on the B percentage and the index of the percentArray. typeFinder would analyze the type
    of personality of the test taker. Dimension1 would determine if a person is Extrovert or Introvert,
    dimension2 of Sensation or iNtuition, dimension3 Thinking or Feeling and dimension3 Judging or Perceiving.*/
    public static String typeFinder(int [] argsQuestion1, int [] argsQuestion2, int [] argsQuestion3, int[] argsQuestion4 ){
        String[] infp = {"I", "N", "F", "P"};
        String[] estj = {"E", "S", "T", "J"};
        String type = "";
        int[] percent = percentArrayCreator(argsQuestion1, argsQuestion2, argsQuestion3, argsQuestion4);
        for (int i = 0; i < percent.length; i++) {
            if (percent[i] > 50){
                type += infp[i];
            } else if (percent[i] == 50) {
                type += "X";
            } else {
                type += estj[i];
            }
        }
        return type;
    }
}