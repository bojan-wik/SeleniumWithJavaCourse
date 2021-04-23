package Chapter32;

import java.util.ArrayList;
/**
 * Przykład użycia ArrayList w Chapter8_9 -> AddProductsToCart_ImplicitExplicitWait.java
 */
public class ArrayListDemo {

    public static void main(String[] args) {

        /**
         * Standard array - basic functionality in Java.
         * fixed sized - wymaga określenia wielkości przy definiowaniu array i nie da się jej potem zmienić
         */
        //String[] array = {"Mietek", "Gieniu"};
        String array[] = new String[2];
        array[0] = "Mietek";
        array[1] = "Gieniu";
        /**
         * array nie da się w prosty sposób wyprintować, zazwyczaj trzeba zastosować for-loop
         */
        System.out.println(array);
        for (int i = 0; i < array.length; i += 1) {
            System.out.println(array[i]);
        }

        /**
         * ArrayList - part of Java collection framework.
         * dynamic sized - określenie wielkości przy definiowaniu ArrayList jest opcjonalne i da się ją potem zmienić
         */
        ArrayList<String> arrayList = new ArrayList<String>(2);
        arrayList.add("eloooo");
        arrayList.add("rap");
        /**
         * ArrayList da się w prosty sposób wyprintować
         */
        System.out.println(arrayList);
        /**
         * Dodawanie i usuwanie
         */
        arrayList.add(1, "gangsta");
        System.out.println(arrayList);
        arrayList.remove(0);
        System.out.println(arrayList);
        arrayList.add("ziomy");
        System.out.println(arrayList);
        arrayList.remove("rap");
        arrayList.add("ziomy");
        System.out.println(arrayList);
        /**
         * inne metody
         */
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.indexOf("ziomy"));
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.size());
    }
}
