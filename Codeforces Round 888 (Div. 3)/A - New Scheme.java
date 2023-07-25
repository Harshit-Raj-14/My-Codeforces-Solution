import java.util.*;
class Main{
    public static void main (String args[]){
            Scanner sc = new Scanner(System.in);
            int arr[] = new int[8];
            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            boolean flag=true;
            for(int i=0;i<arr.length;i++){
                if(i+1<arr.length && arr[i]>arr[i+1]) flag=false;
                if(arr[i]<100 || arr[i]>675) flag=false;
                if(arr[i]%25!=0) flag=false;
            }
            if(flag==true) System.out.println("Yes");
            else System.out.println("No");
            sc.close();
    }
}