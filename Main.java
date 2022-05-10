package com.company;



public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, String> ht = new MyHashTable<>();
        ht.put(105,"John");
        ht.put(21, "Lona");
        ht.put(31, "Gon");
        System.out.println(ht.getKey("John"));
        System.out.println(ht.contains("Lona"));




        BST<Integer, String> bst = new BST<>();
        bst.put(5,"Joli");
        bst.put(3,"Momo");
        bst.put(6,"Candy");
        System.out.println(bst.size());
        System.out.println(bst.get(3));
        bst.delete(5);
        bst.iterator();
    }
}
