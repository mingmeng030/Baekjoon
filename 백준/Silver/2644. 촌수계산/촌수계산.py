import sys
from collections import deque

#input
n = int(input())
a, b = map(int, input().split())
m = int(input())
family = [list(map(int, sys.stdin.readline().split()))for _ in range(m)]

#방문확인
visit = [-1] * (n+1)
visit[a] = 0

#양방향 그래프 생성
graph = {i:[] for i in range(1, n+1)}
for x, y in family:
    graph[x].append(y)
    graph[y].append(x)

#BFS
def bfs(a):

    Q = deque([a])
    while(Q):
        node = Q.popleft()
        for n in graph[node]:
            if visit[n] == -1:
                Q.append(n)
                visit[n] = visit[node] + 1

#DFS
def dfs(node):

    for n in graph[node]:
        if visit[n] == -1:
            visit[n] = visit[node] + 1
            dfs(n)

bfs(a)
# dfs(a)
print(visit[b])