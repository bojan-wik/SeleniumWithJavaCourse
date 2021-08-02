package Chapter30;

/**
 * Function overriding - ficzer, który pozwala na zdefiniowanie w child-class customowej implementacji funkcji, która jest
 * odziedziczona z parent-class.
 * Kiedy dana metoda w child-class ma tą samą nazwę/parametry/signature/return-type co metoda w parent-class, to wtedy dochodzi do
 * sytuacji, w której metoda z child-class 'nadpisuje' odpowiadającą jej metodę z parent-class i to ona jest ostatecznie wykonywana przez program.
 */
public class FunctionOverriding extends Inheritance_a_ParentClass {

    public static void main(String[] args) {

        FunctionOverriding functionOverridingDemo = new FunctionOverriding();
        // metoda, która występuje tylko w child-class
        functionOverridingDemo.Roof();
        // metoda, która występuje zarówno w parent-class, jak i child-class
        // metoda z child-class nadpisuje metodę z parent-class
        functionOverridingDemo.Audiosystem();
        // metoda, która występuje tylko w parent-class
        functionOverridingDemo.Gear();

        /**
         * Jednocześnie możliwe jest stworzenie obiektu parent-clasy, wtedy wywołując tą samą metodę wywołujemy jej implementację
         * z parent-class.
         */
        Inheritance_a_ParentClass parentClassObject = new Inheritance_a_ParentClass();
        parentClassObject.Audiosystem();
    }

    public void Roof() {
        System.out.println("Roof code is implemented");
    }

    public void Audiosystem() {
        System.out.println("Audiosystem child-class code is implemented.");
    }
}
