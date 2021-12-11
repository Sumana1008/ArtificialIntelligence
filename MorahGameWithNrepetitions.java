Design an algorithm and code it for two finger Morah game with n repetitions.

CODE:
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n:");
        int n = sc.nextInt();


        int a[][][][] = new int[n][n][n][n];

        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    for (int l = 1; l <= n; l++) {

                        int m = j + i + l + k;

                        if (m % 2 == 0) {

                            a[i - 1][j - 1][k - 1][l - 1] = m;
                            System.out.print(a[i - 1][j - 1][k - 1][l - 1] + " ");
                        } else {
                            a[i - 1][j - 1][k - 1][l - 1] = -m;
                            System.out.print(a[i - 1][j - 1][k - 1][l - 1] + " ");

                        }

                    }
                    System.out.print("   ");

                }

            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Now Maximizer performs:(O)");
        int num=n;
        Maximizer(a,num);
    }

    public static void Maximizer(int[][][][] a, int n) {
        int ma=n*n*n;
        int[] b = new int[ma];
        int ml= 0;
        while(ml<ma) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {

                            if (a[i][j][k][l] % 2 == 0) {

                                b[ml] = a[i][j][k][l];
                                ml++;
                            }

                        }
                    }
                }
            }
        }

        System.out.println();
        System.out.println("After Maximizing values are:");
        for (int m = 0; m < b.length; m++) {


            System.out.print(b[m] + "  ");
        }
        System.out.println();
        System.out.println("Now finding minimum among these: minimizer:(E)");
        int cn=n*n;
        int dn=n;
        int c[] = new int[cn];
        int d[] = new int[dn];
        int i = 0;
        for (int m = 0; m < b.length; m++) {
            if (b[m] > b[m + 1]) {
                System.out.println(b[m + 1]);
                c[i] = b[m + 1];
            } else {
                c[i] = b[m];
            }
            m += 1;
            i++;
        }
        for (int k = 0; k < c.length; k++) {
            System.out.print(c[k]+ " ");
        }
        System.out.println();
        System.out.println("Now applying Maximizer:(O)");

        int ic = 0;
        for (int m = 0; m < c.length; m++) {
            if (c[m] > c[m + 1]) {
                System.out.println(c[m + 1]);
                d[ic] = c[m + 1];
            } else {
                d[ic] = c[m];
            }
            m += 1;

            ic++;
        }
        System.out.println();

        for (int k = 0; k < d.length; k++) {
            System.out.println(d[k]);
        }
        System.out.println();

        System.out.println("Now doing minimizing :(E)");

        for (int p = 0; p < d.length; p++) {

            Arrays.sort(d);
        }
        System.out.println("Final value is:   "+d[0]);
    }

}
