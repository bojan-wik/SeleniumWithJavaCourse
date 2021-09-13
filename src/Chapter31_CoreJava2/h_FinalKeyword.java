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
 * Utworzyłem osobną klasę 'h_FinalKeyword_ChildClass' ...
 */
public class h_FinalKeyword {

    String text = "Parent-class variable";

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
