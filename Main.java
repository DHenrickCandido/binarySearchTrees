import AVL.*;
import BST.*;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int[] numElements = {100, 500, 1000, 10000, 20000};
        System.out.println("BINARY TREE TEST:");
        for (int i = 0; i < numElements.length; i++) {
            System.out.println("TEST WITH " + numElements[i] + " ELEMENTS: ");
            testBinaryTree(numElements[i]);
        }
        System.out.println("\n\n\n");

        System.out.println("AVL TREE TEST:");
        for (int i = 0; i < numElements.length; i++) {
            System.out.println("TEST WITH " + numElements[i] + " ELEMENTS: ");
            testAVLTree(numElements[i]);
        }

    }

    public static void testBinaryTree(int numElements) {
        BinaryTree tree = new BinaryTree();
        Random random = new Random();
        int[] randomNumbers = new int[numElements];

        for (int i = 0; i < numElements; i++) {
            int randomNumber = random.nextInt(1000); 
            randomNumbers[i] = randomNumber;
            tree.add(randomNumber);
        }

        long startTime = System.nanoTime();
        for (int randomNumber : randomNumbers) {
            tree.add(randomNumber);
        }
        long endTime = System.nanoTime();
        long insertTime = endTime - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numElements / 2; i++) {
            int randomNumber = randomNumbers[i];
            tree.delete(randomNumber);
        }
        endTime = System.nanoTime();
        long deleteTime = endTime - startTime;


        startTime = System.nanoTime();
        for (int i = 0; i < 50; i++) {
            int randomNumber = randomNumbers[i];
            tree.containsNode(randomNumber);
        }
        endTime = System.nanoTime();
        long searchTime = endTime - startTime;

        System.out.println("Time taken for insertions: " + insertTime/1_000_000.0 + " milliseconds");
        System.out.println("Time taken for deletions: " + deleteTime/1_000_000.0 + " milliseconds");
        System.out.println("Time taken for searches: " + searchTime/1_000_000.0 + " milliseconds");
        
    }


    public static void testAVLTree(int dataSize) {

        AVLTree avlTree = new AVLTree();
        Random random = new Random();
        long startTime, endTime;
        
        startTime = System.nanoTime();
        for (int i = 0; i < dataSize; i++) {
            int randomNumber = random.nextInt(1000);
            avlTree.insert(randomNumber);
        }
        endTime = System.nanoTime();
        long addTime = endTime - startTime;
    
        int randomDelete = random.nextInt(1000); 
    
        startTime = System.nanoTime();
        avlTree.delete(randomDelete);
        endTime = System.nanoTime();
        long deleteTime = endTime - startTime;
    
        int randomSearch = random.nextInt(1000);
    
        startTime = System.nanoTime();
        Node result = avlTree.find(randomSearch);
        
        endTime = System.nanoTime();
        long searchTime = endTime - startTime;
    
        System.out.println("AVL Tree Operations:");
        System.out.println("Time taken to add: " + addTime/ 1_000_000.0 + " milliseconds");
        System.out.println("Time taken to delete: " + deleteTime/ 1_000_000.0 + " milliseconds");
        System.out.println("Time taken to search: " + searchTime/ 1_000_000.0 + " milliseconds");
    }
    
}

