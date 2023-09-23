import java.util.*;
public class main{
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int g=arr[0];   //intial gcd of full array
            for(int i=1;i<arr.length;i++){
                g=gcd(g,arr[i]);
            }
            int cost=0;
            if(g==1) cost=0;    //already 1
            else if(g!=1){
                if(gcd(g,n)==1) cost=1; //first minimal cost operation gcd(g, n)
                else if(gcd(g,n-1)==1) cost=2;  //second minimal cost operation gcd(g,n-1)
                else cost=3;    //both operations applied : gcd(g,n,n-1) will defintiely be 1
            }
            System.out.println(cost);
        }
        sc.close();
    }

    public static int gcd(int a, int b){
        return (b==0) ? a:gcd(b,  a%b);  
    }
}

/*
LOGIC---
Make gcd(array)=1
Operation a[i]=gcd(i,a[i]) => cost=n-i+1
Objective: With minimum cost make gcd of array 1

One thing to make gcd array is for atleast any two elements to have gcd(ax,ay)=1.
Then gcd of entire array will be 1.

Case I: GCD (array)=1 => no operations => cost=0;

Case II: gcd of array is not 1.
Now how to choose which element to apply operation on to find minimum cost.
cost=n-i+1
n-> constant
i-> needs to be maximum to have mnimum cost
range of i is[1,n]
i should be n.

Now either just by changing the last element can get gcd 1. last_el=gcd(last_el,last_index)=gcd(an,n) => cost for changing last element=n-n+1=1
Or by changing the second last element as well to get gcd 1. secondlast_el=gcd(secondlast_el, second last index)=gcd(an-1,n-1) => cost for chaning second last element=n-(n-1)+1=2
So, one thing we cleared the maximum cost to make gcd of array 1 is =>3
minimum cost to make gcd of array 1 is =>0
cost is in range[0,3]

Now how to proceed:
Step I: calculate intial gcd of array
Ste II:
if gcd==1 => cost=0;
if gcd!=1
Case I: try the lowest cost operation :
if(gcd!=1)
then, try gcd(a(n), n)
But the above cna also be written as gcd(intialgcdofarray, n) Because at the end we need to find the gcd of full array. And an was already included int he gcd of full array.
cost=1
If the above still does not yield gcd=1

Try the second lowest operation: gcd(intialgcdofarray, n-1)
cost=2
If the above does nto work, the final thing to do is apply operation in both last elemtns this will produce a cumulative efffect:
gcd(intialgcdofarray, n, n-1)
Now we are well aware that gcd(x,x-1) = 1
So, the above will always default a complete gcd of 1 for the array now with cost=3.


*/