function solution(n) {
    const nOneLength = n.toString(2).split("0").join("").length;
    for(let i = n + 1; i <= 1000000; i++) {
        if(nOneLength === i.toString(2).split("0").join("").length) {
            return i;            
        }
    }
}