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
        Random rand = new Random(10);
        int[] regionNumber = new int[4];
        int[][] rc = new int[regionNumber.length][6];
        int maxSchools = 6;
        int numberOfSchoolsPerRegion;
        int weightOfLitter;
        int choice;
        
        System.out.println("enter number of schools participated per Region: ");
        numberOfSchoolsPerRegion = console.nextInt();
        
        if (numberOfSchoolsPerRegion <= maxSchools)
        {
            System.out.println("Menu \n");
            System.out.println("\n");
            System.out.println("1 - Display in \n2 - Calculate averages \n3 - Display the winner \n4 - QUIT \n\nYour choice: \n");
            choice = console.nextInt();
            
            switch(choice){
                case 1: 
                    System.out.println("Chose option 1");
                    return;
                case 2: 
                    System.out.println("Chose option 2");
                    return;
                case 3: 
                    System.out.println("Chose option 3");
                    return;
                case 4: 
                    System.out.println("Chose option 4");
                    return;
                default:
                    System.out.println("System Error: Input not supported");
            }
            
            for (int i = 0; i < numberOfSchoolsPerRegion; i++)
            {
                for (int j = 0; j < regionNumber.length; j++)
                {
                    //System.out.println("enter weight of litter of school in " + j + " participated in Region " + (i+1));
                    //weightOfLitter = console.nextInt();
                    weightOfLitter = rand.nextInt(300);
                    rc[j][i] = weightOfLitter;
                }
            }
            
            for (int i = 0; i < numberOfSchoolsPerRegion; i++)
            {
                for (int j = 0; j < regionNumber.length; j++)
                {
                    System.out.print(rc[j][i] + "\t");
                }
                System.out.println("\n");
            }
        }else{
            System.out.println("System Error: MAximum number of schools allowed per Region is 6");
        }
        
    }
    
}
