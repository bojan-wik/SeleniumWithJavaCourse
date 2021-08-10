package Chapter31_CoreJava2;

/**
 * Constructor - byt podobny do funkcji/metody. Zadaniem Constructora jest inicjalizacja obiektu (uruchomienie jego kodu)
 * już na etapie jego utworzenia.
 * Za każdym razem, kiedy taki obiekt jest tworzony - kod jest uruchamiany.
 */
public class c_Constructors {

    public static void main(String[] args) {
        c_Constructors c_constructors = new c_Constructors();
        c_constructors.sampleMethod();
    }

    /**
     * a) Constructor ma taką samą nazwę jak klasa, w której się znajduje
     * b) Constructor nie zwraca żadnych wartości (główna różnica pomiędzy Constructorem a metodą)
     */
    public c_Constructors() {
        System.out.println("Constructor is initialized");
    }

    public void sampleMethod() {
        System.out.println("Sample method is initialized");
    }
}
