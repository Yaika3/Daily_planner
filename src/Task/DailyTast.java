package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTast extends Task {
    private final LocalDateTime dataTime;
    private final Integer id;

    public DailyTast(String title, Type type, String description) {
        super(title, type, description);
        this.id = idGenerator;
        this.dataTime = LocalDateTime.now();
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskdate) {
        return true;
    }

    @Override
    public String toString() {
        return "Ежедневная задача №" + id + " : "+ getTitle()+ " ("+ getType() + " ) Время создания "+
                dataTime + getDescription();
    }
}
