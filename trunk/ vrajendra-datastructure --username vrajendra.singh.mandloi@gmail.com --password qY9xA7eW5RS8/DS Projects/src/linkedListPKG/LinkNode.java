package linkedListPKG;

public class LinkNode<T> {
	private T value;
	private LinkNode<T> next;

	// Constructors
	public LinkNode(){
		// Empty Constructor
	}

	public LinkNode(T value){
		this.value = value;
		this.next = null;
	}

	public LinkNode(T value, LinkNode<T> next){
		this.value = value;
		this.next = next;
	}
	// add a value to the list in front.
	public void add(T value){
		next = new LinkNode<T>(value, next);
	}

	// add a value in list at the end.
	public void addlast(T value){
		LinkNode<T> node = this;
		while(node.next !=null)
			node = node.next;

		node.next=new LinkNode<T>(value);
	}

	// add at nth position
	public void addnth(int position, T value){
		
		LinkNode<T> node = this.getNode(position-1);
		node.next = new LinkNode<T>(value,node.next);
	}
	
	// delete the First Node
	public void delete1stNode(){
		
	}
	
	// delete the nth Node.
	public void deleteNthNode(int position){
		int index = 1;
		LinkNode<T> node = this;
		while(position-1 != index){
			node = node.next;
			index++;
		}
		node.next = node.next.next;
	}
	
	// Delete a particular value of Object
	public void deleteParticularObject(T value){
		LinkNode<T> node = this;
		while(node!= null){
			if(node.value.equals(value))
			{
				node.next = node.next.next;
				break;
			}
			node = node.next;
		}
	}
	
	//Display method
	public void displayList(){
		for(LinkNode<T> node = this; node!=null; node = node.next){
			System.out.println(node.value);
		}
	}

	public void replaceN(int position, T value){
		LinkNode<T> node = this.getNode(position);
		node.setValue(value);
	}
	
	public LinkNode<T> getNode(int position){
		LinkNode<T> node = this;
		int index = 1;
		while(position != index){
			node = node.next;
			index++;
		}
		return node;
	}

	//Setters and getters
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public LinkNode<T> getNext() {
		return next;
	}

	public void setNext(LinkNode<T> next) {
		this.next = next;
	}
}
