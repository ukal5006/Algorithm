function solution(targets) {
    let answer = 0;
    
    targets.sort((a, b) => a[1] - b[1]);
    
    let shot = -1;
    
    for(let i = 0; i < targets.length; i++) {
        if(targets[i][0] > shot) {
            shot = targets[i][1] - 0.5;
            answer++;
        }
    }
    
    return answer;
}