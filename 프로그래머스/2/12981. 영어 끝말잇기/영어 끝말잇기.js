function solution(n, words) {
    const set = new Set();
    const length = words.length;
    let answer = [];
    
    for(let i = 0; i < length; i++) {
        if(i === 0) {
            set.add(words[i]);
        }
        else {
            const nowSize = set.size;
            
            if(words[i - 1].slice(-1) !== words[i][0]) {
                let a = i % n + 1;
                let b = Math.floor(i / n) + 1;
                
                return [a, b];
            }
            set.add(words[i]);
            
            
            if(nowSize === set.size) {
                let a = i % n + 1;
                let b = Math.floor(i / n) + 1;
                
                return [a, b];
            }
        }
    }
    
    return [0, 0];
    
}