import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan1 = new Scanner(System.in);

        System.out.println("Please enter grades. Enter '-1' when done. ");

        int[] histograms = new int [10];
        int input =0;
        int index = 0;

        while (true)            //build the array until user inputs -1
        {

            input = getValidInteger(-1, 100);

            if (input == -1) break;     //ends the program when input is -1

            index = input / 10;         //calculates the index of the input number; 88/10=8 so index is 8

            if (input == 100)           //if input number is 100; 100/10=10 and there is no index 10 [array is 0-9]
                histograms [9]++;       //assigns it to index 9 since it is the last index
            else
                histograms[index] ++  ; //enters the input to the relavent index

        }

        //this prints out the array into a histogram based on user input
        for (int i = 0; i < histograms.length ; i++) {          // i to the limit of the array length

            if (i == 9)     // for special case in index 9 where it will display 90-99
            {
                System.out.print("90 - 100 ");  //changing the special case to display 90-100
            }else
            {
                System.out.printf("%d - %d ", i*10, i*10+9 );   //for loop to print the ranges 0-9;10-19...etc
            }

            for (int j = 0; j < histograms[i] ; j++) {          // j to the limit of the value inside the element
                System.out.print("* ");           //prints '*' by reading the arrays value

            }
            System.out.println();
        }
        
    }

/*
    This validates the user input is Integer
*/
    public static int getValidInteger() {
        Scanner scan1 = new Scanner(System.in);
        //validation for numbers
        while (!scan1.hasNextInt()) {
            scan1.nextLine(); //clears the buffer
            System.out.println("Please enter an integer! "); //tells user to enter number
        }

        return scan1.nextInt(); //takes the correct integer

    }

    public static boolean checkRange(int input, int min, int max) {

        if (input < min || input > max) {
            return false;
        }

        return true;
    }

    public static int getValidInteger(int min, int max) {

        int userInput = getValidInteger();
        while (checkRange(userInput, min, max) == false) {
            System.out.println("Please provide a number within range!");
            userInput = getValidInteger();
        }
        return userInput;
    }


}
