import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class OpMaxPairWiseProduct{

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        var num = s.nextInt();
        long[] numbers = new long[num];
        for (int i=0; i<num; i++){
            numbers[i]=s.nextLong();
        }
        System.out.println(getOpMaxPairWiseProduct(numbers));
    }

    static long[] swap(long[] numbers, int a, int b){
        long temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
        System.out.println(a+","+b);
        System.out.println(Arrays.toString(numbers));
        return numbers;
    }
    static long getOpMaxPairWiseProduct(long[] numbers){
        int num = numbers.length;
//Basically in this algorithm we want to ignore the largest 
//number we got the first time and then scan only among the remaining
//elements to get another largest among them even if it is same to
//previous largest number.
        int index = 0;
        for(int i=0; i<num; i++){
            if(numbers[i]>numbers[index]){
                index = i;
            }
        }
//Now we have the position of largest number now we are going to 
//push it to last index position. Why?
        swap( numbers, index, num-1 );
        index = 0;
        for( int i = 0; i < num - 1; i++ ){  //Here is the reason after pushing
                                        //largest number to the terminal end
                                        //we can easily ignore that number
            if( numbers[i] > numbers[index] ){
                index = i;
            }
        }
        swap( numbers, index, num-2 );
//Now the two largest numbers are at last two position
//we can now find max product pair
		return numbers[num-1]*numbers[num-2];
	}
}
