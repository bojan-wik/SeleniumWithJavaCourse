package Chapter32_CoreJava3_Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c_HashMap {

    public static void main(String[] args) {

        /**
         * object that maps keys to values
         */
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "first name");
        hashMap.put(2, "last name");
        hashMap.put(3, "age");
        hashMap.put(4, "nationality");

        //System.out.println(hashMap.get(4));

        /**
         * can not contain duplicate keys - valuesy są nadpisywane
         */
        hashMap.put(1, "address");
        //System.out.println(hashMap.get(1));

        /**
         * usuwanie
         */
        hashMap.remove(3);
        //System.out.println(hashMap.get(3));

        /**
         * Mogę za pomocą metody entrySet() przekonwertować HashMap na Set.
         * Wtedy taki Set będzie zawierał elementy składające się key-values z HashMapy.
         * Każdy z tych elementów (key-value) to obiekt Map.Entry
         */
        Set hashMapConvertedToSet = hashMap.entrySet();
        //System.out.println("Initial mappings are: " + hashMap);
        //System.out.println("The set is: " + hashMapConvertedToSet);

        /**
         * Następnie mogę przeiterować po takim przekonwertowanym secie, podobnie jak robiłem to już wcześniej.
         * Różnica jest taka, że tutaj każdy z elementów setu to kombinacja key-value. Wyprintowanie setIterator.next() da mi takie właśnie kombinacje.
         */
        Iterator setIterator1 = hashMapConvertedToSet.iterator();
        while (setIterator1.hasNext()) {
            System.out.println(setIterator1.next());
        }

        /**
         * Aby dostać się osobno do key i osobno do value muszę najpierw zcastować setIterator.next() do Map.Entry
         * potem za pomocą dedykowanych metod printować osobno key i osobno value/
         */
        Iterator setIterator2 = hashMapConvertedToSet.iterator();
        while (setIterator2.hasNext()) {
            Map.Entry mapEntry = (Map.Entry)setIterator2.next();
            System.out.println(mapEntry.getKey());
            System.out.println(mapEntry.getValue());
        }
    }
}
