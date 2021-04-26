import java.util.*;
public class SortedPQ<K,V> {
    /** primary collection of priority queue entries */
    private LinkedList<Entry<K,V>> list = new LinkedList<>();
    private Comparator<K> comp;
  
    /** Creates an empty priority queue based on the natural ordering of its keys. */
    public SortedPQ() { comp = new DefaultComparator<K>(); }
  
    // Creates an empty priority queue using the given comparator to order keys.
   public SortedPQ(Comparator<K> c) {  comp = c;}

    //Returns the number of items in the priority queue.
    public int size() { return list.size(); }

    public boolean isEmpty() { return size() == 0; }
   
    //Inserts a key-value pair and returns the entry created.
    public Entry<K,V> insert(K key, V value) {
        Entry<K,V> newest = new Entry<>(key, value);
        // walk forward, looking for larger key
        int i=0;
        for(Entry<K, V> walk: list){
            if (compare(newest, walk) < 0) break;
            i++;
        }
        list.add(i, newest);      
        return newest;
      }

   // returns an entry with minimal key.
    public Entry<K,V> min() {
        if (list.isEmpty()) return null;
        return list.getFirst();
      }
  
    //Removes and returns an entry with minimal key.
    public Entry<K,V> removeMin() {
        if (list.isEmpty()) return null;
        return list.removeFirst();
      }
     
     /** Method for comparing two entries according to key */
  public int compare(Entry<K,V> a, Entry<K,V> b) {
    return comp.compare(a.getKey(), b.getKey());
  }
}  