function solution(arr) {
    let answer = 1;
    const length = arr.length;
    for(let i = 0; i < length; i++) {
        if(i === 0) {
            answer *= arr[i];
        }
        
        else {
            let LCM = -1;
            const min = Math.min(answer, arr[i]);
            
            for(let j = min; j > 1; j--) {
                if(answer % j === 0 && arr[i] % j === 0) {
                    LCM = j;
                    break;
                }
            }
            
            if(LCM === -1) {
                answer *= arr[i];
            }
            else {
                answer *= arr[i] / LCM;
            }
        }
    }
    return answer;    
}