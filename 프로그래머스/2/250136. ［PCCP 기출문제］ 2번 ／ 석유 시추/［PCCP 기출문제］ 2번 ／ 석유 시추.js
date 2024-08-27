function solution(land) {
    const n = land.length; // 세로 길이
    const m = land[0].length; // 가로 길이
    const visited = Array.from({ length: n }, () => Array(m).fill(false));
    const oilClusterSizes = []; // 석유 덩어리 크기와 열 정보 저장

    const directions = [
        [-1, 0], // 위
        [1, 0], // 아래
        [0, -1], // 왼쪽
        [0, 1] // 오른쪽
    ];

    function bfs(i, j) {
        const queue = [[i, j]];
        visited[i][j] = true;
        let size = 0;
        const columns = new Set(); // 이 덩어리가 포함된 열

        while (queue.length > 0) {
            const [x, y] = queue.shift();
            size++;
            columns.add(y); // 현재 열 기록

            for (const [dx, dy] of directions) {
                const nx = x + dx;
                const ny = y + dy;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] === 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.push([nx, ny]);
                }
            }
        }
        return { size, columns: Array.from(columns) }; // 덩어리 크기와 열 정보 반환
    }

    // 모든 석유 덩어리 탐색
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (land[i][j] === 1 && !visited[i][j]) {
                const { size, columns } = bfs(i, j);
                oilClusterSizes.push({ size, columns });
            }
        }
    }

    // 각 열에서 최대 석유량 계산
    const maxOilByColumn = Array(m).fill(0);

    for (const { size, columns } of oilClusterSizes) {
        for (const col of columns) {
            maxOilByColumn[col] += size; // 해당 열에 덩어리 크기 합산
        }
    }

    // 최대 석유량 반환
    return Math.max(...maxOilByColumn);
}
