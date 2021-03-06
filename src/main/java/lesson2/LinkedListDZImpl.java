package lesson2;

public class LinkedListDZImpl<E> implements LinkedListDZ<E> {
    private int size;
    private Node <E> first;

    @Override
    public void insertFirst(E value) {
        first =  new Node<>(value, first);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> temp = first;
        first = temp.next;
        size--;
        temp.next = null;
        return temp.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == first) {
            first = first.next;
        } else  {
            previous.next = current.next;
        }
        current.next = null;
        size--;
        return  true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
//            return size == 0;
    }

    @Override
    public E getFirst() {
        return first.item;
    }
}