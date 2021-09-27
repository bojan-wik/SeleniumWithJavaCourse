package Chapter31_CoreJava2;

/**
 * Exception w Java to niechciane, lub niespodziewane wydarzenie, które może wydarzyć się podczas uruchamiania programu
 * i które może zaburzyć flow tego programu np. poprzez jego przerwanie.
 *
 * W Javie jest różnica pomiędzy Exception a Error. Obie z nich są childclassami dla klasy 'Throwable'.
 *
 *  1. Exception:
 *      a) problemy, z którymi program może sobie poradzić i powinien sobie poradzić
 *
 *  2. Error:
 *      a) błędy, po których program może działać niestabilnie, lub nie działać wcale
 *      b) rzucane przez virtual machine i program nie powinien ich rzucać samodzielnie
 *      c) występują np. kiedy zabraknie pamięci
 */
public class k_Exceptions {

    int a = 8;
    int b = 4;
    int c = 0;

    /**
     * W matematyce nie dzieli się przez zero. Tutaj wykonuję taką operację.
     * Późniejsze wywołanie metody 'displayDivideByZeroResult()' wywali exception 'ArithmeticException'
     */
    /*int divideByZeroResult = a / c;
    public void displayDivideByZeroResult() {
        System.out.println(divideByZeroResult);
    }*/

    /**
     * Jeżeli podejrzewam, że w moim programie mogą być jakieś elementy, które powodują wywalenie jakiegoś exception,
     * to wtedy takie elementy mogę umieścić w bloku try-catch
     */
    try {
        int divideByZeroResult = a / c;
        public void displayDivideByZeroResult() {
            System.out.println(divideByZeroResult);
        }
    }
    catch (Exception exception) {
        System.out.println("An exception is caught");
    }
    
    public static void main(String[] args) {
        k_Exceptions classObject = new k_Exceptions();
        classObject.displayDivideByZeroResult();
    }
}
