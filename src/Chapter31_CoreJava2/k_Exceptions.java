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

    public static void main(String[] args) {

        int a = 8;
        int b = 4;
        int c = 0;

        /**
         * W matematyce nie dzieli się przez zero. Tutaj wykonuję taką operację.
         * Potem chcę wyprintować "Will I be executed?", ale nie będzie to możliwe, ponieważ program wywali się wcześniej
         * i rzuci ArithmeticException
         */
        /*int divideByZeroResult = a / c;
        System.out.println(divideByZeroResult);
        System.out.println("Will I be executed?");*/

        /**
         * Jeżeli podejrzewam, że w moim programie może być jakaś część kodu, która powoduje pojawienie się jakiegoś exception, to wtedy taki kod mogę umieścić w bloku try.
         * Wtedy, jeżeli w bloku try faktycznie pojawia się exception, jest on rzucany i łapany w bloku catch.
         * W bloku catch mogę się dalej zająć wyłapanym exception w pożądany sposób np. printując info o takim zdarzeniu. Jest to tzw. exception handler.
         * Blok catch powinien występować zawsze bezpośrednio po bloku try.
         * Exceptiony generowane przez system są automatycznie rzucane. Aby manualnie rzucić exception, trzeba użyć keyworda 'throw'.
         */
        /*try {
            int divideByZeroResult = a / c;
            System.out.println(divideByZeroResult);
        }
        catch (ArithmeticException exceptionObject) {
            System.out.println("The exception (ArithmeticException) is caught.");
        }
        System.out.println("Will I be executed?");*/
        /**
         * W tym przypadku tworzę array na 3 elementy, a potem staram się dostać do 5-tego elementu tej listy, który nie istnieje.
         * To spowoduje pojawienie się 'ArrayIndexOutOfBoundsException'.
         */
        int[] arr = new int[3];
        try {
            System.out.println(arr[4]);
        }
        /**
         * Po jednym bloku try może następować wiele bloków catch. Każdy z takich bloków będzie osobnym exception handlerem,
         * czyli sposobem, w jaki dany exception jest obsługiwany. Tutaj tworzę 3 bloki catch.
         * Na początku nasłuchuję pod kątem 'ArithmeticException' (on nie pasuje), potem pod kątem 'ArrayIndexOutOfBoundsException' (on pasuje),
         * a na końcu pod kątem wszystkich typów exception (chyba zawsze warto go dodawać na końcu jako zabezpieczenie)
         */
        catch (ArithmeticException exceptionObject) {
            System.out.println("The exception (ArithmeticException) is caught.");
        }
        catch (ArrayIndexOutOfBoundsException exceptionObject) {
            System.out.println("The exception (ArrayIndexOutOfBoundsException) is caught.");
        }
        catch (Exception exceptionObject) {
            System.out.println("The exception (general) is caught.");
        }
        /**
         *  finally (blok opcjonalny) -  kod w tym bloku jest uruchamiany zawsze, niezależnie od tego, czy jakiś wyjątek został rzucony, czy nie.
         *  czyli np. jeżeli zakomentuję catch-bloki dla 'ArrayIndexOutOfBoundsException' i 'Exception' to wtedy wyjątek nie zostanie wyłapany i obsłużony,
         *  to spowoduje wysypanie się skryptu, ale mimo tego kod w finally-bloku zostanie uruchomiony.
         *  finally-blok może być przydatny do uruchamiania tzw. clean-up kodu, który robiłby porządki po testach np. zamykał przeglądarkę i czyścił cookiesy,
         *  usuwał założone na potrzeby testów pliki itp.
         */
        finally {
            System.out.println("Code within the 'finally' block");
        }
        System.out.println("Will I be executed?");
    }
}
