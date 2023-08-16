import java.util.*;
public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t--> 0) {
      int n = sc.nextInt();
      int arr[] = new int[n];
      int index=0;
      for(int i=1;i<=n;i+=2){ //since we are taking double of each element in secodn loop the only element left not to be counted will be the odd oens so take a jump of 2 starting from 1 => will land on odd
        for(int j=i;j<=n;j*=2){
          arr[index]=j;
          index++;
        }
      }
      for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
      }
      System.out.println();
    }
    sc.close();
  }
}

/*
LOGIC---
Permutation of n is the permutation of array [1,2,3,....,n]
Step 1: Is finding a certain permutation
di=gcd(ai,a(imodn)+1) => finding gcd of consecutive elements
Step 2: Making another array of the given gcd statement for each permuation
Step 3: Calculating score of each permutation by counting the number of disticnt elements in forme dgcd array
Return the permutation with the maximum score


eg : n=5 -> 1,2,3,4,5
gcd max score can be made by permuation 1,2,4,3,5
gcd(1,2) -> 1
gcd(2,4) -> 2
gcd(4,3) -> 1
gcd(3,5) -> 1
gcd(5,1) -> 1   //a(imodn)+1
Score =2 (max score possible)


eg: n=7 -> 1,2,3,4,5,6,7
gcd max score can be made by permutation 1,2,4,3,6,5,7
gcd(1,2) -> 1
gcd(2,4) -> 2
gcd(4,3) -> 1
gcd(3,6) -> 3
gcd(6,5) -> 1
gcd(5,7) -> 1
gcd(7,1) -> 1
score = 3(max score possible)


Now if we were to try to find the maximum number of distinct gcd of adjacent elemnt of the permutation it would never go beyond n/2.
Rememeber can also be checked by observation. 
For example permuation of n=10 will have 5 distinct gcds max.
the distinct gcds are  - 1,2,3,4,5
Now that came from 1,2,4,8,3,6,5,10,7,9
Now you can see that we have arranged the adjacent elemnts as double to get distinct gcds
1,2 => 1
2,4 => 2
4,8 => 4
3,6 => 3
5,10 => 5
Now since double of 6(i.e.12) exceeds 10. It is only going to give us a repeated gcd and so on for other numbers like 7,9

So our aim should be to get the double of each numbers adjacent to each other
What we need to do is find a pattern to make that happen now. That's what our question reduces down to.
To make the adjacent elemnts double and present them.

The problem asks us to find the permutation giving s the maximum gcd.
*/

/* BETTER & EASY ELEGANT SOLUTION */
import java.util.*;
public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t--> 0) {
      int n = sc.nextInt();
      HashSet<Integer> set = new HashSet<>();   //all elemtn sar egoing to be distinct in permutation
      for(int i=1;i<=n;i++){
        set.add(i);
      }
      for(int i=1;i<=n;i++){
        if(set.contains(i)){
          int j=i;
          while(j<=n){
            System.out.print(j+" ");
            set.remove(j);
            j*=2;
          }
        }
      }
      System.out.println();
    }
    sc.close();
  }
}

/* 
LOGIC ---
BETTER SOLUTION OF FINDING THE PATTERN REQUIRED

To generate the kind of pattern we want
We put all the elements in hashset
We start with first element and then keep on putting its double until we exceed.
At the same time we remove the elements used from the hashset
And keep on iterating only if set still contains the number
*/

