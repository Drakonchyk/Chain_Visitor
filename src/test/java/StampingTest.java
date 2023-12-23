import org.junit.jupiter.api.Test;
import ua.ucu.edu.apps.*;

import static org.junit.jupiter.api.Assertions.*;

class StampingTest {

    @Test
    void testStampingVisitor() {
        StampedSignature s1 = new StampedSignature("POC", "CS1");
        StampedSignature s2 = new StampedSignature("OOP", "CS2");
        Signature s3 = new StampedSignature("Probability", "BA");

        Group g1 = new Group("CS1");
        g1.addTask(s2);
        g1.addTask(s1);

        Group group2 = new Group("CS2");
        group2.addTask(s3);

        StampingVisitor stampingVisitor = new StampingVisitor("BA");

        g1.accept(stampingVisitor);

        assertTrue(s1 instanceof StampedSignature);
        assertEquals("CS1", s1.getGroupId());

        assertTrue(s2 instanceof StampedSignature);
        assertEquals("CS2", s2.getGroupId());
    }

    @Test
    void testGroupExecution() {
        Signature s1 = new StampedSignature("POC", "CS1");
        Signature s2 = new StampedSignature("OOP", "CS2");
        Signature s3 = new StampedSignature("Probability", "BA");

        Group g1 = new Group("CS1");
        g1.addTask(s2);
        g1.addTask(s1);

        Group group2 = new Group("CS2");
        group2.addTask(s3);

        StampingVisitor stampingVisitor = new StampingVisitor("BA");

        g1.accept(stampingVisitor);
        group2.accept(stampingVisitor);

        Group g1Copy = new Group("CS1");
        g1Copy.addTask(new StampedSignature("OOP", "CS2"));
        g1Copy.addTask(new StampedSignature("POC", "CS1"));

        g1Copy.accept(new StampingVisitor("AnotherVisitor"));
        assertEquals(g1.toString(), g1Copy.toString());
    }
}
