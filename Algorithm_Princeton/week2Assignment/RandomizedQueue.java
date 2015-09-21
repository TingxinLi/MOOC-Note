package week2Assignment;

import edu.princeton.cs.algs4.*;
import java.util.Iterator;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int N = 0;
    
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		items = (Item[]) new Object[2];
	}
	public boolean isEmpty() {
		return N == 0;
	}  
	
	public int size() {
	    return N;
	}
    
	private void resize(int n){
		assert n == items.length / 2 || n == items.length * 2 + 1;
		@SuppressWarnings("unchecked")
		Item[] newItems = (Item[]) new Object[n];
		for (int i = 0; i < N; i++) newItems[i] = items[i];
		items = newItems;
	}
    
	public void enqueue(Item item) {
		if ( item == null ) throw new java.lang.NullPointerException();
    	if ( items.length == N) resize( items.length * 2 + 1 );
    	items[N++] = item;
    }
	
    public Item dequeue() {
    	if ( isEmpty() ) throw new java.util.NoSuchElementException();
    	int ranN = StdRandom.uniform(N);
    	Item temp = items[ranN];
    	if ( ranN != N - 1 ) items[ranN] = items[ N - 1 ];
    	items[ N - 1 ] = null;
    	N--;
    	if ( N <= items.length / 4) resize( items.length / 2 );
    	return temp;
    }
    
    public Item sample()  {
    	if ( N == 0) throw new java.util.NoSuchElementException();
    	int ranN = StdRandom.uniform(N);
    	return items[ranN];
    }
    
    public Iterator<Item> iterator() {
    	return new ListIteratorRan();
	}

	private class ListIteratorRan implements Iterator<Item>{
		int count;
		private Item[] iter;
		@SuppressWarnings("unchecked")
		public ListIteratorRan(){
			count = 0;
			iter = (Item[]) new Object[N];
			for(int i=0; i<N; i++) iter[i] = items[i];
			StdRandom.shuffle(iter);
		}
		@Override
		public boolean hasNext(){
			return count < N;
		}
		@Override
		public Item next(){
			if ( !hasNext() ) throw new java.util.NoSuchElementException();
			Item temp = iter[count++];
			return temp;
		}
        public void remove() {  
            throw new UnsupportedOperationException();  
        } 
	}
	
    public static void main(String[] args){
		RandomizedQueue<String> rq = new RandomizedQueue<String>();
		rq.enqueue("aaa");
		System.out.println(rq.dequeue());
		rq.enqueue("bbb");
		System.out.println(rq.dequeue());
		rq.enqueue("ccc");
		System.out.println(rq.dequeue());
		rq.enqueue("ddd");
		System.out.println(rq.dequeue());
		rq.enqueue("eee");
		System.out.println(rq.dequeue());
		rq.enqueue("aaa");
		/**rq.enqueue("fff");
		rq.enqueue("ggg");
		System.out.println(rq.sample());
		rq.enqueue("hhh");
		rq.enqueue("iii");
		rq.enqueue("jjj");
		rq.enqueue("lll");
		rq.enqueue("kkk");**/
		System.out.println("----------------");
		Iterator<String> it = rq.iterator();
		while(it.hasNext()) System.out.print(it.next());
		System.out.println("\n----------------");
		Iterator<String> it1 = rq.iterator();
		while(it1.hasNext()) System.out.print(it1.next());
		System.out.println("\n----------------");
		Iterator<String> it2 = rq.iterator();
		while(it2.hasNext()) System.out.print(it2.next());
    }
}

