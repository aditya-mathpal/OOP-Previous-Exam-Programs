public class sol_5C {
    public static void main(String[] args) {
        int x = 15, y = 2, z = 5;
        boolean condition1 = x > y || z++ < x;
        boolean condition2 = x % y == 0 && ++z > y;
        int result = (condition1?x:y) * z--;
        System.out.println("Condition1:" + condition1);
        System.out.println("Condition2:" + condition2);
        System.out.println("Result:" + result);
    }
}

/*
solution:
true
false
75

explanation:
both boolean conditions are determined before reaching the second expression due to short-circuit operators.
condition1 is true based on the first expression, condition2 is false based on the first expression.
hence result is x * z = 15 * 5 = 75, z is decremented after this operation.
*/