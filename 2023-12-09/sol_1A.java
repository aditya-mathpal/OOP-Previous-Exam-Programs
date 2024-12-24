import java.util.*;

class sol_1A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max=0,min=0,sum=0,count=0;
		double avg=0;
		String choice;
		Boolean firstNum = true;
		System.out.println("Enter a number:");
		do {
			System.out.print("> ");
			int n = sc.nextInt();
			sc.nextLine();
			if(firstNum) {
				max = n;
				min = n;
				firstNum = !firstNum;
			}
			else {
				if(n > max) max = n;
				if(n < min) min = n;
			}
			sum += n;
			count++;
			avg = (double)sum/count;
			System.out.print("Do you wish to enter another number? Enter yes or no: ");
			choice = sc.nextLine();
		} while(choice.equals("yes"));

		System.out.println("The largest number entered was " + max + ", smallest was " + min + ", sum was " + sum + ", average of all entered numbers was " + avg + ".");
	}
}

/*
output:
Enter a number:
> 7
Do you wish to enter another number? Enter yes or no: yes
> 13
Do you wish to enter another number? Enter yes or no: yes
> 26
Do you wish to enter another number? Enter yes or no: no
The largest number entered was 26, smallest was 7, sum was 46, average of all entered numbers was 15.333333333333334.
*/