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
            int cost=0;
            Arrays.sort(arr);
            for(int i=0;i<arr.length/2;i++){
                cost+=(arr[n-i-1] - arr[i]);
            }
            System.out.println(cost);
        }
        sc.close();
    }
}

/*
eg - 1 5 6 3 4
sorting - 1,3,4,5,6
So, if we paint each elemnt just once the cost will be - max(e) - min(e) = e-e = 0
So, we atleast need to paint two elements with one color to begin getting max possible.
Since, we are doing max-min. Why not sort the array and do last-begin element.
Similarly following the same pursuit: second largest - second smallest will again yield a max result.
So, after sorting we would need two pointers or just keep on subtractign the last with first.
So, based on this:
1,6 -> red (say, you can pick any rndom color)
3,5 -> blue
4 -> green
Solution = [max(1,6)-min(1,6)] + [max(3,5) - min(3,5)] + [max(4)-min(4)] = [6-1]+[5-3]+[4-4]=5+2+0 = 7
*/
