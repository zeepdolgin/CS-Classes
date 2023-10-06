import java.util.NoSuchElementException;

public class SLinkedList<T> {

  SNode<T> head;

  public SLinkedList() {this.head = null;}
  public SLinkedList(T data) {this.head = new SNode<T>(data);}
  public SLinkedList(SNode<T> head) {this.head = head;}


  public boolean isEmpty() {return this.head == null;}

  public T getFirst() {return this.head.getData();}

  public void addFirst(T data) {
    SNode<T> temp = new SNode<T>(data);
    temp.next = this.head;
    this.head = temp;
  }
  public T removeFirst() {
    if (isEmpty()) throw new IllegalStateException("The list is empty!");
    SNode<T> temp = this.head;
    this.head = temp.getNext();
    temp.setNext(null);
    return temp.getData();
  }
  public void display() {
    if (isEmpty()) System.out.println("List is empty.");
    else{
      SNode<T> curr = this.head;
      String tmp = "";
      while(curr != null){
        if (curr.getNext()==null) tmp += curr.getData();
        else tmp += curr.getData() + " -> ";
        curr = curr.getNext();
      }
      System.out.println(tmp);
    }
  }
  public T update(T key, T data) {
    if (isEmpty()) throw new IllegalStateException("The list is empty!");
    SNode<T> curr = this.head;
    while (curr != null && !curr.getData().equals(key)) {
      curr = curr.getNext();
    }
    if (curr == null) throw new NoSuchElementException("The element was not found!");
    T temp = curr.getData();
    curr.setData(data);
    return temp;
  }
  public T remove(T key) {
    if (isEmpty()) throw new IllegalStateException("The list is empty!");
    SNode<T> prev = null;
    SNode<T> curr = this.head;
    if (curr.getData().equals(key)){
      this.head = this.head.getNext();
      curr.setNext(null);
      return curr.getData();
    }
    while (curr != null && !curr.getData().equals(key)){
      prev = curr;
      curr = curr.getNext();
    }
    if (curr == null) throw new NoSuchElementException("The element wasn't found!");
    prev.setNext(curr.getNext());
    curr.setNext(null);
    return curr.getData();
  }
  public int size() {
    int size = 0;
    SNode<T> curr = this.head;
    while (curr != null) {
      curr = curr.next;
      size++;
    }
    return size;
  }
}