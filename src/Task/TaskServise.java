package Task;

import Exeptions.TaskNotFoundExeptions;

import java.time.LocalDate;
import java.util.*;

public class TaskServise {

    static Set<Task> taskSet = new HashSet<>();

    public static void addTask(Scanner scanner , Map<Integer , Task> taskMap){
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        System.out.println(" Название задачи " );
        String taskName = scanner.next();
        System.out.println(" Краткое описание ");
        String taskDescription = scanner.next();
        System.out.println("\n Выберите тип задачи:\n 1 - личная \n 2 - рабочая");
        Type taskTyp = Type.PERSONAL;

        int menu2 = scanner2.nextInt();
        switch (menu2){
            case 1:
                taskTyp=Type.WORK;
                break;
            case 2:
                taskTyp = Type.PERSONAL;
                break;
            default:{
                System.out.println("Неверный тип задачи ");
                taskTyp=Type.valueOf("Личная");
            }

        }
        System.out.println("1 - однократная задача \n 2 - ежедневная \n 3 - еженедельная \n 4 - ежемесячная \n  5 - ежегодная");
        Task task1;
        int menu = scanner2.nextInt();
        switch (menu){
            case 1:
                task1=new OneTimeTast(taskName,taskTyp,taskDescription);
                break;
            case 2:
                task1 =new DailyTast(taskName,taskTyp,taskDescription);
                break;
            case 3:
                task1 = new WeeklyTast(taskName,taskTyp,taskDescription);
                break;
            case 4:
                task1 = new MonthlyTast(taskName,taskTyp,taskDescription);
                break;
            case 5:
                task1= new YearlyTast(taskName,taskTyp,taskDescription);
            default:{
                System.out.println("Неверно указана повторяемость задачи");
                task1=new OneTimeTast(taskName,taskTyp,taskDescription);
            }
        }

    }
    public static void updateDescription(Map<Integer,Task> tasks){
        Scanner scannerID = new Scanner(System.in);
        System.out.println("Ведите ID задачи которую нужно изменить");
        Integer id = scannerID.nextInt();
        try {
            chechID(tasks, id);
            Scanner scanner= new Scanner(System.in);
            System.out.println("Введите новое описание - ");
            String description = scanner.nextLine();
            tasks.get(id).setDescription(description);
            System.out.println("Задача "+ id + "Описание изменено "+ tasks.get(id).getDescription());
        }catch (TaskNotFoundExeptions e){
            System.out.println(e.getMessage() + id);
        }
    }
    public static void removedTask(Map<Integer,Task> tasks){
        Scanner scannerId = new Scanner(System.in);
        System.out.println("Напишите номер задачи для удаления ");
        Integer id=scannerId.nextInt();
        try {
            chechID(tasks, id);
            Task task = tasks.get(id);
            taskSet.add(task);
            tasks.remove(id);
            System.out.println("Задача "+ id + " Удалена ");
        }catch (TaskNotFoundExeptions e){
            System.out.println( e.getMessage() + id);
        }
    }
    public static void getRemovedTask(){
        if(taskSet.size()> 0){
            System.out.println(" Всего удаленных задач "+ taskSet.size());
            Iterator<Task> iterator =taskSet.iterator();
            while (iterator.hasNext()){
                Task next = iterator.next();
                System.out.println(next);
            }
        }else System.out.println(" Удаленных задач нет ");
    }
    public static void updateTitle(Map<Integer,Task> tasks){
        Scanner scannerID = new Scanner(System.in);
        System.out.println("Введите номер задачи для изменения названия ");
        Integer id = scannerID.nextInt();
        try {
            chechID(tasks, id);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите новое название ");
            String taskName = scanner.nextLine();
            tasks.get(id).setTitle(taskName);
            System.out.println("У задачи "+ id + "Новое название "+ tasks.get(id).getTitle());

        }catch (TaskNotFoundExeptions e){
            System.out.println(e.getMessage() + id);
        }

    }
    public static void getAllByDate (Map<Integer, Task> tasks , LocalDate date){
        int i = 0;
        for (Map.Entry<Integer, Task> task : tasks.entrySet()){
            LocalDate taskDate = task.getValue().getDateTime().toLocalDate();
            if (taskDate.equals(date) || task.getValue().appearsIn(date,taskDate)){}
            i++;
            System.out.println(task);
        }
    }
    public static LocalDate inputDate(){
        Scanner scannerDa = new Scanner(System.in);
        System.out.println("Введите день ");
        int d = scannerDa.nextInt();
        System.out.println("Введите месяц");
        int m = scannerDa.nextInt();
        System.out.println("Введите год ");
        int y = scannerDa.nextInt();
        return LocalDate.of(y,m,d);
    }
    public static void chechID (Map<Integer , Task> tasks , int id)throws TaskNotFoundExeptions{
        if(!tasks.containsKey(id)){
            throw new TaskNotFoundExeptions("Нет задачи с таким номером");
        }
    }

}
