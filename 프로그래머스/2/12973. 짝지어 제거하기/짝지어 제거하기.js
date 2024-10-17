function solution(s) {
    const stack = [];
    for(let char of s) {
        if(stack.length > 0 && stack[stack.length - 1] === char) {
            stack.pop();
        }
        else {
            stack.push(char);
        }
    }
    
    if(stack.length > 0) {
        return 0;
    }
    else {
        return 1;
    }
}