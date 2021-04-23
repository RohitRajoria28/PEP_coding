import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;

@SuppressWarnings("unchecked")
public class  bellman {
	public static void main(String[] args) throws NumberFormatException, IOException {
         Scanner scn=new Scanner(System.in);
         int v=scn.nextInt();
         int e=scn.nextInt();
         
         int arr[][]=new int[e][3];
         
         for(int i=0;i<e;i++){
             arr[i][0]=scn.nextInt();
             arr[i][1]=scn.nextInt();
             arr[i][2]=scn.nextInt();
         }
         
         int path[]=new int[v];
         path[0]=0;
         for(int i=1;i<v;i++){
             path[i]=Integer.MAX_VALUE;
         }
         for(int j=0;j<v-1;j++){
            for(int i=0;i<e;i++){
             int u= arr[i][0]-1;
             int ve= arr[i][1]-1;
             int wt=arr[i][2];
             if(u==Integer.MAX_VALUE){
                  continue;
             }
             if(path[ve]>path[u]+wt){
                 path[ve]=path[u]+wt;
             }
         } 
       }
       for(int i=1;i<v;i++){
           if(path[i]==Integer.MAX_VALUE){
               System.out.print(1000000000 );
           }else{
               System.out.print(path[i]+" " );
           }
       }
         
         
         
	}
}
