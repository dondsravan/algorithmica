import java.util.Arrays;
import java.util.Random;

public class TwoSum {

//	WORST ONE
//	n-1 + n-2 + n-3 + .... + 3 + 2 + 1 = c n(n-1)/2 = O(n^2)
	public static boolean twoSumNaiveMethod(int[] in, int target) {
		for (int i = 0; i < in.length; i++) {
			for (int j = i + 1; j < in.length; j++) {
				if (in[i] + in[j] == target) {
					return true;
				}
			}
		}
		return false;
	}

//	BEST ONE
//	O(n) - 100Cr ~ 0.5Sec
	public static boolean twoSumTwoPointer(int[] in, int target) {
		int i = 0, j = in.length - 1;
		int sum;
		while (i < j) {
			sum = in[i] + in[j];
			if (sum == target) {
				return true;
			} else if (sum > target)
				--j;
			else
				++i;
		}
		return false;
	}

//	O(n.log n) - 100Cr ~ 35Sec
	public static boolean twoSumBinarySearch(int[] in, int target) {
		for (int i = 0; i < in.length-1; ++i) {
			if (Arrays.binarySearch(in, i + 1, in.length, target - in[i]) >= 0)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random rand = new Random();
		int[] in = new int[n];
		int target = (rand.nextInt(n) + 1);

		for (int i = 0; i < n; i++) {
			in[i] = rand.nextInt(n) + 1;
		}

		Arrays.sort(in);

		// For Debugging

		/*System.out.println("N: " + n + "\n");
		for (int i = 0; i < n; i++)
			System.out.print(in[i] + " ");
		System.out.println("\n");*/
		
		target = 0;

		long start1 = System.currentTimeMillis();
		System.out.println(twoSumNaiveMethod(in, target));
		long start2 = System.currentTimeMillis();
		System.out.println(twoSumTwoPointer(in, target));
		long start3 = System.currentTimeMillis();
		System.out.println(twoSumBinarySearch(in, target));
		long end = System.currentTimeMillis();

		System.out.println((start2 - start1) / 1000.0 + " Seconds.");
		System.out.println((start3 - start2) / 1000.0 + " Seconds.");
		System.out.println((end - start3) / 1000.0 + " Seconds.");
	}
}
