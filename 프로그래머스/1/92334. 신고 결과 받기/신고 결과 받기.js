function solution(id_list, report, k) {
    const userBan = id_list.map((e) => false);
    const reportCnt = id_list.map((e) => 0);
    const reportSet = id_list.map((e) => new Set());
    
    for(let i = 0; i < report.length; i++) {
        const [user, reported] = report[i].split(" ");
        const idx = id_list.indexOf(user);
        reportSet[idx].add(reported);
    }
    
    for(let i = 0; i < reportSet.length; i++) {
        for(const reported of reportSet[i]) {
            const idx = id_list.indexOf(reported);
            reportCnt[idx]++;
        }
    }
    
    for(let i = 0; i < reportCnt.length; i++) {
        if(reportCnt[i] >= k) userBan[i] = true;
    }
    
    const answer = reportSet.map((e) => {
        let cnt = 0;
        for(const reported of e) {
            const idx = id_list.indexOf(reported);
            if(userBan[idx]) cnt++;
        }
        
        return cnt;
    })
    
    return answer;
}