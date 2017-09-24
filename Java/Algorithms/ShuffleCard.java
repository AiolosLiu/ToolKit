import java.util.Random;

public class ShuffleCard {

	public void shuffle(int[] nums){
		if (nums == null || nums.length <= 1){
			return;
		}
		
		Random rant = new Random();
		
		for (int i = 0; i < nums.length; ++ i){
			int pos = rant.nextInt(54);
			swapNum(i, pos, nums);
		}
	}
	
	private void swapNum(int a, int b, int[] nums){
		int temp = nums[a];
		nums[a]  = nums[b];
		nums[b]  = temp;
	}
	public static void main(String[] args) {
		int[] nums = new int[54];
		//Random rant = new Random();
		int len = nums.length;
		for (int i = 0; i < len - 2; ++ i){
			nums[i] = i + 1;
		}
		nums[len - 2] = -1;
		nums[len - 1] = -2;

		ShuffleCard sc = new ShuffleCard();
		
		sc.shuffle(nums);
		
		for (int i = 0; i < len; ++ i){
			if ((i + 1) % 12 == 0){
				System.out.println(nums[i]);
			} else {
				if (nums[i] < 10 && nums[i] > 0){
					System.out.print(nums[i] + "  ");
				} else {
					System.out.print(nums[i] + " ");
				}
				
			}
		}
	}

}
