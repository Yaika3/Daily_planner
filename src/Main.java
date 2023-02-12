import Task.Task;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Task.TaskServise.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Task> tasks = new HashMap<>();
//        tasks.put(taskMap1)
        try (Scanner scanner = new Scanner(System.in)){
            label:
            while (true){
                printMenu1();
                System.out.println("Выберите пунк меню ");
                if(scanner.hasNext()){
                    int menu = scanner.nextInt();
                    switch (menu){
                        case 1:
                            addTask(scanner, tasks);
                            break ;
                        case 2:
                            removedTask(tasks);
                            break ;
                        case 3:
                            LocalDate date = inputDate();
                            System.out.println("Задачи на дату "+ date);
                            getAllByDate(tasks,date);
                            break ;
                        case 4:
                            getRemovedTask();
                            break ;
                        case 5:
                            updateTitle(tasks);
                            break ;
                        case 6:
                            updateDescription(tasks);
                            break label;


                    }
                }
            }

        }
    }

    private static void printMenu1() {
        System.out.println("\n 1 - Создать задачу \n 2 - Удалить задачу\n 3 - Задача на определенный день \n  4 - Список удаленных задач \n 5 - Поменять название задачи \n 6 - поменять описание \n  ");
    }
}
//создана новая ветка для пулла.