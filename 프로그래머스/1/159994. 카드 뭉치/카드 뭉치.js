function solution(cards1, cards2, goal) {
    while(goal.length > 0) {
        if(cards1[0] === goal[0]) {
            cards1.shift();
            goal.shift();
        }
        else if(cards2[0] === goal[0]) {
            cards2.shift();
            goal.shift();
        }
        else {
            break;
        }
    }
    
    if(goal.length === 0) {
        return "Yes";
    }
    else return "No";
}