
public class Main {
	public static void main(String[] args) {

		RationalNumber r1 = new RationalNumber(1, 3);
		RationalNumber r2 = new RationalNumber(2, 3);

		System.out.println("get numerator and denominator for r1 and r2");
		System.out.println(r1.getNumerator() + "/" + r1.getDenominator());
		System.out.println(r2.getNumerator() + "/" + r2.getDenominator());

		System.out.println();

		System.out.println("Add Rational number");
		System.out.println(r1.add(r2).toString());
		System.out.println(r2.add(r1).toString());

		System.out.println();

		System.out.println("Subtract Rational number");
		System.out.println(r1.subtract(r2).toString());
		System.out.println(r2.subtract(r1));

		System.out.println();

		System.out.println("Multiplying Rational number");
		System.out.println(r1.multiply(r2).toString());
		System.out.println(r2.multiply(r1).toString());

		System.out.println();

		System.out.println("Divide Rational number");
		System.out.println(r1.divide(r2).toString());
		System.out.println(r2.divide(r1).toString());


	}
}
