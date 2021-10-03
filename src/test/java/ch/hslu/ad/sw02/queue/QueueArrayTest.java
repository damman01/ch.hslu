package ch.hslu.ad.sw02.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class QueueArrayTest {
    private static Logger LOG = LogManager.getLogger(QueueArrayTest.class);

    @Test
    public void addToEmptyQueueTest() {
        LOG.info("addToEmptyQueueTest");
        QueueArray testQueue = new QueueArray();
        LOG.debug("testQueue after create " + testQueue);
        char testChar = 'f';

        testQueue.add(testChar);
        LOG.debug("testQueue after add " + testQueue);

        assertEquals(1, testQueue.index());
        assertEquals(testChar, testQueue.show());
    }

    @Test
    public void addMaxElementsTest() {
        LOG.info("addMaxElementsTest");
        QueueArray testQueue = new QueueArray(3);
        LOG.debug("testQueue after create " + testQueue);
        char first = 'a';

        testQueue.add(first);
        LOG.debug("testQueue after add " + testQueue);
        testQueue.add('b');
        LOG.debug("testQueue after add " + testQueue);
        testQueue.add('c');
        LOG.debug("testQueue after add " + testQueue);

        assertEquals(3, testQueue.index());
        assertEquals(first, testQueue.show());
    }

    @Test
    public void addMaxPlusOneElementsTest() {
        LOG.info("addMaxPlusOneElementsTest");
        QueueArray testQueue = new QueueArray(3);
        LOG.debug("testQueue after create " + testQueue);
        char first = 'a';

        testQueue.add(first);
        LOG.debug("testQueue after add " + testQueue);
        testQueue.add('b');
        LOG.debug("testQueue after add " + testQueue);
        testQueue.add('c');
        LOG.debug("testQueue after add " + testQueue);
        Exception result = assertThrows(IllegalStateException.class, () -> testQueue.add('d'));
        LOG.debug("result after overflow " + result);
        LOG.debug("testQueue after overflow " + testQueue);

        assertTrue(result.getMessage().contains("full"));
    }

    @Test
    public void removeEmptyQueueTest() {
        LOG.info("removeEmptyQueueTest");
        QueueArray testQueue = new QueueArray(3);
        LOG.debug("testQueue after create " + testQueue);

        Exception result = assertThrows(IllegalStateException.class, () -> testQueue.remove());
        LOG.debug("result after empty remove " + result);

        assertTrue(result.getMessage().contains("empty"));
    }

    @Test
    public void removeOnlyElementTest() {
        LOG.info("removeOnlyElementTest");
        QueueArray testQueue = new QueueArray(3);
        LOG.debug("testQueue after create " + testQueue);
        testQueue.add('a');
        LOG.debug("testQueue after add " + testQueue);

        testQueue.remove();
        LOG.debug("testQueue after remove " + testQueue);

        assertEquals(0, testQueue.index());
    }

    @Test
    public void removeElementsTest() {
        LOG.info("removeElementsTest");
        QueueArray testQueue = new QueueArray(3);
        LOG.debug("testQueue after create " + testQueue);
        testQueue.add('a');
        LOG.debug("testQueue after add " + testQueue);
        char lastElement = 'b';
        testQueue.add(lastElement);
        LOG.debug("testQueue after add " + testQueue);

        testQueue.remove();
        LOG.debug("testQueue after remove " + testQueue);

        assertEquals(1, testQueue.index());
        assertEquals(lastElement, testQueue.show());
    }

    @Test
    public void addRotationTest() {
        LOG.info("addRotationTest");
        QueueArray testQueue = new QueueArray(3);
        LOG.debug("testQueue after create " + testQueue);
        char secondElement = 'b';
        testQueue.add('a');
        LOG.debug("testQueue after add " + testQueue);
        testQueue.add(secondElement);
        LOG.debug("testQueue after add " + testQueue);
        testQueue.add('c');
        LOG.debug("testQueue after add " + testQueue);

        testQueue.remove();
        LOG.debug("testQueue after remove " + testQueue);
        testQueue.add('e');
        LOG.debug("testQueue after add " + testQueue);

        assertEquals(3, testQueue.index());
        assertEquals(secondElement, testQueue.show());
    }

    @Test
    public void removeRotationTest() {
        LOG.info("removeRotationTest");
        QueueArray testQueue = new QueueArray(3);
        LOG.debug("testQueue after create " + testQueue);
        char lastElement = 'f';
        testQueue.add('a'); // Index 0
        LOG.debug("testQueue after add " + testQueue);
        testQueue.add('b'); // Index 1
        LOG.debug("testQueue after add " + testQueue);
        testQueue.add('c'); // Index 2
        LOG.debug("testQueue after add " + testQueue);
        testQueue.remove(); // remove a
        LOG.debug("testQueue after remove " + testQueue);
        testQueue.remove(); // remove b
        LOG.debug("testQueue after remove " + testQueue);
        testQueue.remove(); // remove c
        LOG.debug("testQueue after remove " + testQueue);
        testQueue.add('e'); // Index 0
        LOG.debug("testQueue after add " + testQueue);
        testQueue.add(lastElement); // Index 1
        LOG.debug("testQueue after add " + testQueue);

        testQueue.remove(); // remove e
        LOG.debug("testQueue after remove " + testQueue);

        assertEquals(1, testQueue.index());
        assertEquals(lastElement, testQueue.show());
    }
}
