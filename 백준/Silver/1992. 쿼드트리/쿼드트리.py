# 백준 1992
import sys
input = sys.stdin.readline
N = int(input())

data = [list(input().strip()) for i in range(N)]
result = []

def solution(x,y,N):
  global result
  
  check = data[x][y]

  for i in range(x,x+N):
    

    for j in range(y,y+N):
      if check != data[i][j]:
        result.append('(')
        solution(x,y,N//2)
        solution(x,y+N//2,N//2)
        solution(x+N//2,y,N//2)
        solution(x+N//2,y+N//2,N//2)
        result.append(')')
        return
      
  if check == '0':
    result.append('0')
    return
  else:
    result.append('1')
    return
        


solution(0,0,N)
print("".join(result))
