import java.util.Scanner;

public class Validator
{
public static String getString(Scanner sc, String prompt, boolean getFullLine)
{
	String s;
    System.out.println(prompt);
    if(!getFullLine)
    {
	    s = sc.next();  // read user entry
	    sc.nextLine();  // discard any other data entered on the line
    }
    else
    {
    	s = sc.nextLine();
    }
    return s;
}

public static int getInt(Scanner sc, String prompt)
{
    int i = 0;
    boolean isValid = false;
    while (isValid == false)
    {
        System.out.println(prompt);
        if (sc.hasNextInt())
        {
            i = sc.nextInt();
            isValid = true;
        }
        else
        {
            System.out.println("Error! Invalid integer value. Try again.");
        }
        sc.nextLine();  // discard any other data entered on the line
    }
    return i;
}

public static String yesNoCheck(Scanner sc, String prompt, boolean lowerCase)
{
	boolean isValid = false;
	String temp = "";
	System.out.println(prompt);
	while(isValid == false)
	{
		temp = sc.nextLine().toLowerCase();
		if(temp.equals("y") || temp.equals("n"))
		{
			isValid = true;
		}
		else
		{
			if(lowerCase)
				System.out.println("Error! Please enter \"y\" or \"n\". ");
			else
				System.out.println("Error! Please enter \"Y\" or \"N\". ");
		}
	}
	return temp;
}

public static int getInt(Scanner sc, String prompt,
int min, int max)
{
    int i = 0;
    boolean isValid = false;
    while (isValid == false)
    {
        i = getInt(sc, prompt);
        if (i > max || i < min)
            System.out.println(
                "Error! Number must be less than " + max + ".");
        else
            isValid = true;
    }
    return i;
}

public static double getDouble(Scanner sc, String prompt)
{
    double d = 0;
    boolean isValid = false;
    while (isValid == false)
    {
        System.out.println(prompt);
        if (sc.hasNextDouble())
        {
            d = sc.nextDouble();
            isValid = true;
        }
        else
        {
            System.out.println("Error! Invalid decimal value. Try again.");
        }
        sc.nextLine();  // discard any other data entered on the line
    }
    return d;
}

public static double getDouble(Scanner sc, String prompt,
double min, double max)
{
    double d = 0;
    boolean isValid = false;
    while (isValid == false)
    {
        d = getDouble(sc, prompt);
        if (d > max || d < min)
            System.out.println(
                "Error! Number must be less than " + max + ".");
        else
            isValid = true;
    }
    return d;
}
}