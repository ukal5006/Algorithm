function solution(dartResult) {
    const map = [0];
    let answer = 0;
    let index = 0;
    
    for(let i = 0; i < dartResult.length; i++) {
        if(!isNaN(dartResult[i])) {
            index++;
            
            if(!isNaN(dartResult[i + 1])) {
                map.push(10);
                i++;
            }
            else {
                map.push(Number(dartResult[i]));
            }
        }
        
        else {
            if(dartResult[i] === "D") {
                map[index] = map[index] ** 2;
            }
            else if(dartResult[i] === "T") {
                map[index] = map[index] ** 3;
            }
            else if(dartResult[i] === "*") {
                map[index - 1] *= 2;
                map[index] *= 2;
            }
            else if(dartResult[i] === "#") {
                map[index] *= -1;
            }
        }
    }
    
    for(let i = 1; i <= index; i++) {
        answer += map[i];
    }
    
    return answer;
}