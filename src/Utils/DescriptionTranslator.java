package Utils;

/**
 * Created by lexa on 31.03.16.
 */
public class DescriptionTranslator {

    public static String Translate(String input) {
        switch (input) {
            case "sky is clear":
                return "Ясно";
            case "light rain":
                return "Легкий дождь";
            case "moderate rain":
                return "Небольшой дождь";
            case "heavy intensity rain":
                return "Дождь";
            case "mist":
                return "Туман";
            case "scattered clouds":
                return "Небольшая облачность";
            case "few clouds":
                return "Переменная облачность";
            case "light snow":
                return "Небольшой снег";
            case "overcast clouds":
                return "Облачно";
            case "Sky is Clear":
                return "Ясно";
            case "broken clouds":
                return "Рваные облака";

        }
        return input;
    }

}
