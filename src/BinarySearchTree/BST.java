package BinarySearchTree;


import java.util.NoSuchElementException;

public class BST {
    private BTNode<Integer> root;

    public BST() {
        root = null;
    }

    public boolean find(Integer i) {
        BTNode<Integer> n = root;
        boolean found = false;

        while (n != null && !found) {
            int comp = i.compareTo(n.data);
            if (comp == 0)
                found = true;
            else if (comp < 0)
                n = n.left;
            else
                n = n.right;
        }

        return found;
    }

    public boolean insert(Integer i) {
        BTNode<Integer> parent = root, child = root;
        boolean goneLeft = false;

        while (child != null && i.compareTo(child.data) != 0) {
            parent = child;
            if (i.compareTo(child.data) < 0) {
                child = child.left;
                goneLeft = true;
            } else {
                child = child.right;
                goneLeft = false;
            }
        }

        if (child != null)
            return false;  // nthVal already present
        else {
            BTNode<Integer> leaf = new BTNode<Integer>(i);
            if (parent == null) // tree was empty
                root = leaf;
            else if (goneLeft)
                parent.left = leaf;
            else
                parent.right = leaf;
            return true;
        }
    }


    private int count = 0;

    //the greater function takes an int as it's parameter and returns the amount of numbers in the tree that are greater than in passed parameter
    public int greater(int n) {
        //if the tree is empty return 0
        if (root == null) {
            return 0;
        }
        //traverseGreater called to traverse through the tree and increment the counter for each nthVal in the tree bigger than the passed parameter n
        traverseGreater(root, n);
        int result = count;
        count = 0;
        return result;
    }


    //traverseGreater is a private function used by the greater method
    //it takes a BTNode and an int as parameters
    //it is a recursive function used to traverse through the tree
    //it counts all of the Integers in the trees that are greater than the int n parameter
    private void traverseGreater(BTNode currentNode, int n) {
        //if the current nodes data is bigger then the n parameter then increment the count by 1
        if ((Integer) currentNode.data > n) {
            count++;
        }
        //if the left child of the current node isn't null then call the function again
        //passing the left child of the current node and the n parameter as the parameters
        if (currentNode.left != null) {
            traverseGreater(currentNode.left, n);
        }
        //if the right child of the current node isn't null then call the function again
        //passing the right child of the current node and the n parameter as the parameters
        if (currentNode.right != null) {
            traverseGreater(currentNode.right, n);
        }
    }


    //nodePos is a counter used to keep track of the position of the currentNode if the tree's data was in ascending order
    private int nodePos = 0;
    //nthVal is a variable used to store the data of the node in the nth position when getNth is called by nth
    private int nthVal = Integer.MIN_VALUE;

    //getNth is a private function which takes a BTNode currentNode and an int i as parameters
    //getNth is recursively called in a specific way to undertake in-order traversal
    //it returns the value that is in the position of the int i parameter passed. If the position doesn't exist Integer.MIN_VALUE will be returned
    private int getNth(BTNode currentNode, int i) {

        //if the left child of currentNode is not equal to null then call getNth passing in the left child and i as it's parameter
        if (currentNode.left != null) {
            getNth(currentNode.left, i);
        }

        //if nodePos is the same as parameter i then assign the nthVal variable to the currentNode's data
        if (nodePos == i) {
            nthVal = (int) currentNode.data;
        }

        //increment nodePos by 1
        nodePos++;

        //if the right child of currentNode is not equal to null then call getNth passing in the right child and i as it's parameter
        if (currentNode.right != null) {
            getNth(currentNode.right, i);
        }

        return nthVal;
    }


    //the nth function takes an int as it's parameter and returns the nthVal that would be in the position of the passed parameter
    //if the tree's contents were in an array ordered in ascending order
    public int nth(int i) {

        int nthNum = getNth(root, i);

        //if the passed int i isn't a location in the array then an exception is thrown
        if (nthVal == Integer.MIN_VALUE) {
            throw new NoSuchElementException();
        }

        nodePos = 0;
        nthVal = 0;

        //the int in position i in the array is returned
        return nthNum;
    }

}
