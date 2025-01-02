function solution(k, dungeons) {
    let answer = 0;
    let length = dungeons.length;
    const used = Array(length).fill(false);
    
    bfs(0, []);
    
    return answer;
    
    function bfs(cnt, arr) {
        if(cnt === length) {
            let temp = 0;
            let health = k;
            
            for(let i = 0; i < length; i++) {
                if(health >= dungeons[arr[i]][0]) {
                    temp++;
                    health -= dungeons[arr[i]][1];
                }
            }
            answer = Math.max(temp, answer);
            
            return;
        }
        
        for(let i = 0; i < length; i++) {
            if(used[i] === false) {
                used[i] = true;
                bfs(cnt + 1, [...arr, i]);
                used[i] = false;
            }
        }
    }
}