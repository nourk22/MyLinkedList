public class MyLinkedList{

  //instance variables
  private int size;
  private Node start,end;

  //constructor
  public MyLinkedList(int length, Node first, Node last){
    size = length;
    start = first;
    end = last;
  }

  //methods
  public int size(){
    return size;
  }

  //get and set
  public String get(int index){
    Node curr = start;
    for (int i=0; i<index; i++){
      curr = curr.getNext();
    }
    return curr.getData();
  }

  //public String set(int index, String value);

  //public boolean add(String value);
  //public boolean add(int index, String value);

  //public String toString();
  //Any helper method that returns a Node object MUST BE PRIVATE!
}
