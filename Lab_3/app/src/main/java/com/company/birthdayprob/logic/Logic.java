package com.company.birthdayprob.logic;

import java.util.Random;
import java.util.ArrayList; // метод позволяет работать со списками
import com.company.birthdayprob.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early Android interactions.
 * Designing the assignments this way allows you to first learn key 'Java' features without
 * having to beforehand learn the complexities of Android.
 *
 */
public class Logic 
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG =
        Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * <p>
     * It is called 'mOut' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'mOut' is good enough).
    */
    OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labelled 'Process...' is pressed.
     */
    public void process() {
        int groupSize = mOut.getSize();
        int simulationCount = mOut.getCount();

        if (groupSize < 2 || groupSize > 365) {
            mOut.makeAlertToast("Group Size must be in the range 2-365.");
            return;
        }
        if (simulationCount <= 0) {
            mOut.makeAlertToast("Simulation Count must be positive.");
            return;
        }

        double percent = calculate(groupSize, simulationCount);

        // report results
        mOut.println("For a group of " + groupSize + " people, the percentage");
        mOut.println("of times that two people share the same birthday is");
        mOut.println(String.format("%.2f%% of the time.", percent));

    }

    /**
     * This is the method that actually does the calculations.
     * <p>
     * We provide you this method that way we can test it with unit testing.
     */
    public double calculate(int size, int count) {
        // TODO -- add your code here
        // оздаём массив(список) неопределённой длины
        /* ArrayList<Integer> peopleList = new ArrayList<Integer>();
        double counter = 0;

        // проводим определённое количество эксперементов
        for (int j = 0; j < count; j++) {
            final Random random = new Random(j);

            // для каждого эксперемента заполняем массив определённым количеством случайных чисел(дней рождений)
            // благодаря библиотеке пользуемся удобными методами
            for (int i = 0; i < size; i++) {
                peopleList.add(random.nextInt(365));
            }

            /* ищем вхождение символа i, если символ встречается в массиве больше(то есть первое вхождение
            * символа это и не есть последнее), тогда учитываем это в счётчике и выходим из цикла, так как по
            * условию надо найти вхождение только у двух людей из группы */
            // for (int i = 0; i < peopleList.size(); i++){

               // if (peopleList.indexOf(peopleList.get(i)) != peopleList.lastIndexOf(peopleList.get(i))){
                  //  counter++;
                 //   break;
              //  }
           // }

            // очищаем список для следущего эксперимента
           // peopleList.clear();
       // }
       // return (counter / count * 100); */

        int[] peopleList = new int[size];
        double counter = 0; // нельзя что бы было int, потому что результат становится равен нулю(хз почему)

        // проводим определённое количество эксперементов
        for (int j = 0; j < count; j++) {

            final Random random = new Random(j);

            // для каждого эксперемента заполняем массив определённым количеством случайных чисел(дней рождений)
            for (int i = 0; i < size; i++) {
                peopleList[i] += random.nextInt(365);
            }

            // переменная внутреннего цикла сравнения, чтоб сравнивать числа со следующими
            int insideCount = 1;

            // перебираем массив дней рождений
            for (int i = 0;  i < peopleList.length; i++){

                // сравниваемое число
                int num = peopleList[i];

                // указатель для завершения эксперемента
                boolean flag = false;

                /* ищем вхождение символа i, если символ совпал с другим, значит условие соблюдено
                добавляем значение к счётчику и выходим, то есть такое день рождение уже существует, поэтому
                завершаем эксперимент с этой группой */
                for (int k = insideCount; k < peopleList.length; k++) {
                    if (peopleList[k] == num) {
                        counter++;
                        flag = true;
                        break;
                    }
                }

                // прибавляем 1, чтоб счётчик сравнения начинался со следующего числа
                insideCount++;

                /* выходим при первом совпадении дней рождений, так как надо найти совпадение у двух
                членов группы, то есть одного совпадения в группе достаточно (первый эксперемент - есть
                совпадение в группе, тогда выходим и начинаем новый эксперимент с другой группой) */
                if (flag) {
                    break;
                }
            }

            // очищаем массив для следущего эксперимента
            for (int i = 0; i < peopleList.length; i++) {
                peopleList[i] = 0;
            }
        }

        /* для нахождения общего процента совпадений, надо взять количество совпадений дней рождений в группах,
        при каждом эксперименте, и разделить на общее количество эксперементов умножив результат на 100 */
        return (counter / count * 100);
    }
    // TODO - add your code here
}
