function solution(n, info) {
    let score = 0;
    let answer = [-1];
    let array = Array.from({length : 11}, () => 0);
    
    dfs(array, n, 0);
    
    return answer;
    
    function dfs(shotArray, leftArrow, idx) {
        let nowArray = [...shotArray];
        if(leftArrow === 0 || idx === 10) {
            if(leftArrow > 0) {
                nowArray[10] += leftArrow;
            }
            
            let nowScore = 0;
            
            for(let i = 0; i < 10; i++) {
                if(info[i] === 0 && nowArray[i] === 0) {
                    continue;
                }
                
                if(nowArray[i] > info[i]) {
                        nowScore += 10 - i;
                    }
                    else {
                        nowScore -= 10 - i;
                    }
            }
            
            if(nowScore >= score && nowScore > 0) {
                if(nowScore > score) {
                    answer = [...nowArray];
                    score = nowScore;
                }
                else {
                    answer = compare(answer, nowArray)
                }
            }
            
            return;
        }
        
        if(leftArrow > info[idx]) {
            nowArray[idx] = info[idx] + 1;
            dfs([...nowArray], leftArrow - nowArray[idx], idx + 1);
        }
        
        dfs([...shotArray], leftArrow, idx + 1);
    }
    
    function compare(arr1, arr2) {
        for(let i = 10; i >= 0; i--) {
            if(arr1[i] > arr2[i]) {
                return arr1;
            }
            else if(arr2[i] > arr1[i]) {
                return arr2;
            }
        }
        
        return arr1;
    }
}