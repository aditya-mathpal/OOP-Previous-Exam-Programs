import java.util.*;

class City {
    private int temp, humidity, ID;

    public City(int ID) {
        this.ID = ID;
    }

    public void display() {
        System.out.println("\nCity ID: " + ID + "\nTemperature: " + temp + " deg C\nHumidity: " + humidity + "%");
    }

    public int getID() {
        return this.ID; 
    }
    public void setTemp(int temp) {
        this.temp = temp;
    }
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void alert() {
        if (this.temp > 40) System.out.println("High temperature in city " + this.ID);
        if(this.humidity > 80) System.out.println("High humidity in city " + this.ID);
    }
}

class sol_1A {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String choice;
        City cities[] = new City[50];
        int i = 0, exit = 0;
        System.out.println("Enter 'add city', 'update data', 'display data', or 'exit'");
        while(exit==0) {
            System.out.print("> ");
            choice = sc.nextLine();
            switch(choice) {
            case "add city":
                System.out.print("Enter city ID: ");
                cities[i] = new City(sc.nextInt());
                System.out.print("Enter temp and humidity: ");
                cities[i].setTemp(sc.nextInt());
                cities[i].setHumidity(sc.nextInt());
                sc.nextLine(); // consume newline
                cities[i].alert();
                i++;
                break;
            case "update data":
                System.out.print("Enter city ID: ");
                int c = sc.nextInt();
                int d;
                for(int j=0;j<i;j++) {
                    if(cities[j].getID() == c) {
                        System.out.print("Enter updated temp and humidity: ");
                        cities[j].setTemp(sc.nextInt());
                        cities[j].setHumidity(sc.nextInt());
                        sc.nextLine();
                        cities[j].alert();
                        break;
                    }
                }
                break;                
            case "display data":
                if(i>0) for(int j = 0;j<i;j++) cities[j].display();
                else System.out.println("No data to display");
                break;
            case "exit":
                exit = 1;
                break;
            }
        }
        sc.close();
    }
}

/*
Enter 'add city', 'update data', 'display data', or 'exit'
> add city
Enter city ID: 10
Enter temp and humidity: 30 70
> add city
Enter city ID: 20
Enter temp and humidity: 20 60
> display data

City ID: 10
Temperature: 30 deg C
Humidity: 70%

City ID: 20
Temperature: 20 deg C
Humidity: 60%
> update data
Enter city ID: 20
Enter updated temp and humidity: 20 65
> display data

City ID: 10
Temperature: 30 deg C
Humidity: 70%

City ID: 20
Temperature: 20 deg C
Humidity: 65%
> exit
*/