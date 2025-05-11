package DAA;

import java.util.Scanner;

public class BruteForceNQueens {

    // Function to check if the current arrangement of queens is valid
    private static boolean isValid(int[] positions) {
        int n = positions.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                // Check if two queens are in the same column or diagonal
                if (positions[i] == positions[j] || Math.abs(positions[i] - positions[j]) == Math.abs(i - j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(int[] positions) {
        int n = positions.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (positions[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] positions = new int[n];
        for (int i = 0; i < n; ++i) {
            positions[i] = i;
        }

        do {
            if (isValid(positions)) {
                printBoard(positions);
            }
        } while (nextPermutation(positions));

    }

    private static boolean nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;

        // Find the first decreasing element
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // If the entire array is non-increasing, we've generated the last permutation
        if (i < 0) {
            return false;
        }

        // Find the element just larger than arr[i]
        int j = n - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        swap(arr, i, j);

        reverse(arr, i + 1, n - 1);
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}