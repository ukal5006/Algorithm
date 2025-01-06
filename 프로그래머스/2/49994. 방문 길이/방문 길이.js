function solution(dirs) {
    const dir = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    const visitedI = Array.from({length : 11}, () => Array(11).fill(false));
    const visitedJ = Array.from({length : 11}, () => Array(11).fill(false));
    let i = 5;
    let j = 5;
    let answer = 0;
    
    for(let d = 0; d < dirs.length; d++) {
        [i, j] = check(i , j, dirs[d]);
    }
    
    return answer;
    
    function check(i, j, command) {
        let direct = -1;
        
        if(command === "U") {
            direct = 0;    
        }
        else if(command === "D") {
            direct = 1;    
        }
        else if(command === "R") {
            direct = 2;    
        }
        else if(command === "L") {
            direct = 3;    
        }
        
        const nextI = i + dir[direct][0];
        const nextJ = j + dir[direct][1];
        
        if(nextI >= 0 && nextI <= 10 && nextJ >= 0 && nextJ <= 10) {
            if(nextI === i) {
                if(!visitedJ[nextI][Math.min(nextJ, j)]) {
                    answer++;
                    visitedJ[nextI][Math.min(nextJ, j)] = true;
                }
            }
            else {
                if(!visitedI[Math.min(nextI, i)][nextJ]) {
                    answer++;
                    visitedI[Math.min(nextI, i)][nextJ] = true;
                }
            }
            
            return [nextI, nextJ];
        }
        else {
            return [i, j];
        }
    }
    
    
    return answer;
}