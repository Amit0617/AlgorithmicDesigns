import java.util.*;
import java.io.*;
// Integer Integer -> Integer
//   n1       n2   ->   d
// Give the greatest number which can divide both given integers.
public class GCD{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int d = 1;
// Greatest divisor will be smaller than smallest of both given number
        int min = Math.min(n1,n2);
        for (int i = 1; i<=min; i++){
            if ( n1%i==0 && n2%i==0 ){
                d = i;
            }
        }
        System.out.println(d);
    }
}
