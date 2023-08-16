import java.util.*;
public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t--> 0) {
      int a = sc.nextInt(); //pressed by Anna only
      int b = sc.nextInt(); //pressed by Katie only
      int c = sc.nextInt(); //can be pressed by either
      if (c % 2!=0 && a==b) System.out.println("First");
      else if (a > b) System.out.println("First");
      else System.out.println("Second");
    }
    sc.close();
  }
}


LOGIC---
Anna makes the first move.
Game is optimal -> each player plays to win
The girl who cannot press a button loses. -> The one unable to make a turn looses.
To win Anna would want to finsh the c buttons and then she can take her time to finish her a buttons.
Same for Katie she will want to finish the c buttons first and then go to b buttons.

Now general cases -> (a,b,c)
Case I: (0,0,even) -> in this case Anna starts and then Katie plays. So eg-2 -> then Katie wins playing the last turn
Case II: (0,0,odd) -> in this case Anna starts and then Katie plays. So, eg-3 -> Anna wins
So, what if a=a and b=b => (a,b,c)

FINAL 5 CASES:
If c is even and a>b => (2,1,even=2) => c button finishes with Katie playing. Anna wins becuase she get to play one extra button in her own case.
If c is even and a<=b => (1,2,even=2) => c button finishes with Katie playing. Katie wins with extra buttons to play.

If c is odd and a>b => (2,1,odd=3) => c button finishes with Anna playing. Anna wins.
If c is odd and a<b => (1,2,odd=3) => c button finishes with Anna playing. Katie wins.
Extra case : If c is odd and a==b => (1,1,odd=3) => c button finishes with Anna playing. Anna wins.

Above conclusion:
Special case check first -> c is odd and a==b => Anna wins
Case I : a>b =>Anna wins regardless c is odd or even
Case II: a<=b(c even) or a<b(c odd) => Katie wins as an else case to be



/* SIMPLER SOLUTION */
    import java.util.*;
    public class Main
    {
    	public static void main(String[] args) {
    	    Scanner sc = new Scanner(System.in);
    	    int t = sc.nextInt();
    	    while(t-->0){
    	        int a = sc.nextInt();
    	        int b = sc.nextInt();
    	        int c = sc.nextInt();
    	        if(c%2==0){
    	            System.out.println(a>b?"First":"Second");
    	        }else{
    	            System.out.println(b>a?"Second":"First");
    	        }
    	    }
    	}
    }



/* THIRD SOLUTION */
import java.util.*;
public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t--> 0) {
      int a = sc.nextInt(); //pressed by Anna only
      int b = sc.nextInt(); //pressed by Katie only
      int c = sc.nextInt(); //can be pressed by either
      a+=Math.ceil(c/2.0);
      b+=Math.floor(c/2.0);
      if(a>b) System.out.println("First");
      else System.out.println("Second");
    }
    sc.close();
  }
}


LOGIC---
Note : We won't be using a+=Math.ceil(c/2); but a+=Math.ceil(c/2.0);
Becuase we want to do float division and then find its ciel or floor.
If we do integer division /2, we already get the truncated values then floor and ceil loes their purpose.