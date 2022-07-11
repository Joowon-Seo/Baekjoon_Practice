# 백준 2579
import sys
input = sys.stdin.readline
N = int(input())

dp =[[0,0,0]]+[[int(input()),0 ,0] for i in range(N)]
dp[1][1],dp[1][2] = dp[1][0],dp[1][0]
for i in range(2,N+1):
  dp[i][1] = dp[i][0] + max(dp[i-2][1],dp[i-2][2])
  dp[i][2] = dp[i][0] + dp[i-1][1]
print(max(dp[N]))
