package Chapter30_CoreJava1;

public class x_SampleClass {

    // access modifier: public
    public int sampleVariableAccessPublic = 44;
    public void sampleMethodAccessPublic() {
        System.out.println("Text from a method with public access");
    }

    // access modifier: default
    int sampleVariableAccessDefault = 23;
    void sampleMethodAccessDefault() {
        System.out.println("Text from a method with default access");
    }
}
