import java.util.*;
public class Main{
public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();
    while(t-->0){
        int sum=sc.nextInt();     //total amount to pay
        int k=sc.nextInt();     //value k
        int a1=sc.nextInt();     //coins of value 1
        int ak=sc.nextInt();     //coins of value k
        int fancyk=0;
        int fancy1=0;
        //use ak coins
        int akcoinsused = Math.min(ak, sum/k);
        sum-=k*akcoinsused;
        //use a1 coins
        sum-=a1;
        if(sum>0){  //still need to pay more time to use fancy coins
            //use fancy coins worth ak
            fancyk=sum/k;   //we utilise fancyk to fullest and if sum<k; the division simply returns 0 fancyk used
            sum-=k*fancyk;
            if(sum>0){  //sum still left finally use fancy coin of worth 1
                fancy1=sum; //with this we are able to pay fully now
            }
        }
        System.out.println(fancyk + fancy1);
    }
    sc.close();
}
}

/*
LOGIC ---

sum=m=total amount to pay
a1=no of coins worth 1
ak = no of coins worth k
What the questions want us to do is to use as minimum fancy coins as possible

Regular coins - coins worth 1(~a1 coins) and coins worth k(~ak coins)
Fancy coins - infinite coins worth 1 and k

First we will start by spending ak coins, then a1 coins
Then finally we will try to use fancy coisn to cover left sum

Case I: no need to use fancy coins ( can completely pay with regular coins)
Now if no of coins worth 1(~a1) exceeds the sum, no need to use fancy coins, since a1 coisn can fully pay sum
if no. of coin worth k(~ak) k*ak==sum ; No need to use fancy coins, since ak coins can fully pay sum
if m<k*ak && m%k<=a1    => No need to use fancy coins => If we can pay some part of m with ak, if ak*k is greater than 


Case II: Need to use fancy coins. How? Best possible way?


First we will start by spending ak coins, then a1 coins
Then finally we will try to use fancy coisn to cover left sum
How many ak coins can we use with the thought that we want to use maximum number of ak coins?
useak = Math.min(ak,  m/k); => m/k=total number of ak coins required. So, either ak_required exceeds ak given to us or otherwise we can utilise all the ak. 
We will get the number of ak we will be putting to use.

So, remaining sum => sum = sum - (value of useak) => sum-=Math.min(k*ak,(m/k)*k);  => we are multiplying here with k since we need to find values by subtracting the actual worth of useak coins.
sum-=k*(ak_coins_used)
Note that: (m/k)*k => actually represents something equivalent to Math.floor(m/k)*k => since we are calculating the number of coins, we would be needing a floor value.

Now we are to uitlise a1 coins? What will be the best posible way?
remaining sum => sum = sum - 1*a1;
=>sum-=a1
So, if sum<=0 => we are sufficient enough to pay the sum by ourselves without needing fancy coins

Otherwise, if sum[sum>0] is still left to be covered now its time to use fancy coins:
Again to use the mnimum possible no. of fancy coins we will try to use the k worth fancy coins first in the same way we did as above.
fancyk = (sum/k)*k;    again here we are here considering how many k worth fancy coins could be used.
remaining sum => sum-=(sum/k)*k;

Now time to use fancy1 worth 1 coins: i.e., if sum is still not become zero and is left to cover
fancy1=remaingsum=sum

So, our ans= minimum number of fancy coins used = fnacyk+fancy1 

*/
