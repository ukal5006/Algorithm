function solution(id_list, report, k) {
    const idMap = new Map();
    const userBan = id_list.map((e) => false);
    const reportCnt = id_list.map((e) => 0);
    const reportSet = id_list.map((e) => new Set());
    
    for(let i = 0; i < id_list.length; i++) {
        idMap.set(id_list[i], i);
    }
    
    for(let i = 0; i < report.length; i++) {
        const [user, reported] = report[i].split(" ");
        const idx = getId(user);
        reportSet[idx].add(reported);
    }
    
    for(let i = 0; i < reportSet.length; i++) {
        for(const reported of reportSet[i]) {
            const idx = getId(reported);
            reportCnt[idx]++;
        }
    }
    
    for(let i = 0; i < reportCnt.length; i++) {
        if(reportCnt[i] >= k) userBan[i] = true;
    }
    
    const answer = reportSet.map((e) => {
        let cnt = 0;
        for(const reported of e) {
            const idx = getId(reported);
            if(userBan[idx]) cnt++;
        }
        
        return cnt;
    })
    
    return answer;
    
    function getId(id) {
        return idMap.get(id);
    }
}