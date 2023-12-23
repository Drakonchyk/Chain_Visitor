package ua.ucu.edu.apps;

public class Signature implements Task{
    private String content;

    public Signature(String content) {
        this.content = content;
    }

    public String getContent() { return content; }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
