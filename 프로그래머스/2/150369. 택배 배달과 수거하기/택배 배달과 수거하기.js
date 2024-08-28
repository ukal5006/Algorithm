function solution(cap, n, deliveries, pickups) {
    var answer = 0;
    
    var delIdx = n - 1;
    var pickIdx = n - 1;
    
    var delArr = [];
    var pickArr = [];
    
    var diff;
    
    while(delIdx > -1) {
        for(var i = cap; i > 0;) {
            if(deliveries[delIdx] != 0) {
                if(i == cap) {
                    delArr.push(delIdx + 1);
                    deliveries[delIdx]--
                    i--
                }
                else {
                    deliveries[delIdx]--
                    i--
                }
            }
            else {
                delIdx--
            }
            if(delIdx < 0) break;
        }
    }
    while(pickIdx > -1) {
        for(var i = cap; i > 0;) {
            if(pickups[pickIdx] != 0) {
                if(i == cap) {
                    pickArr.push(pickIdx + 1);
                    pickups[pickIdx]--
                    i--
                }
                else {
                    pickups[pickIdx]--
                    i--
                }
            }
            else {
                pickIdx--
            }
            if(pickIdx < 0) break;
        }
    }
    if(delArr.length == pickArr.length) {
        for(var i = 0; i < delArr.length; i++) {
            answer += Math.max(delArr[i], pickArr[i]) * 2
        }
    }
    else if(delArr.length > pickArr.length) {
        diff = delArr.length - pickArr.length;
        for(var i = 0; i < delArr.length - diff; i++) {
            answer += Math.max(delArr[i], pickArr[i]) * 2
        }
        for(var i = delArr.length - diff; i < delArr.length; i++) {
            answer += delArr[i] * 2;
        }
    }
    else {
        diff = pickArr.length - delArr.length;
        for(var i = 0; i < pickArr.length - diff; i++) {
            answer += Math.max(delArr[i], pickArr[i]) * 2
        }
        for(var i = pickArr.length - diff; i < pickArr.length; i++) {
            answer += pickArr[i] * 2;
        }
    }
    return answer;
}