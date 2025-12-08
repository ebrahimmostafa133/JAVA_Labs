import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class lab1_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[1000];  
        Random rand = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000);  
        }
        
        int maxi=0,mini=1000;
        //start timer
        long startTime = System.nanoTime();
        for(int i=0;i<numbers.length;i++){
          if(numbers[i]>maxi) maxi=numbers[i];
          if(numbers[i]<mini) mini=numbers[i];
        }
        
        //stop timer
        long endTime = System.nanoTime();
        System.out.println(maxi);
        System.out.println(mini);
        System.out.println("Time taken: " + (endTime - startTime) + " unit time --> Loop" );
        
        //------------------------------------------------------------
        Arrays.sort(numbers);


        System.out.print("Enter a number to search: ");
        int key = input.nextInt();
        long startTime1 = System.nanoTime();
        int index = binarySearch(numbers, key);
        long endTime1 = System.nanoTime();
        System.out.println("Time taken: " + (endTime1 - startTime1) +" unit time --> binary search");

        if (index != -1) {
            System.out.println("Number found at index: " + index);
        } else {
            System.out.println("Number not found in the array.");
        } 
    }

    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid; // found
            } else if (arr[mid] < key) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }

        return -1; // not found
    }
}

