public class MergeSort {
	public void sort(int[] nums){
		if (nums == null || nums.length == 0){
			return;
		}
		
		mergeSort(0, nums.length - 1, nums);
	}
	
	private void mergeSort(int beg, int end, int[] nums){
		if (beg >= end){
			return;
		}
		
		int mid = beg + (end - beg) / 2;
		
		mergeSort(beg, mid, nums);
		mergeSort(mid + 1, end, nums);
		merge(beg, end, nums);
	}
	private void merge(int beg, int end, int[] nums) {
		int left   = beg + (end - beg) / 2;
		int right  = left + 1;
		int len    = end - beg + 1;
		int index  = 0;
		int[] temp = new int[len];

		while (beg <= left && right <= end){
			if (nums[beg] <= nums[right] ){
				temp[index ++] = nums[beg ++];
			} else {
				temp[index ++] = nums[right ++];
			}
		}
		
		while (beg <= left){
			temp[index ++] = nums[beg];
			++ beg;
		}
		while (right <= end){
			temp[index ++] = nums[right];
			++ right;
		}
		
		for (int i = end; i >= end - len + 1; -- i, -- index){
			nums[i] = temp[index - 1];
		}
	}

	public static void main(String[] args) {
		int[] nums = {45,15,7,8,75,1,4,63,48,53,15,48,3,47,99}; 
		MergeSort ms = new MergeSort();
		ms.sort(nums);
		
		for (int n : nums){
			System.out.print(n + " ");
		}
	}
}
