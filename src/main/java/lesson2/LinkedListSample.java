package lesson2;

public class LinkedListSample {

    public static void main(String[] args) {
        LinkedListDZ <String> myList = new LinkedListDZImpl<>();
        myList.insertFirst("A");
        myList.insertFirst("B");
        myList.insertFirst("C");
        LinkedListDZ <Integer> myList2 = new LinkedListDZImpl<>();
        myList2.insertFirst(1);
        myList2.insertFirst(2);
        myList2.insertFirst(3);
        myList2.insertFirst(4);

        while (!myList.isEmpty() && !myList2.isEmpty()){
            System.out.println(myList.removeFirst());
            System.out.println(myList2.removeFirst());
            System.out.println(myList.isEmpty());
            System.out.println(myList2.isEmpty());
            System.out.println("size myList = " + myList.size());
            System.out.println("size myList2 = " +myList2.size());
        }
    }

}
