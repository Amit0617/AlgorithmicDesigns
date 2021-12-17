import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class STMaxPairWiseProduct {

// Fast algorithm - O(n)
static long getMaxPairWiseProductFast(long[] numbers){
int n = numbers.length;
int ind1=0;
for(int i=1; i<n ; i++){
if(numbers[i]>numbers[ind1]){
ind1 = i ;
}
}
int ind2 = 0;
if(ind1 == 0) {ind2 = 1;}
else ind2 = 0;
for (int j=1; j<n; j++){
//part below can cause this algorithm to fail when a array have largest number twice
//if(numbers[j]!=numbers[ind1] && numbers[j]>numbers[ind2]){
if(j!=ind1 && numbers[j]>numbers[ind2]){
ind2 = j;
}
}
return numbers[ind1]*numbers[ind2];
}

//Slow algorithm - O(n^2)
static long getMaxPairWiseProduct(long[] numbers){
int num = numbers.length;
long product = 1;
for(int i=0; i < num; i++){
for(int j=i+1; j < num; j++){
//exception handling - this was failing when the array like [5, 0] was passed in debugging
if (num == 2 && (numbers[i] == 0 || numbers[j] == 0)){
product = 0;
}
else{
product = Math.max(product, numbers[i]*numbers[j]);}
}
}
return product;
}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		long M = s.nextLong();
		while (true) {
			Random r = new Random();
			int random = r.nextInt(2, N);
			long[] numbers = new long[random];
			for (int i = 0; i<random; i++){
				numbers[i] = r.nextLong(0, M);
				}
			//System.out.println(numbers); error in output	
			System.out.println(Arrays.toString(numbers));
			long result1 = getMaxPairWiseProduct(numbers);
			long result2 = getMaxPairWiseProductFast(numbers);
			if (result1 == result2) {
				System.out.println("OK");}
			else {
				System.out.println("Wrong answer:"+ result1 + "," + result2);
			   
			     break;   
			     }
		          }
		               }	
			           }

