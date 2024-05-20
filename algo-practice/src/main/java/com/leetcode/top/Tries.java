package com.leetcode.top;

public class Tries {
    private Node root;

    public Tries() {
        root = new Node('\0');

    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    public boolean preFix(String word) {
        return getNode(word) != null;

    }

    private Node getNode(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) return null;
            curr = curr.children[c - 'a'];
        }
        return curr;
    }

    class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];

        }
    }

    public static void main(String[] args) {
        Tries tries=new Tries();
        tries.insert("techie");
        tries.insert("techi");
        tries.insert("tech");
        System.out.println(tries.search("tech"));
        System.out.println(tries.search("techi"));
        System.out.println(tries.search("techiedelight"));
        System.out.println(tries.preFix("techi"));
    }
}
