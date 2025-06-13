function solution(n, s, a, b, fares) {
    const graph = Array.from({length : n + 1}, () => Array(n + 1).fill(Infinity));
    
    for(const [start, end, cost] of fares) {
        graph[start][end] = cost;
        graph[end][start] = cost;    
    }
    
    for(let k = 1; k <= n; k++) {
        for(let i = 1; i <= n; i++) {
            for(let j = 1; j <= n; j++) {
                if(graph[i][j] > graph[i][k] + graph[k][j]) graph[i][j] = graph[i][k] + graph[k][j];
            }
        }
    }
    
    let answer = graph[s][a] + graph[s][b];
    
    for(let i = 1; i <= n; i++) {
        if(i !== s) {
            let costSum = 0;
            costSum += graph[s][i] + graph[i][a] + graph[i][b];
            
            if(i === a) costSum -= graph[a][a];
            
            if(i === b) costSum -= graph[b][b];
            
            answer = Math.min(costSum, answer);
        }
    }
    
    return answer;
}