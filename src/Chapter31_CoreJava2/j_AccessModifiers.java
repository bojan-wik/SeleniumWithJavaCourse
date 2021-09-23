package Chapter31_CoreJava2;

import Chapter30.*;

/**
 * Access modifiers - służą do zarządzania poziomem dostępu dla poszczególnych bytów (klas, metod, zmiennych, konstruktorów, data members)
 * przed którymi są użyte.
 *
 * Istnieją 4 typy access modifiers:
 *      a) default - kiedy nie ma żadnego access modifiera sprecyzowanego
 */

public class j_AccessModifiers {

    public static void main(String[] args) {

        /**
         * ad a) default
         * Stworzyłem sobie klasę 'x_SampleClass' która znajduje się w odrębnym package 'Chapter30'. Wewnątrz mam metodę 'sampleMethodAccessDefault()',
         * którą chcę tutaj wywołać. Normalnie (gdyby ta metoda miała access-modifier 'public') byłoby to możliwe poprzez zaimportowanie package,
         * stworzenie obiektu klasy i wywołanie metody.
         * Ale w momencie kiedy metoda 'sampleMethodAccessDefault()' ma access-modifier=default nie jest ona dostępna dla klas spoza swojego package.
         */
        x_SampleClass sampleClass = new x_SampleClass();
        sampleClass.sampleMethodAccessDefault();
    }
}
