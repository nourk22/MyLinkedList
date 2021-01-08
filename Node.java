public class Node{

  //instance variables
  private String data;
  private Node next,prev;

  //constructor
  public Node(String value){
    data = value;
    next = null;
    prev = null;
  }

  //get methods
  public String getData(){
    return data;
  }

  public Node getNext(){
    return next;
  }

  public Node getPrev(){
    return prev;
  }

  //set methods
  public void setData(String value){
    data = value;
  }

  public void setNext(Node nextNode){
    next = nextNode;
  }

  public void setPrev(Node prevNode){
    prev = prevNode;
  }
  
}
