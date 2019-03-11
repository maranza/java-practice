package refusecollection;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author master
 */
public class RefuseCollection {

    /**
     * @param args the command line arguments
     */
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args)
    {
        Random rand = new Random();
        int maxSchools = 6;
        int regions = 4;
        int[][] data = new int[maxSchools][regions];

        // generate values
        data = generateLitterWeights(maxSchools, regions);

        // displaying the menu
        menu(data);

    }

    static void menu(int data[][])
    {
        int choice;
        System.out.println("Menu \n");
        System.out.println("1 - Display information \n2 - Calculate averages \n3 - Display the winner \n4 - QUIT \n\nYour choice: \n");
        choice = console.nextInt();

        switch (choice)
        {
            case 1:
                displayInformation(data);
                menu(data);
                return;
            case 2:
                displayAverages(data);
                menu(data);
                return;
            case 3:
                displayHighestWeight(data);
                menu(data);
                return;
            case 4:
                System.out.println("Thank you for visiting");
                return;
            default:
                System.out.println("System Error: Input not supported");
                menu(data);
        }
    }

    private static int[][] generateLitterWeights(int maxSchools, int regions)
    {
        Random rand = new Random();
        int numberOfSchoolsPerRegion;
        int weightOfLitter;

        int[][] rc = new int[maxSchools][regions];

        //System.out.println("number of columns: "+rc[0].length); // columns
        for (int i = 0; i < rc[0].length; i++) //rows
        {
            System.out.println("enter number of schools participated per Region: ");
            numberOfSchoolsPerRegion = console.nextInt();

            if (numberOfSchoolsPerRegion <= maxSchools)
            { //rows
                for (int j = 0; j < numberOfSchoolsPerRegion; j++) //columns
                {
                    //System.out.println("enter weight of litter of school in " + j + " participated in Region " + (i+1));
                    //weightOfLitter = console.nextInt();
                    weightOfLitter = rand.nextInt(800);
                    rc[j][i] = weightOfLitter;
                    System.out.println("inside main LOOP");
                }
            } else
            {
                // TODO: fix this bug.
                System.out.println("System Error: MAximum number of schools allowed per Region is 6 try again");
            }
        }
        return rc;
    }

    static int[][] calculateTotalsAndAverages(int[][] data)
    {

        int columnSum = 0;
        int[][] sumArray = new int[2][data[0].length];
        for (int k = 0; k < data[0].length; k++)
        {
            for (int i = 0; i < data.length; i++)
            {
                columnSum += data[i][k];
            }
            sumArray[0][k] = columnSum; //present sums
            sumArray[1][k] = columnSum / data.length; //present averages
            columnSum = 0;
        }

        return sumArray;
    }

    static int[] getHighestWeight(int data[][])
    {
        int[] position = new int[3];
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[0].length; j++)
            {
                if (data[i][j] > position[2])
                {
                    position[2] = data[i][j]; //present max value
                    position[1] = i; // present row (school)
                    position[0] = j; // present column (region)
                }
            }
        }

        return position;
    }

    private static void displayHighestWeight(int data[][])
    {
        int[] highesWeightAndSchoolLocation = getHighestWeight(data);
        System.out.println("The Winner is School " + (highesWeightAndSchoolLocation[1] + 1) + " in Region " + (highesWeightAndSchoolLocation[0] + 1)
                + "\nThe winning School collected " + highesWeightAndSchoolLocation[2] + " kg litter\n\n");
    }

    static void displayInformation(int data[][])
    {
        System.out.println("Litter collected by schools in " + data.length + " regions");
        System.out.println("\t\t\t  regions");

        System.out.print("\t");
        for (int i = 0; i < data[0].length; i++)
        {
            System.out.print("\t " + (i + 1));
        }
        System.out.println("\n");

        for (int i = 0; i < data.length; i++)
        {
            System.out.print("School " + (i + 1) + "\t");
            for (int j = 0; j < data[0].length; j++)
            {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println("\n");
        }
        //printing sums and averages
        System.out.println("=======================Averages=======================\n");
        displayAverages(data);

    }

    static void displayAverages(int data[][])
    {
        int[][] as = calculateTotalsAndAverages(data);
        int track = 0;
        for (int i = 0; i < as.length; i++)
        {
            if (i == 0)
            {
                System.out.print("Totals " + " " + "\t");
            } else
            {
                System.out.print("averages " + " " + "\t");
            }

            for (int j = 0; j < as[0].length; j++)
            {
                System.out.print(as[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

}
