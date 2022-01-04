import java.util.*;
import java.io.*;

public class GCDFast{
public static void main(String[] args){
Scanner s = new Scanner(System.in);
int n1 = s.nextInt();
int n2 = s.nextInt();
if (n2 > n1){
swap(n1, n2);
}
System.out.println(getGCD(n1, n2));
}
static int[] swap (int n1, int n2){
int[] arr = new int[2];
arr[0] = n1 - n2;
arr[1] = arr[0] + n2;
arr[0] = arr[1] - arr[0];
return arr;
}
static int getGCD(int n1, int n2){
if (n1%n2 == 0){
return n2;
}
else {
while (n2 != 0){
int temp = n2; //storing divisor
n2 = n1%n2; //updating remainder which will be used as divisor
n1 = temp; //updating with divisor which will be used as dividend
}
return n1; //returning divisor when n2 i.e., remainder is zero
} 
}
}
