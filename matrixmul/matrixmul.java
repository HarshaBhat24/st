package matrixmul;

import java.util.Scanner;
public class matrixmul {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
// Input dimensions
System.out.print("Enter number of rows in M1: ");
int m = sc.nextInt();
System.out.print("Enter number of columns in M1: ");
int n = sc.nextInt();
System.out.print("Enter number of rows in M2: ");
int o = sc.nextInt();
System.out.print("Enter number of columns in M2: ");
int p = sc.nextInt();
// Check multiplication condition
if (n != o) {
System.out.println("Matrix Multiplication is not possible (M1 columns ≠ M2 rows).");
return;
}
// Input Matrix A
int[][] A = new int[m][n];
System.out.println("Enter elements of Matrix A:");
for (int i = 0; i < m; i++) {
for (int j = 0; j < n; j++) {
System.out.print("A[" + i + "][" + j + "] : ");
A[i][j] = sc.nextInt();
}
}
// Input Matrix B
int[][] B = new int[o][p];
System.out.println("Enter elements of Matrix B:");
for (int i = 0; i < o; i++) {
for (int j = 0; j < p; j++) {
System.out.print("B[" + i + "][" + j + "] : ");
B[i][j] = sc.nextInt();
}
}
// Result matrix m × p
int[][] result = new int[m][p];
// Multiplication logic
for (int i = 0; i < m; i++) {
for (int j = 0; j < p; j++) {
for (int k = 0; k < n; k++) {
result[i][j] += A[i][k] * B[k][j];
}
}
}
// Print Result
System.out.println("Resultant Matrix:");
for (int i = 0; i < m; i++) {
for (int j = 0; j < p; j++) {
System.out.print(result[i][j] + " ");
}
System.out.println();
}
sc.close();
}
}