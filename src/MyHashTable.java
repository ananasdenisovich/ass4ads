public class MyHashTable <K, V>{

    public class hashNode<K, V>{
        private K key;
        V value;
        private hashNode<K, V> next;
        public hashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    public hashNode<K, V>[] chainArray;
    private int M = 10000;
    private int size;
    public MyHashTable() {
        chainArray = new hashNode[M];
        size = 0;
    }

    public MyHashTable(int M){
        this.M = M;
    }


    public int getSize() {
        return size;
    }

    public hashNode<K, V>[] getChainArray() {
        return chainArray;
    }

    public int hash(K key){
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
    //public V remove(K key){
      //  int index = hash(key);
        //hashNode<K, V> node = chainArray[index];
        //hashNode<K, V> prev = null;
        //while (node != null) {
          //  if (node.key.equals(key)) {
            //    if (prev == null) {
              //      chainArray[index] = node.next;
                //} else {
                  //  prev.next = node.next;
                //}
                //size--;
                //return node.value;
            //}
            //prev = node;
            //node = node.next;
        //}
        //return null;
    //}
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
    private void increaseCapacity(int newCapacity) {
        MyHashTable<K, V> newTable = new MyHashTable<>(newCapacity);
        for (int i = 0; i < M; i++) {
            hashNode<K, V> node = chainArray[i];
            while (node != null) {
                newTable.put(node.key, node.value);
                node = node.next;
            }
        }
        M = newCapacity;
        chainArray = newTable.chainArray;
    }
    public void remove(V value){
        int index = chainArray.length - 1;
        hashNode<K, V> node = chainArray[index];
        hashNode<K, V> prev = null;
        while (node != null) {
            if (node.value.equals(value)) {
                if (prev == null) {
                    chainArray[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
            }
            prev = node;
            node = node.next;
        }
    }
    public void replace(K key, V oldValue, V newValue){
        remove(oldValue);//removes an oldValue
        put(key, newValue);//puts newValue
    }
}
