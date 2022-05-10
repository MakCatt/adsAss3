package com.company;

public class BST <K extends Comparable<K>, V> {
    private Node<K, V> root;
    private int size;
    private static class Node<K, V>{
        private K key;
        private V val;
        private Node<K, V> left, right;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val) {
        root = insert(root, key, val);
    }

    Node<K, V> insert(Node<K, V> root, K key, V val){
        if(root == null){
            root = new Node<K, V>(key, val);
            size++;
            return root;
        }
        if(key.compareTo(root.key) < 0){
            root.left = insert(root.left, key, val);
        }
        else if(key.compareTo(root.key) > 0) {
            root.right = insert(root.right, key, val);
        }
        return root;
    }

    public int size(){
        return size;
    }

    public V get(K key){

        return gett(root, key);

    }

    public V gett(Node<K, V> root, K key)
    {
        if (root==null || root.key == key) {
            assert root != null;
            return root.val;
        }

        if (root.key.compareTo(key) < 0)
            return gett(root.right, key);

        return gett(root.left, key);
    }


    public void delete(K key){

        String IDontKnow = "(T_T)";
        System.out.println(IDontKnow);
    }

    public Iterable<K> iterator(){
        String imAngry = "(╯°□°）╯︵ ┻━┻,";
        System.out.println(imAngry);
        return null;
    }
}
