public class BinaryTree {
    static class Node{
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    Node root;
    public BinaryTree(){
        root = null;
    }
    private Node insert(Node current, int data){
        if (current == null){
            return new Node(data);
        }
        if (data < current.data){
            current.left = insert(current.left, data);
        } else if (data > current.data){
            current.right = insert(current.right, data);
        }
        return current;
    }
    public void insert(int data){
        root = insert(root, data);
    }
    private void inOrder(Node node){
        if (node != null){
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
    public void inOrder(){
        inOrder(root);
    }
    private int findSmallestValue(Node root){
        return root.left == null ? root.data : findSmallestValue(root.left);
    }
    private String search(Node root, int data) {
        if (root == null) {
            return "notFound";
        } else if (root.data == data) {
            return "found";
        } else if (data < root.data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }
    public void search(int data){
        System.out.println(search(root, data));
    }

}
