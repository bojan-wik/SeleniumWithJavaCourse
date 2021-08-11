package Chapter31_CoreJava2;

/**
 * Constructor - byt podobny do funkcji/metody. Zadaniem Constructora jest inicjalizacja obiektu (uruchomienie jego kodu)
 * już na etapie jego utworzenia.
 * Za każdym razem, kiedy taki obiekt jest tworzony - kod jest uruchamiany.
 */
public class c_Constructors1 {
    /**
     * a) Constructor ma taką samą nazwę jak klasa, w której się znajduje
     * b) Constructor nie zwraca żadnych wartości (główna różnica pomiędzy Constructorem a metodą)
     */
    public c_Constructors1() {
        System.out.println("Constructor is called and its code is executed.");
    }

    /**
     * Klasyczna metoda
     */
    public void sampleMethod() {
        System.out.println("Sample method is called and its code is executed.");
    }

    public static void main(String[] args) {
        /**
         * Constructor jest wywoływany już w tym momencie - na etapie tworzenia obiektu
         */
        c_Constructors1 c_constructors1 = new c_Constructors1();
        /**
         * Metodę sampleMethod() muszę jeszcze specjalnie wywołać w ten sposób.
         * Dla constructora jest to zbędne.
         */
        c_constructors1.sampleMethod();
    }
}
/**
 * Generalnie byt typu Constructor jest obecny zawsze w każdej klasie, niezależnie od tego, czy sami go zdefinujemy, czy nie.
 * Jeżeli sami go nie zdefiniowaliśmy, jak w przykładzie powyżej, to podczas tworzenia obiektu wywoływany jest defaultowy Constructor.
 * Dlatego też w praktyce Constructor jest często stosowany - nie wymaga on osobnego wywołania, jak metoda, przez co nie trzeba o tym pamiętać i kod jest mniej podatny na błędy
 */
