package Chapter30_CoreJava1;

/**
 * Tworzę klasę parent, która reprezentuje cechy obecnej generacji aut produkowaną przez firmę 'X'.
 * Cechy te to: color, gear, brakes, audiosystem. Te cechy mają być wspólne dla obecnej i przyszłych generacji aut.
 */
public class Inheritance_a_ParentClass {

    String color = "red";

    public void Gear() {
        System.out.println("Gear code is implemented.");
    }

    public void Brakes() {
        System.out.println("Brakes code is implemented.");
    }

    public void Audiosystem() {
        System.out.println("Audiosystem parent-class code is implemented.");
    }
}
