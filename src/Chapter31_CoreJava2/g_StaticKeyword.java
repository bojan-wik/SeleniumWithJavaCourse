package Chapter31_CoreJava2;

/**
 * 'Static' keyword to non-access modifier, który może być używany przy:
 *  a) zmiennych,
 *  b) metodach,
 *  c) blokach,
 *  d) zagnieżdżonych klasach.
 */
public class g_StaticKeyword {

    /**
     * a) 'Static' keyword użyty przy zmiennej sprawia, że zmienna staje się class variable
     */
    static String race = "Human";
    static String sex = "Man";
    /**
     * Tym samym zmienne utworzone na poziomie klasy, ale bez keyworda 'static' są instance variable
     */
    String name;
    String country;

    /**
     * Tworzenie static variables jest możliwe TYLKO na poziomie klasy. Nie można ich tworzyć w obrębie np. metody, konstruktora
     */
    g_StaticKeyword(String name, String country){
        this.name = name;
        this.country = country;
    }
    /**
     * b) Metoda z keywordem 'static'. W obrębie takiej static method mogę odwoływać się tylko do innych elementów typu static
     * np. zmiennych, czy metod.
     * Odwołanie się do zmiennej non-static da mi errora.
     */
    public static void displayVariablesStaticMethod() {
        System.out.println(sex + "\n");
        //System.out.println(name);
    }

    public void displayVariables() {
        System.out.println(race);
        System.out.println(name);
        System.out.println(country + "\n");
    }

    public static void main(String[] args) {

        /**
         * ad b) Wywołanie static method jest możliwe już przed stworzeniem obiektu klasy i bez odniesienia do takiego obiektu,
         * ew. mogę odnieść się do samej klasy
         */
        displayVariablesStaticMethod();
        //g_StaticKeyword.displayVariablesStaticMethod();
        /**
         * Jeżeli chcę wywołać non-static method muszę wcześniej stworzyć obiekt klasy i się do niego odnieść
         */
        g_StaticKeyword classInstance1 = new g_StaticKeyword("Wiktor", "Poland");
        g_StaticKeyword classInstance2 = new g_StaticKeyword("Luc", "France");
        classInstance1.displayVariables();
        classInstance2.displayVariables();
    }
}
