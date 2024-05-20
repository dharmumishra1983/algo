package com.leetcode.extra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZigzagIterator {
    
    Map<List<Integer>,Boolean> statusMap=new HashMap<>();
    List<List<Integer>> inputList = new ArrayList<>();
    Map<List<Integer>, Integer> inputData;
    Node root = null;
    Node temp1;
    Node current;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        statusMap.put(v1,false);
        statusMap.put(v2,false);
        inputList.add(v1);
        inputList.add(v2);
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
        int position = 0;
        int counter = 0;
        while (true) {
            if (position == inputList.size()) {
                position = 0;
                counter++;
            }
            List<Integer> l1 = inputList.get(position);
            if(isFinished(statusMap)){
                break;
            }
            int data = getValue(l1, counter,statusMap);
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

    public int getValue(List<Integer> l, int index,Map<List<Integer>,Boolean> statusMap) {
        if (index < l.size()) {
            return l.get(index);
        } else {
            statusMap.put(l,true);
        }
        return -1;
    }
    private boolean isFinished(Map<List<Integer>,Boolean> l1){
        boolean flag=true;
        for(List<Integer> key:l1.keySet()){
            if(l1.get(key)==false){
                flag=false;
            }
        }
        return flag;
    }

}


class Node {
    Node next;

    int data;

    public Node(int data) {
        this.data = data;
    }
}
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */