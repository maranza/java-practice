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
        
        System.out.println("enter number of schools participated per Region: ");
        numberOfSchoolsPerRegion = console.nextInt();
        
        if (numberOfSchoolsPerRegion <= maxSchools)
        {
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
        }
        
    }
    
}
