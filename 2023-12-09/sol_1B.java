class Car {
	private String carName;

	public Car() {
		carName = "default car";
	}
	public Car(String carName) {
		this.carName = carName;
	}

	public String getCarName() {
		return this.carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public void displayCarName() {
		System.out.println(this.carName);
	}
}

class Model {
	private String modelName;

	public Model() {
		modelName = "default model";
	}
	public Model(String modelName) {
		this.modelName = modelName;
	}

	public String getModelName() {
		return this.modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public void displayModelName() {
		System.out.println(this.modelName);
	}
}

class Result {
	public static void merge(Car c, Model m) {
		String conc = c.getCarName() + m.getModelName();
		c.setCarName(conc);
		m.setModelName(conc);
	}
}

class sol_1B {
	public static void main(String[] args) {
		Car c = new Car("Toyota");
		Model m = new Model("Land Cruiser");

		System.out.println("Before merge:");
		c.displayCarName();
		m.displayModelName();

		Result.merge(c,m);

		System.out.println("After merge:");
		c.displayCarName();
		m.displayModelName();
	}
}

/*
Before merge:
Toyota
Land Cruiser
After merge:
ToyotaLand Cruiser
ToyotaLand Cruiser
*/