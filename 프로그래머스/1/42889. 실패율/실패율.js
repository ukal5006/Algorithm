function solution(N, stages) {
    const map = [];
    let member = 0;
    
    for(let i = 1; i <= N; i++) {
        map.push([i, 0, 0]);
    }
    
    for(let i = 0; i < stages.length; i++) {
        const blockStage = stages[i];
        if(blockStage === N + 1) {
            member++;
        }
        else {
            map[blockStage - 1][1]++;
        }
    }
    
    for(let i = N - 1; i >= 0; i--) {
        if(member === 0 && map[i][1] === 0) {
            map[i][2] = 0;
        }
        else {
            member += map[i][1];
            map[i][2] = map[i][1] / member;
        }
    }
    
    map.sort((a, b) => {
        if(a[2] === b[2]) return a[0] - b[0];
        else return b[2] - a[2];
    })
    
    return map.map((e) => e[0]);
}