import java.util.*;
class Main{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(); //plates he ate
        int m=sc.nextInt(); //something like dishes listed on menu with prices
        String ate[] = new String[n+1];
        for(int i=1;i<ate.length;i++){
            ate[i]=sc.next();
        }
        String menu[] = new String[m+1];   //only m items listed on menu and n>=m
        for(int i=1;i<menu.length;i++){
            menu[i]=sc.next();
        }
        int price[] = new int[m+1];  //if color is not avaiable on menu it menas its price is price[0], otherwise price correspond to m[i]~p[i]
        for(int i=0;i<price.length;i++){
            price[i]=sc.nextInt();
        }
        //now making a hashmap between menu and price for easy search and get
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=1;i<menu.length;i++){
            map.put(menu[i],price[i]);
        }
        long bill=0;
        for(int i=1;i<ate.length;i++){
            if(map.containsKey(ate[i])) bill+=map.get(ate[i]);
            else bill+=price[0];    //if not on menu then price[0]
        }
        System.out.println(bill);
        sc.close();
    }
}