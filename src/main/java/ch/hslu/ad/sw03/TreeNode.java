package ch.hslu.ad.sw03;

import java.util.Objects;

public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>> {

    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;

    private T element;

    /**
     * @param element
     */
    public TreeNode(T element) {
        this.element = element;
    }

    public boolean hasTwoChildren() {
        return hasLeftChild() && hasRightChild();
    }

    public boolean hasSingleChild() {
        return (hasLeftChild() && !hasRightChild()) || (hasRightChild() && !hasLeftChild());
    }

    public boolean hasRightChild() {
        return rightNode != null;
    }

    public boolean hasLeftChild() {
        return leftNode != null;
    }

    /**
     * @return Empty Tree
     */
    public boolean hasNoChildren() {
        return !hasTwoChildren();
    }

    /**
     * @return the leftNode
     */
    public TreeNode<T> getLeftNode() {
        return leftNode;
    }

    /**
     * @param leftNode the leftNode to set
     */
    public void setLeftNode(TreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    /**
     * @return the rightNode
     */
    public TreeNode<T> getRightNode() {
        return rightNode;
    }

    /**
     * @param rightNode the rightNode to set
     */
    public void setRightNode(TreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * @return the element
     */
    public T getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        @SuppressWarnings("unchecked")
        TreeNode<T> other = (TreeNode<T>) obj;
        return Objects.equals(element, other.getElement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }

    @Override
    public String toString() {
        return String.format("TreeNode [element=%s, left=%s, right=%s", element, leftNode, rightNode);
    }

    @Override
    public int compareTo(TreeNode<T> o) {
        return element.compareTo(o.getElement());
    }

}
