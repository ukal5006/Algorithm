function solution(n, results) {
    const resultGraph = Array.from({length : n + 1}, () => Array(n + 1).fill(0));
    let answer = 0;
    
    for(const result of results) {
        const [winner, loser] = result;
        resultGraph[winner][loser] = 1;
        resultGraph[loser][winner] = -1;
    }
    
    for(let k = 1; k <= n; k++) {
        for(let i = 1; i <= n; i++) {
            for(let j = 1; j <= n; j++) {
                if(resultGraph[i][k] === 1 && resultGraph[k][j] === 1) {
                    resultGraph[i][j] = 1;
                    resultGraph[j][i] = -1;
                }
                if(resultGraph[i][k] === -1 && resultGraph[k][j] === -1) {
                    resultGraph[i][j] = -1;
                    resultGraph[j][i] = 1;
                }
            }
        }
    }
    
    for(let i = 1; i <= n; i++) {
        let known = 0;
        
        for(let j = 1; j <= n; j++) {
            if(resultGraph[j][i] !== 0) known++;
        }
        
        if(known === n - 1) answer++;
    }
    
    return answer;
}