class MedianFinder {
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
    int size=0;
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        size++;
        if(maxHeap.isEmpty() || num<=maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        if(minHeap.size()+1 < maxHeap.size()){
            Integer element=maxHeap.poll();
            minHeap.offer(element);
        }
        else if(maxHeap.size() < minHeap.size()){
            Integer element=minHeap.poll();
            maxHeap.offer(element);
        }
    }
    
    public double findMedian() {
        if(size%2!=0) return (double) maxHeap.peek();
        return (maxHeap.peek()+minHeap.peek())/2.0;
    }
}
