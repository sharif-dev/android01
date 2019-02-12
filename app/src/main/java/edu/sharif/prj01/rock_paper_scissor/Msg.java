package edu.sharif.prj01.rock_paper_scissor;

public class Msg {
    private Task task = Task.READY;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
