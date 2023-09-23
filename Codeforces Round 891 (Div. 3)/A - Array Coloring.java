import java.util.*;

public class Hello {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();   
            int arr[] = new int[n];
            int oddcount=0;
            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
                if(arr[i]%2!=0) oddcount++;
            }  
            if(oddcount%2!=0) System.out.println("NO");
            else System.out.println("YES");
        }
        sc.close();
    }
}

/*
LOGIC ---
The question asks us in away to divide the number into two non empty groups

Having same parity means - both sum should be odd or both even
if all elements are even we have parity
if all elements are odd :
Case I: (odd number of elements-> no parity as there will be two sums one odd and one even) eg: 1,3,3
Case II: (even number of elements -> parity will be there with both either odd formation or even formation) eg: 1,3 or 1,3,3,1

General Case :
Let's say there are n even number and m odd numbers
even numbers will always give us an even sum
even+even = even
(even+odd) = odd
odd+odd=even
 We think,
 If we have odd number of odd numbers, i.e. m is odd. So, m-1 will make up even sum. But we will still be left with that extra odd not making the parity.
 If we have even number of even numbers, i.e. m is even. So, we can have n even sums and m even sums making parity. 

Conclusion : Having even number of odd numbers will bring parity making both sums even.
*/

