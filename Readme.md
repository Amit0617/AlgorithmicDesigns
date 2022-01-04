### What is this?
This repository is a collection of whatever I learn to improve my DSA skills. I am documenting it because it gives me an opportunity to look back and ponder again on concepts which I have learned with more matured perspective in comparison to my first visit through those concepts.
Let's start now.

## Algorithmic Designs
Starting with simplest things like `GetInputFromUser.java` and `APlusB.java` to familiarize myself with java language(have used long time ago.)

### Maximum Pairwise Product
Find maximum product of two *distinct* numbers in a list of numbers.

Now to actually reflect that we have understood the problem we will try to come up with a naive algorithm that just works without much thinking about time and memory constraints.

###### Naive Algorithm
A naive approach of doing this will be just multiplying all possible pairs, then comparing them and keep updating the `product` for larger one. 
At the end we will be having the largest possible product in that sequence of numbers.
An example code is available in repository `MaxPairWiseProduct.java`.

Fine! so we are done right? No.
The problem with above code is that its time complexity will be &theta;(n<sup>2</sup>). How? (link to runtimes section) Which simply means we have to improve our algorithm.

###### Fast Algorithm
A faster approach to get maximum pairwise product can be finding two largest numbers in sequence of numbers which will be giving maximum product.

To find first largest and second largest elements, we need to scan only two times through the array and updating two indices i.e., `index1` and `index2` with their position inside array.

An example code is available in repository `MaxPairWiseProductFast.java` 

###### Testing and Debugging
The part in algorithm designing which generally gets skipped and often overlooked. However, the most important part. It is generally assumed that there are multiple ways to implement a logic but in actual there are very few ways(or algorithms) which cover all the edge cases.

To test our algorithm we will write a program to generate random datasets and will use that in testing our algorithm.

An example code for generating required inputs is available in repository `RandomNumbers.java`

We can use `RandomNumbers.java` to create `dataset.txt`.
`java RandomNumbers > dataset.txt` in console and then `java MaxPairWiseProductFast < dataset.txt` to use that dataset as input rather than from STDIN (entering yourself).

###### Stress Testing 
Now the problem is it is still very slow and boring. We need to test our algorithm heavily and find the finally one that causes our algorithm fail.

So this is the time to do _Stress Testing_.
We need following things to do it:-
*i) Our algorithm which we want to test.*
*ii) Other trivial algorithm(which might be slower) performing same solution* 
*iii) A random dataset generator.*
*iv) An infinite loop which will keep running until we find a test case for which our algorithm gives different solution.*

Methodology behind all this is that our algorithm must give same answer as the trivial algorithm(assuming it is implemented correctly, obviously) in every case. If that's not the case then it must be missing something.

We take the random dataset generator and print a random array. Feed the random array into both algorithms and compare the result if they are same move ahead i.e., generate new random dataset and feed again. If the results are not same then stop the loop and print the test case which was fed into algorithms. So we can look into it and think about its failure cause.

An example code is available in repository `STMaxPairWiseProduct.java` 

After running `java STMaxPairWiseProduct` it stopped at one case where the results were differing. At `[5,0]` answers were differing as the result of naive algorithm was `1` and fast algorithm gave `0`. And we can also see that correct answer should be `zero`. There was a problem in Naive algorithm and it is clear that I have not considered this edge case.

On Fixing the problem and again running it keeps going on and suddenly fails. Analysing the array and finding maximum pairwise product ourselves, it can be observed that this time result from faster algorithm is wrong and naive algorithm have worked correctly. And it was realised that fast algorithm fails when largest number occurs twice in array. Clearly, in that case first largest number and second largest number will be same and fast algorithm skips that number and chooses actuallly third largest number. A fix is made in the code where instead of comparing that element we are comparing indices now so that first largest number don't get counted twice and if second largest number is same then it gets considered.

We will run the program again and it will keep going for very long time. Then we will just stop it after getting bored enough.

If we consider our fast algorithm then it seems very cluttery way to ignoring the first largest number in search of second largest number within an array.

So we can do one more _optimization_ to fix it. After finding the first largest number in array we can move it the last or first index of array and then can easily ignore that index position when scanning for second largest number.

An example code is available in repository `OpMaxPairWiseProduct.java`

###### A Straight way
We can also implement this problem by sorting the array in ascending or descending order using some sorting techniques, then returning the product of last two numbers or first two numbers respectively. 
However, it is providing more than required that it is sorting whole array where we need just two largest numbers. Also, it's runtime will be higher than our fast or optimised algorithm i.e., _O(nlogn)_ in comparison to _O(n)_. Still it is not very slow and can be considered an efficient algorithm.

So this was some introduction to good practices for making a really working and fast(may be complex sometimes) algorithm. 

### Nth Fibonacci number
Find nth fibonacci number. 

###### Fibonacci Series 
If you don't know what fibonacci series is then it is basically a sequence of numbers where each number is sum of the preceeding two numbers.
It goes in following way

`0,1,1,2,3,5,8,13,21,...`

[Learn more](https://en.wikipedia.org/wiki/Fibonacci_number)

###### Naive Algorithm
If we look at fibonacci series then it can be calculated for any nth number because there is only one way to follow it assuming algorithm knows the first two numbers only i.e., `0` and `1`

So a recursive approach can be implemented to find it. An example code is available in repository `NthFibonacci.java` 

Compile the code `javac NthFibonacci.java`
Run it `java NthFibonacci` and try some small inputs upto 20. When you are sure it is giving the expected output try input like 45. It would be taking some noticeable time.(Really slow algorithm)
Runtime in this case grows exponentially i.e., _O(2<sup>n</sup>)_ which can be felt by trying some input like 90. This will allow you to take a coffee break!
Why so slow?
>I was joking. Actually it will take **years** to compute. 

###### Runtime of Naive algorithm
Considering algorithm given in example code we have _T(n) = 3_ for n <= 1 and _T(n) = 3 + T(n-1) + T(n-2)_ for n >= 2.
Where _T(n)_ is number of lines of code needs to be executed for calculating the nth fibonacci number.
>Facing difficulty in visualising? [gif](link in repo)
If you have 2Ghz CPU clock speed than it will take approx **28,000 years** to compute _T(100)_. Enjoy coffee break!
Don't believe me, run `java NthFibonacci` and open another window of your terminal and enter `ps u -C java` 
Just leaving an example photo...
two photos

If you look at the tree below you will find one of the reason is that it is calculating same thing again and again. 
[photo]   

Fibonacci(2) is calculated 13 times in finding just Fibonacci(8). For Fibonacci(9) it will rise to 21.
[total wastage!]

###### Another Algorithmic Solution
If we just think then in a go we can tell Fibonacci(8) will be 13 and we were able to do it by simply going in the series upto 8th number like `0,1,1,2,3,5,8,13` 
If we implement algorithm in similar way it must be faster than recursion approach.
An example code is available in repository `NthFibonacciFast.java`
Now try finding Fibonacci(90) and I challenge you to take a sip of coffee. More easier try even going to close to Mug before your console prints the result.
Note - If you will try something higher like Fibonacci(90) then it might fail because of integer overflow. So use something like `long`. However that will also fail for Fibonacci(100) but now you know that you can handle it by using a data-type of higher range.

[gif](link) Compare the results for recursive versus table.

###### A Simpler Mathematical approach
There is a direct formula for finding nth fibonacci number.






### Last Digit of a Large Fibonacci Number
Find last digit of the nth Fibonacci number

Since it grows exponentially faster hence it is somewhat more practical to find just last digit rather than whole number.

To find last digit we don't have to care about the other digits of preceeding numbers, because it will be sum of last digits only. 

Calculating last digit only will allow us to give inputs like even `30000` i.e., F(30000) and will give its last digit in no time. If we talk about algorithm the only difference is going to be there that we will use `mod 10` to carry last digit and leaving all other digits.

An example code is available in repository `LastdigitFibonacci.java`

### Greatest Common Divisor
Find greatest common divisor of two given integers.

###### Naive Algorithm
Basically we need a number that in collection of numbers which divides both and it should be greatest among them.

Greatest number in collection of numbers which can divide both of them must be smaller than the smallest between two.

An example code is available in repository `GCD.java`.

###### Fast Algorithm
If you remember we have learned an algorithm(method) when we were kids. May be you knew it as HCF(Highest Common Factor).
A division method where we take the smaller number as divisor and greater number as dividend. If the greater number got divided completely i.e., remainder comes out to be zero then the divisor itself is the HCF of those two numbers. Else, remainder becomes the new divisor and the divisor in previous operation becomes dividend and this keeps going on until zero remainder is obtained.
[Image](link)
>This is one of the classic algorithm and called as grand-daddy of all algorithms because it is the oldest nontrivial algorithm that has survived to the present day. [Donald Knuth](https://en.wikipedia.org/wiki/Donald_Knuth).
>It is famously known as Euclidean algrorithm. This algorithm has many theoretical and practical applications. It is used to reduce fractions to their simplest form, and is a part of many other number-theoretic and *cryptographic* calculations. Computations using this algorithm form part of the cryptographic protocols that are used to secure internet communications, and in methods for breaking these cryptosystems by factoring large composite numbers. 
>The GCD of two numbers a and b is the product of the prime factors shared by the two numbers, where a same prime factor can be used multiple times, but only as long as the product of these factors divides both a and b. For example, since 1386 can be factored into 2 × 3 × 3 × 7 × 11, and 3213 can be factored into 3 × 3 × 3 × 7 × 17, the greatest common divisor of 1386 and 3213 equals 63 = 3 × 3 × 7, the product of their shared prime factors. If two numbers have no prime factors in common, their greatest common divisor is 1 (obtained here as an instance of the empty product), in other words they are coprime. A key advantage of the Euclidean algorithm is that it can find the GCD efficiently without having to compute the prime factors. Factorization of large integers is believed to be a computationally very difficult problem, and the security of many widely used cryptographic protocols is based upon its infeasibility.
>It is based on the principle that the greatest common divisor of two numbers does not change if the larger number is replaced by its difference with the smaller number. For example, 21 is the GCD of 252 and 105 (as 252 = 21 × 12 and 105 = 21 × 5), and the same number 21 is also the GCD of 105 and 147 (= 252 - 105).  By reversing the steps, the GCD can be expressed as a linear combination of the two original numbers, that is the sum of the two numbers, each multiplied by an integer (for example, 21 = 5 × 105 + (−2) × 252). The fact that the GCD can always be expressed in this way is known as Bézout's identity. 
>[Learn more](https://en.wikipedia.org/wiki/Euclidean_algorithm)   

An example code is available in repository `GCDFast.java`

###### Stress Testing Algorithm and System 😝
[Screenshot](link)

Try yourself to see how slow an algorithm becomes for large numbers because of linear time complexity (_O(n)_).
An example code is available in repository `STGCD.java`

###### GCD of two or more numbers
DIY

>Hint: gcd(a,b,c) = gcd(gcd(a,b),c)

### LCM
Find LCM of two given numbers.

###### Naive Algorithm
DIY

To be continued...


{
_Note:- Definitions below are completely made up by myself and reflects my understanding of these. These shouldn't be considered standard definitions of algorithms._
**Greedy algorithm** - A technique to solve a bigger problem by considering a subproblem within it and solving it in such a way that can solve the bigger problem by iterating that again and again. Didn't understood? Move ahead.
**Divide and Conquer algorithm** - A technique to solve a bigger problem by breaking it down into multiple smaller kind of subproblem and joining them all together. As you can expect from its name also!
*If you look closely Greedy algorithm is also the same but there all the smaller problems are of similar kind in contrast to divide and conquer problem where the smaller subproblems are different(but not of different kind) and have to deal with each of them in different way recursively.*

Some more Technical jargon to give you complete insight and you don't have imposter syndrome anymore.
**Safe Choice** -







At the end, remember you will never be asked to solve a problem using greedy algorithm because these algorithms are taught to give you insight of how to think for a problem(which I feel we already have, we are generally just unaware of these fancy terms) rather than giving you a machinery to put input and get the desired output.}
