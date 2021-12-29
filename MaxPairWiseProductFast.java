import java.util.*;
import java.io.*;
public class MaxPairWiseProductFast{
static long getMaxPairWiseProductFast(long[] numbers){
int n = numbers.length;
int ind1=0;
for(int i=1; i<n ; i++){
if(numbers[i]>numbers[ind1]){
ind1 = i ;
}
}
int ind2 = 0;
if(ind1 == 0) {ind2 = 1;} // Why? 
//the following if conditional will never get satisfied if there 
//are only two elements in array and array have first largest 
//number at first index (ind1 = 0) and hence it ind2 will not get 
//updated and will remain ind2=0 which is not second largest 
//number but the first largest number.
else ind2 = 0;
for (int j=1; j<n; j++){
if(numbers[j]!=numbers[ind1] && numbers[j]>numbers[ind2]){
ind2 = j;
}
}
return numbers[ind1]*numbers[ind2];
}

public static void main(String args[]){
Scanner s = new Scanner(System.in);

int n = s.nextInt();
long[] numbers = new long[n];
for(int i = 0; i<n; i++){
numbers[i]=s.nextLong();
}

System.out.println(getMaxPairWiseProductFast(numbers));
}
}
