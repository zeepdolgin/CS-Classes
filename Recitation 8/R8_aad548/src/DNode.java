public class DNode<T> {
  
  T data;
  DNode<T> next;
  DNode<T> prev;

  public DNode() {
    this.data = null;
    this.next = null;
    this.prev = null;
  }

  public DNode(T data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }

  public DNode(T data, DNode<T> next) {
    this.data = data;
    this.next = next;
    this.prev = null;
  }

  public DNode(T data, DNode<T> next, DNode<T> prev) {
    this.data = data;
    this.next = next;
    this.prev = prev;
  }

  public void setData(T data) {this.data = data; }
  public void setNext(DNode<T> next) { this.next = next; }
  public void setPrev(DNode<T> prev) { this.prev = prev;}


  public T getData(){return this.data;}
  public DNode<T> getNext() {return this.next; }
  public DNode<T> getPrev() {return this.prev;}
}