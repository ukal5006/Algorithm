class MinHeap {
    constructor() {
        this.heap = [];
    }
    
    insert(num) {
        this.heap.push(num);
        this.bubbleUp();
    }
    
    bubbleUp() {
        let idx = this.heap.length - 1;
        
        while(idx > 0) {
            let pIdx = Math.floor((idx - 1) / 2);
            
            if(this.heap[pIdx] <= this.heap[idx]) break;
            
            [this.heap[pIdx], this.heap[idx]] = [this.heap[idx], this.heap[pIdx]];
            idx = pIdx;
        }
    }
    
    delete() {
        if(this.heap.length === 1) return this.heap.pop();
        
        const min = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.bubbleDown();
        
        return min;
    }
    
    bubbleDown() {
        const len = this.heap.length;
        let idx = 0;
        
        while(true) {
            let lIdx = idx * 2 + 1;
            let rIdx = idx * 2 + 2;
            let sIdx = idx;
            
            if(lIdx < len && this.heap[sIdx] > this.heap[lIdx]) sIdx = lIdx;
            
            if(rIdx < len && this.heap[sIdx] > this.heap[rIdx]) sIdx = rIdx;
            
            if(idx === sIdx) break;
            
            [this.heap[idx], this.heap[sIdx]] = [this.heap[sIdx], this.heap[idx]];
            idx = sIdx;
        }
    }
    
    size() {
        return this.heap.length;
    }
}


function solution(scoville, K) {
    const minHeap = new MinHeap();
    let answer = 0;
    
    for(let i = 0; i < scoville.length; i++) {
        minHeap.insert(scoville[i]);
    }
    
    while(minHeap.size() > 0) {
        const min = minHeap.delete();
        
        if(min >= K) {
            break;
        }
        else if(minHeap.size() === 0) {
            answer = -1;
            break;
        }
        else {
            minHeap.insert(min + 2 * minHeap.delete());
            answer++;
        }
    }
    
    return answer;
}