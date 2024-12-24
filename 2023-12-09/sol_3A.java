class sol_3A {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		try {
			System.out.println(arr[0]/0);
		} catch(ArithmeticException e) {
			System.out.println("You cannot divide by zero.");
		}

		try {
			System.out.println(arr[5]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Cannot access array element out of bounds.");
		}

		//example for unreachable catch block
		// try {
		// 	System.out.println(arr[4]);
		// } catch(Exception e) {
		// 	System.out.println("Exception caught.");
		// }
		//  catch(ArrayIndexOutOfBoundsException e) {
		// 	System.out.println("(this catch block is unreachable) Cannot access array element out of bounds.");
		// }
	}
}

/*
output:
You cannot divide by zero.
Cannot access array element out of bounds.
*/