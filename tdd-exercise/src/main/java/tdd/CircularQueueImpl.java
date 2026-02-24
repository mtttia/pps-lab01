package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {
    private final List<Integer> queue;

    CircularQueueImpl(){
        queue = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enqueue(int queueValue) {
        queue.add(queueValue);
    }

    @Override
    public int size() {
        return queue.size();
    }
}
