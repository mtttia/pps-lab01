package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {
    private final List<Integer> queue;
    private final int queueSize;
    private int currentIndex;
    private int queueStartIndex;
    private int currentSize;

    CircularQueueImpl(int queueSize){
        queue = new ArrayList<>();
        this.queueSize = queueSize;
        currentIndex = 0;
        queueStartIndex = 0;
        currentSize = 0;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enqueue(int queueValue) {
        if(currentIndex >= queue.size()){
            queue.add(queueValue);
            increaseCurrentIndex();
        }
        else{
            queue.set(currentIndex, queueValue);
            increaseCurrentIndex();
            increaseQueueStartIndex();
        }
        currentSize++;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public int dequeue() {
        if(size() <= 0){
           throw new IllegalStateException();
        }
        int value = queue.get(queueStartIndex);
        increaseQueueStartIndex();
        currentSize--;
        return value;
    }

    private void increaseCurrentIndex(){
        currentIndex = (currentIndex + 1) % queueSize;
    }

    private void increaseQueueStartIndex(){
        queueStartIndex = (queueStartIndex + 1) % queueSize;
    }
}
