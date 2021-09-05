package Chapter31_CoreJava2;

/**
 * Słowo kluczowe 'this' to zmienna referencyjna, która odnosi się do danego obiektu
 */
public class e_ThisKeyword {

    String text = "Variable directly in the class";

    public void sampleMethod() {
        String text = "Variable in the method";
        /**
         * W tym momencie mam dwie zmienne o dokładnie takiej samej nazwie ("text").
         * Jedna z nich jest globalna - zdefiniowana na poziomie klasy/obiektu, druga lokalna - zdefiniowana na poziomie metody.
         * Teraz jeżeli chcę z poziomu metody odnieść się do zmiennej lokalnej robię to w standardowy sposób jak niżej.
         */
        System.out.println(text);
        /**
         * ale jeżeli z tego samego poziomu metody chcę się odnieść do zmiennej globalnej o tej samej nazwie, muszę użyć
         * keyworda 'this'
         */
        System.out.println(this.text);
    }

    public static void main(String[] args) {
        e_ThisKeyword e_thisKeyword = new e_ThisKeyword();
        e_thisKeyword.sampleMethod();
    }
}
