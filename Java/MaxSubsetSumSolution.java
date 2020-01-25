//https://www.hackerrank.com/challenges/max-array-sum/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxSubsetSumSolution {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int maxSum = 0;
        int maxSumPrevTwo = 0;
        
        for(int i=0; i< arr.length; ++i ){
            
            if (arr[i]+maxSumPrevTwo > maxSum ){
                int temp = maxSum;
                maxSum = arr[i]+ maxSumPrevTwo ;
                maxSumPrevTwo = temp;
            }
            else{
                maxSumPrevTwo = maxSum;
            }
        }

        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
