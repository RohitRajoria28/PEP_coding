import java.io.*;
import java.util.*;
// @SuppressWarnings("unchecked")
public class  Negative_wt_cycle_detection {

	public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.print(Neg());
	    // Scanner scn =new Scanner(System.in);
	    // int v=scn.nextInt();
	    // int e=scn.nextInt();
	    // int arr[][]=new int[e][3];
	    // for(int i=0;i<e;i++){
	    //     arr[i][0]=scn.nextInt();
	    //     arr[i][1]=scn.nextInt();
	    //     arr[i][2]=scn.nextInt();
	    // }
        // int path[]=new int[v];
        // path[0]=0;
        // for(int i=1;i<v;i++){
        //     path[i]=Integer.MAX_VALUE;
        // }
        // for(int i=0;i<v-1;i++){
        //     for(int j=0;j<e;j++){
        //           int u=arr[j][0];
        //           int ve=arr[j][1];
        //           int wt=arr[j][2];
        //           if(path[u]==Integer.MAX_VALUE){
        //               continue;
        //           }
        //           if(path[ve]>path[u]+wt){
        //               path[ve]=path[u]+wt;
        //           }
        //     }
        // }
        // // int opath[]=new int[v];
        // // for(int i=0;i<v;i++){
        // //     opath[i]=path[i];
        // // }
        // boolean flag;
        //     for(int j=0;j<e;j++){
        //         int u=arr[j][0];
        //         int ve=arr[j][1];
        //         int wt=arr[j][2];
        //           flag=false;
        //         if(path[u]==Integer.MAX_VALUE){
        //             continue;
        //         }
        //         if(path[ve]>path[u]+wt){
        //             // path[ve]=path[u]+wt;
        //             System.out.print(1);
        //             flag=true;
        //         }
        //   }
        // if(flag=false) System.out.print(0);
    }
    public static int Neg(){
        Scanner scn =new Scanner(System.in);
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
        for(int i=0;i<v-1;i++){
            for(int j=0;j<e;j++){
                  int u=arr[j][0];
                  int ve=arr[j][1];
                  int wt=arr[j][2];
                  if(path[u]==Integer.MAX_VALUE){
                      continue;
                  }
                  if(path[ve]>path[u]+wt){
                      path[ve]=path[u]+wt;
                  }
            }
        }
        // int opath[]=new int[v];
        // for(int i=0;i<v;i++){
        //     opath[i]=path[i];
        // }
        // boolean flag;
            for(int j=0;j<e;j++){
                int u=arr[j][0];
                int ve=arr[j][1];
                int wt=arr[j][2];
                //   flag=false;
                if(path[u]==Integer.MAX_VALUE){
                    continue;
                }
                if(path[ve]>path[u]+wt){
                    // path[ve]=path[u]+wt;
                    // System.out.print(1);
                    // flag=true;
                    return 1;
                }
          }
          return 0;
        // if(flag=false) System.out.print(0);
    }
}