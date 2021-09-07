package Chapter31_CoreJava2;

/**
 * 'Static' keyword to non-access modifier, który może być używany przy:
 *  - blokach,
 *  - zmiennych,
 *  - metodach,
 *  - zagnieżdżonych klasach.
 */
public class g_StaticKeyword {

    /**
     * a) Class variable
     */
    static String race = "Human";

    /**
     * b) Instance variable
     */
    String name;
    String country;

    /**
     * c) Local variable
     */
    g_StaticKeyword(String name, String country){
        this.name = name;
        this.country = country;
    }

    public void displayVariables() {
        System.out.println(race);
        System.out.println(name);
        System.out.println(country + "\n");
    }

    public static void main(String[] args) {

        g_StaticKeyword classInstance1 = new g_StaticKeyword("Wiktor", "Poland");
        g_StaticKeyword classInstance2 = new g_StaticKeyword("Luc", "France");


        /**
         * Wywołuję wcześniej stworzoną metodę display(), która wyświetla mi wszystkie zmienne.
         * Piersza zmienna 'race' jako class variable, jest współdzielona przez oba obiekty i jest od nich niezależna.
         * Pozostałe dwie zmienne 'name' i 'country' zostały zdefiniowane na etapie tworzenia obiektów i są od nich zależne.
         */
        classInstance1.displayVariables();
        classInstance2.displayVariables();
    }
}
