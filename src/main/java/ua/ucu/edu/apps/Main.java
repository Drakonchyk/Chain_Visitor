package ua.ucu.edu.apps;

public class Main {
    public static void main(String[] args) {
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
    }
}

