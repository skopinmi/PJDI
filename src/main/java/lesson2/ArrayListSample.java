package lesson2;

import java.io.*;

public class ArrayListSample {

    public static void main(String[] args) {
        ArrayListDZ <String> listDZ = new ArrayListDZImpl<>();
        listDZ.add("1");
        listDZ.add("2");
        listDZ.add("3");
        listDZ.add("4");
        listDZ.add("5");
        System.out.println(listDZ.size());
        System.out.println(listDZ.get(2));
        System.out.println(listDZ.remove(2));
        System.out.println(listDZ.get(2));
        System.out.println(listDZ.contains("3"));
        System.out.println(listDZ.contains("1"));
        System.out.println(listDZ.indexOf("4"));
    }
}
