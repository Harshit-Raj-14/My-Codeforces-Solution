import java.util.*;
public class Main{
public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();
    while(t-->0){
        String s = sc.next();
        if(s.equals("()")) {System.out.println("NO"); continue;}    //come out of loop to next test case
        else {
            System.out.println("YES");
            StringBuilder sb1 = new StringBuilder("");  //sb1 is of type (((())))
            for(int i=0;i<s.length();i++) sb1.append('(');
            for(int i=0;i<s.length();i++) sb1.append(')');
            StringBuilder sb2 = new StringBuilder("");  //sb2 is of type ()()()
            for(int i=0;i<s.length();i++) sb2.append("()");
            if (sb1.toString().contains(s)) {
                System.out.println(sb2.toString());
            } else {
                System.out.println(sb1.toString());
            }
        }
    }
    sc.close();
}
}

/*
THE LOGIC I RELAIZED AFTER SOLVING THIS QUESTION---
The question has told us about a string s of ) and ( say of length n.
We are asked to find another string of length 2n and which makes a sensable arithmetic valid bracket sequence.
Now there can be three cases : 
I: ((((....))))
II: ()()()...
III: combination of above two cases I and II maybe like ()(())()

Now think of this what is a common substring  between I and II:
Its - ()
and there is no other common substring between I and II
In fact this () is the only possible length 2 valid brcket sequence and is one pattern which will exist in all valid bracket sequences.
So, s=="()" cannot make a valid t becuase otherwise t will always contain this. So say no to this.

Now we have already been given string s and we made a valid bracket string t of length 2*s.length
i.e., we made the two strings of case I and II of length 2*s.
Let'say string s is not () and it exists as substring in case I. From our above discussion, we can guarnatee that it now cannot be a substring in II and vice versa.
Hence all we need to do is print the other string which will not have substring s.
*/

/*
LOGIC I worked when giving the contest---
We are given string s
We need to find another string t, of double length of s which can be a valid arithmetic bracket sequence and also not containing s as a substring.

s can contain any number of ( or ), what is needed is it should be double in length.

Affter observing test cases:
The only time when t cannot exist will be when s="()", becuase the solution t has only two case (()) or ()()
And here s is a substring in both.
So, for s=() return no
else yes

Now the real question is how to find t


eg: s=)(
    then t cannot be ()() becuase s here is a substring
    possible t is  (())

Analysing regular bracket formation can be of three types -
I: all seperate : ()()()....
II: one palced inside one another : ((((....)))) 
III: a combination of above two

Problem asking?
Now we ened to find t of 2*s.length() and does not have s as a substring.

All we need to do is generate string of case I and II and check whichever not cotnains s is our answer.
*/