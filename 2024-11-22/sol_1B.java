import java.util.*;

class Vaccine {
	private String name;
	private int ID, year, month, day;
	private boolean severeAllergyStatus;

	public Vaccine(String name, int ID, boolean severeAllergyStatus, int day, int month, int year) {
		this.name = name;
		this.ID = ID;
		this.severeAllergyStatus = severeAllergyStatus;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public boolean eligibility(int day, int month, int year) {
		if (severeAllergyStatus == true) return false;
		if(year - this.year > 0) return true;
		if(month - this.month < 6) return false;
		if(month - this.month == 6 && day < this.day) return false;
		return true;
	}

	public String getName() {
		return this.name;
	}
}

class sol_1B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vaccine[] v = new Vaccine[50];
		int count = 0;
		boolean exit = false;
		String choice;
		System.out.println("Enter 'add person', 'check eligibility', or 'exit'");
		while(!exit) {
			System.out.print("> ");
			choice = sc.nextLine();
			if(choice.equals("add person")) {
				System.out.print("Enter name: ");
				String name = sc.nextLine();
				System.out.println("Enter ID: ");
				int ID = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter severe allergy status (true or false): ");
				boolean allergy = sc.nextBoolean();
				System.out.println("Enter date of last vaccination (dd mm yyyy): ");
				int day = sc.nextInt();
				int month = sc.nextInt();
				int year = sc.nextInt();
				sc.nextLine();
				v[count++] = new Vaccine(name,ID,allergy,day,month,year);
			}
			else if(choice.equals("check eligibility")) {
				for(int i = 0;i<count;i++) {
					System.out.print("\n" + v[i].getName() + " ");
					if(v[i].eligibility(22,12,2024)) System.out.println("is eligible to be vaccinated.");
					else System.out.println("is not eligible to be vaccinated.");
				}
			}
			else if(choice.equals("exit")) exit = true;
			else System.out.println("Enter a valid input.");
		}
		sc.close();
	}
}

/*
output:
Enter 'add person', 'check eligibility', or 'exit'
> add person
Enter name: Aditya
Enter ID:
2309
Enter severe allergy status (true or false):
false
Enter date of last vaccination (dd mm yyyy):
01 03 2021
> check eligibility

Aditya is eligible to be vaccinated.
> exit
*/