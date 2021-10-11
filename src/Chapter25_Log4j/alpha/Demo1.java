package Chapter25_Log4j.alpha;

import org.apache.logging.log4j.*;

public class Demo1 {

    /**
     * Tworzę obiekt o nazwie 'logger', który jest obiektem klasy Logger. Przypisuję do niej wywołanie metody getLogger(), która jako argument
     * przyjmuje nazwę klasy, w której logger się znajduje ('Demo'). 'Demo.class.getName()' przekazuje całkowitą ścieżkę do klasy.
     */
    private static final Logger logger = LogManager.getLogger(Demo1.class.getName());

    public static void main(String[] args) {

        /**
         * Istnieje wiele metod do printowania tekstu, używanych w zależności od kontekstu np. debug, info, error, fatal itd.
         * Defaultowo Logger printuje tylko error message, w tym przypadku error i fatal. Messsage debug i info nie zostaną wyprintowane.
         * Trzeba zmienić konfigurację, żeby one też zostały wyprintowane. Taką konfigurację można ustawić za pomocą pliku .xml
         */
        logger.debug("debug message"); // eg. "I have clicked on button"
        logger.info("info message"); // eg. "Button is displayed"
        logger.error("error message"); // eg. "Button is NOT displayed"
        logger.fatal("fatal message"); // eg. "Button is missing"

        /**
         * Za pomocą pliku .xml można skonfigurować m.in.
         *      a) gdzie logować? czy np. tylko printować w konsoli, czy zapisywać wszystkie logi do zewn. pliku?
         *          za to odpowiada tag <Appenders> i odpowiednio tagi <Console> i <File>
         *      b) jak logować? możemy ustawić pattern wiadomości wewn. tagu <Console>
         *          np. <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
         *      c) co logować? ustawiane w tagu <Loggers> w którym z kolei są tagi <Logger> i <Root>
         *          np. sytuacja powyżej, gdzie logowane są tylko errory jest ustawiona poprzez <Root level="error">
         *          gdybym chciał żeby wszystkie typy message były printowane musiałbym ustawić <Root level="trace">
         */
    }
}
