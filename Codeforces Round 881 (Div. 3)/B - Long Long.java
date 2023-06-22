import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            long maxsum=0;
            int op=0;
            for(int i=0;i<arr.length;i++){
                maxsum+=Math.abs(arr[i]);   //maxsum is the full positive sum
            }
            int flag=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==0) continue;
                if(arr[i]<0){
                    if(flag==0) {   //from here to break the series and count as one operation applied
                        op++;
                        flag=1;     //reconfigure to start the new series
                    }  
                }
                else flag=0;    //positive element 
            }
            System.out.println(maxsum+" "+op);
        }
        sc.close();
    }
}

/*
We change all -ve to zero and for each sequence of -ve we count as 1 operation
Ingnore if 0
Add all number since we will get max sum if all are added in +ve that's why we ened to ocnvert all -ve to +ve

NOTE ---
We can delete all zeros from the array, and it won't affect on answer.
Minimum number of operations we should do — number of continuous subsequences with negative values of elements.
*/
