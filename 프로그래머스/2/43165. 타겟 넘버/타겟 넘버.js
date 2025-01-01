function solution(numbers, target) {
    let answer = 0;
    let length = numbers.length;
    
    function dfs(idx, nowValue) {
        if(idx === length) {
            if(nowValue === target) answer++;
            return;
        }
        
        dfs(idx + 1, nowValue + numbers[idx]);
        dfs(idx + 1, nowValue - numbers[idx]);
    }
    
    dfs(0, 0);
    
    return answer;
}