public class SNode<T> {
  T data;
  SNode<T> next;

  public SNode() {
    this.data = null;
    this.next = null;
  }

  public SNode(T data) {
    this.data = data;
    this.next = null;
  }

  public SNode(T data, SNode<T> next) {
    this.data = data;
    this.next = next;
  }

  public void setData(T data) {this.data = data; }
  public void setNext(SNode<T> next) { this.next = next; }
  public T getData(){return this.data;}
  public SNode<T> getNext() {return this.next; }
}