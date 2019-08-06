import java.util.Scanner;

public class BackwardString {
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		String input;

		System.out.println("Enter a string: ");
		input = keyboard.nextLine();

		displayBackwards(input);
	}

	public static void displayBackwards(String string)
	{
		StringBuilder str = new StringBuilder(string);

		int index;

		int count = 0;

		System.out.print(string + " spelled backwards is: ");

		for(index = 0; index < str.length(); index++)
		{
			count = (str.length() - 1) - index;
			System.out.print(str.charAt(count));
		}

		System.out.println();
	}
}