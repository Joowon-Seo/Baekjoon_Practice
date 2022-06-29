# 백준 11399 그리디
n = int(input())
li = list(map(int, input().split()))
li.sort()
allTime = 0
for i in range(n):
  allTime += sum(li[0:i+1])

print(allTime)

