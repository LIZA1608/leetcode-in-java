

import java.util.*;
public class Main {
    public static void main(String args[]) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int a[]=new int [n];
       int b[]=new int [n];
       for(int i=0;i<n;i++){
           a[i]=sc.nextInt();
       }
        for(int i=0;i<n;i++){
           b[i]=sc.nextInt();
       }
       int sum=0;
       int start=0;
       int totalsum=0;
       int totaltoll=0;
       for(int i=0;i<n;i++){
           totalsum+=a[i];
           totaltoll+=b[i];
       }
       if(totaltoll>totalsum){
           System.out.print("1");
       }
       for(int i=0;i<n;i++){
           sum=0;
           boolean found=true;
           for(int j=0;j<n;j++){
               int city=(i+j)%n;
               sum+=a[city]-b[city];
               if(sum<0){
                   found=false;
                   break;
               }
           }
           if(found){
               start=i;
               break;
           }
       }
       System.out.print(start);
    }
}
