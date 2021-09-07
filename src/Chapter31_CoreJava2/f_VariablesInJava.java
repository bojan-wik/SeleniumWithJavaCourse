package Chapter31_CoreJava2;

/**
 * Typy zmiennych w Javie:
 *      a) class variable
 *      b) instance variable
 *      c) local variable
 *
 * Wcześniej zamiennie z 'class variable' używałem pojęcia 'global variable', ale jak doczytałem w Javie de facto nie ma czegoś takiego,
 * jak zmienne globalne. Nie wgłębiałem się w temat, ale pewnie wynika to ze składni, która powoduje, że te zmienne są zawsze jakoś ograniczone
 * i nigdy w pełni globalne, tak jak np. w Pythonie, gdzie jak się go uczyłem, to pojęcie 'global variable' było często i powszechnie używane w tutorialach.
 * W Javie tego nie ma.
 */
public class f_VariablesInJava {

    /**
     * a) Class variable:
     * zmienna, która jest zdefiniowana (zadeklarowana i zainicjalizowana) bezpośrednio na poziomie klasy i ma modifier static.
     * Zmienna taka nie jest przypisana do żadnego konkretnego obiektu danej klasy, będzie miała zawsze taką samą wartość i nie da się jej zmienić.
     */
    static String race = "Human";

    /**
     * b) Instance variable:
     * jest to w zasadzie class variables z jedną różnicą - nie ma modifiera static.
     * Dzięki temu w różnych obiektach tej klasy taka zmienna może mieć przypisane różne wartości.
     */
    String name;
    String country;

    /**
     * c) Local variable:
     * zmienna zdefiniowana wewnątrz danej metody/konstruktora/bloku (tutaj wewn. konstruktora)
     */
    f_VariablesInJava(String name, String country){
        this.name = name;
        this.country = country;
    }

    public void displayVariables() {
        System.out.println(race);
        System.out.println(name);
        System.out.println(country + "\n");
    }

    public static void main(String[] args) {

        /**
         * ad a) Class variable - zmienna taka nie jest przypisana do żadnego konkretnego obiektu klasy.
         * Nie muszę tworzyć obiektu klasy żeby ją wywołać.
         */
        //System.out.println(race);

        /**
         * ad b) Instance variable - w różnych obiektach tej klasy taka zmienna może mieć przypisane różne wartości.
         * Muszę stworzyć obiekt klasy żeby ją wywołać.
         */
        f_VariablesInJava classInstance1 = new f_VariablesInJava("Wiktor", "Poland");
        f_VariablesInJava classInstance2 = new f_VariablesInJava("Luc", "France");
        //System.out.println(classInstance1.name);
        //System.out.println(classInstance2.name);

        /**
         * Wywołuję wcześniej stworzoną metodę display(), która wyświetla mi wszystkie zmienne.
         * Piersza zmienna 'race' jako class variable, jest współdzielona przez oba obiekty i jest od nich niezależna.
         * Pozostałe dwie zmienne 'name' i 'country' zostały zdefiniowane na etapie tworzenia obiektów i są od nich zależne.
         */
        classInstance1.displayVariables();
        classInstance2.displayVariables();
    }
}
