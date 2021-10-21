package ch.hslu.ad.sw03;

import java.util.Comparator;

import org.apache.logging.log4j.*;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {
    private static Logger lLOG = LogManager.getLogger(BinaryTree.class);

    private Comparator<T> comparator;
    TreeNode<T> root = null;
    
    TreeNode<T> foundNode = null;
    int level = 0;

    /**
     * @param comparator
     */
    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public BinaryTree() {
        this.comparator = null;
    }


    @Override
    public void add(final T elemenT) {
        if (!(elemenT instanceof Comparable)) {
            throw new IllegalArgumentException();
        }
        TreeNode<T> newNode = null;

        // position suchen

        newNode = search(root, elemenT);

        root = newNode;

    }

    public TreeNode<T> search(TreeNode<T> parentNode, T elementT) {
        if (parentNode == null) {
            parentNode = new TreeNode<>(elementT);

            lLOG.trace("level: {} root: {}", level, elementT);
            return parentNode;
        }

        /**
         * parentNode ist gleich elementT parentNode returnen
         */
        if (parentNode.getElement().compareTo(elementT) == 0) {

            lLOG.trace("level: {} found: {}", level, elementT);
            foundNode = parentNode;
            level--;
            return parentNode;
        }

        level++;

        /**
         * parentNode ist kleiner als elementT Im rechten Child weiter suchen wenn kein
         * rechtes Child vorhanden -> Child erstellen und returnen
         */
        if (parentNode.getElement().compareTo(elementT) < 0) {
            if (parentNode.hasRightChild()) {
                lLOG.trace("level: {} Search: {}", level, elementT);
                parentNode.setRightNode(search(parentNode.getRightNode(), elementT));
                level--;
                return parentNode;
            } else {
                parentNode.setRightNode(new TreeNode<>(elementT));
                lLOG.trace("level: {} rightChild: {}", level, elementT);
                level--;
                return parentNode;
            }
        }

        /**
         * parentNode ist grösser als elementT Im linken Child weiter suchen wenn kein
         * linkes Child vorhanden -> Child erstellen und returnen
         */
        if (parentNode.getElement().compareTo(elementT) > 0) {
            if (parentNode.hasLeftChild()) {
                lLOG.trace("level: {} Search: {}", level, elementT);
                parentNode.setLeftNode(search(parentNode.getLeftNode(), elementT));
                level--;
                return parentNode;
            } else {
                parentNode.setLeftNode(new TreeNode<>(elementT));
                lLOG.trace("level: {} leftChild: {}", level, elementT);
                level--;
                return parentNode;
            }
        }

        lLOG.trace("End of level: {} search: {}", level, elementT);
        return parentNode;
    }

    @Override
    public void remove(T elementT) {
        // TODO Auto-generated method stub

    }

    @Override
    public void inorder() {
        // TODO Auto-generated method stub

    }

}
