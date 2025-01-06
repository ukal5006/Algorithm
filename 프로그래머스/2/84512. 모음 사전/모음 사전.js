function solution(word) {
    const strArr = [];
    const map = ["A", "E", "I", "O", "U"];
    let answer = 0;
    
    while(true) {
        if(strArr.length < 5) {
            strArr.push("A");
        }
        
        else {
            const idx = map.indexOf(strArr.pop());
            
            check(strArr, idx);
        }
        
        answer++;
        
        if(word === strArr.join("")) {
            break;
        }
    }
    
    function check(arr, idx) {
        if(idx === 4) {
            const nextIdx = map.indexOf(arr.pop());
            
            check(arr, nextIdx);
        }
        else {
            arr.push(map[idx + 1]);
        }
    }
    
    return answer;
}