package Chapter31_CoreJava2;

/**
 * Wyodrębniamy 2 typy constructorów:
 *      a) default / no-argument constructor
 *      b) parameterized constructor
 */
public class c_Constructors2 {

    /**
     * a) default / no-argument constructor (typ constructora o którym uczyłem się wcześniej w 'c_Constructors1.java')
     */
    public c_Constructors2() {
        System.out.println("Constructor (no-argument) is called");
    }

    /**
     * b) parameterized constructor
     */
    public c_Constructors2(String name) {
        System.out.printf("Constructor (parameterized) is called with argument: %s", name).println();
    }

    public static void main(String[] args) {
        /**
         * Nie jest tak, że wywoływane są wszystkie zdefiniowane constructory. Wywołuje się albo ten, albo ten.
         * Defaultowo wywoływany jest defaultowy (no-argument) constructor.
         *
         */
        c_Constructors2 c_constructors2 = new c_Constructors2();
        /**
         * Jeżeli chcę wywołać sparametryzowany contructor, muszę stworzyć osobny obiekt i podać odpowiedni argument
         */
        c_Constructors2 c_constructors2_1 = new c_Constructors2("Wiktor");
    }
}
/**
 * Podczas tworzenia contructorów działa ta sama zasada co podczas tworzenia metod - możliwy jest Overloading.
 * Mogę mieć więcej niż jednego constructora o tej samej nazwie (w tym przypadku ta sama nazwa jest wręcz wymuszana, bo wszystkie constructory muszą się nazywać tak samo jak ich klasa)
 * kiedy constructory różnią się od siebie:
 *  a) bądź liczbą parametrów
 *  b) bądź data typami parametrów
 *  c) bądź kolejnością parametrów
 */
