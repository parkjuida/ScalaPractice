package chapter11;

public class IntegerEqual {
    public boolean isEqual(Integer x, Integer y) {
        return x == y;
    }

    public boolean isEqualObject(Integer x, Integer y) {
        return x.equals(y);
    }

    public static void main(String[] args) {
        IntegerEqual integerEqual = new IntegerEqual();

        System.out.println(integerEqual.isEqual(421, 421));
        System.out.println(integerEqual.isEqualObject(1, 1));
    }
}
