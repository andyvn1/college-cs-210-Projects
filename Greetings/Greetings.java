// CS210 Assignment #3 "Greetings"
// Andy Vargas Noesi
//Print a greeting message in specific format for the user with estimated age
import java.util.*;

public class Greetings {

    public static void main(String[] args) {        
        Scanner s = new Scanner(System.in);
        System.out.println(getGreetings(s));
    }

    //It would collect user input and for greeting message calculating the age of the user
    private static String getGreetings(Scanner console) {
        System.out.print("Please enter your first name: ");
        String name = console.nextLine().toLowerCase();
        System.out.println();
        System.out.print("Please enter your last name: ");
        String lastName = console.nextLine().toLowerCase();
        System.out.println();
        System.out.print("Please enter your year of birth: ");
        int yearBorn = console.nextInt();
        System.out.println();

        String firstLetterNameUpper = name.substring(0,1).toUpperCase();
        String lastName_with_firstLetterCapitalize = lastName.replace(lastName.substring(0,1),
                lastName.substring(0,1).toUpperCase());
        int age = getCurrentYear() - yearBorn;

        String message = "Greetings, " + firstLetterNameUpper + ". " + lastName_with_firstLetterCapitalize +
                "! You are about " + age + " years old";
        
        return message;
    }
    //Method get the current year to use it in the calculation for age on getGreetings
    private static int getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
