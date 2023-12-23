package ua.ucu.edu.apps;

public class StampedSignature extends Signature {
    private String groupId;

    public StampedSignature(String content, String groupId) {
        super(content);
        this.groupId = groupId;
    }

    public String getGroupId() { return groupId; }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
