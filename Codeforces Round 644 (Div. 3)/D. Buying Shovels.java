import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(); //no of shovels to buy
            int k=sc.nextInt(); //no. of packages
            int ans=Integer.MAX_VALUE;
            for(int i=1;i*i<=n;i++){
                if(n%i==0){
                    if(i<=k) ans= Math.min(ans, n/i);    //if i is the package type then (i/k) is the number of packets
                    if(n/i<=k) ans=Math.min(ans, i);    // if i/k is the package type then i is the number of packets to be taken 
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}

/*
LOGIC---
We know, (package-type) x (no of that packets) = n
So, k*x=n
So, in a way k and x are factors of n.
So, we ened to find the maximum factor of n that is less than k to get minimum number of packets.

So, if k is the max-factor(packet-type) -> number of packets = x= n/k
Otherwise, if x is the max-factor(packet-type) -> number of packets= k = n/x
The mnimum of above two scenarios will give us our answer. 
*/


import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt(); //no of shovels to buy
            int k=sc.nextInt(); //no. of packages
            int mincount=Integer.MAX_VALUE;
            for(int i=k;i>=1;i--){
                if(n%i==0){
                    int count=n/i;
                    mincount=Math.min(mincount, count);
                }
            }
            System.out.println(mincount);
        }
        sc.close();
    }
}

/*
LOGIC---
The i th package has i shovels.
Find minimum number of packages to get n shovels.
Since we are allowed to take only one package type as many times as we want.

Greedy Approach:
We can simple iterate through loop and compare against value of each kind.
But obviously this is slow(also saw the compiler working very slow in test case 4 itself).
This greedy O(n) approach will give me TLE.

Efficient approach:
Because we are iterating through k->1 to check against each kind of package in a greedy fashion.
Now let's see, since we have to get n shovels from one single type of packet.
And we can have that packet any number of times.
So, let's say we picked kth packet x times.
So, k*x=n

Hence, k ends up here as a factor of n.
k=x/n

So, that means only packets which are a factor of n iwll actually lend us the correct answer.

So, tell me where will the factors of n ends.
Its, from 1<=factors<=sqrt(n)

Now, we want to buy the largest type of package possible to minimize the number of packages we have to buy. 
Thus, the type of package we want is the largest factor of N that is less than or equal to K, 
and our answer is then N divided by this package size.

Question reduces to, finding the maximum divisor of the number n not greater than k.

*/