// CS210 Assignment #4 "Birthdays"
// Andy Vargas Noesi
/*Program ask for date of today and two people birthday compare them, and it comes back with information about their
birthday when is going to be next birthday, what absolute day of the year is their birthday, who birthday
is first or wishes happy birthday if is the same day. */

import java.util.Scanner;

public class Birthdays {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        //Information of today date
        System.out.print("Please enter today's date (month day): ");
        int year = 2024;
        int month = console.nextInt();
        int day = console.nextInt();
        int dayOfTheYearFromToday = dayOfTheYear(month, day, year);
        System.out.printf("Today is %d/%d/%d, day #%d of the year.\n", month, day, year, dayOfTheYearFromToday);

        // provide how many days to each person birthdays
        int daysToBirthdayPerson1 = daysToBirthday(console, year, dayOfTheYearFromToday, 1);
        int daysToBirthdayPerson2 = daysToBirthday(console, year, dayOfTheYearFromToday, 2);

        System.out.println();
        System.out.println(soonestBirthdayMessage(daysToBirthdayPerson1, daysToBirthdayPerson2));

        System.out.println();
        System.out.println("Ahoy, matey! January 10 be the International Festival of Laughter in Zadar, Croatia!" +
                "\nJoin for a day of global humor and endless laughs!");
    }
    // Method indicate if isLeap year or not return boolean. This method is important because it tells if the month of February is going to have 28 days or 29 days.
    public static boolean isLeapYear(int year){
        boolean leapYear = false;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)){
            leapYear = true;
        }else {
            return leapYear;
		}
        return leapYear;
    }
    // method returns an int, that indicate the absoluteness day calendar of a specific give year.
    public static int dayOfTheYear(int month, int days, int year){
        int daysInTheMonth = 0;
        for (int i = 1; i < month ; i++) {
            if (i == 4 || i == 6 || i == 9 || i == 11){
                daysInTheMonth += 30;
            } else if (i == 2 && isLeapYear(year)) {
                daysInTheMonth += 29;
            } else if (i == 2 && !isLeapYear(year)) {
                daysInTheMonth += 28;
            } else {
                daysInTheMonth += 31;
            }

        }
        daysInTheMonth += days;
		return daysInTheMonth;
	}
    //Method use the date of the day to compare if a birthday has already happened or not.
    public static boolean birthDayAlreadyHappen(int currentDayOfTheYear, int birthdayDayOfTheYear){
        boolean itHappen = false;
        if ( currentDayOfTheYear <= birthdayDayOfTheYear){
            return itHappen;
        } else {
            itHappen = true;
        }
        return itHappen;
    }
    //Method measure whose birthday is sooner and provide String depending if is person1, person 2 or both people have the same birthday
    public static String soonestBirthdayMessage(int daysUntilBirthday_person1, int daysUntilBirthday_person2){
        if (daysUntilBirthday_person1 < daysUntilBirthday_person2){
            return "Person #1's birthday is sooner";
        } else if (daysUntilBirthday_person1 == daysUntilBirthday_person2) {
            return "Wow, you share the same birthday! ^__^";
        }else {
            return "Person #2's birthday is sooner.";
        }
    }
    // I provide user inputs of people birthdays to calculate how many days to birthday, taking in consideration if the birthday have happened already or not.
    public static int daysToBirthday(Scanner console, int year, int dayOfTheYearFromToday, int person){
        int nextBirthday;
        System.out.println();
        System.out.printf("Please enter person #%d's birthday (month day): ", person);
        int birthdayMonth = console.nextInt();
        int birthdayDay = console.nextInt();
        int birthdayDayOfTheYear = dayOfTheYear(birthdayMonth, birthdayDay, year);
        int daysInTheYear = dayOfTheYear(12,31,year);


        System.out.printf("%d/%d/%d falls on day #%d of %d. \n", birthdayMonth, birthdayDay, year, birthdayDayOfTheYear, daysInTheYear);

        if (birthDayAlreadyHappen(dayOfTheYearFromToday, birthdayDayOfTheYear)){
            int daysRestOfTheYear = 0;
            for (int i = dayOfTheYearFromToday; i < daysInTheYear ; i++) {
                daysRestOfTheYear ++;
            }
            int newBirthdayDayOfTheYear = dayOfTheYear(birthdayMonth, birthdayDay, year + 1);
            nextBirthday = (newBirthdayDayOfTheYear + daysRestOfTheYear);
        }else {
            nextBirthday = Math.max(dayOfTheYearFromToday, birthdayDayOfTheYear) - Math.min(dayOfTheYearFromToday, birthdayDayOfTheYear);
        }

        if (dayOfTheYearFromToday == birthdayDayOfTheYear){
            System.out.println("Happy Birthday! :)");
        }else {
            System.out.printf("Your next birthday is in %d day(s).", nextBirthday);
            System.out.println();
        }

        return nextBirthday;
    }
}
