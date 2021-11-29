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
        hashMap.put(1, "yoł!");
        //System.out.println(hashMap.get(1));

        /**
         * usuwanie
         */
        hashMap.remove(3);
        //System.out.println(hashMap.get(3));

        //Set<Map.Entry<Integer, String>> HashMapObjectConvertedToSet = hashMapObject.entrySet();
        Set HashMapConvertedToSet = hashMap.entrySet();
        Iterator setIterator = HashMapConvertedToSet.iterator();

        while (setIterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry)setIterator.next();
            System.out.println(mapEntry.getKey());
            System.out.println(mapEntry.getValue());
        }
    }
}
