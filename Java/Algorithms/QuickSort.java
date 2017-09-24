import java.util.Random;

public class QuickSort {
	public void sort(int[] nums){
		if (nums == null || nums.length == 0){
			return;
		}
		
		quickSort(0, nums.length - 1, nums);
	}
	
	private void quickSort(int beg, int end, int[] nums){
		if (beg >= end){
			return;
		}

		Random random = new Random();
		int flag = nums[random.nextInt(end - beg) + beg];
		int onp  = beg;
		int twp  = end;
		
		while(onp <= twp){
			while (nums[onp] < flag){
				++ onp;
			}
			
			while (nums[twp] > flag){
				-- twp;
			}
			
			if (onp <= twp){
				swapNum(onp, twp, nums);
				++ onp;
				-- twp;
			}
		}
		if (beg < twp){
			quickSort(beg, twp, nums);
		}
		if (onp < end){
			quickSort(onp, end, nums);
		}
		
	}
	
	private void swapNum(int a, int b, int[] nums){
		int temp = nums[a];
		nums[a]  = nums[b];
		nums[b]  = temp;
	}
	
	public static void main(String[] args) {
	int[] nums   = {5, 465, 46, 154, 15, 21, 4, 5};
		QuickSort qs = new QuickSort(); 
		qs.sort(nums);
		
		for (int n : nums){
			System.out.println(n);
		}
		
	}

}
