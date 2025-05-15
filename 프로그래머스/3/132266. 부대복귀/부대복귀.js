function solution(n, roads, sources, destination) {
    const answer = [];
    const roadMap = new Map();
    const minTimeMap = new Map();
    
    for(let i = 0; i < roads.length; i++) {
        const [x, y] = roads[i];
        if(!roadMap.has(x)) {
            roadMap.set(x, new Set());
        }
        roadMap.get(x).add(y);  
        
        if(!roadMap.has(y)) {
            roadMap.set(y, new Set());
        }
        roadMap.get(y).add(x); 
    }
    
    bfs(destination);
    
    for(let i = 0; i < sources.length; i++) {
        const time = minTimeMap.get(sources[i]);
        
        if(time !== undefined) {
            answer.push(time);
        }
        else {
            answer.push(-1);
        }
    }
    
    return answer;
    
    function bfs(des){
        const visited = new Array(n + 1).fill(false);
        const queue = [[des, 0]];
        minTimeMap.set(des, 0);
        visited[des] = true;
        
        while(queue.length > 0) {
            const [pos, time] = queue.shift();
            
            for(const linked of roadMap.get(pos)) {
                if(!visited[linked]) {
                    minTimeMap.set(linked, time + 1);
                    visited[linked] = true;
                    queue.push([linked, time + 1]);
                }
            }
        }
    }
}