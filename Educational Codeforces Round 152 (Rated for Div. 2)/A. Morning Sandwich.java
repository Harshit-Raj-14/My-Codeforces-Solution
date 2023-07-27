import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int b = sc.nextInt();
            int c = sc.nextInt();
            int h = sc.nextInt();
            int filling = c+h;
            int sandwhich=0;
            while(b>1 && filling>0){    //one bread need to be left to put at last
                filling--;
                b--;
                sandwhich++;
            }
            System.out.println(sandwhich*2 +1);
        }
        sc.close();
    }
}


/*
LOGIC ---
Formula sandwhich - cheese/ham - bread
1 JUMBOsandwhich = 1 bread+1fill+1bread+1ham+....+1bread
1 sandwhich = 1bread+1fill
1JUMBO=2*sandwhich+1bread = no. of layers

So, let's find no of sandwhich we can make
for 1 cheese/ham = 1 bread on top
1 bread at bottom is itself the top of next (except for the last bread at bottom)
cheese = ham = filling
*/

