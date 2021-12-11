TOWERS OF HANOI:
CODE:
import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter no.of disks: ");
int n = sc.nextInt();
towerOfHanoi(n,'A','C', 'B');
}
static void towerOfHanoi(int n, char from_rod, char to_rod, char helper_rod)
{
if (n == 1)
{
System.out.println("Take disk 1 from rod " + from_rod + " to rod " + to_rod);
return;
}
towerOfHanoi(n-1, from_rod, helper_rod, to_rod);
System.out.println("Take disk " + n + " from rod " + from_rod + " to rod " + to_rod);
towerOfHanoi(n-1, helper_rod, to_rod, from_rod);
}
}

MAP COLOURING PROBLEM:
CODE:
import java.util.*;
import java.util.Scanner;
public class Main
{
private int V, numOfColors;
private int[] color;
private int[][] graph;
public void graphColor(int[][] g, int noc)
{
V = g.length;
numOfColors = noc;
color = new int[V];
graph = g;
try
{
solve(0);
System.out.println("No solution");
}
catch (Exception e)
{
System.out.println("\nSolution exists ");
display();
}
}
public void solve(int v) throws Exception
{
if (v == V)
throw new Exception("Solution found");
for (int c = 1; c <= numOfColors; c++)
{
if (isPossible(v, c))
{
color[v] = c;
solve(v + 1);
color[v] = 0;
}
}
}
public boolean isPossible(int v, int c)
{
for (int i = 0; i < V; i++)
if (graph[v][i] == 1 && c == color[i])
return false;
return true;
}
public void display()
{
System.out.print("\nColors : ");
for (int i = 0; i < V; i++)
System.out.print(color[i] +" ");
System.out.println();
}
public static void main (String[] args)
{
Scanner scan = new Scanner(System.in);
System.out.println("Map Colouring Problem\n");
Main gc = new Main();
System.out.print("Enter number of vertices: ");
int V = scan.nextInt();
System.out.println("\nEnter matrix:\n");
int[][] graph = new int[V][V];
for (int i = 0; i < V; i++)
for (int j = 0; j < V; j++)
graph[i][j] = scan.nextInt();
System.out.print("\nEnter number of colors: ");
int c = scan.nextInt();
gc.graphColor(graph, c);
}
}