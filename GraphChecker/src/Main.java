import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertex");
        int n = scanner.nextInt();

        int[][] matrix = AdjacencyMatrix(n);
        isReflexive(matrix, n);
        isSymmetric(matrix, n);
        isTransitive(matrix, n);
        isAcyclic(matrix, n);
        isConnectivity(matrix,n);
        isEulerianPath(matrix,n);


    }
    public static int[][] AdjacencyMatrix(int numvertex) {
        int[][] matrix = new int[numvertex][numvertex];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < numvertex; i++) {
            for (int j = 0; j < numvertex; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < numvertex; i++) {
            for (int j = 0; j < numvertex; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }


    public static void isReflexive(int mat[][], int n) {
        int s = 0;

        for (int i = 0; i<n; i++) {
            for (int j=0;j<n; j++) {

                if (i==j) {
                    s=s+mat[i][j];
                }
            }
        }
        if (s==n) {
            System.out.println("Reflexive.");
        } else {
            System.out.println("not Reflexive.");
        }
    }


    public static void isSymmetric(int mat[][], int n) {


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != mat[j][i]) {
                    System.out.println("not symmetric");
                    return;
                }

            }

        }
        System.out.println("Symmetric");
    }

    public static void isTransitive(int mat[][], int n) {
        int c[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] += mat[i][k] * mat[k][j];
                }
                if (mat[i][j] != c[i][j]) {
                    System.out.println("not Transitive");
                    return;
                }
            }
        }
        System.out.println("Transitive");
    }

    public static void isAcyclic(int[][] mat, int n) {

        boolean[] v = new boolean[n];
        boolean[] p = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!v[i] && isCycle(mat, i, v, p)) {
                System.out.println("not Acyclic");
                return;
            }
        }

        System.out.println("Acyclic");
    }

    private static boolean isCycle(int[][] mat, int n, boolean[] v, boolean[] p) {
        v[n] = true;
        p[n] = true;

        for (int i = 0; i < mat[n].length; i++) {
            if (mat[n][i] == 1) {
                if (!v[i] && isCycle(mat, i, v, p)) {
                    return true;
                } else if (p[i]) {
                    return true;
                }
            }
        }

        p[n] = false;
        return false;
    }

    public static void isConnectivity(int[][] mat, int n) {
        int v[] = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 1 && v[i] == 0) {
                    v[i] = 1;
                }

            }
        }
        boolean connected = false;

        for (int i = 0; i < n; i++) {
            if (v[i] == 1) {
                connected = true;
            } else {
                connected = false;
                break;
            }
        }
        if (connected) {
            System.out.println("Connectivity");
        } else {
            System.out.println("not Connectivity");
        }
    }

    public static void isEulerianPath(int[][] mat, int n) {

        int Count = 0;
        int degree = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                degree += mat[i][j];
            }
            if (degree % 2 == 1) {
                Count++;
            }
        }
        if (Count == 0 || Count == 2) {
            System.out.println("not Eulerian path");
        } else {
            System.out.println("Eulerian path");

        }


    }
}

