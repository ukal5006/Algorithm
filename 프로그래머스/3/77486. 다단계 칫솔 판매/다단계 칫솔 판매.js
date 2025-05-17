function solution(enroll, referral, seller, amount) {
    const answer = [];
    const multi = {};
    const money = {};
    const profit = 100;
    const ratio = 0.1
    
    for(let i = 0; i < enroll.length; i++) {
        multi[enroll[i]] = referral[i];
        money[enroll[i]] = 0;
    }
    
    for(let i = 0; i < seller.length; i++) {
        dfs(seller[i], amount[i] * profit);
    }
    
    for(let i = 0; i < enroll.length; i++) {
        answer.push(money[enroll[i]]);
    }
    
    return answer;
    
    
    function dfs(name, earnMoney) {
        const parent = multi[name];
        const parentMoney = Math.floor(earnMoney * ratio);
        money[name] += earnMoney - parentMoney;
        
        if(parentMoney > 0 && parent !== "-") {
            dfs(parent, parentMoney);
        }
        return;
    }
}