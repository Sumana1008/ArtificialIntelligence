Topic: Coordination Game
Code:
import java.util.*;
public class Main
{
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
//choose what the top one should be minimizer or maximizer ?
System.out.println("Please enter the value on top E or O: ");
String str = sc.next();
// enter no. of fingers
System.out.println("no of fingers you need: ");
int n = sc.nextInt();
ArrayList<ArrayList<Integer>> list = new
ArrayList<ArrayList<Integer>>();
ArrayList<Integer> sub_list = new ArrayList<Integer>();
for(int i = 1; i <= n; i++){
for(int j = 1; j <= n; j++){
int num = i+j;
if(num % 2 == 0){
sub_list.add(num);
}else{
num = 'a' - (num+97);
sub_list.add(num);
}
//num = 0;
}
list.add(sub_list);
}
ArrayList<Integer> list1 = new ArrayList<Integer>();
if(str.equals("E")){
int opt_x = 0;
int opt_y = 0;
for(int i = 0; i < n; i++){
int min = list.get(i).get(0);
for(int j = 1; j < n; j++){
int num = list.get(i).get(j);
if(num < min){
min = num;
opt_y = j;
}
}
list1.add(min);
}
int max = list1.get(0);
for(int i = 1; i < n; i++){
int num = list1.get(i);
if(num > max){
max = num;
opt_x = i;
}
}
System.out.println("The optimal value is: " + max);
System.out.println("The optimal path is: " + opt_x + " " +
opt_y);
}
if(str.equals("O")){
int opt_x1 = 0;
int opt_y1 = 0;
for(int i = 0; i < n; i++){
int max = list.get(i).get(0);
for(int j = 1; j < n; j++){
int num = list.get(i).get(j);
if(num > max){
max = num;
opt_y1 = j;
}
}
list1.add(max);
}
int min = list1.get(0);
for(int i = 1; i < n; i++){
int num = list1.get(i);
if(num < min){
min = num;
opt_x1 = i;
}
}
System.out.println("The optimal value is: " + min);
System.out.println("The optimal path is: " + opt_x1 + " " +
opt_y1);
}
}
}
