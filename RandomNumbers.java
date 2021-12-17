import java.util.Random;
public class RandomNumbers{
public static void main (String[] args){
//randomint
Random r = new Random();
int random = r.nextInt(100);
System.out.println(random);
//for loop of random ints randomint times
for(int i = 0; i<random ; i++){
System.out.println(r.nextLong(100000));
}
}
}
