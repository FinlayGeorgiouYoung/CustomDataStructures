package PriorityQueue;

public interface Queue<Integer, String> {
    public void addtopq(String str, Integer priority);

    public void deleteFront();

    public String front();

    public boolean isEmpty();
}

class QueueException extends RuntimeException {
    QueueException(String s) {
        super("Tried to apply " + s + " to empty queue");
    }
}