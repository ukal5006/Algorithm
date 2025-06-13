function solution(n, results) {
    const resultGraph = Array.from({length : n + 1}, () => Array(n + 1).fill(0));
    let answer = 0;
    
    for(const result of results) {
        const [winner, loser] = result;
        resultGraph[winner][loser] = 1;
        resultGraph[loser][winner] = -1;
    }
    
    for(let i = 1; i <= n; i++) {
        for(let j = 1; j <= n; j++) {
            if(i !== j && resultGraph[i][j] !== 0) {
                bfs(i, j, resultGraph[i][j]);
            }
        }
    }
    
    
    for(let i = 1; i <= n; i++) {
        if(check(i)) answer++;
    }
    
    return answer;
    
    
    function bfs(me, target, value) {
        const queue = [target];
        const visited = Array(n + 1).fill(false);
        visited[target] = true;
        
        while(queue.length > 0) {
            const nowTarget = queue.shift();
            
            for(let i = 1; i <= n; i++) {
                if(!visited[i] && resultGraph[nowTarget][i] === value) {
                    resultGraph[me][i] = value;
                    resultGraph[i][me] = value * -1;
                    visited[i] = true;
                    
                    queue.push(i);
                }
            }
        }
    }
    
    function check(i) {
        let winCount = 0;
        
        for(let j = 1; j <= n; j++) {
            if(i !== j) {
                if(resultGraph[i][j] === 1) winCount++;
                else if(resultGraph[i][j] === 0) return false;
            }
        }
        
        return true;
    }
    
    
}