package Chapter30;

/**
 * Declared with the abstract keyword
 */
public abstract class AbstractClass_ParentAircraftRules {

    /**
     * Pierwsze dwie metody są non-abstract, mają jakieś body
     */

    public void engine() {
        System.out.println("Follow general engine construction rules");
    }

    public void safety() {
        System.out.println("Follow general safety rules");
    }

    /**
     * Ta metoda jest abstract, nie ma żadnego body
     */

    public abstract void color();
}
