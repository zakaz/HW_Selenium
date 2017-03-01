package framework.environment;

/**
 * Created by admin1 on 25/2/17.
 */
public interface EnvBase {
    //Всегда нужно помнить, что тесты могут быть запущены с любого места с любой машины
    //Любой хардкод должен отсутствовать
    //Для таких целей лучше создать отдельный интерфейс, где будет удобно менять настройки,
    //а не бегать по всему коду и искать причины возникающих проблем
    String chromeDriverPath = "C:\\Users\\zakir_mustafin@epam.com\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe";
    String firefoxDriverPath = "...";
    String gridHubUrl = "http://localhost:4444/wd/hub";
//.....
}
