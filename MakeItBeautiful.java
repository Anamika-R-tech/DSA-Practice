import java.util.*;

public class MakeItBeautiful{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        boolean result = isBeautifulArray(arr, n);
        System.out.println(result);
            
        }
        
    }
    static boolean isBeautifulArray(int arr[], int n){
        int arr1[] = new int[n];
        arr1[0] = arr[0];
        for(int i =1; i < n; i++){
            if(arr1[i -1] == arr[i]){
                return false;
            }
            else{
                arr1[i] = arr1[i - 1] + arr[i];
            }
        }
        return true;

    }
}