package Chapter30;

/**
 * Function Overloading - ficzer który pozwala na istnieje w obrębie jednej klasy wielu funkcji/metod o tej samej nazwie.
 * Jest to możliwe gdy:
 *
 *         a) data types parametrów są inne (np. int, String etc.)
 *
 *         b) Liczba parametrów jest inna
 *
 *         c) data types i liczba parametrów jest inna
 */
public class FunctionOverloading {

    public static void main(String[] args) {

        FunctionOverloading functionOverloadingExample = new FunctionOverloading();
        functionOverloadingExample.getData(5);
        functionOverloadingExample.getData("Eloooo!");
        functionOverloadingExample.getData(10, 100);
    }

    // Pierwsza funkcja
    public void getData(int a) {
        System.out.println(a);
    };

    // a) data types parametrów są inne
    public void getData(String a) {
        System.out.println(a);
    };

    // b) Liczba parametrów jest inna
    public void getData(int a, int b) {
        System.out.println(a);
        System.out.println(b);
    };

    // c) data types i liczba parametrów jest inna
    public void getData(String a, int b) {};
}





