package com.belyf;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList<T> {
    List<T> list = new ArrayList<>();
    public void unshift(T element) {
        list.add(element);
    }

    public T shift() {
        T element = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return element;
    }

    public T pop() {
        T element = list.get(0);
        list.remove(0);
        return element;
    }

    public void push(T element) {
        list.add(0, element);
    }
}
