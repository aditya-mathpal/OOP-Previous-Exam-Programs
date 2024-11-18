/*
 Illustrate exception handling mechanism with a specific example in java
*/

// solution
class sol_3A {
    public static void main(String[] args) {
        try {
            int a = 10, b = 0;
            System.out.println(a/b);
        } catch (ArithmeticException e) {
            System.out.println("Tried to divide by 0");
        }
    }
}

/*
output:
Tried to divide by 0
*/