package week2Assignment;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	
	private class Node{
		Item item;
		Node pre;
		Node next;
	}
	
	public Deque()   {
		first = null;
		last = null;
		N = 0;
	}   
	
	public boolean isEmpty()  {
		return N == 0;
	}  
	
	public int size()   {
	    return N;
	}  
	
	public void addFirst(Item item)  {
		if ( item == null ) throw new java.lang.NullPointerException();
		Node oldFirst = first;
		first = new Node();
		if ( N == 0 ) {
			first.item = item;
			last = first;
		}
		else{
			first.item = item;
			first.next = oldFirst;
			oldFirst.pre = first;
		}
		N++;
	}     
	
	public void addLast(Item item) {
		if ( item == null ) throw new java.lang.NullPointerException();
		Node oldLast = last;
		last = new Node();
		if ( N == 0 ) {
			last.item = item;
			first = last;
		}
		else{
			last.item = item;
			oldLast.next = last;
			last.pre = oldLast;
		}
		N++;
	}    
	
	public Item removeFirst()  {
		if ( N == 0) throw new java.util.NoSuchElementException();
		Item item = first.item;
		if ( N == 1){
			first = null;
			last = null;
		}
		else{
			first = first.next;
			first.pre = null;
		}
		N--;
		return item;
	} 

	public Item removeLast()  {
		if ( N == 0) throw new java.util.NoSuchElementException();
		Item item = last.item;
		if ( N == 1){
			first = null;
			last = null;
			N--;
		}
		else{
			last = last.pre;
			last.next = null;
			N--;
		}
		return item;
	}     
	
	public Iterator<Item> iterator()  {
		return new ListIterator();
	}       // return an iterator over items in order from front to end
	private class ListIterator implements Iterator<Item>{
		private Node iter = first;
		@Override
		public boolean hasNext(){
			return !(iter == null);
		}
		@Override
		public Item next(){
			if ( !hasNext() ) throw new java.util.NoSuchElementException();
			Item item = iter.item;
			iter = iter.next;
			return item;
		}
        public void remove() {  
            throw new UnsupportedOperationException();  
        } 
	}
	public static void main(String[] args){
		Deque<String> de = new Deque<String>();
		de.addFirst("aaaa");
		de.addFirst("bbbb");
		de.addLast("cccc");
		System.out.println(de.size());
		de.addLast("dddd");
		de.removeFirst();
		Iterator<String> it = de.iterator();
		while(it.hasNext()) System.out.println(it.next());
		System.out.println(de.size());
	}   
}