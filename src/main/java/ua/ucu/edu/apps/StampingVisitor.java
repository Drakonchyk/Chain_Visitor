package ua.ucu.edu.apps;

public class StampingVisitor implements Visitor {
    private String groupId;

    public StampingVisitor(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public void visit(Signature signature) {
        System.out.println("Stamped: " + signature.getContent() + " with Group ID: " + groupId);
    }
}
