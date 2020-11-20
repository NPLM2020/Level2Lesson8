import structure.customlist.GBIterator;
import structure.customlist.GBList;
import structure.impl.DoubleLinkedList;

public class Main {

    public static void main(String[] args) {
        GBList list = new DoubleLinkedList();
        list.add("Apple");
        list.add("Apple2");
        list.add("Apple3");
        list.add("Apple4");
        list.add("Apple5");
        list.add("Apple6");

        System.out.println("Created:\n" + list);
        System.out.println("Size: " + list.size() + "\n");

        list.remove("Apple4");

        System.out.println("Element removed:\n" + list);
        System.out.println("Size: " + list.size() + "\n");

        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Element at index 11: " + list.get(11));
    }
}
