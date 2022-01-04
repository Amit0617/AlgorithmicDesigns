import java.util.*;
import java.io.*;

public class GCD{

/*static int[] swap(int n1, int n2){
int temp = n1;
n1 = n2;
n2 = temp;
int[] numbers = new int[2];
numbers[0] = n1;
numbers[1] = n2;
return numbers;
}
*/

public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int n1 = s.nextInt();
	int n2 = s.nextInt();
	int d = 0;
	/*if (n1<n2){
	int[] arr = new int[2];
	arr[0] = n1;
	arr[1] = n2;
	swap(n1, n2);
	System.out.println(n1+","+n2);
	}*/
	for (int i = 1; i<=n1; i++){
	if (n1%i==0 && n2%i==0){
	if (n1 ==0){return n2;}
	if (n2 ==0 ) { 
	   return n1;
	}
	d = i;
	}
	}
	System.out.println(d);
}
}
