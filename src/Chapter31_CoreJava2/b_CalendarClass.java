package Chapter31_CoreJava2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class b_CalendarClass {

    public static void main(String[] args) {

        /**
         * Tworzę obiekt klasy Calendar - w inny sposób niż to robiłem do tej pory. Klasa Calendar ma dedykowaną metodę
         * do inicjalizowania obiektów - getInstance()
         */
        Calendar calendar = Calendar.getInstance();

        /**
         * Podobnie, jak w przypadku klasy Date - korzystam z pomocy klasy SimpleDateFormat
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy \nhh:mm\n");
        String formattedCalendarDate = simpleDateFormat.format(calendar.getTime());
        System.out.println(formattedCalendarDate);

        /**
         * Ficzery unikalne dla klasy Calendar, których nie ma w klasie Date np. mogę ekstraktować poszczególne wartości z daty
         */
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(dayOfMonth);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hourOfDay);
        int isItAMorPM = calendar.get(Calendar.AM_PM);
        System.out.println(isItAMorPM);
    }
}
