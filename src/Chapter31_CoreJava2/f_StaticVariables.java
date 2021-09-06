package Chapter31_CoreJava2;

public class f_StaticVariables {

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
    f_StaticVariables(String name, String country){
        this.name = name;
        this.country = country;
    }

    public static void main(String[] args) {

        /**
         * ad a) Class variable - zmienna taka nie jest przypisana do żadnego konkretnego obiektu klasy.
         * Nie muszę tworzyć obiektu klasy żeby ją wywołać.
         */
        System.out.println(race);

        /**
         * ad b) Instance variable - w różnych obiektach tej klasy taka zmienna może mieć przypisane różne wartości.
         * Muszę stworzyć obiekt klasy żeby ją wywołać.
         */
        f_StaticVariables classInstance1 = new f_StaticVariables("Wiktor", "Poland");
        f_StaticVariables classInstance2 = new f_StaticVariables("Luc", "France");
        System.out.println(classInstance1.name);
        System.out.println(classInstance2.name);
    }
}
