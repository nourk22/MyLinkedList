public class MyLinkedList{

  //instance variables
  private int size;
  private Node start,end;

  //constructor
  public MyLinkedList(){
    size = 0;
    start = null;
    end = null;
  }

  //methods
  public int size(){
    return size;
  }

  //get and set
  public String get(int index){
    if (index>=size || index<0){
      throw new IndexOutOfBoundsException();
    }

    Node curr = start;
    for (int i=0; i<index; i++){
      curr = curr.getNext();
    }
    return curr.getData();
  }

  public String set(int index, String value){
    if (index>=size || index<0){
      throw new IndexOutOfBoundsException();
    }

    String currVal = get(index);
    Node currNode = start;

    for (int i=0; i<index; i++){
      currNode = currNode.getNext();
    }
    currNode.setData(value);

    return currVal;
  }

  //add methods
  public boolean add(String value){
    Node added = new Node(value);

    if (size==0){
      start = added;
      end = added;
    }else{
      added.setPrev(end);

      Node currNode = start;
      for (int i=0; i<size-1; i++){
        currNode = currNode.getNext();
      }
      currNode.setNext(added);

      end = added;
    }

    size++;

    return true;
  }

  public void add(int index, String value){
    if (index>size || index<0){
      throw new IndexOutOfBoundsException();
    }

    if (index == size){
      add(value);
    }else if(index == 0){
      Node added = new Node(value);

      added.setNext(start);
      start.setPrev(added);
      start = added;
      size++;

    }else{
      Node added = new Node(value);

      Node node1 = start; //node right before
      Node node2 = start; //node right after
      for (int i=0; i<index-1; i++){
        node1 = node1.getNext();
      }
      for (int i=0; i<index; i++){
        node2 = node2.getNext();
      }
      node1.setNext(added);
      added.setPrev(node1);
      added.setNext(node2);
      node2.setPrev(added);

      size++;
    }
  }

  //remove
  public String remove(int index){
    Node curr;

    if (index>=size || index<0){
      throw new IndexOutOfBoundsException();
    }

    String prevVal = start.getData();

    //removing size 1 list
    if (size==1){
      start = null;
      end = null;
      size = 0;
    }

    //removing the head
    if (size > 1 && index==0){
      curr = start.getNext();
      curr.setPrev(null);
      start=curr;

      size --;
    }

    //removing the tail
    if (size > 1 && index==size-1){
      prevVal=end.getData();

      curr = end.getPrev();
      curr.setNext(null);
      end = curr;

      size --;
    }

    //removing from middle
    if (size > 1 && index>0 && index<size-1){
      curr=start;

      for (int i=0; i<index; i++){
        curr=curr.getNext();
      }

      prevVal = curr.getData();

      Node previous = curr.getPrev();
      Node next = curr.getNext();
      previous.setNext(next);
      next.setPrev(previous);

      size--;
    }

    return prevVal;
  }


  public String toString(){
    Node currNode = start;
    String list = "[";

    if (size==1){
      list+=currNode.getData();
    }else{
      for (int i=0; i<size-1; i++){
        list+=currNode.getData() + ", ";
        currNode = currNode.getNext();
      }
    }

    if (size>1){
      list+=currNode.getData();
    }

    list+="]";

    return list;
  }

  public String toStringReversed(){
    Node currNode = end;
    String list = "[";

    if (size==1){
      list+=currNode.getData();
    }else{
      for (int i=0; i<size-1; i++){
        list+=currNode.getData() + ", ";
        currNode = currNode.getPrev();
      }
    }

    if (size>1){
      list+=currNode.getData();
    }

    list+="]";

    return list;
  }

  public static void main(String[] args) {


		MyLinkedList list = new MyLinkedList();

    System.out.println();
		System.out.println("Initial Size: " + list.size());
    System.out.println();

    System.out.println("Testing Adds:");
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list);

		list.add(1, "1");
		System.out.println(list);
		list.add(0, "0");
		System.out.println(list);
		list.add(5, "5");
		System.out.println(list);
    System.out.println();
		System.out.println("Set: " + list.set(3, "3"));
		System.out.println(list);
    System.out.println(list.toStringReversed());

    System.out.println();
    System.out.println("Testing Remove:");
    //list.remove(-1);
    //list.remove(6);
    //list.remove(7);
    System.out.println("Index 5 (tail): " + list.remove(5));
    System.out.println(list);
    System.out.println("Index 0 (head): " + list.remove(0));
    System.out.println(list);
    System.out.println("Index 2 (middle): " + list.remove(2));
    System.out.println(list);
    System.out.println("Index 1 (middle): " + list.remove(1));
    System.out.println(list);
    System.out.println("Index 5 (tail): " + list.remove(1));
    System.out.println(list);
    System.out.println("Index 0 (size 1): " + list.remove(0));
    System.out.println(list);
  //  System.out.println("Index 0 (empty list): " + list.remove(0));
  //  System.out.println(list);


	}

}
