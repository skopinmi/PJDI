package lesson2;

public interface LinkedListDZ <E> {
   void insertFirst(E value);
   E removeFirst();
   boolean remove(E value);
   boolean contains(E value);
   int size();
   boolean isEmpty();
   E getFirst();

   class Node <E> {
       E item;
       Node<E> next;
       Node<E> last;

       public Node(E item, Node<E> next) {
           this.item = item;
           this.next = next;
           this.last = this;
       }
   }
}
