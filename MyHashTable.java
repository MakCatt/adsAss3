package com.company;



public class MyHashTable<K, V> {
    private static class HashNode<K, V>{
        private final K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 10;
    private int size;

    public MyHashTable() {
        this(10);
    }

    public MyHashTable(int M){
        this.M = M;
        this.chainArray = new HashNode[M];
        this.size = 0;
    }

    private int hash(K key){
        return Math.abs(key.hashCode() % chainArray.length);
    }

    public void put(K key, V value){
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        while(head != null) {
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = chainArray[index];
        HashNode<K, V> node = new HashNode<K, V>(key, value);
        node.next = head;
        chainArray[index] = node;
    }

    public int size(){
        return size;
    }

    public V get(K key){
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> previous = null;
        while(head != null){
            if(head.key.equals(key)){
                size--;
                if(previous != null){
                    previous.next = head.next;
                }
                else{
                    chainArray[index] = head.next;
                }
                return null;
            }
            previous = head;
            head = head.next;
        }
        return null;
    }

    public boolean contains(V value){
        for (HashNode<K, V> kvHashNode : chainArray) {
            HashNode<K, V> head = kvHashNode;
            while (head != null) {
                if (head.value.equals(value)) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        for (HashNode<K, V> kvHashNode : chainArray) {
            HashNode<K, V> head = kvHashNode;
            while (head != null) {
                if (head.value.equals(value)) {
                    return head.key;
                }
                head = head.next;
            }
        }
        return null;
    }
}
