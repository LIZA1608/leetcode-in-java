
/*when use recurrion give tle*/

class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        return chtdg(amount,coins,0);
    }
    public int chtdg(int amount,int []coins,int i){
        if(amount==0){
            return 1;
        }
        if(i>=coins.length){
            return 0;
        }
        int inc=0;
        int exc=0;
        if(amount>=coins[i]){
            inc=chtdg(amount-coins[i],coins,i);
        }
        exc=chtdg(amount,coins,i+1);
        return inc+exc;
    }
}
