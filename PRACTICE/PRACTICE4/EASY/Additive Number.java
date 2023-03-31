import java.util.*;
public class Main {
     public static boolean isAdditiveNumber(String num) {
        return isAdditiveNumberFrom(0, num, new ArrayList<>());
    }

    private static boolean isAdditiveNumberFrom(int curIdx, String num, List<String> result) {
        if (curIdx == num.length() && result.size() >= 3) {
            return true;
        }
        for (int i = curIdx; i <= num.length() - 1; i++) {
            if (i != curIdx && num.charAt(curIdx) == '0') {
                break;
            }
            String curNum = num.substring(curIdx, i + 1);
            if (result.size() <= 1 || curNum.equals(
                    String.valueOf(
                            Long.parseLong(result.get(result.size() - 1)) + Long.parseLong(result.get(result.size() - 2)))
            )) {
                result.add(curNum);
                if (isAdditiveNumberFrom(i + 1, num, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
if( isAdditiveNumber(s)==true){
    System.out.print("true");
}
else{
    System.out.print("false");
}
    }
}
