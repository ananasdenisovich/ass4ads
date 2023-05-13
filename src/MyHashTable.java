public class MyHashTable <K, V>{
    public class hashNode<K, V>{
        private K key;
        private V value;
        private hashNode<K, V> next;
        public hashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private hashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;
    public MyHashTable(){
        chainArray = new hashNode[M];
        size = 0;
    }
    public MyHashTable(int M){
        this.M = M;
    }
    int hash(K key){
        int hashCode = key.hashCode();
        return (hashCode & 0x7fffffff) % M;
    }
    public void put(K key, V value){
        int index = hash(key);
        hashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        hashNode<K, V> newNode = new hashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }
    public V get(K key){
        int index = hash(key);
        hashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public V remove(K key){
        int index = hash(key);
        hashNode<K, V> node = chainArray[index];
        hashNode<K, V> prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    chainArray[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }
    public boolean contains(V value){
        for (int i = 0; i < M; i++) {
            hashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            hashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }


}
