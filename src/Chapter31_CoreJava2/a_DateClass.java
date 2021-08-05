package Chapter31_CoreJava2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class a_DateClass {

    public static void main(String[] args) {

        Date date = new Date();
        /**
         * Dafultowo na wyjściu otrzymuję datę w formacie: Thu Aug 05 14:48:19 CEST 2021
         */
        System.out.println(date);
        //System.out.println(date.toString());
        /**
         * W momencie kiedy chcę otrzymać datę w customowym formacie (np. dzień/miesiąc/rok) do tego celu muszę wykorzystać klasę SimpleDateFormat.
         * Jako argument podaję stringa z pożądanym formatem daty.
         */
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        /**
         * Obiekt klasy SimpleDateFormat (simpleDateFormat1) sam w sobie nie posiada informacji odnośnie bieżącej daty.
         * Posiada jedynie informację o pożądanym formacie daty.
         * Używam metody format(), jako argument podaję obiekt klasy Date (date) i na wyjściu otrzymuję bieżącą datę w pożądanym formacie.
         */
        System.out.println(simpleDateFormat1.format(date));

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(simpleDateFormat2.format(date));
    }
}
