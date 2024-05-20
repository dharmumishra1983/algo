package com.algo.amazon;
// Make an iterator for lists of lists.
// 1->2->3
// 4->5->6
// 7->8->9
// 10->11
// return: 1->4->7->10->2->5->8->11->3->6->9


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ListOfListsIterator {
    List<List<Integer>> inputList;
    Map<List<Integer>, Integer> inputData;
    Node root = null;
    Node temp1;
    Node current;

    public ListOfListsIterator(List<List<Integer>> input) {
        this.inputList = input;
        populateList();
    }

    public int next() {
        int data = current.data;
        current = current.next;
        return data;
    }

    public boolean hasNext() {
        if (current != null) {
            return true;
        }
        return false;

    }

    public void populateList() {
        List<Boolean> statusList = new ArrayList<>();
        int position = 0;
        int counter = 0;
        while (true) {
            if (statusList.size() == inputList.size()) {
                break;
            }
            if (position == inputList.size()) {
                position = 0;
                counter++;
            }
            List<Integer> l1 = inputList.get(position);
            int data = getValue(l1, counter, statusList);
            if (data != -1) {
                if (root == null) {
                    Node temp = new Node(data);
                    temp.next = null;
                    root = temp;
                    temp1 = temp;
                    current = root;
                } else {
                    Node temp3 = new Node(data);
                    temp3.next = null;
                    temp1.next = temp3;
                    temp1 = temp3;
                }
            }
            position++;
        }

    }

    public int getValue(List<Integer> l, int index, List<Boolean> statusList) {
        if (index < l.size()) {
            return l.get(index);
        } else {
            statusList.add(true);
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> listOfList = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2,3));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4,5,6));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(7,8,9));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(10,11));
        listOfList.add(l1);
        listOfList.add(l2);
        listOfList.add(l3);
        listOfList.add(l4);
        ListOfListsIterator listOfListsIterator = new ListOfListsIterator(listOfList);

        while (listOfListsIterator.hasNext()) {
            System.out.print(listOfListsIterator.next() + " ");
        }
    }
}

class Node {
    Node next;

    int data;

    public Node(int data) {
        this.data = data;
    }
}
