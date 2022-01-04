import java.util.*;
import java.io.*;

public class GCD{
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int n1 = s.nextInt();
	int n2 = s.nextInt();
	int d = 0;
	int min = Math.min(n1,n2);
	for (int i = 1; i<=min; i++){
		d = i;
	}
	System.out.println(d);
}
}
