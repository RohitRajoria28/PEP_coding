import java.io.*;
import java.util.*;

public class Main {

	public static void solution(ArrayList<Integer> al){
	    for(int i=al.size()-1;i>=0;i--){

            int val=al.get(i);

            if(isPrime(val)){
                al.remove(i);
            }
	         
	        
	    }
		// write your code here
		
    }
    public static boolean isPrime(int val){
        for(int f=2;f*f<val;f++){
            if(val%f==0){
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
	}

}