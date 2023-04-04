package pgdp.datastructures.lists;

import java.util.List;

public class DoublyLinkedList {

    private DoublyLinkedListElement head;
    private DoublyLinkedListElement tail;

    private int size;

    public DoublyLinkedList()
    {
        head = tail = null;
        size = 0;
    }

    public void append(int info)
    {
        if(head == null)
        {
            head = tail = new DoublyLinkedListElement(info);
            size++;
            return;
        }
        tail.next = new DoublyLinkedListElement(info);
        tail.next.prev = tail;
        tail = tail.next;
        size++;
    }

    public int size(){return size;}

    public int get(int index)
    {
        if(index >= size || index < 0)
            return Integer.MIN_VALUE;
        if (index < size / 2) {
            DoublyLinkedListElement temp = head;
            for (int i = 0; i < index; i++)
                temp = temp.next;
            return temp.getInfo();
        } else {
            DoublyLinkedListElement temp = tail;
            for (int i = size - 1; i > index; i--)
                temp = temp.prev;
            return temp.getInfo();
        }
    }

    public void remove(int ind)
    {
        if(ind >= size || ind < 0)
            return;
        DoublyLinkedListElement toDel;
        if (ind < size / 2) {
            toDel = head;
            for (int i = 0; i < ind; i++)
                toDel = toDel.next;
        } else {
           toDel = tail;
            for (int i = size - 1; i > ind; i--)
                toDel = toDel.prev;
        }

        if(size == 1)
        {
            head = tail = null;
            size = 0;
            return;
        }
        if(toDel == tail) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }
        if(toDel == head)
        {
            head = head.next;
            head.prev = null;
            size--;
            return;
        }
        toDel.next.prev = toDel.prev;
        toDel.prev.next = toDel.next;
        size--;
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder();
        if(size == 0)
            return str.toString();
        DoublyLinkedListElement curr = head;

        str.append(curr.getInfo());
        curr = curr.next;
        for (int i = 1; i < size; i++) {
            str.append(",").append(curr.getInfo());
            curr = curr.next;
        }
        return str.toString();
    }

    public void appendList(DoublyLinkedList toApp)
    {
        if(head == null) {
            this.head = toApp.head;
            this.tail = toApp.tail;
            this.size = toApp.size();
        }
        else if(toApp.head != null) {
            tail.next = toApp.head;
            tail.next.prev = tail;
            tail = toApp.tail;
            size += toApp.size();;
        }
    }

    public boolean isEqual(DoublyLinkedList toCompare)
    {
        if(toCompare == null)
            return false;
        if(size != toCompare.size)
            return false;
        DoublyLinkedListElement first = head;
        DoublyLinkedListElement second = toCompare.head;
        for (int i = 0; i < size; i++)
        {
            if(first.getInfo() != second.getInfo())
                return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public int sum()
    {
        DoublyLinkedListElement tmp = head;
        int sum = 0;
        for (int i = 0; i < size; i++)
        {
            sum += tmp.getInfo();
            tmp = tmp.next;
        }
        return sum;
    }

    public DoublyLinkedList copy()
    {
        DoublyLinkedList res = new DoublyLinkedList();
        DoublyLinkedListElement el = head;
        for (int i = 0; i < size; i++)
        {
            res.append(el.getInfo());
            el = el.next;
        }
        return res;
    }
}
