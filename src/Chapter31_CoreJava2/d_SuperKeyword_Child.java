package Chapter31_CoreJava2;

/**
 * Super Keyword - byt, który pozwala na odnoszenie się do obiektów z klasy parent. Powiązane z koncepcją dziedziczenia.
 * Głównie używane z:
 *      a) zmiennymi
 *      b) metodami
 *      c) konstruktorami
 */
public class d_SuperKeyword_Child extends d_SuperKeyword_Parent {

    String text = "Text from child class";

    public void demoMethod() {
        System.out.println("Method from child class");
    }

    /**
     * c) I tak samo jest z wywoływaniem konstruktorów
     */
    public d_SuperKeyword_Child() {
        super();
        //super("Wiktor");
        System.out.println("Constructor from child class");
        /**
         * Generalnie w przypadku konstruktorów, nawet jeśli nie użyję keyworda super() to konstruktor z parent klasy jest automatycznie wywoływany,
         * ale tylko taki, który jest default / no-argument.
         * Jeżeli w parent klasie mam tylko parameterized constructor to tu już muszę typowo użyć keyworda super() z odpowiednim argumentem
         */
    }

    public void display() {
        /**
         * a) W tym przypadku zostanie wywołana zmienna text z klasy child. Działa tu zasada Overridingu, o której uczyłem się już wcześniej
         * - jeżeli mam dokładnie takie same zmienne (ta sama nazwa, to samo data type) w klasie parent i w klasie child to w obrębie klasy child
         * zmienna z klasy child nadpisuje tą z klasy parent.
         */
        System.out.println(text);
        /**
         * Co zrobić, aby wyprintować także text z klasy parent? Muszę skorzystać z keyworda 'super'.
         */
        System.out.println(super.text);
        /**
         * b) Tak samo jest z wywoływaniem funkcji.
         */
        demoMethod();
        super.demoMethod();
    }

    public static void main(String[] args) {

        d_SuperKeyword_Child d_superKeyword_child = new d_SuperKeyword_Child();
        d_superKeyword_child.display();
    }
}
