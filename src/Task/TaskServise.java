package Task;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TaskServise {

    static Set<Task> taskSet = new HashSet<>();

    public static void addTask(Scanner scanner , Map<Integer , Task> taskMap){
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);

        System.out.println(" Название задачи " );
        String taskName = scanner.next();
        System.out.println(" Краткое описание ");
        String taskDescription = scanner.next();
        System.out.println("\n Выберите тип задачи:\n 1 - рабочая \n 2 - личная");

    }




}
