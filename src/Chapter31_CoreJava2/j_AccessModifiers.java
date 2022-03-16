package Chapter31_CoreJava2;

import Chapter30_CoreJava1.x_SampleClass;

/**
 * Access modifiers - służą do zarządzania poziomem dostępu dla poszczególnych bytów (klas, metod, zmiennych, konstruktorów, data members)
 * przed którymi są użyte.
 *
 * Istnieją 4 typy access modifiers (uszeregowane malejąco wg. zakresu dostępu):
 *      a) public - największy zakres dostępu, byty z tym access modifier są dostępne z każdego poziomu programu/projektu
 *      b) protected - dostęp z poziomu tego samego package + z innego package dla child-class
 *      c) default - kiedy nie ma żadnego access modifiera sprecyzowanego, takie byty są dostępne tylko z poziomu tego samego package
 *      d) private - najmniejszy zakres dostępu, tylko z poziomu tej samej klasy
 *
 */

public class j_AccessModifiers {

    public static void main(String[] args) {

        x_SampleClass sampleClass = new x_SampleClass();

        /**
         * ad a) public
         */
        sampleClass.sampleMethodAccessPublic();
        System.out.println(sampleClass.sampleVariableAccessPublic);

        /**
         * ad c) default
         * Stworzyłem sobie klasę 'x_SampleClass' która znajduje się w odrębnym package 'Chapter30'. Wewnątrz mam metodę 'sampleMethodAccessDefault()',
         * którą chcę tutaj wywołać. Normalnie (gdyby ta metoda miała access-modifier 'public') byłoby to możliwe poprzez zaimportowanie package,
         * stworzenie obiektu klasy i wywołanie metody.
         * Ale w momencie kiedy metoda 'sampleMethodAccessDefault()' ma access-modifier=default nie jest ona dostępna dla klas spoza swojego package.
         */
        //sampleClass.sampleMethodAccessDefault();
        //System.out.println(sampleClass.sampleVariableAccessDefault);

    }
}
