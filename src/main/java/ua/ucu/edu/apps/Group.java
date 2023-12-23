package ua.ucu.edu.apps;

import java.util.ArrayList;
import java.util.List;

public class Group implements Task {
    private List<Task> tasks;
    private String groupId;

    public Group(String groupId) {
        this.groupId = groupId;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void accept(Visitor visitor) {
        System.out.println("Visiting group: " + groupId);
        for (Task task : tasks) {
            task.accept(visitor);
        }
    }

    @Override
    public String toString() {
        return "Group " + groupId;
    }
}