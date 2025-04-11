function solution(bandage, health, attacks) {
    let hp = health;

    for(let i = 0; i < attacks.length; i++) {
        if(i !== 0) {
            const healTime = attacks[i][0] - attacks[i - 1][0] - 1;
            const heal = healTime * bandage[1] + Math.floor(healTime / bandage[0]) * bandage[2];
            hp = Math.min(hp + heal, health);
        }

        hp -= attacks[i][1];

        if(hp <= 0) return -1;
    }

    return hp;
}