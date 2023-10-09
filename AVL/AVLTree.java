package AVL;

public class AVLTree {
    public Node root;

    public void insert(int data) {
        root = add(root, data);
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }
        int left = height(node.left);
        int right = height(node.right);

        if (left > right)
            return 1 + left;

        return 1 + right;
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.right) - height(node.left);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;

        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;

        return x;
    }

    private Node rebalance(Node z) {
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    public Node add(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } else if (node.data > data) {
            node.left = add(node.left, data);
        } else if (node.data < data) {
            node.right = add(node.right, data);
        } 
        return rebalance(node);
    }

    private Node mostLeftChild(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node deleteRecursive(Node node, int data) {
        if (node == null) {
            return node;
        } else if (node.data > data) {
            node.left = deleteRecursive(node.left, data);
        } else if (node.data < data) {
            node.right = deleteRecursive(node.right, data);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.data = mostLeftChild.data;
                node.right = deleteRecursive(node.right, node.data);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    public void delete(int data) {
        root = deleteRecursive(root, data);
    }

    public Node find(int data) {
        Node current = root;
        
        while (current != null) {
    
            if (current.data == data) {
                break;
            } else if (current.data < data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return current;
    }

}
