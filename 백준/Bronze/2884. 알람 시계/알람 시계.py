h, m = map(int,input().split())
if m - 45>=0:
  m2 = m- 45
  h2 = h
else:
  m2 = 60+(m-45)
  if h == 0:
    h2 = 23
  else:
    h2 = h - 1  
print("{} {}".format(h2,m2))

