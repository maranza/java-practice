package refusecollection;

import java.util.Arrays;
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
    
    static int [] sumOfWeights(int[][] array)
    {
        int index = 0;
        int temp[] = new int[array[index].length];
        for (int i = 0; i < array[0].length; i++)
        {
            int sum = 0;
            for (int j = 0; j < array.length; j++)
            {
                sum += array[j][i];
            }
            temp[index] = sum;
//            System.out.println("Index is: " + index + " Sum is: " + sum);
            index++;
        }
        return temp;
    }
    
    
    public static void main(String[] args)
    {
        
        int[] one = {1,2,3};
        int[] two = {2,4,6};
        
        one = two;
        
        System.out.println("testing: "+ Arrays.toString(one));
        
        Random rand = new Random(50);
        int maxSchools = 6;
        int regions = 4;
        int[] regionNumber = new int[regions];
        int[][] rc = new int[regionNumber.length][maxSchools + 1];
        int numberOfSchoolsPerRegion;
        int weightOfLitter;
        int choice;
        
        System.out.println("enter number of schools participated per Region: ");
        numberOfSchoolsPerRegion = console.nextInt();
        
        if (numberOfSchoolsPerRegion <= maxSchools)
        {
//            System.out.println("Menu \n");
//            System.out.println("\n");
//            System.out.println("1 - Display in \n2 - Calculate averages \n3 - Display the winner \n4 - QUIT \n\nYour choice: \n");
//            choice = console.nextInt();
//            
//            switch(choice){
//                case 1: 
//                    System.out.println("Chose option 1");
//                    return;
//                case 2: 
//                    System.out.println("Chose option 2");
//                    return;
//                case 3: 
//                    System.out.println("Chose option 3");
//                    return;
//                case 4: 
//                    System.out.println("Chose option 4");
//                    return;
//                default:
//                    System.out.println("System Error: Input not supported");
//            }
            
            for (int i = 0; i < numberOfSchoolsPerRegion; i++) //rows
            {
                
                for (int j = 0; j < regions; j++) //columns
                {
                    //System.out.println("enter weight of litter of school in " + j + " participated in Region " + (i+1));
                    //weightOfLitter = console.nextInt();
                    weightOfLitter = rand.nextInt(800);
                    rc[j][i] = weightOfLitter;
                }
                System.out.println("\n");
            }
            
//            System.out.println("===================================\n");
//            for (int i = 0; i < regionNumber.length; i++)
//            {
//                System.out.print(rc[i][numberOfSchoolsPerRegion + 1] + "\t");
//            }


            System.out.println("===========================Calculating sums===================================\n");
            
            
            
//            System.out.println("sums : " + Arrays.toString(sumOfWeights(rc)));
//            int columnSums[] = new int[regions];
//            for (int i = 0; i < rc.length; i++)
//            {
//                for (int j = 0; j < rc[i].length; j++)
//                {
//                    columnSums[j] += rc[i][j];
//                }
//            }
//            
//            System.out.println("The sums of each column are: ");
//            for (int i = 0; i < columnSums.length; i++)
//            {
//                System.out.print("Column " + i + ": " + columnSums[i] + "\t");
//            }
            
            System.out.println("===========================Printing Array Values==============================\n");
            for (int i = 0; i < numberOfSchoolsPerRegion; i++)
            {
                for (int j = 0; j < regions; j++)
                {
                    System.out.print(rc[j][i] + "\t");
                }
                System.out.println("\n");
            }
            
            System.out.println("================================================================================\n");
            
            
            System.out.println("===========================Printing Array Values==============================\n");
            int[][] as = calculateTotalsAndAverages(rc, regions);
            for (int i = 0; i < as.length; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    System.out.print(as[i][j] + "\t");
                }
                System.out.println("\n");
            }

            System.out.println("================================================================================\n");
            
            System.out.println("sums and avg " + Arrays.toString(calculateTotalsAndAverages(rc, regions)));
            System.out.println("highest weight: " + getHighestWeight(rc, maxSchools, regions));
            
        }else{
            System.out.println("System Error: MAximum number of schools allowed per Region is 6");
        }
        
    }
    
    static int[][] calculateTotalsAndAverages(int[][] data, int regions){
        
        int columnSum = 0;
        int[][] sumArray = new int[2][4];
        for (int k = 0; k < regions; k++)
        {
            for (int i = 0; i < data.length; i++)
            {
                columnSum += data[k][i];
//                System.out.println("Column sum: " + columnSum);
            }
            sumArray[0][k] = columnSum;
            sumArray[1][k] = columnSum/data.length;
            columnSum = 0;
        }
//        System.out.println("sums : " + Arrays.toString(sumArray));
        
        return sumArray;
    }
    
    static int getHighestWeight(int data[][], int maxSchools, int  maxRegion ){
        int max = 0;
        for (int i = 0; i < maxRegion; i++)
        {
            for (int j = 0; j < maxSchools; j++)
            {
                if (data[i][j] > max)
                    max = data[i][j];
            }
            System.out.println("\n");
        }

        return max;
    }
    
}
