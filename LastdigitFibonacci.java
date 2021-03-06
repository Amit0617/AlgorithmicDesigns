import java.util.*;
import java.io.*;

class LastdigitFibonacci{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(getLastdigitFibonacci(n));
    }

    static int getLastdigitFibonacci(int n){
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i<=n; i++){
            arr[i] = arr[i-1]%10 + arr[i-2]%10;
            arr[i] = arr[i]%10;
        }
        return arr[n];
    }
}
