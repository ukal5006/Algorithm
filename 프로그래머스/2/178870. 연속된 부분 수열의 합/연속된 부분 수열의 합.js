function solution(sequence, k) {
    const len = sequence.length;
    const answer = [0, len - 1];
    let ansLen = len;
    let l = 0;
    let r = 0;
    let sum = sequence[0];
    
    while(r < len) {
        if(sum === k) {
            const nowLen = r - l + 1;
            
            if(ansLen > nowLen) {
                answer[0] = l;
                answer[1] = r;
                ansLen = nowLen;
            }
            
            sum -= sequence[l];
            l++;
        }
        else if(sum < k) {
            r++;
            sum += sequence[r];
        }
        else {
            sum -= sequence[l];
            l++;
        }
    }
    
    return answer;
}