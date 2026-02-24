package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {
    private final List<Integer> queue;
    private final int queueSize;
    private int currentIndex;
    private int queueStartIndex;

    CircularQueueImpl(int queueSize){
        queue = new ArrayList<>();
        this.queueSize = queueSize;
        currentIndex = 0;
        queueStartIndex = 0;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enqueue(int queueValue) {
        if(currentIndex >= queue.size()){
            queue.add(queueValue);
        }
        else{
            queue.set(currentIndex, queueValue);
        }
        increaseCurrentIndex();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public int dequeue() {
        if(size() <= 0){
           throw new IllegalStateException();
        }
        int value = queue.get(queueStartIndex);
        increaseQueueStartIndex();
        return value;
    }

    private void increaseCurrentIndex(){
        if(currentIndex == queueStartIndex){
            increaseQueueStartIndex();
        }
        currentIndex = (currentIndex + 1) % queueSize;
    }

    private void increaseQueueStartIndex(){
        queueStartIndex = (queueStartIndex + 1) % queueSize;
    }
}
