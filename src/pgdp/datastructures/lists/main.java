package pgdp.datastructures.lists;

public class main {
    public static void main(String[] args)
    {
        DoublyLinkedList l = new DoublyLinkedList();
        l.append(3);

        l.remove(0);
        System.out.println(l.toString());
    }
}
