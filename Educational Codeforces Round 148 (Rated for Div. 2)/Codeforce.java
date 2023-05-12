import java.util.*;

public class Codeforce {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String s = sc.next();
            char ch[] = s.toCharArray();
            int count[] = new int[26];
            for(int i=0;i<s.length()/2;i++){
                count[s.charAt(i)-'a']++;
            }
            int numberOfDifferentChar=0;
            for(int i=0;i<count.length;i++){
                if(count[i]>0) numberOfDifferentChar++;
            }

            if(numberOfDifferentChar>=2) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}


/* The question has asked us can another palindrome be reconstructed
By observation if no.of different character in half of a palindrome string >= 2; then it is always possible to do so
Otherwise not
*/


