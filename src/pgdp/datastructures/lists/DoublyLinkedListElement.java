package pgdp.datastructures.lists;

public class DoublyLinkedListElement {

    private int info;
    public DoublyLinkedListElement next;
    public DoublyLinkedListElement prev;

    public DoublyLinkedListElement(int info)
    {
        this.info = info;
        next = null;
        prev = null;
    }

    public int getInfo() {
        return info;
    }
}
