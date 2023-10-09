package AVL;

public class Main {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.delete(20);
        avlTree.insert(5);
        
        System.out.println(avlTree.root.left.data);
    }
}
