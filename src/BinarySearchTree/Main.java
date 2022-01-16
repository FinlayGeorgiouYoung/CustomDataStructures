package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(9);
        tree.insert(5);
        tree.insert(11);

        System.out.println(tree.greater(5));
        System.out.println(tree.nth(4));
    }

}
