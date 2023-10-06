import java.util.NoSuchElementException;

public class DLinkedList<T> {

  DNode<T> head;

  public DLinkedList() {this.head = null;}
  public DLinkedList(T data) {this.head = new DNode<T>(data); }
  public DLinkedList(DNode<T> head) {this.head = head;}
  public boolean isEmpty() {return this.head == null;}
  public T getFirst() {return this.head.getData();}
  
  public void addFirst(T data) {
    DNode<T> temp = new DNode<T>(data);
    temp.setNext(this.head);
    this.head.prev = temp;
    this.head = temp;
  }
  public T removeFirst() {
    if (isEmpty()) throw new IllegalStateException("The list is empty");
    DNode<T> temp= this.head;
    this.head = temp.getNext();
    this.head.setPrev(null);
    temp.setNext(null);
    return temp.getData();
  }

  public void display() {
    if (isEmpty()) System.out.println("List is empty.");
    else{
      DNode<T> curr = this.head;
      String tmp = "";
      while(curr != null){
        if (curr.getNext()==null) tmp += curr.getData();
        else tmp += curr.getData() + " <--> ";
        curr = curr.getNext();
      }
      System.out.println(tmp);
    }
  }
  public T update(T key, T data) {
    if (isEmpty()) throw new IllegalStateException("The list is empty!");
    DNode<T> curr = this.head;
    while (curr != null && !curr.getData().equals(key)) {
      curr = curr.getNext();
    }
    if (curr == null) throw new NoSuchElementException("The element was not found!");
    T temp = curr.getData();
    curr.setData(data);
    return temp;
  }

  public int size() {
    if (this.head == null) return 0;
    int size = 0;
    DNode<T> curr = this.head;
    while (curr != null){
      curr = curr.next;
      size++;
    } 
    return size;
  }

  public T remove(T key) {
    if (isEmpty()) throw new IllegalStateException("The list is empty!");
    DNode<T> prev = null;
    DNode<T> curr = this.head;
    if (curr.getData().equals(key)){
      this.head = this.head.getNext();
      this.head.setPrev(null);
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
    curr.setPrev(null);
    return curr.getData();
  }
}