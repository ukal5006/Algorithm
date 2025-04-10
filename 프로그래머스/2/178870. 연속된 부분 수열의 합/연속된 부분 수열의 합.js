function solution(sequence, k) {
    const len = sequence.length;
    const answer = [0, len];
    let sum = sequence[0];
    let l = 0;
    let r = 0;
    
    while(r < len) {
        if(sum === k) {
            if(answer[1] - answer[0] > r - l) {
                answer[0] = l;
                answer[1] = r;
            }
            
            sum -= sequence[l];
            l++;
            r++;
            sum += sequence[r];
        }
        else if(sum > k) {
            sum -= sequence[l];
            l++;
        }
        else {
            r++;
            sum += sequence[r];
        }
    }
    
    return answer;
}