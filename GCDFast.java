import java.util.*;
import java.io.*;

public class GCDFast{
static void swap (int n1, int n2){

}
static void getGCD(int n1, int n2){
if (n1%n2 == 0){
return n2;
}
else {
while (n2 != 0){
int temp = n2;
n2 = n1%n2;
n1 = temp;
}
} 
}
public static void main(String[] args){
Scanner s = new Scanner(System.in);
int n1 = s.nextInt();
int n2 = s.nextInt();
if (n2 > n1){
swap(n1, n2);
}
System.out.println(getGCD(n1, n2));
}
}
