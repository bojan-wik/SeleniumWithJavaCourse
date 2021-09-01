package Chapter31_CoreJava2;

public class d_SuperKeyword_Parent {

    // a)
    String text = "Text from parent class";

    // b)
    public void demoMethod() {
        System.out.println("Method from parent class");
    }

    // c) default / no-argument constructor
    public d_SuperKeyword_Parent() {
        System.out.println("Constructor from parent class");
    }

    // d) parameterized constructor
    /*public d_SuperKeyword_Parent(String name) {
        System.out.println("Constructor from parent class");
    }*/
}
