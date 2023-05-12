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
}
