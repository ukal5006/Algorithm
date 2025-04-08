function solution(users, emoticons) {
    const discount = [10, 20, 30, 40];
    const answer = [-1, -1];
    
    dfs([]);
    
    return answer;
    
    function dfs(arr) {
        if(arr.length === emoticons.length) {
            const result = cal(arr);
            
            if(answer[0] < result[0]) {
                answer[0] = result[0];
                answer[1] = result[1];
            }
            else if(answer[0] === result[0] && answer[1] < result[1]) {
                answer[1] = result[1];
            }
            return;
        }
        
        for(let i = 0; i < 4; i++) {
            dfs([...arr, discount[i]]);
        }
    }
    
    function cal(arr) {
        let member = 0;
        let money = 0;
        
        for(let i = 0; i < users.length; i++) {
            let sum = 0;
            
            for(let j = 0; j < emoticons.length; j++) {
                if(users[i][0] <= arr[j]) sum += emoticons[j] * (100 - arr[j]) / 100;
            }
            
            if(sum >= users[i][1]) member++;
            else money += sum;
        }
        return [member, money];
    }
}