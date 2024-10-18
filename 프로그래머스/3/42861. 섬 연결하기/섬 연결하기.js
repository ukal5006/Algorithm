function solution(n, costs) {
    const map = Array.from({ length: n }, () => Array(n).fill(Infinity));
    const used = Array(n).fill(false);
    let answer = 0;
    
    // 비용 정보를 인접 행렬 형태로 저장
    for (const [a, b, c] of costs) {
        map[a][b] = c;
        map[b][a] = c;
    }

    // 시작 노드 (0번 섬) 선택
    used[0] = true;
    let edgesUsed = 0;

    while (edgesUsed < n - 1) {
        let minCost = Infinity;
        let minEdge = [-1, -1];

        // 현재 사용된 노드와 연결된 최소 비용 간선 찾기
        for (let i = 0; i < n; i++) {
            if (used[i]) {
                for (let j = 0; j < n; j++) {
                    if (!used[j] && map[i][j] < minCost) {
                        minCost = map[i][j];
                        minEdge = [i, j];
                    }
                }
            }
        }

        // 최소 비용 간선을 사용
        if (minEdge[0] !== -1) {
            const [u, v] = minEdge;
            answer += minCost;
            used[v] = true; // 새로 연결된 노드 마킹
            edgesUsed++;
        }
    }

    return answer;
}
