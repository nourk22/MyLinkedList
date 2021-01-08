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
      added.setPrev(null);
      added.setNext(null);
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

/*
		MyLinkedList list = new MyLinkedList();

		System.out.println(list.size());

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
		System.out.println(list.set(3, "3"));
		System.out.println(list);
*/

	}

}
