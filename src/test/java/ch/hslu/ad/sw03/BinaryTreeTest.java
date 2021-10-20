package ch.hslu.ad.sw03;

import static org.assertj.core.api.Assertions.*;

import java.util.TreeSet;

import org.apache.logging.log4j.*;
import org.junit.jupiter.api.Test;


public class BinaryTreeTest {
    private static Logger lLOG = LogManager.getLogger(BinaryTreeTest.class);

    @Test
    void testAddMultiElements() {
        BinaryTree<Integer> testTree = new BinaryTree<>();
        testTree.add(4);
        testTree.add(2);
        testTree.add(1);
        testTree.add(3);
        testTree.add(6);
        testTree.add(5);
        testTree.add(8);
        testTree.add(7);
        testTree.add(9);
        assertThat(testTree.root.hasTwoChildren()).isTrue();
        assertThat(testTree.root.getRightNode().hasTwoChildren()).isTrue();
        assertThat(testTree.root.getLeftNode().hasTwoChildren()).isTrue();
    }

    @Test
    void testAddOneElement() {
        BinaryTree<Integer> testTree = new BinaryTree<>();
        testTree.add(9);
        assertThat(testTree.root.getElement()).isEqualTo(9);
    }

    @Test
    void testAddNull() {
        BinaryTree<Integer> testTree = new BinaryTree<>();
        assertThatIllegalArgumentException().isThrownBy(() -> testTree.add(null));
    }


    @Test
    void testSearch() {
        BinaryTree<Integer> testTree = new BinaryTree<>();
        testTree.add(4);
        testTree.add(2);
        testTree.add(1);
        testTree.add(3);
        testTree.add(6);
        testTree.add(5);
        testTree.add(8);
        testTree.add(7);
        testTree.add(9);

        testTree.search(testTree.root, 8).getElement();

        assertThat(testTree.foundNode.getElement()).isEqualTo(8);

    }

    @Test
    void testAddSameTwice() {
        BinaryTree<Integer> testTree = new BinaryTree<>();
        testTree.add(5);
        testTree.add(6);
        testTree.add(5);
        testTree.add(6);

        assertThat(testTree.root.getRightNode().getElement()).isEqualTo(6);
    }

    @Test
    void testTreeSet() {
        TreeSet<Integer> testTree = new TreeSet<>();

        testTree.add(5);
        lLOG.trace("testTreeSet" + testTree.toString());
        testTree.add(4);
        lLOG.trace("testTreeSet" + testTree.toString());
        testTree.add(2);
        lLOG.trace("testTreeSet" + testTree.toString());
        testTree.add(3);
        lLOG.trace("testTreeSet" + testTree.toString());
        testTree.add(1);
        lLOG.trace("testTreeSet" + testTree.toString());
        testTree.add(6);
        lLOG.trace("testTreeSet" + testTree.toString());
        testTree.add(8);
        lLOG.trace("testTreeSet" + testTree.toString());
        testTree.add(7);


        lLOG.trace("testTreeSet" + testTree.toString());


    }

}
