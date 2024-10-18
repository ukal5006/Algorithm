function solution(n, a, b) {
    let answer = 1;
    
    while(true) {
        const A = Math.ceil(a / 2);
        const B = Math.ceil(b / 2);
        if(A === B) {
            return answer;
        }
        else {
            answer++;
            a = A;
            b = B;
        }
    }
}