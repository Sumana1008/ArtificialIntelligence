Write a program to solve water jug problem. For any values of m,n 
and d; with conditions:
a) m-n=1 and b) d<n
Code:
import java.util.*;
public class Main {
int m = 0; int n = 0;
int m_max = 6; int n_max = 5;
int d = 3;
void checkGoal() {
int fin = 0;
System.out.println("Path from Initial State to Solution State:");
System.out.println();
System.out.println("{" + this.m + "," + this.n + "}");
while(fin != 1)
{
if((this.m == this.d) || (this.n == this.d))
{
fin = 1;
}
if(this.m==0)
{
fillA();
}
else if ((this.m > 0) && (this.n != this.n_max))
{
transferAtoB();
}
else if ((this.m > 0) && (this.n == this.n_max))
{
emptyB();
}
}
}
void fillA() {
this.m = this.m_max;
System.out.println("{" + this.m + "," + this.n + "}");
}
void fillB() {
this.n = this.n_max;
System.out.println("{" + this.m + "," + this.n + "}");
}
void transferAtoB() {
int fin = 0;
while(fin != 1) {
this.n += 1;
this.m -= 1;
if((this.n == this.n_max) || (this.m == 0))
{
fin = 1;
}
}
System.out.println("{" + this.m + "," + this.n + "}");
}
void emptyA() {
this.m=0;
System.out.println("{" + this.m + "," + this.n + "}");
}
void emptyB() {
this.n=0;
System.out.println("{" + this.m + "," + this.n + "}");
}
public static void main(String args[]) {
Main w = new Main();
w.checkGoal();
}
}