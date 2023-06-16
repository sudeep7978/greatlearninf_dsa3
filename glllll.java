import java.util.Scanner;

public class FindPairWithGivenSumInBST {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the sum
        int sum = scanner.nextInt();

        // Create a new Binary Search Tree
        BinarySearchTree bst = new BinarySearchTree();

        // Add nodes to the Binary Search Tree
        bst.add(60);
        bst.add(70);
        bst.add(100);
        bst.add(80);
        bst.add(90);

        // Find the pair with the given sum
        Pair pair = bst.findPairWithGivenSum(sum);

        // Print the pair
        if (pair != null) {
            System.out.println("The pair with the given sum is " + pair);
        } else {
            System.out.println("The nodes are not found");
        }
    }
}

class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(int data) {
        root = addNode(root, data);
    }

    private Node addNode(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } else if (data < node.data) {
            node.left = addNode(node.left, data);
        } else {
            node.right = addNode(node.right, data);
        }
        return node;
    }

    public Pair findPairWithGivenSum(int sum) {
        return findPairWithGivenSum(root, sum);
    }

    private Pair findPairWithGivenSum(Node node, int sum) {
        if (node == null) {
            return null;
        } else {
            // Check if the current node has the given sum
            if (node.data == sum) {
                return new Pair(node.data, 0);
            } else {
                // Recursively search the left and right subtrees
                Pair leftPair = findPairWithGivenSum(node.left, sum - node.data);
                Pair rightPair = findPairWithGivenSum(node.right, sum - node.data);

                // If a pair is found in either subtree, return it
                if (leftPair != null || rightPair != null) {
                    return new Pair(leftPair.first, rightPair.second);
                }
            }
        }
        return null;
    }
}

class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair {

    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
