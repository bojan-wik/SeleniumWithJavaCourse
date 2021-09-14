package Chapter31_CoreJava2;

public class h_FinalKeyword_ChildClass extends h_FinalKeyword {

    public void sampleMethod() {
        System.out.println("Child-class method");
    }

    public static void main(String[] args) {
        h_FinalKeyword_ChildClass childClass = new h_FinalKeyword_ChildClass();
        System.out.println(childClass.sampleVariable);
        childClass.sampleMethod();
    }
}
