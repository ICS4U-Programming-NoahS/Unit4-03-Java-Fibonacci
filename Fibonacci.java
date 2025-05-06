import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

/**
* The Fibonacci program will read a set of whole numbers from 'input.txt'.
* It will check if it is a valid whole number.
* If it is not a valid whole number, it will write an error message.
* It will then calculate the fibonacci of each valid whole number.
* Finally, it will write the results to 'output.txt'.
*
* @version 1.0
* @since 2025-05-05
*/

final class Fibonacci {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the reverse string method.
     *
     * @param n the number of the calculated fibonacci.
     * @return the fibonacci of the number.
     */

    public static int recFib(final int n) {

        // Base case
        if (n == 0 || n == 1) {

            // because fib(0) = 0 and fib(1) = 1
            return n;
        } else {
            // Recursive case
            // Call the fibonacci method recursively
            // and add the two previous numbers
            // to get the current number
            return recFib(n - 1) + recFib(n - 2);
        }
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // pass the relative path to the input file as a parameter
        File file = new File("./input.txt");

        // Create a file object
        FileWriter myWriter = new FileWriter("./output.txt");

        // Create a scanner object to read the file
        Scanner scanner = new Scanner(file);

        // Greeting and program description
        System.out.println("Welcome to the fibonacci program!");
        System.out.print("This program will read a set");
        System.out.println(" of whole numbers from 'input.txt'.");
        System.out.println("It will check if it is a valid whole number.");
        System.out.print("If it is not a valid whole number,");
        System.out.println(" it will write an error message.");
        System.out.print("It will then calculate the fibonacci");
        System.out.println(" of each valid whole number.");
        System.out.println("It will write the results to 'output.txt'.");

        // Keep reading the file until there are no more lines
        while (scanner.hasNextLine()) {

            // Read the string from the file
            String line = scanner.nextLine();

            // to catch invalid whole number
            try {
                // try to convert the string to an integer
                int number = Integer.parseInt(line);

                // Check if the integer is a whole number
                if (number < 0) {
                    // If the number is negative
                    outputStr += ("'" + line
                            + "' is not a valid whole number.\n"
                    );

                // if the number is greater than 0
                } else {

                    // Get the sorted array by calling the select sort function
                    int fibonacci = recFib(number);

                    // Add the reversed string to the output string
                    outputStr += (
                        "The fibonacci of " + number
                        + " is " + fibonacci + ".\n"
                    );
                }

            // if the string is not a valid whole number
            } catch (Exception exception) {

                // If the string is not a valid
                // whole number, write an error message
                outputStr += ("'" + line + "' is not a valid whole number.\n");
            }
        }

        // Write the output string to the file
        myWriter.write(outputStr);

        // Close the file writer
        myWriter.close();

        // Added a blank line for spacing
        System.out.println("");

        // Display success message
        System.out.println("Successfully wrote to 'output.txt'");

        // Close the scanner
        scanner.close();
    }
}
