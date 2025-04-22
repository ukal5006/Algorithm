function solution(storage, requests) {
    const dir = [[-1, 0],[1, 0],[0, -1],[0, 1]];
    const n = storage.length;
    const m = storage[0].length;
    let map = Array.from({length : n + 2}, () => Array(m + 2).fill(0));
    let newMap;
    let answer = n * m;
    
    
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            map[i + 1][j + 1] = storage[i][j];
        }
    }
    
    for(let k = 0; k < requests.length; k++) {
        const cmd = requests[k];
        newMap = map.map((e) => [...e]);
        
        for(let i = 1; i < n + 1; i++) {
            for(let j = 1; j < m + 1; j++) {
                if(map[i][j] === cmd[0]) {
                    move(cmd, i, j);
                }
            }
        }
        map = newMap.map((e) => [...e]);
    }
    
    
    function move(cmd, i, j) {
        if(cmd.length === 2) {
            newMap[i][j] = 1;
            answer--;
        }
        else {
            const used = Array.from({length : n + 2}, () => Array(m + 2).fill(false));
            if(dfs(i, j, used)) {
                answer--;
            }
        }
    }
    
    function dfs(i, j, used) {
        for(let d = 0; d < 4; d++) {
            const nextI = i + dir[d][0];
            const nextJ = j + dir[d][1];
            if(!used[nextI][nextJ] && map[nextI][nextJ] === 0) {
                newMap[i][j] = 0;
                return true;
            }
            if(!used[nextI][nextJ] && map[nextI][nextJ] === 1) {
                used[nextI][nextJ] = true;
                const result = dfs(nextI, nextJ, used);
                
                if(result) {
                    newMap[i][j] = 0;
                    return true;
                }
            }
        }
        
        return false;
    }
    
    return answer;
}

