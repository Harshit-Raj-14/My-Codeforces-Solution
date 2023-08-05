import java.util.*;

public class hello {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();   
            int arr[] = new int[n]; 
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int maxop=0;
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]){
                    maxop = Math.max(maxop, arr[i]);
                }
            }
            System.out.println(maxop);
        }
        sc.close();
    }
}

/*
LOGIC ---
we move across array and when we encounter ai>ai-1 we know array is not sorted and we can apply the operations.
Now we know that this operation will continue until a[i] will actually reduce to zero to beocme equal to or less that a[i+1] there is no other way.
So, the no. of operations will be steps taken to convert a[i] to 0. Since we are subtracting by one every time.
That will be a[i] itself.
Now question asks us what is the max no of operatiosn need to be applied.
Since each time operation is applied it will affect and help other unsorted places as well. 
So, instea dof trying to reach unsorted array.
We find number of operations applied at each unsorted place and check which place eneds the maximum number of times to apply the operation.
Applying this max number of operatiosn wll surely work for others as well.

*/

