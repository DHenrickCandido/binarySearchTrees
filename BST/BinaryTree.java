package BST;
public class BinaryTree {
    public Node root;

    private Node addRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        } else {
            return current;
        }

        return current;
    }

    public void add(int data) {
        root = addRecursive(root, data);
    }

    private boolean containsNodeRecursive(Node current, int data) {
        if (current == null) {
            return false;
        }
        if (data == current.data) {
            return true;
        } else if (data < current.data) {
            return containsNodeRecursive(current.left, data);
        } else {
            return containsNodeRecursive(current.right, data);
        }

    }

    public boolean containsNode(int data) {
        return containsNodeRecursive(root, data);
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    private Node deleteRecursive(Node current, int data) {
        if (current == null) {
            return null;
        }
    
        if (data == current.data) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.right == null) {
                return current.left;
            }
            
            if (current.left == null) {
                return current.right;
            }

            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);

            return current;
        } 


        if (data < current.data) {
            current.left = deleteRecursive(current.left, data);
            return current;
        }
        current.right = deleteRecursive(current.right, data);
        return current;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node searchRecursive(Node current, int data) {
        if (current == null) {
            return null;
        }
        if (data == current.data) {
            return current;
        } else if (data < current.data) {
            return this.searchRecursive(current.left, data);
        } else {
            return this.searchRecursive(current.right, data);
        }

    }

    public Node search(int data) {
        return searchRecursive(root, data);
    }
}
