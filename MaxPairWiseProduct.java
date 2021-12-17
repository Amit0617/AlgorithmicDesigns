import java.util.*;
import java.io.*;
public class MaxPairWiseProduct{
//Function
static long getMaxPairWiseProduct(long[] numbers){
int num = numbers.length;
long product = 1;
for(int i=0; i < num; i++){
for(int j=i+1; j < num; j++){
product = Math.max(product, numbers[i]*numbers[j]);
}
}
return product;
}
//Main
public static void main(String[] args){
Scanner s = new Scanner(System.in);
int n = s.nextInt();
long[] numbers = new long[n];
for(int i =0; i<n; i++){
numbers[i]= s.nextLong();
}
System.out.println(getMaxPairWiseProduct(numbers));
}
}
