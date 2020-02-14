import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {3, 1, 45, 2, 7, 9, 10, 23, 64, 13, 12, 100};
		mergeSortModified(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void merge(int[] arr, int l, int m, int r) {
		int arr1 = m + 1 - l;
		int arr2 = r - m;
		
		int[] L = new int[arr1];
		int[] R = new int[arr2];
		
		for (int i = 0; i < arr1; i++)
			L[i] = arr[l + i];
		for (int i = 0; i < arr2; i++)
			R[i] = arr[m + i + 1];
		
		int i = 0, j = 0;
		int k = l;
		
		while (i < arr1 && j < arr2) {
			if (L[i] > R[j]) {
				arr[k] = R[j];
				j++;
			}
			else {
				arr[k] = L[i];
				i++;
			}
			k++;
		}
		
		while (i < arr1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while (j < arr2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	public static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			
			merge(arr, l, m, r);
		}
	}
	
	public static void mergeSortModified(int[] arr) {
		//check if there's more than one element in the array
		if (arr.length > 1) {
			//find index of the middle element
			int m = (arr.length - 1) / 2;
			
			int[] L = new int[m + 1]; //length of left side array
			int[] R = new int[arr.length - m - 1]; //length of right side array
			
			for (int i = 0; i < L.length; i++) //copy values of array
				L[i] = arr[i];
			for (int i = 0; i < R.length; i++)
				R[i] = arr[m + i + 1];
			
			mergeSortModified(L); //split arrays in half recursively
			mergeSortModified(R);
			
			//At this point L and R are all single values for first run
			
			//Merging starts
			
			int i = 0, j = 0, k = 0;
			
			//replace each values in original array in ascending order
			while (i < L.length && j < R.length) {
				if (L[i] < R[j])
					arr[k++] = L[i++];
				else
					arr[k++] = R[j++];
			}
			
			//check if there's any left
			while (i < L.length)
				arr[k++] = L[i++];	
			while (j < R.length)
				arr[k++] = R[j++];
			
			//after merging the previous arr is in order
			//back to previous level and merge with the other array
		}
	}
}
