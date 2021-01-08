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
    if (index>=size || index<0){
      throw new IndexOutOfBoundsException();
    }

    if (index == size){
      add(value);
    }else{
      Node added = new Node(value);

      Node currNode = start;
      for (int i=0; i<index-1; i++){
        currNode = currNode.getNext();
      }
      currNode.setNext(added);
      added.setPrev(currNode);

      size++;
    }
  }

  public String toString(){
    Node currNode = start;
    String list = "[";

    if (size==1){
      list+=currNode.getData();
    }else{
      for (int i=0; i<size-1; i++){
        list+=currNode.getData()+", ";
        currNode = currNode.getNext();
      }
    }

    if (size>1){
      list+=currNode.getData();
    }

    list+="]";

    return list;
  }

  public static void main(String[] args) {

		MyLinkedList ll = new MyLinkedList();

		System.out.println(ll.size());

		ll.add("a");
		ll.add("b");
		ll.add("c");
		System.out.println(ll);

		ll.add(1, "d");
		System.out.println(ll);
		ll.add(0, "e");
		System.out.println(ll);
		ll.add(5, "f");
		System.out.println(ll);
		System.out.println(ll.set(3, "g"));
		System.out.println(ll);


	}

}
