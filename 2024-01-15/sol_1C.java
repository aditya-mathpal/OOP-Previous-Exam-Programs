/*
Write a Java Program to create an integer array of size n and remove all duplicate elements and
 display the modified array
*/

// solution:
import java.util.*;

class sol_1C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter elements of the array: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(arr[i] == arr[j]) {
                    for(int k = j+1;k<n;k++) {
                        arr[k-1] = arr[k];
                    }
                    n--;
                    j--;
                    break;
                }
            }
        }
        System.out.print("Array without duplicates: ");
        for(int i=0;i<n;i++) System.out.print(arr[i] + " ");
        sc.close();
    }
}

/*
sample output:
Enter size of array: 5
Enter elements of the array: 4 1 2 1 4
Array without duplicates: 4 1 2
*/