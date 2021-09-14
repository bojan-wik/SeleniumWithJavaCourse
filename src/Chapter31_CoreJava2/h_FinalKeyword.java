package Chapter31_CoreJava2;

/**
 * 'final' keyword to, podobnie jak 'static' keyword o którym uczyłem się niedawno, non-access modifier,
 * który aplikujemy tylko do:
 *      a) zmiennych
 *      b) metod
 *      c) klas
 * aby je 'zastrzec'. Wtedy to:
 *      a) final variable - daje nam zmienną typu constant, której nie da się zmodyfikować
 *      b) final method- daje nam metodę, której nie da się nadpisać (function overriding) przez żadną child-class
 *      c) final class - daje nam klasę, z której nie można dziedziczyć (inherit / extends)
 */

/**
 * ad c) final class - klasa, z której nie można dziedziczyć.
 * Utworzyłem osobną klasę 'h_FinalKeyword_ChildClass', która dziedziczy z tej klasy ('h_FinalKeyword').
 * W momencie kiedy klasa 'h_FinalKeyword' staje się final, nie można z niej nic dziedziczyć i pojawia się error.
 */
public class h_FinalKeyword {
    /**
     * ad b) final method - klasa, która nie może być nadpisana.
     * W child-class stworzyłem metodę o tej samej nazwie. Normalnie zachodzi zjawisko function-overriding, o którym już się wcześniej uczyłem.
     * W momencie kiedy metoda staje się final, nie można jej nadpisać i pojawia się error.
     */
    public void sampleMethod() {
        System.out.println("Parent-class method");
    }
    String sampleVariable = "Parent-class variable";

    public static void main(String[] args) {
        /**
         * ad a) final variable - zmienna, której nie da się zmodyfikować.
         * Dobrą praktyką jest pisać nazwy zmiennyc typy constant z dużych liter, i ew. oddzielać podkreślnikiem np. 'FINAL_VARIABLE'
         */
        final int FINAL_VARIABLE = 1;
        System.out.println(FINAL_VARIABLE);
        /**
         * Przy próbie modyfikacji wywala błąd.
         */
        //FINAL_VARIABLE = 3;
        //System.out.println(FINAL_VARIABLE);
        /**
         * Ta sama operacja na zmiennej bez keyworda 'final' jest dozwolona.
         */
        String notAFinalVariable = "Wiktor";
        System.out.println(notAFinalVariable);
        notAFinalVariable = "Marek";
        System.out.println(notAFinalVariable);
    }
}
