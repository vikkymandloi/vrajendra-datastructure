package java9_classtypes;

class GenericOuter<T extends Number> {
    public class Inner<S extends Comparable<S>> {
        T getT() { return null;}
        S getS() { return null;}
    }
}

public class InnerOuterTest {
    public static void main(String[] args) {
    	GenericOuter<Integer>.Inner<Double> x1 = null;
        Integer i = x1.getT();
        Double d = x1.getS();
    }
}