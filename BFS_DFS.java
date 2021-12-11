Write a program to search en element using Breadth First Search:
Code:
import java.util.*;
public class Main {
private int V;
private LinkedList<Integer> adj[];
private Queue<Integer> queue;
Main(int v)
{
V = v;
adj = new LinkedList[v];
for (int i=0; i<v; i++)
{
adj[i] = new LinkedList<>(); }
queue = new LinkedList<Integer>(); }
void addEdge(int v,int w)
{
adj[v].add(w);
}
void BFS(int n)
{
boolean nodes[] = new boolean[V]; int
a = 0;
nodes[n]=true;
queue.add(n);
while (queue.size() != 0)
{
n = queue.poll();
System.out.print(n+" ");
for (int i = 0; i < adj[n].size(); i++) {
a = adj[n].get(i);
if (!nodes[a])
{
nodes[a] = true;
queue.add(a);
}
}
}
}
public static void main(String args[])
{
Main graph = new Main(19);
graph.addEdge(1,4);
graph.addEdge(1,7);
graph.addEdge(1,8);
graph.addEdge(8,2);
graph.addEdge(8,7);
graph.addEdge(8,9);
graph.addEdge(6,10);
graph.addEdge(6,7);
graph.addEdge(2,9);
System.out.println("The Breadth First Traversal of the graph is as follows :");
graph.BFS(1);
}
}

Depth First Search:
Code:
import java.util.*;
class Main
{
int V;
LinkedList<Integer>[] adj;
Main(int V)
{
this.V = V;
adj = new LinkedList[V];
for (int i = 0; i < adj.length; i++) adj[i] =
new LinkedList<Integer>();
}
void addEdge(int v, int w)
{
adj[v].add(w);
}
void DFS(int n)
{
boolean nodes[] = new boolean[V];
Stack<Integer> stack = new Stack<>();
stack.push(n);
int a = 0;
while(!stack.empty())
{
n = stack.peek();
stack.pop();
if(nodes[n] == false)
{
System.out.print(n + " "); nodes[n]
= true;
}
for (int i = 0; i < adj[n].size(); i++) {
a = adj[n].get(i);
if (!nodes[a])
{
stack.push(a);
}
}
}
}
public static void main(String[] args)
{
Main g = new Main(6);
g.addEdge(0, 2);
g.addEdge(0, 1);
g.addEdge(1, 0);
g.addEdge(1, 5);
g.addEdge(2, 0);
g.addEdge(2, 3);
g.addEdge(3, 4);
g.addEdge(3, 2);
g.addEdge(4, 3);
g.addEdge(5, 3);
System.out.println("The Depth First Traversal of the graph is ");
g.DFS(0);
}
}