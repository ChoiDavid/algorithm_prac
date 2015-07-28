package myutil;

public class BasicOperation {
	public static int max(int... nums){
		int max = Integer.MIN_VALUE;
		for(int num : nums) {
			if(num > max)
				max = num;
		}
		return max;
	}
	
	public static int min(int... nums){
		int min = Integer.MAX_VALUE;
		for(int num : nums) {
			if(num < min)
				min = num;
		}
		return min;
	}
	
	public static int[] init_array(int[] array, int init_val) {
		for(int i = 0; i < array.length; i++)
			array[i] = init_val;
		return array;
	}
	
	public static int[][] init_array(int[][] array, int init_val) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				array[i][j] = init_val;
			}
		}
		return array;
	}
}
