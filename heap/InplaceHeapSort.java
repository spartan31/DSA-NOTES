package heap;

public class InplaceHeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 4 , 1 , 3 , 9 , 7};
		for (int i = 0; i < arr.length; i++) {
			insertintoVirtualheap(arr, i);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[arr.length-1 - i] = removeFromheap(arr, arr.length - i);
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static int removeFromheap(int[] arr, int heapSize) {
		int temp = arr[0];
		arr[0] = arr[heapSize - 1];
		heapSize--;
		int index = 0;
		int leftindex = 2 * index + 1;
		int rightindex = 2 * index + 2;

		while (leftindex < heapSize) {
			int minindex = index;
			if (arr[leftindex] < arr[minindex]) {
				minindex = leftindex;
			}

			if (rightindex < heapSize && arr[rightindex] < arr[minindex]) {
				minindex = rightindex;
			}
			if  (minindex != index) {
				int temp1 = arr[index];
				arr[index] = arr[minindex];
				arr[minindex] = temp1;
				index = minindex;
				leftindex = 2 * index + 1;
				rightindex = 2 * index + 2;
			} else {
				break;
			}

		}
		return temp;
	}

	private static void insertintoVirtualheap(int[] arr, int i) {
		int childindex = i;
		int parentindex = (childindex - 1) / 2;
		while (childindex > 0) {
			if (arr[childindex] < arr[parentindex]) {
				int temp = arr[childindex];
				arr[childindex] = arr[parentindex];
				arr[parentindex] = temp ;
				childindex = parentindex ;
				parentindex = (childindex - 1)/2;
			} else {
				return;
			}
		}

	}

}
