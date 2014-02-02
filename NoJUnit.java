// no-JUnit
// https://github.com/marshallford/no-junit
// Marshall Ford
package exampleclient;
import java.text.DecimalFormat;

public class NoJUnit {

    // variables
    private static String line = "------------------------------";
    private static String doubleLine = "==============================";
    private static String title = "";
    private static int total = 0;
    private static int counter = 0;
    private static double percent = 0.0;
    private static boolean showDebug = false;

    // send special alert message
    private static void alert(String alert)
    {
        System.out.println("NoJUnit ==> " + alert);
    }

    // counter, also used to handle spacing
    private static void counter()
    {
        if(counter == 0)
        {
            System.out.print("\n\n");
            System.out.println(title + "\n" + doubleLine);
        }
        counter++;
    }

    // set the title of the test and the starting line length
    public static void setupTest(String newTitle, int newLineLength)
    {
        title = newTitle;
        if (showDebug)
        {
            System.out.print("\n\n");
            alert("Title was set");
        }
        lineLength(newLineLength);
    }

    // override to enable optional debug feature
    public static void setupTest(String newTitle, int newLineLength, boolean debug)
    {
        showDebug = debug;
        setupTest(newTitle,newLineLength);
    }

    // actual testing method
    public static void test(boolean foo, String message)
    {
        if(foo)
        {
            counter();
            System.out.println("[X] " + message);
        }
        else
        {
            System.out.println("[ ] " + message);
        }
        total++;
    }

    // set the line length for both the normal line and double line
    public static void lineLength(int newLineLength)
    {
        int i;
        if (newLineLength < 0)
        {
            if (showDebug)
                alert("Line length was not set");
        }
        else
        {
            line = "";
            doubleLine = "";
            for (i = 0; i < newLineLength; i++)
            {
                line += "-";
                doubleLine += "=";
            }
            if (showDebug)
                alert("Line length was set to " + i);
        }
    }

    // output the results, including total tests, tests completed, and percentage completed
    public static void results()
    {
        if (counter == 0)
        {
            System.out.println("\n\n" + title + "\n" + doubleLine);
            alert("No tests were run, try again");
            System.out.println(doubleLine);
            return;
        }
        System.out.println("\n" + line);
        System.out.println("NoJUnit Results");
        System.out.println("Total Tests: " + total + "   ||   " + "Passed Tests: " + counter + "   ||   " + "Failed Tests: " + (total - counter));
        percent = ((double)counter/total)* 100;
        DecimalFormat newFormat = new DecimalFormat("#.##");
        percent =  Double.valueOf(newFormat.format((percent)));
        System.out.println("Pass Percentage: " + percent + "%");
        if (percent >= 100)
        {
            System.out.println("[x] Passed All Tests");
        }
        else
        {
            System.out.println("[ ] Passed All Tests");
        }
        System.out.println(line);
        // reset values
        counter = 0; total = 0; percent = 0.0; title = ""; showDebug = false;
        doubleLine = "==============================";
        line = "------------------------------";
    }
}
