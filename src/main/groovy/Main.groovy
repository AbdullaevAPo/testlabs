import lab1.PrologTable

/**
 * Created by ali on 16.09.15.
 */
public class Main {
    public static void main(String[] args){
        // лабу я чутка поменял, аля пролог стайл, т.е.
        // есть таблица правил и таблица фактов
        // цель сначала проверяется на наличие такого факта, если факта нету
        // то начинается процесс унификации (лол) с одним из правил
        // и если заголов совпад, то рекурсивно
        // для каждого элемента из правой части правила запускаем
        // весь процесс
         def prologTable = new PrologTable(['a->c&b', 'b->d|p'],
                    ['c'])
        println(prologTable.table)

        println prologTable.findPath('a', 0)

    }
}
