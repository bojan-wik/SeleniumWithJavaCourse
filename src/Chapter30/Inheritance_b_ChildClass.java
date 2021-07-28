package Chapter30;

/**
 * Tworzę klasę child, która reprezentuje cechy przyszłej generacji aut produkowanej przez firmę 'X'.
 * Podpinam się do klasy parent za pomocą keyworda 'extends'. Dzięki temu klasa child dziedziczy wszystkie cechy aut, które muszą być wspólne dla wszystkich generacji.
 */
public class Inheritance_b_ChildClass extends Inheritance_a_ParentClass {

    public static void main(String[] args) {

        Inheritance_b_ChildClass childClass = new Inheritance_b_ChildClass();
        /**
         * Tworzę obiekt klasy 'Inheritance_ChildClass', która dziedziczy metody klasy 'Inheritance_ParentClass'
         */
        String color = childClass.color;
        System.out.println(color);
        childClass.Gear();
        childClass.Brakes();
        childClass.Audiosystem();

        childClass.Engine();
    }

    /**
     * Poza tym mogę tworzyć metody, które są specific dla danej klasy child np. engine, która jest cechą wprowadzoną tylko dla tej konkretnej generacji aut.
     */
    public void Engine() {
        System.out.println("Engine code is implemented.");
    }
}
