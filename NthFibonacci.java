import java.util.*;
import java.io.*;

class NthFibonacci {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(getFibonacci(n));
    }

    static int getFibonacci(int n){
        if ( n == 0 || n == 1 ){
            return n;
        }
        else {
            return getFibonacci(n-1)+getFibonacci(n-2);
        }
    }
}

