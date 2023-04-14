
/*solution/*
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer>list=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            // if(list.containsKey(c)){
            //     list.put(c,list.get(c)+1);
            // }
            // else{
            //     list.put(c,1);
            // }
            //shortcut->
            list.put(c,list.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(list.get(s.charAt(i))==1){
                        return i;
            }

        }
        return -1;
    }
}
