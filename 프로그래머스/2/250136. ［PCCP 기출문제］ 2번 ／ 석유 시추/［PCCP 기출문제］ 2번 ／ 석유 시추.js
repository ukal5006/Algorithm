function solution(land) {
    const newLand = land.map((e) => e.map((e2) => e2));
    const oilMap = [];
    const dir = [[-1, 0], [1, 0], [0, -1], [0, 1]];
    const n = land.length;
    const m = land[0].length;
    let idx = 1;
    let answer = 0;

    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            if(newLand[i][j] === 1) bfs(i, j);
        }
    }

    for(let i = 0; i < m; i++) {
        const oilSet = new Set();
        let oilSum = 0;

        for(let j = 0; j < n; j++) {
            if(land[j][i] > 0) oilSet.add(land[j][i]);
        }

        for(const oil of oilSet) {
            oilSum += oilMap[oil - 1];
        }

        answer = Math.max(oilSum, answer);
    }

    return answer;

    function bfs(i, j) {
        const queue = [[i, j]];
        let sumOil = 0;

        newLand[i][j] = 0;
        land[i][j] = idx;
        sumOil++;

        while(queue.length > 0) {
            const [nowI, nowJ] = queue.shift();
            

            for(let d = 0; d < 4; d++) {
                const nextI = nowI + dir[d][0];
                const nextJ = nowJ + dir[d][1];

                if(nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < m && newLand[nextI][nextJ] === 1) {
                    queue.push([nextI, nextJ]);
                    newLand[nextI][nextJ] = 0;
                    land[nextI][nextJ] = idx;
                    sumOil++;
                }
            }
        }

        oilMap.push(sumOil);
        idx++;
    }
}