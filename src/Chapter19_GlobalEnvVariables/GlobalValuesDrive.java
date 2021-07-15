package Chapter19_GlobalEnvVariables;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * W Java możemy zaciągać dane z zewnętrznych plików *.properties.
 * W tym przypadku chcę zaciągnąć dane z pliku data.properties, który znajduje się w tym samym folderze co plik z klasą
 */
public class GlobalValuesDrive {

    public static void main(String[] args) throws IOException {

        /**
         * W Java istnieje klasa 'Properties', która umożliwia skanowanie plików *.properties i wyciąganie z nich
         * wskazanych wartości.
         * Najpierw tworzę obiekt tej klasy
         */
        Properties properties = new Properties();
        /**
         * Następnie muszę stworzyć obiekt reprezentujący  plik data.properties, aby zczytać jego treść.
         * Aby to zrobić. muszę najpierw stworzyć obiekt klasy FileInputStream i jako argument podaję ścieżkę (absolutną) do pliku data.properties.
         * Tworzę jakby stream treści pliku i umieszczam ten stream w obiekcie.
         */
        FileInputStream propertiesFileInput =
                new FileInputStream("C:\\Users\\bojanoww\\IdeaProjects\\SeleniumWithJavaCourse\\src\\Chapter19_GlobalEnvVariables\\data.properties");
        /**
         * Następnie wykorzystuję obiekt klasy properties i za pomocą jego metody 'load()' ładuję obiekt pliku data.properties,
         * potem mogę za pomocą metody 'getProperty()' zaciągać odpowiednie dane
         */
        properties.load(propertiesFileInput);
        System.out.println(properties.getProperty("browser"));
        System.out.println(properties.getProperty("url"));
        /**
         * Mogę także ingerować w dane keys i modyfikować ich values, a także ustanawiać nowe key=value.
         */
        properties.setProperty("browser", "Firefox");
        System.out.println(properties.getProperty("browser"));

        System.out.println(properties.getProperty("CompletelyNewKey"));
        properties.setProperty("CompletelyNewKey", "SomeValue");
        System.out.println(properties.getProperty("CompletelyNewKey"));

        /**
         * Sam plik data.properties nie jest modyfikowany. Modyfikowane są tylko wartości, które istnieją już w samym obiekcie klasy
         * Properties, a są nimi m.in. skopiowane wartości z pliku data.properties.
         * Aby móc zapisać zmiany muszę skorzystać z klasy 'FileOutputStream'
         */
        FileOutputStream propertiesFileOutput =
                new FileOutputStream("C:\\Users\\bojanoww\\IdeaProjects\\SeleniumWithJavaCourse\\src\\Chapter19_GlobalEnvVariables\\data1.properties");
    }
}
