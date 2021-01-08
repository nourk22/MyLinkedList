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

  public String getData(){
    return data;
  }

  public Node getNext(){
    return next;
  }

  public Node getPrev(){
    return prev;
  }
  //write get/set methods for all three instance variables.


}
