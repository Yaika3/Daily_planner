package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    static int idGenerator = 0;
    private String title;
    private final Type type;
    private int id;
    private final LocalDateTime dateTime;
    private String description;

    public Task(String title, Type type, String description) {
        this.idGenerator++;
        this.id = idGenerator;
        this.type = type;
        this.dateTime = LocalDateTime.now();
        if(description.isEmpty()) { description = " Пусто ";}
        this.description = description;
//        try {checkTitle(title)
//            this.title = title;
//        }catch (IncorrectArgumentExeption e){
//            System.out.println("title "+ title + "/n" + e.getMassage);
//        }throw  new IllegalArgumentException();
    }
    public int getId() {
        return id;
    }
    public Type getType() {
        return type;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idGenerator == task.idGenerator && id == task.id && dateTime == task.dateTime && Objects.equals(title, task.title) && Objects.equals(type, task.type) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenerator, title, type, id, dateTime, description);
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void appearsIn(){

    }

    public String getDescription() {
        return description;
    }

    public abstract boolean appearsIn(LocalDate inputDate, LocalDate taskdate);


    @Override
    public String toString() {
        return "Task{" +
                "idGenerator=" + idGenerator +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
