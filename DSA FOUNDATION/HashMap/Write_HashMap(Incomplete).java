import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) throws Exception {
       int bi=hashFunction(key);
       int di=getIndexInBucket(bi,key);
       if(di==-1){
        //   key doen't exist
        HMNode node=new HMNode(key,value);
        bucket[bi].addLast(node);
        this.size++
       }else{
        //   Key already exist 
           HMNode node=bucket[bi].get[di];
           node.value=value;
       }
    }

    public V get(K key) throws Exception {
       int bi=hashFunction(key);
       int di=getIndexInBucket(bi,key);
       if(di==-1){
           return null;
       }else{
           HMNode node=bucket[bi].get(di);
           return node.value;
       }
    }

    public boolean containsKey(K key) {
       int bi=hashFunction(key);
       int di=getIndexInBucket(bi,key);
       if(di==-1){
           return false;
       }else{
           return true;
       }
    }

    public V remove(K key) throws Exception {
        int bi=hashFunction(key);
       int di=getIndexInBucket(bi,key);
       if(di==-1){
           return null;
       }else{
           HMNode node=bucket[bi].remove(di);
           this.size--;
           return node.value;
       }
      
    }

    public ArrayList<K> keyset() throws Exception {
       ArrayList<K> list=new ArrayList<>();
       for(int i=0;i<bucket.length;i++){
           for(HMNode node:bucket[i]){
               list.add(node);
           }
       }
       return list;
    }

    public int size() {
        return this.size;
     }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}