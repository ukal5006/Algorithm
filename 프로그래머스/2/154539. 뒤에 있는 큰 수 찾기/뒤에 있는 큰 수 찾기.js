function solution(numbers) {
    const len = numbers.length;
    let answer = Array(len).fill(-1);
    let stack = [];

    for (let i = 0; i < len; i++) {
        while (stack.length > 0 && numbers[stack[stack.length - 1]] < numbers[i]) {
            answer[stack.pop()] = numbers[i];
        }
        stack.push(i);
    }

    return answer;
}