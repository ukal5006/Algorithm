function solution(maps) {
    const dir = [[-1, 0], [1, 0], [0, -1], [0, 1]];
    const n = maps.length;
    const m = maps[0].length;
    const used = Array.from({length : n}, () => Array(m).fill(false));
    let answer = -1;
    bfs();
    return answer;
    function bfs() {
        const queue = [[0, 0, 0]];
        while(queue.length > 0) {
            const now = queue.shift();
            if(now[0] === n - 1 && now[1] === m - 1) {
                answer = now[2] + 1;
                return;
            }
            for(let d = 0; d < 4; d++) {
                const nowI = now[0] + dir[d][0];
                const nowJ = now[1] + dir[d][1];
                if(nowI >= 0 && nowI < n && nowJ >= 0 && nowJ < m && maps[nowI][nowJ] && !used[nowI][nowJ]) {
                    used[nowI][nowJ] = true;
                    queue.push([nowI, nowJ, now[2] + 1]);
                }
            }
        }
        
    }
    
    
    return answer;
}