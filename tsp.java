1.CREATE NXN ENVIRONMENT GENERATE THE LOCATIONS OF N CITIES THERE.FIND THE SOLUTION OF TSP.
Travelling Sales Problem: 
Code: 
import java.io.*; 
import java.util.*; 
public class Main{ 
static int tspdp(int c[][], int tour[], int start, 
int n) 
{ 
int mintour[] = new int[10], temp[] = new int[10], 
mincost = 999, ccost, i, j, k; 
if (start == n - 1) 
{ 
return (c[tour[n - 1]][tour[n]] 
+ c[tour[n]][1]); 
} 
for (i = start + 1; i <= n; i++) 
{ 
for (j = 1; j <= n; j++) 
temp[j] = tour[j]; 
temp[start + 1] = tour[i]; 
temp[i] = tour[start + 1]; 
if ((c[tour[start]][tour[i]]
+ (ccost = tspdp(c, temp, start + 1, n))) < mincost) 
{ 
mincost = c[tour[start]][tour[i]] + ccost; for (k = 1; k <= n; k++) 
mintour[k] = temp[k]; 
} 
} 
for (i = 1; i <= n; i++) 
tour[i] = mintour[i]; 
return mincost; 
} 
public static void main(String[] args) { 
Scanner in = new Scanner(System.in); int c[][] = new int[10][10], tour[] = new int[10]; int i, j, cost; 
System.out.print("Enter No. of Cities: "); int n = in.nextInt(); 
if (n == 1) { 
System.out.println("Path is not possible!"); System.exit(0); 
} 
System.out.println("Enter the Cost Matrix:"); for (i = 1; i <= n; i++) 
for (j = 1; j <= n; j++) 
c[i][j] = in.nextInt();
for (i = 1; i <= n; i++) 
tour[i] = i; 
cost = tspdp(c, tour, 1, n); 
System.out.print("The Optimal Tour is: "); 
for (i = 1; i <= n; i++) 
System.out.print(tour[i] + "->"); 
System.out.println("1"); 
System.out.println("Minimum Cost: " + cost); 
} 
} 

2.Find the optimal path between between the two farthest cities with A* search
TSP USING A* SEARCH:
import java.util.*;
public class Main {
static void findMinRoute(int[][] tsp)
 {
 int sum = 0;
 int counter = 0;
 int j = 0, i = 0;
 int min = Integer.MAX_VALUE;
 List<Integer> visitedRouteList = new ArrayList<>();
 visitedRouteList.add(0);
 int[] route = new int[tsp.length];
 while (i < tsp.length && j < tsp[i].length) {
 if (counter >= tsp[i].length - 1) {
 break;
 }
 if (j != i
 && !(visitedRouteList.contains(j))) {
 if (tsp[i][j] < min) {
 min = tsp[i][j];
 route[counter] = j + 1;
 }
 }
 j++;
 if (j == tsp[i].length) {
 sum += min;
 min = Integer.MAX_VALUE;
 visitedRouteList.add(route[counter] - 1);
 j = 0;
 i = route[counter] - 1;
 counter++;
 }
 }
 i = route[counter - 1] - 1;
 for (j = 0; j < tsp.length; j++) {
 if ((i != j) && tsp[i][j] < min) {
 min = tsp[i][j];
 route[counter] = j + 1;
 }
 }
 sum += min;
 System.out.print("Minimum Cost is : ");
 System.out.println(sum);
 }
 static int tspdp(int c[][], int tour[], int start, int n)
 {
 int mintour[] = new int[10], temp[] = new int[10],
 mincost = 999, ccost, i, j, k;
 if (start == n - 1)
 {
 return (c[tour[n - 1]][tour[n]]
 + c[tour[n]][1]);
 }
 for (i = start + 1; i <= n; i++)
 {
 for (j = 1; j <= n; j++)
 temp[j] = tour[j];
 temp[start + 1] = tour[i];
 temp[i] = tour[start + 1];
 if ((c[tour[start]][tour[i]]
 + (ccost = tspdp(c, temp, start + 1, n)))
 < mincost)
 {
 mincost = c[tour[start]][tour[i]] + ccost;
 for (k = 1; k <= n; k++)
 mintour[k] = temp[k];
 }
 }
 for (i = 1; i <= n; i++)
 tour[i] = mintour[i];
 return mincost;
 }
 public static void main(String[] args)
 {
 Scanner in = new Scanner(System.in);
 int c[][] = new int[15][15], tour[] = new int[15];
 int i,j, cost;
 System.out.print("Enter No. of Cities: ");
 int n = in.nextInt();
 System.out.print("Enter Co-ordinates (x,y) where x,y < 15");
 int[] x = new int[n];
 int[] y = new int[n];
 for(int p=0; p<n; p++)
 { 
 System.out.println("Enter x"+(p+1));
 x[p]=in.nextInt();
 System.out.println("Enter x"+(p+1));
 y[p]=in.nextInt();
 }
 System.out.print("Enter initial City ( 1 ");
for(i=2;i<=n;i++){
 System.out.print("/ "+i+" ");
}
 System.out.println(")");
int ini=in.nextInt();
 System.out.print("Enter Final City ( 1 ");
for(i=2;i<=n;i++){
 System.out.print("/ "+i+" ");
}
 System.out.println(")");
 int fin=in.nextInt();
 System.out.println("Enter initial City");
 if (n == 1) {
 System.out.println("Path is not possible!");
 System.exit(0);
 }
 int xsqr=0,ysqr=0;
 for (i = 0; i < n; i++){
 for ( j = 0; j < n; j++){
 xsqr=(x[i]-x[j])*(x[i]-x[j]);
 ysqr=(y[i]-y[j])*(y[i]-y[j]);
 int sunsqr=xsqr+ysqr;
 double result;
 result = Math.sqrt(sunsqr);
 c[i][j] = (int)result;
 }
 }
 int K=1;
 int L=ini;
 for (i = 0; i < c[0].length; i++) {

 // Swap two numbers
 int temp = c[K - 1][i];
 c[K - 1][i] = c[L - 1][i];
 c[L - 1][i] = temp;
 }
 K=n;
 L=fin;
 for (i = 0; i < c[0].length; i++) {

 // Swap two numbers
 int temp = c[K - 1][i];
 c[K - 1][i] = c[L - 1][i];
 c[L - 1][i] = temp;
 }
 for (i = 1; i <= n; i++){
 tour[i] = i;
 }
 cost = tspdp(c, tour, 1, n);
 System.out.print("The Optimal Tour is: ");
 System.out.println("1");
 System.out.println("Minimum Cost: " + cost);
 findMinRoute(c);
 for (i = 1; i <= n; i++){
 System.out.print(tour[i] + "->");
 }
}
}

