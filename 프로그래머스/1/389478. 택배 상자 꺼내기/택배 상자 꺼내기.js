function solution(n, w, num) {
    const row = Math.ceil(n / w);
    const arr = Array.from({length : row}, () => Array(w).fill(0));
    let boxNum = 1;
    let findCan = -1;
    let answer = 1;
    
    for(let i = 0; i < row; i++) { // 상자 쌓기
        if(i % 2 === 0) { // 짝수 줄이면
            for(let j = 0; j < w; j++) { // 방향을 오른쪽으로 쌓기
                if(boxNum === num) findCan = j; // 위치한 칸 기억
                
                arr[i][j] = boxNum;
                boxNum++;
                if(boxNum > n) break; // 쌓는 박스 번호가 n보다 커지면 break
            }
        }
        else { // 홀수 줄이면
            for(let j = w - 1; j >= 0; j--) { // 방향을 왼쪽으로 쌓기
                if(boxNum === num) findCan = j; // 위치한 칸 기억    
                
                arr[i][j] = boxNum;
                boxNum++;
                if(boxNum > n) break; // 쌓는 박스 번호가 n보다 커지면 break
            }
        }
    }
    
    for(let i = row - 1; i >= 0; i--) { // 제일 윗줄부터 찾기
        if(arr[i][findCan] !== 0) { // 해당 줄에 박스 없는 경우가 아니면
            if(arr[i][findCan] !== num) answer++; // 찾는 박스 번호가 아니라면 answer + 1
            else break; // 찾으면 break;
        }
    }
    
    return answer;
    
}