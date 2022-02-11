### What is this?
This repository is a collection of whatever I learn to improve my DSA skills. I am documenting it because it gives me an opportunity to look back and ponder again on concepts which I had learnt with more matured perspective in comparison to my first visit through those concepts.
Let's start now.
<hr></hr>
It is still work in progress repository and don't take anything as line of stone right now. It needs lots of curation and arrangement to be considered as resource of learning.
<hr></hr>

# Algorithmic Designs
Starting with simplest things like `GetInputFromUser.java` and `APlusB.java` to familiarize myself with java language(have used long time ago).

To be familiar with what an algorithm is we should jump directly on grounds instead of explaining it in some _words_, I would like to give you a _feel_ of it. 

## Maximum Pairwise Product
Find maximum product of two *distinct* numbers in a list of numbers.

Lets frame a algorithm for the given condition. You are given a list of numbers and you would like to find greatest possible product of any two numbers within the list.
Now to actually reflect that we have understood the problem we will try to come up with a naive algorithm, that just works. We will not think much about time and memory constraints right now.

##### Naive Algorithm
A naive approach of doing this will be just multiplying all possible pairs of numbers within the given list of numbers, then comparing them and updating the `product` for larger one. 
At the end we will be having the largest possible product in that sequence of numbers.
An example code is available in repository `MaxPairWiseProduct.java`.

Fine! so we are done right? No.
The problem with above code is that its time complexity will be &theta;(n<sup>2</sup>). [How?](link to runtimes section) Which simply means we have to improve our algorithm.

##### Fast Algorithm
A faster approach to get maximum pairwise product can be - finding two largest numbers in sequence of numbers because those will be giving maximum product.

To find first largest and second largest elements, we need to scan only two times through the array and updating two indices i.e., `index1` and `index2` with their position inside array.

An example code is available in repository `MaxPairWiseProductFast.java` 

##### Testing and Debugging
The part in algorithm designing which generally gets skipped and often overlooked. However, the most important part. It is generally assumed that there are multiple ways to implement a logic but in actual there are very few ways(or algorithms) which cover all the edge cases.

To test our algorithm we will write a program to generate random datasets and will use that in testing our algorithm.

An example code for generating required inputs is available in repository `RandomNumbers.java`

We can use `RandomNumbers.java` to create `dataset.txt` by redirecting its output.  
`java RandomNumbers > dataset.txt` in console and then `java MaxPairWiseProductFast < dataset.txt` to use that dataset as input rather than from STDIN (entering yourself).

##### Stress Testing 
Now the problem is - it is still very slow and boring. We need to test our algorithm heavily and find the finally one case(if exists) that can lead our algorithm to fail.

So this is the time to do _Stress Testing_.  
We need following things to do it:-  
*i) Our algorithm which we want to test.*  
*ii) Other trivial algorithm(which might be slower) performing same solution.*  
*iii) A random dataset generator.*  
*iv) An infinite loop which will keep running until we find a test case for which our algorithms give different solution.*  

Methodology behind all this is that our algorithm must give same answer as the trivial algorithm(assuming it is implemented correctly) in every case. If that's not the case then it must be missing something.

We take the random dataset generator and print a random array. Feed the random array into both algorithms and compare the result if they are same move ahead i.e., generate new random dataset and feed again. If the results are not same then stop the loop and print the test case which was fed into algorithms. So we can look into it and think about its failure cause.

An example code is available in repository `STMaxPairWiseProduct.java` 

After running `java STMaxPairWiseProduct` it stopped at one case where the results were differing. At `[5,0]` answers were differing as the result of naive algorithm was `1` and fast algorithm gave `0`. And we can also see that correct answer should be `zero`. There was a problem in Naive algorithm and it is clear that I have not considered this edge case.

On Fixing the problem and again running it keeps going on and suddenly fails. Analysing the array and finding maximum pairwise product ourselves, it can be observed that this time result from faster algorithm is wrong and naive algorithm have worked correctly. And it was realised that fast algorithm fails when largest number occurs twice in array. Clearly, in that case first largest number and second largest number will be same and fast algorithm skips that number and chooses actuallly third largest number. A fix is made in the code where instead of comparing that element we are comparing indices now so that first largest number don't get counted twice and if second largest number is same then it gets considered.

We will run the program again and it will keep going for very long time. Then we will just stop it after getting bored enough.

If we consider our fast algorithm then it seems very cluttery way to ignoring the first largest number in search of second largest number within an array.

So we can do one more _optimization_ to fix it. After finding the first largest number in array we can move it the last or first index of array and then can easily ignore that index position when scanning for second largest number.

An example code is available in repository `OpMaxPairWiseProduct.java`

##### A Straight way
We can also implement this problem by sorting the array in ascending or descending order using some sorting techniques([which will learn later but here only](link to sorting techniques)), then returning the product of last two numbers or first two numbers respectively. 
However, it is providing more than required that it is sorting whole array where we need just two largest numbers. Also, it's runtime will be higher than our fast or optimised algorithm i.e., _O(nlogn)_ in comparison to _O(n)_. Still it is not very slow and can be considered an efficient algorithm.

So this was some introduction to good practices for making a really working and fast(may be complex sometimes) algorithm. 

## Nth Fibonacci number
Find nth fibonacci number. 

##### Fibonacci Series 
If you don't know what fibonacci series is then it is basically a sequence of numbers where each number is sum of the preceeding two numbers.
It goes in following way

`0,1,1,2,3,5,8,13,21,...`

[Learn more](https://en.wikipedia.org/wiki/Fibonacci_number)

##### Naive Algorithm
If we look at fibonacci series then it can be calculated for any nth number because there is only one way to follow it assuming algorithm knows the first two numbers only i.e., `0` and `1`

So a recursive approach can be implemented to find it. An example code is available in repository `NthFibonacci.java` 

Compile the code `javac NthFibonacci.java`
Run it `java NthFibonacci` and try some small inputs upto 20. When you are sure it is giving the expected output try input like 45. It would be taking some noticeable time.(Really slow algorithm)
Runtime in this case grows exponentially i.e., _O(2<sup>n</sup>)_ which can be felt by trying some input like 90. This will allow you to take a coffee break!
Why so slow?
>I was joking. Actually it will take **years** to compute. 

##### Runtime of Naive algorithm
Considering algorithm given in example code we have _T(n) = 3_ for n <= 1 and _T(n) = 3 + T(n-1) + T(n-2)_ for n >= 2.
Where _T(n)_ is number of lines of code needs to be executed for calculating the nth fibonacci number.
>Facing difficulty in visualising? [gif](link in repo)
If you have 2Ghz CPU clock speed than it will take approx **28,000 years** to compute _T(100)_. Enjoy coffee break!
Don't believe me, run `java NthFibonacci` and open another window of your terminal and enter `ps u -C java` 
Just leaving an example photo...
[photolink](psNthFibon)

If you look at the tree below you will find one of the reason is that it is calculating same thing again and again. 
[photo](recursiveTree)   

Fibonacci(2) is calculated 13 times in finding just Fibonacci(8). For Fibonacci(9) it will rise to 21.
[total wastage!](babu rao)

##### Another Algorithmic Solution
If we just think then in a go we can tell Fibonacci(8) will be 13 and we were able to do it by simply going in the series upto 8th number like `0,1,1,2,3,5,8,13` 
If we implement algorithm in similar way it must be faster than recursion approach.
An example code is available in repository `NthFibonacciFast.java`
Now try finding Fibonacci(90) and I challenge you to take a sip of coffee. More easier try even going to close to Mug before your console prints the result.
Note - If you will try something higher like Fibonacci(90) then it might fail because of integer overflow. So use something like `long`. However that will also fail for Fibonacci(100) but now you know that you can handle it by using a data-type of higher range.

[gif](link) Compare the results for recursive versus table.

##### A Simpler Mathematical approach
There is a direct formula for finding nth fibonacci number.






## Last Digit of a Large Fibonacci Number
Find last digit of the nth Fibonacci number

Since it grows exponentially faster hence it is somewhat more practical to find just last digit rather than whole number.

To find last digit we don't have to care about the other digits of preceeding numbers, because it will be sum of last digits only. 

Calculating last digit only will allow us to give inputs like even `30000` i.e., F(30000) and will give its last digit in no time. If we talk about algorithm the only difference is going to be there that we will use `mod 10` to carry last digit and leaving all other digits.

An example code is available in repository `LastdigitFibonacci.java`

## Greatest Common Divisor
Find greatest common divisor of two given integers.

##### Naive Algorithm
Basically we need a number that in collection of numbers which divides both and it should be greatest among them.

Greatest number in collection of numbers which can divide both of them must be smaller than the smallest between two.

An example code is available in repository `GCD.java`.

##### Fast Algorithm
If you remember we have learned an algorithm(method) when we were kids. May be you knew it as HCF(Highest Common Factor).
A division method where we take the smaller number as divisor and greater number as dividend. If the greater number got divided completely i.e., remainder comes out to be zero then the divisor itself is the HCF of those two numbers. Else, remainder becomes the new divisor and the divisor in previous operation becomes dividend and this keeps going on until zero remainder is obtained.
[HCF](link)
>This is one of the classic algorithm and called as grand-daddy of all algorithms because it is the oldest nontrivial algorithm that has survived to the present day. [Donald Knuth](https://en.wikipedia.org/wiki/Donald_Knuth).
>It is famously known as Euclidean algrorithm. This algorithm has many theoretical and practical applications. It is used to reduce fractions to their simplest form, and is a part of many other number-theoretic and *cryptographic* calculations. Computations using this algorithm form part of the cryptographic protocols that are used to secure internet communications, and in methods for breaking these cryptosystems by factoring large composite numbers. 
>The GCD of two numbers a and b is the product of the prime factors shared by the two numbers, where a same prime factor can be used multiple times, but only as long as the product of these factors divides both a and b. For example, since 1386 can be factored into 2 × 3 × 3 × 7 × 11, and 3213 can be factored into 3 × 3 × 3 × 7 × 17, the greatest common divisor of 1386 and 3213 equals 63 = 3 × 3 × 7, the product of their shared prime factors. If two numbers have no prime factors in common, their greatest common divisor is 1 (obtained here as an instance of the empty product), in other words they are coprime. A key advantage of the Euclidean algorithm is that it can find the GCD efficiently without having to compute the prime factors. Factorization of large integers is believed to be a computationally very difficult problem, and the security of many widely used cryptographic protocols is based upon its infeasibility.
>It is based on the principle that the greatest common divisor of two numbers does not change if the larger number is replaced by its difference with the smaller number. For example, 21 is the GCD of 252 and 105 (as 252 = 21 × 12 and 105 = 21 × 5), and the same number 21 is also the GCD of 105 and 147 (= 252 - 105).  By reversing the steps, the GCD can be expressed as a linear combination of the two original numbers, that is the sum of the two numbers, each multiplied by an integer (for example, 21 = 5 × 105 + (−2) × 252). The fact that the GCD can always be expressed in this way is known as Bézout's identity. 
>[Learn more](https://en.wikipedia.org/wiki/Euclidean_algorithm)   

An example code is available in repository `GCDFast.java`

##### Stress Testing Algorithm and System 😝
[Screenshot](link)

Try yourself to see how slow an algorithm becomes for large numbers because of linear time complexity (_O(n)_).
An example code is available in repository `STGCD.java`

##### GCD of two or more numbers
DIY

>Hint: gcd(a,b,c) = gcd(gcd(a,b),c)

## LCM
Find LCM of two given numbers.

Datasets to test 
1. Input : `8 12`
   Output : `24`
   
2. Input : `34569852 1259642`
   Output : ``   

##### Naive Algorithm
DIY

##### Fast Algorithm
DIY


To be continued...

## Runtime - 
When we think about runtimes it intuitively comes to our understanding that the 'time' taken by an algorithm should be a runtime. But thinking from that perspective figuring out runtimes can be a huge mess. Same algorithm may take different time on different systems because it will depend on so many things apart from algorithm like system architecture, specifications of computer, even the compiler being used and the memory heirarchy as different types of memory have different speeds of providing data on demand of CPU.

As a programmer you never know all those details about the machine where your algorithm is going to be run.

An idea which can direct us toward a meaningful aspect of runtime when considering so many variety of issues is that all these differences between computer specifications and architecture multiply runtimes of algorithm by a **large constant**. So when measuring runtime, ignore the constant mulitples of it whether it is 1 second, 1 minute or 1 year. And consider only _asymptotic runtime_ which scales with the input size.

There are some common runtimes _O(log n), O(√n), O(n), O(n*log n), O(n<sup>2</sup>), O(2<sup>n</sup>)_ which can be visualised how they scale with the input size.  
[gif](link)
[Media/rateOfGrowth.png](Media/rateOfGrowth.png)

So we are actually interested in **rate of growth** of runtime of algorithm.

Quick intrduction to Asymptotic notations: There are three notations which are used to describe runtimes of different algorithms. This can be skipped(Big omega and Big &theta;) if it is your first ever introduction to _Big O_ because it might confuse you at first ever meet:  
**Big O** - It is worst case running time or also called **asymptotic upper bound**. We mostly focus on this because knowing worst case running time gives us a gurrantee that the given algorithm will never take longer than that. We will see how often we tend to leave insignificant values when finding big O.

**Big Omega** - Similarly, it is **asymptotic lower bound** of algorithm runtime.

**Big Theta** - It represents upper bound and lower bound of algorithm runtime. Or more specifically the tight bound for a function _f(n)_. It is denoted by _&theta;(g(n))_ which represents a set of function within which _f(n)_ lies. Usually we use _f(n) = &theta;(g(n))_ to represent that notion which seems little misguiding(but is done for a good reason), where g(n) is a tight bound of _f(n)_.

Back to the actual question - How do we calculate runtime actually?
The runtime of an algorithm with particular input depends upon the steps executed within algorithm and time taken by each step. For example if we consider following example where we are finding whether a number is prime or not:
``` java
 boolean isPrime(int x) {				      "cost"		"times"
 	for (int i = 2; i*i <= x; i++) {			c1		√x
 		if ( x % i == 0 ) {				c2		√x - 1
 			return false;			        c3	        1
 		}
 	}
 	return true;					        c4		1
 }
```
Now each and every line here will take some time according to compiler and hardware constraints. Considering that `ith` line of algorithm takes some constant `c<sub>i</sub>` time than the total time of one particular line will be `c<sub>i</sub>*n<sub>i</sub>` where `n<sub>i</sub>` is the no. of times that step is executed.

The exact total time in this case will come out to be:  
```
T(x) =  c<sub>1</sub>*√x + c<sub>2</sub>*(√x - 1) + c<sub>3</sub> + c<sub>4</sub>
```
which can be expressed as  
```
T(x) = (c<sub>1</sub> + c<sub>2</sub>)*√x + (-c<sub>2</sub> + c<sub>3</sub> + c<sub>4</sub>)
```
i.e., `a*√x + b` where `a` and `b` are another constants.  

As said earlier, we are only interested in _rate of growth_ of algorithm but how do we make sure of that?  
There are some general rules to keep in mind when finding out **Big O**.  
1. Constant multiples are ignored.  
For example:  
An algorithm with running time with `a*n + b` is linear function of _n_ and hence we will consider it as having time complexity _O(n)_.
2. Values of lesser significance(lower rates of growth) are ignored.
`a*n<sup>2</sup> + b*n + c --> n<sup>2</sup>` because simply for greater input size rate of growth of `n<sup>2</sup>` will simply dominate over `n`. [See here](link to the photo of rate of growth).

{
_Note:- Definitions below are completely made up by myself and reflects my understanding of these. These shouldn't be considered standard definitions of algorithms._
## Greedy algorithm - 
A technique to solve a bigger problem by considering a subproblem within it and solving it in such a way that can solve the bigger problem by iterating a locally optimised solution again and again. Didn't understood? Move ahead.

##### Greedy Choice 
A choice which will solve the smaller problem locally and can be applied globally to solve the problem.

##### Safe Choice 
If the greedy choice is optimal solution and consitent with first choice it is called safe choice.

##### An example to understand all above technical shit.
Lets assume n patients have arrived at doctors office at the same time and compounder have to send them inside one by one because they can be treated individually only. Compounder wants to send them in such a way so that total waiting time for all patients is least. Given they can be sent in any order and time required to treat each patient is known.

So Compounder sends the patient with least time of treatment first, thinking that this way second patient will have to wait minimum time in queue. This is called Greedy Choice.

Now, is that choice optimal enough to keep solving the subproblem by iterating it again and again and hence solve the whole problem?

Lets assume 3 patients, P<sub>1</sub>, P<sub>2</sub> and P<sub>3</sub> with treatment time 10 minutes, 30 minutes and 60 minutes arrive at 10:00 A.M. at doctor's clinic.

There are 6 possible arrangements of queue with following total waiting time:  
i) P<sub>1</sub> sent immediately, P<sub>2</sub> after 10 minutes and then P<sub>3</sub> after 30 minutes. Total waiting time = 40 minutes.  
ii) P<sub>2</sub> sent immediately, P<sub>1</sub> after 30 minutes and then P<sub>3</sub> after 10 minutes of P<sub>1</sub>. Total waiting time = 40 minutes.  
iii) P<sub>3</sub> sent immediately, P<sub>1</sub> after 60 minutes and then P<sub>2</sub> after 10 minutes. Total waiting time = 70 minutes.  
iv) P<sub>3</sub> sent immediately, P<sub>2</sub> after 60 minutes and then P<sub>1</sub> after 30 minutes. Total waiting time = 90 minutes.  
v) P<sub>2</sub> sent immediately, P<sub>3</sub> after 30 minutes and then P<sub>1</sub> after 60 minutes. Total waiting time = 90 minutes.  
vi0 P<sub>1</sub> sent immediately, P<sub>3</sub> after 10 minutes and then P<sub>2</sub> after 60 minutes. Total waiting time = 70 minutes.  

Now considering above arrangements its clear that arranging patients with least treatment time to keep first on priority is safe choice.

You might ask that first two arrangements both have least total waiting time so why not second is optimal one? I will suggest think about waiting time for successive patients. However, the total time comes out to be same but second patient i.e., P<sub>1</sub> in that case will have to wait 30 minutes for his 10 minutes treatment, while there is no difference for P<sub>3</sub> it will be 40 in both cases.

This small example allows us to draw a simple conclusion that the greedy choice made first time can be optimally iterated throughout the queue and hence now this greedy choice can be called a <u>_safe choice_</u>.

This whole process is called Greedy Algorithm. Thankyou.

An implementation of this problem is available in repository `MinTotalTime.java`.

One Small and very trivial problem to solve:
Lets suppose you went to an ATM to withdraw some cash. You inserted your card in ATM and this ATM seems to be faulty. This reflects your bank balance on screen. You were confused and hence entered some random digits there 13780 (say) and hit next and damn your bank balance is updated to this new number! 
You hurried back to that edit balance screen and you again pressed some random numbers but this time that numeric pad is behaving differently. After hitting several numbers you found out that those keys(which you have pressed earlier) after pressing next button are no more functional. So, you can't use them this time but you are still on edit screen and keys allowed to be pressed are `2,4,5,6,9`. One button will be working one time only. Now you want to press them in such a manner that you get maximum bank balance.  

_Greedy_ Choice will be to have largest possible number as your bank balance. To have largest number from a given set of digits we would place maximum number among them on maximum priority place.

`Max(2, 4, 5, 6, 9) = 9` place it at highest place and remove that number from the list.  
<u>9</u>_ _ _ _  
`Max(2, 4, 5, 6) = 6` place it at highest place and remove that number from the list.  
<u>9</u><u>6</u>_ _ _   
`Max(2, 4, 5) = 5` place it at highest place and remove that number from the list.  
<u>9</u><u>6</u><u>5</u>_ _  
`Max(2, 4) = 4` place it at highest place and remove that number from the list.  
<u>9</u><u>6</u><u>5</u><u>4</u>_  
`Max(2) = 2` place it at highest place and remove that number from the list.  
<u>9</u><u>6</u><u>5</u><u>4</u><u>2</u>  

The choice we made to pick largest number at that instant is greedy choice and that choice is consistent throughout the process hence this greedy choice is safe choice.  
Now consistently viewing this scenario that greedy choice is turning out to be safe choice this shouldn't be assumed that it will be safe always. Infact, greedy choice often comes out to be a unsafe choice.  
Let's take a look at following example:  
To get the path for largest sum, greedy algorithm will try to make decision on immediate comparison i.e., by comparing `3` and `12`. Finding `12 > 3` it will move ahead and again will make comparison between `5` and `6`. Finding `6 > 5` the largest sum accourdingly will turn out to be `25`. While we can see that the actual largest sum will be `109 (= 7 + 3 + 99)`.
(gif)[https://en.wikipedia.org/wiki/File:Greedy-search-path-example.gif]  

This shows how a greedy choice can be unsafe choice too and we have to think in advance for that whether our greedy choice can give us globally optimised solution on looping through our problem and solving sub-problems.

### Cashier's Money Change Problem
Find minimum number of coins needed to change the required value into coins with denominations 1, 5, 10.

### Maximum Advertisement Revenue Problem
Find such distribution of ads on a popular internet page owned by you so that `n` ads placed on `n` slots on that page. Assuming you have estimated counts of clicks for each slot and different advertisers have different budgets for their ads. You have to maximize total revenue made from adclicks.

### Collecting Signatures


## Divide and Conquer algorithm  
A technique to solve a bigger problem by breaking it down into multiple smaller similar kind of subproblem(non-overlapping) to each other and joining them all together. As you can expect from its name also!








*If you look closely Greedy algorithm is where we try to scale a solution applicable to immediate smaller problem for rest of the subproblem. {also the same but there all the smaller problems are of similar kind in contrast to divide and conquer problem where the smaller subproblems are different(but not of different kind) and have to deal with each of them in different way recursively.}*






At the end, remember you will never be asked to solve a problem using greedy algorithm because these algorithms are taught to give a insight of how to think for a problem(which I feel we already have, we are generally just unaware of these fancy terms) rather than giving you a machinery to put input and get the desired output.}
