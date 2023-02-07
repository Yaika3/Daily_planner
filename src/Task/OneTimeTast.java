package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTast extends  Task {
    private final LocalDateTime dataTime;
    private final Integer id;

    public OneTimeTast(String title, Type type, String description) {
        super(title, type, description);
        this.id = idGenerator;
        this.dataTime = LocalDateTime.now();
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskdate) {
        return false;
    }

    @Override
    public String toString() {
        return "Одноразовая задача №" + id + " : "+ getTitle()+ " ("+ getType() + " ) Время создания "+
                dataTime + getDescription();
    }
}
