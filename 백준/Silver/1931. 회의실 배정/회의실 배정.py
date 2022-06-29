# 백준 1931 그리디

n = int(input())

li = [list(map(int, input().split()))for _ in range(n)]
li = sorted(sorted(li), key = lambda t: t[1])

time = 0
count = 0

for i in li:
  if i[0] >= time:
    time = i[1]
    count += 1

print(count)
