import java.util.Random;

public class TwoSum {

//	n-1 + n-2 + n-3 + .... + 3 + 2 + 1 = c n(n-1)/2 = O(n^2)
	public static boolean twoSumNaiveMethod(int[] in, int target) {
		for (int i = 0; i < in.length; i++) {
			for (int j = i + 1; j < in.length; j++) {
				if (in[i] + in[j] == target) {
					System.out.print(in[i] + " " + in[j] + "\n");
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random rand = new Random();
		int[] in = new int[n];

		for (int i = 0; i < n; i++) {
			in[i] = rand.nextInt(n) + 1;
		}

		System.out.println();

		long start = System.currentTimeMillis();
		System.out.println(twoSumNaiveMethod(in, 0));
		long end = System.currentTimeMillis();

		System.out.println((end - start) / 1000.0 + " Seconds.");
	}
}
