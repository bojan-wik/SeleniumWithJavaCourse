package Chapter32;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<String>();
        /**
         * unordered collection of objects
         */
        hashSet.add("one");
        System.out.println(hashSet);
        hashSet.add("two");
        System.out.println(hashSet);
        hashSet.add("three");
        System.out.println(hashSet);
        hashSet.add("four");
        System.out.println(hashSet);
        System.out.println(hashSet.size());
        /**
         * cannot contain duplicate elements - nie wywala błędu, po prostu po wyprinowaniu widać, że zduplikowany element
         * nie został dodany
         */
        hashSet.add("one");
        System.out.println(hashSet);
        System.out.println(hashSet.size());
        /**
         * jeżeli chcę przeiterować Set, muszę użyć metody iterator() - tak jak zrobiłem to w MultipleWindows.java
         */
        Iterator<String> hashSetIterator = hashSet.iterator();
        /*String hashSetElement1 = hashSetIterator.next();
        System.out.println(hashSetElement1);
        String hashSetElement2 = hashSetIterator.next();
        System.out.println(hashSetElement2);*/
        /**
         * w przypadku iterowania przez duży Set mogę użyć pętli while-loop i metody hasNext(), która zwraca true w momencie,
         * kiedy następny index/element jest obecny w Secie.
         */
        while (hashSetIterator.hasNext()) {
            System.out.println(hashSetIterator.next());
        }
    }
}
