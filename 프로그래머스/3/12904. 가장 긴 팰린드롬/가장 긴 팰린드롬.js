function solution(s) {
    const len = s.length;
    
    if(len < 2) return 1;
    
    let answer = 1;
    let mid = 0;
    
    while(mid <= len - 2) {
            if(s[mid] === s[mid + 1]) {
                const maxI = Math.min(mid, len - mid - 2);
                let nowLen = 2;
                
                for(let i = 1; i <= maxI; i++) {
                    if(s[mid - i] === s[mid + i + 1]) {
                        nowLen += 2;
                        continue;
                    }
                    
                    break;
                }
                
                answer = Math.max(answer, nowLen)
            }
                const maxI = Math.min(mid, len - mid - 1);
                let nowLen = 1;
                
                for(let i = 1; i <= maxI; i++) {
                    if(s[mid - i] === s[mid + i]) {
                        nowLen += 2;
                        continue;
                    }
                    
                    break;
                }
                
                answer = Math.max(answer, nowLen)
        
        mid++;
    }
    
    return answer;
}