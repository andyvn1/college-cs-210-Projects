// CS210 Assignment #8 "Rational Number"
// Andy Vargas Noesi
/* This class will serve as a template to create a rational number, and it wil give access to methods like add,
subtract, multiplication and division of other Objects of the same class.*/

import java.lang.Math;

public class RationalNumber {
	//fields of the class
	private int numerator;
	private int denominator;

	//constructor would allow a user to give a value for the numerator and a value for the denominator as parameters.
	public RationalNumber(int numerator, int denominator) {
		if (denominator != 0) {
			this.numerator = numerator;
			this.denominator = denominator;
		}
	}
	//constructor with no parameters would create the rational number 0/1.
	 public RationalNumber() {
		numerator = 0;
		denominator = 1;
	 }
	
	 public int getDenominator() {
		return denominator;
	 }

	 public int getNumerator() {
		return numerator;
	 }
	/* toString with rules to only display the enumerator if the denominator is 1, simplify to 0 if the enumerator is 0,
	make the rational number positive if the enumerator and denominator are both negative and if one of the numbers
	enumerator and denominator are positive to display the sign on the enumerator*/
	 public String toString() {
		if (denominator == 1) {
			return numerator + "";
		} else if (denominator == -1) {
			return (-1 * numerator) + "";
		} else if (numerator == 0) {
			return numerator + "";
		} else if (numerator < 0 && denominator < 0) {
			return (-1 * numerator) + "/" + (-1 * denominator);
		} else if (numerator > 0 && denominator < 0) {
			return ((-1 * numerator) + "/" + (-1 * denominator));
		} else {
			return numerator + "/" + denominator;
		}
	 }

	 /* add would sum the rational number with another rational number stored in an Array and then return it as a
	 Rational number object */
	 public RationalNumber add(RationalNumber other) {

		int[] newEnumeratorAndDenominator = addOrSubtractTwoFractions(other, "add");
		return new RationalNumber(newEnumeratorAndDenominator[0], newEnumeratorAndDenominator[1]);

	 }
	/* add would subtract the rational number with another rational number stored in an Array and then return it as a
	 Rational number object */
	 public RationalNumber subtract(RationalNumber other) {
		 int[] newEnumeratorAndDenominator = addOrSubtractTwoFractions(other, "subtract");
		 return new RationalNumber(newEnumeratorAndDenominator[0], newEnumeratorAndDenominator[1]);
	 }
	/*multiply method will just multiply the enumerators and the denominators passing this numbers drought a fraction simplifier
	where it will give back an Array containing the simplified numbers that would be used in the creation of the Rational number Object*/
	 public RationalNumber multiply(RationalNumber other) {
		int numeratorAfterMultiplication = numerator * other.getNumerator();
		int denominatorAfterMultiplication = denominator * other.getDenominator();

		int[] newEnumeratorAndDenominator = fractionSimplifier(numeratorAfterMultiplication, denominatorAfterMultiplication);

		return new RationalNumber(newEnumeratorAndDenominator[0], newEnumeratorAndDenominator[1]);
	 }
	 /* It will divide by finding the reciprocal of the other RationalNumber and the used the multiplication method to
	 multiply the two rational numbers.*/
	 public RationalNumber divide(RationalNumber other) {
		int newNumerator = other.getDenominator();
		int newDenominator = other.getNumerator();

		return multiply(new RationalNumber(newNumerator, newDenominator));
	 }

	//create an Array of new numerator after adding or subtracting and new denominator
	public int[] addOrSubtractTwoFractions(RationalNumber other, String addOrSubtract){
		int newNumeratorAddedOrSubtracted = 0;
		int newDenominator = denominator * other.getDenominator();
		int numeratorMultiplierForClass = newDenominator / denominator;
		int numeratorMultiplierForOther = newDenominator / other.getDenominator();
		int newNumeratorForClass = numeratorMultiplierForClass * numerator;
		int newNumeratorForOther = numeratorMultiplierForOther * other.getNumerator();

		if (addOrSubtract.equalsIgnoreCase("add")) {
			newNumeratorAddedOrSubtracted += newNumeratorForClass + newNumeratorForOther;
		} else if (addOrSubtract.equalsIgnoreCase("subtract")) {
			newNumeratorAddedOrSubtracted += newNumeratorForClass - newNumeratorForOther;
		}

		int[] newEnumeratorAndDenominator = fractionSimplifier(newNumeratorAddedOrSubtracted, newDenominator);


		return new int[]{newEnumeratorAndDenominator[0], newEnumeratorAndDenominator[1]};
	}
	//simplifying a fraction
	public int[] fractionSimplifier(int numerator, int denominator){
		boolean numeratorWasNegative = false;
		boolean denominatorWasNegative = false;
		if (numerator < 0 ){
			numeratorWasNegative = true;
			numerator *= -1;
		} else if (denominator < 0) {
			denominatorWasNegative = true;
			denominator *= -1;
		}

		int i = 1;
		while (i <= Math.min(numerator, denominator)){
			if ((denominator % i == 0) && (numerator % i == 0)){
				denominator /= i;
				numerator /= i;
				i = 1;
			}
			i++;
		}
		if (numeratorWasNegative){
			numerator *= -1;
		} else if (denominatorWasNegative) {
			denominator *= -1;
		}

		return new int[]{numerator, denominator};
	}
}
