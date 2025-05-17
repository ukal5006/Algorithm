/**
 * @param {string[]} enroll - 등록된 구성원의 이름 배열
 * @param {string[]} referral - 각 구성원을 추천한 사람의 이름 배열 (index는 enroll과 일치, '-'는 추천인이 없음을 의미)
 * @param {string[]} seller - 판매자의 이름 배열
 * @param {number[]} amount - 각 판매자가 판매한 수량 배열 (index는 seller와 일치)
 * @returns {number[]} 각 구성원이 최종적으로 받는 이익 금액 배열 (enroll 순서와 일치)
 */
function solution(enroll, referral, seller, amount) {
    const answer = [];
    const profitPerUnit = 100; // 판매 수량 1개당 이익 금액
    const referralRatio = 0.1; // 추천인에게 분배될 이익 비율

    // 각 구성원이 최종적으로 받을 이익을 저장하는 맵
    const finalProfits = {};
    // 각 구성원을 추천한 사람(부모)을 저장하는 맵 (자식 -> 부모)
    const referralMap = {};

    // 1. 최종 이익 맵 초기화 및 추천인 맵 구성
    // 모든 구성원의 초기 이익은 0으로 설정
    enroll.forEach(name => {
        finalProfits[name] = 0;
    });

    // referral 배열을 바탕으로 자식 -> 부모 추천인 관계 맵 생성
    for (let i = 0; i < enroll.length; i++) {
        referralMap[enroll[i]] = referral[i];
    }

    // 2. 각 판매 건별 이익 분배
    for (let i = 0; i < seller.length; i++) {
        let currentSeller = seller[i]; // 현재 판매자
        let currentProfit = amount[i] * profitPerUnit; // 해당 판매 건으로 발생한 총 이익

        // 현재 판매자부터 시작하여 추천인 체인을 따라 이익 분배
        // 최상위 추천인 '-'에 도달하거나 분배할 이익이 1원 미만이 될 때까지 반복
        while (currentSeller !== '-' && currentProfit > 0) {
            // 부모에게 넘겨줄 이익 (10% 절사)
            const amountToPassUp = Math.floor(currentProfit * referralRatio);
            // 현재 판매자가 가져갈 이익 (나머지 90%)
            const amountToKeep = currentProfit - amountToPassUp;

            // 현재 판매자의 최종 이익에 가져갈 금액을 누적
            finalProfits[currentSeller] += amountToKeep;

            // 다음 루프를 위해 정보를 갱신
            currentProfit = amountToPassUp; // 부모에게 넘겨줄 금액으로 갱신
            currentSeller = referralMap[currentSeller]; // 현재 판매자의 추천인(부모)으로 이동
        }
        // while 루프 종료 후 currentProfit이 0보다 크더라도, 최상위 추천인 '-'에게 가는 금액은
        // 문제 조건에 따라 특정 구성원(enroll)의 최종 수익에 포함되지 않으므로 별도 처리 불필요.
    }

    // 3. enroll 순서대로 최종 이익 배열 생성
    enroll.forEach(name => {
        answer.push(finalProfits[name]);
    });

    return answer;
}
