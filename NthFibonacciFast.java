import java.util.*;
import java.io.*;

public class NthFibonacciFast{

    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(getNthFibonacciFast(n));
    }

    static long getNthFibonacciFast(int n){
        long[] numbers = new long[n+1];
        numbers[0] = 0;     //it will fail when 0 is given because we have made it compulsory to have two
        numbers[1] = 1;     //elements in the array.
        for(int i = 2; i<=n; i++){
            numbers[i] = numbers[i-1] + numbers[i-2];
        }
        return numbers[n];
    }
}
