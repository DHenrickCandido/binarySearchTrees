package BST;
import javax.swing.plaf.synth.SynthStyle;

public class Main {
    public static void main(String[] args) {
        BinaryTree binTree = new BinaryTree();

        binTree.add(6);
        binTree.add(4);
        binTree.add(8);
        binTree.add(3);
        System.out.println(binTree.root.left.data);

        // System.out.println(binTree.containsNode(4));
        binTree.delete(4);
        System.out.println(binTree.root.left.data);
        Node nodeSearched = binTree.search(3);
        System.out.println(nodeSearched.data);
    }
}
