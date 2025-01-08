function solution(topping) {
    const map = Array(10001).fill(0);
    let culSet = new Set();
    let dongCnt = 0;
    let answer = 0;
    
    for(let i = 0; i < topping.length; i++) {
        if(map[topping[i]] === 0) {
            dongCnt++;
            map[topping[i]]++;
        }
        else {
            map[topping[i]]++;
        }
    }
    
    console.log(dongCnt);
    
    while(true) {
        const temp = topping.pop();
        culSet.add(temp);
        map[temp]--;
        
        if(map[temp] === 0) dongCnt--;
        
        if(culSet.size === dongCnt) answer++;
        
        else if(culSet.size > dongCnt) break;
    }
    
    return answer;
}