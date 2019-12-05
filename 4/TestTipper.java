import net.sourceforge.jFuzzyLogic.FIS;

/**
 * Тестовый парсер FCL-файла
 * компилируем командой "javac -cp ./jFuzzyLogic_v2.1a.jar TestTipper.java"
 * далее кладем файл TestTipper.class в каталог TestTipper
 * и запускаем командой "java -cp ./jFuzzyLogic_v2.1a.jar:TestTipper TestTipper" (Unix)
 * или "java -cp ./jFuzzyLogic_v2.1a.jar;TestTipper TestTipper" (Windows)
 */
public class TestTipper {
  public static void main(String[] args) throws Exception {
    // Загружаем 'FCL' файл.
    String fileName = "tipper.fcl";
    FIS fis = FIS.load(fileName,true);
    // Ошибка при загрузке?
    if( fis == null ) { 
        System.err.println("Ошибка при загрузке файла: '" 
                                + fileName + "'");
        return;
    }

    // Показываем.
    fis.chart();

    // Задаем значения входных переменных.
    fis.setVariable("distancetogoal", 8);
    fis.setVariable("weather", 8);
    fis.setVariable("batterylife", 8);
    fis.setVariable("alreadyhave", 3);

    // Вычисляем.
    fis.evaluate();

    // Печатаем информацию о выходной перменной.
    System.out.println(fis.getVariable("go").toString());

    // Печатаем вещественное значение последней дефаззификации выходной переменной.
    System.out.println(fis.getVariable("go").getValue());

    // Показываем график выходной переменной. 
    fis.getVariable("go").chartDefuzzifier(true);

    // Печатаем информацию о выходной перменной.
    System.out.println(fis.getVariable("speed").toString());

    // Печатаем вещественное значение последней дефаззификации выходной переменной.
    System.out.println(fis.getVariable("speed").getValue());

    // Показываем график выходной переменной. 
    fis.getVariable("speed").chartDefuzzifier(true);
    // Печатаем набор правил.
    System.out.println(fis);
  }
}
