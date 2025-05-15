function solution(sequence) {
    let maxSum1 = -Infinity;
    let maxSum2 = -Infinity;
    let nowSum1 = 0;
    let nowSum2 = 0;
    
    for(let i = 0; i < sequence.length; i++) {
        const val = sequence[i];
        const nowVal1 = val * (i % 2 === 0 ? 1 : -1);
        const nowVal2 = val * (i % 2 === 0 ? -1 : 1);
        
        nowSum1 = Math.max(nowSum1 + nowVal1, nowVal1, 0);
        nowSum2 = Math.max(nowSum2 + nowVal2, nowVal2, 0);
        
        maxSum1 = Math.max(maxSum1, nowSum1);
        maxSum2 = Math.max(maxSum2, nowSum2);
    }
    
    return Math.max(maxSum1, maxSum2);
}