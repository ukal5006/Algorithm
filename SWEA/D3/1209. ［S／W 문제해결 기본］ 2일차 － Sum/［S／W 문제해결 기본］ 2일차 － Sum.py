T = 10
for test_case in range(1, 11):
    a = int(input())
    arr = []
    answer = 0
    for i in range(100):
        temp_arr = list(map(int, input().split()))
        arr_sum = sum(temp_arr)
        if arr_sum > answer:
            answer = arr_sum
        arr.append(temp_arr)

    for i in range(100):
        temp_sum = 0
        for j in range(100):
            temp_sum += arr[j][i]
        if temp_sum > answer:
            answer = temp_sum

    temp_sum = [0,0]
    for i in range(100):
        temp_sum[0] += arr[i][i]
        temp_sum[1] += arr[i][99-i]
    if max(temp_sum) > answer:
        answer = max(temp_sum)
    print(f"#{test_case} {answer}")

