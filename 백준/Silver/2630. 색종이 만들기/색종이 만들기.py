# 백준 2630
import sys
input = sys.stdin.readline
N = int(input())

data = [list(map(int, input().split())) for i in range(N)]

blue_cnt = 0
white_cnt = 0
def solution(data,N):
  global blue_cnt
  global white_cnt
  s = 0
  for i in data:
    s += sum(i)

  if s == N**2:
    blue_cnt += 1
    return
  elif  s == 0:
    white_cnt += 1
    return

  else:
    data_1 = []
    data_2 = []
    data_3 = []
    data_4 = []

    for i in range(N):
      if i < N//2:
        data_1.append(data[i][:N//2])
        data_2.append(data[i][N//2:])
      else:
        data_3.append(data[i][:N//2])
        data_4.append(data[i][N//2:])
    N //= 2
    solution(data_1,N)
    solution(data_2,N)
    solution(data_3,N)
    solution(data_4,N)


solution(data,N)
print(white_cnt)
print(blue_cnt)

