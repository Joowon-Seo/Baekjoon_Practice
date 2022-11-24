# 백준 11047 그리디
N, K = map(int, input().split())
li = sorted([int(input())for _ in range(N)], reverse=True)
count = 0
for i in li:
  count += K//i
  K %= i

print(count)