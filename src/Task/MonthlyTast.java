package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTast extends Task {
    private final LocalDateTime dataTime;
    private final Integer id;

    public MonthlyTast(String title, Type type, String description) {
        super(title, type, description);
        this.id = idGenerator;
        this.dataTime = LocalDateTime.now();
    }

    @Override
    public boolean appearsIn(LocalDate inputDate, LocalDate taskdate) {
        if(inputDate.getDayOfMonth() == taskdate.getDayOfMonth())
            return true;
        else return false;
    }
    @Override
    public String toString() {
        return "Ежемесячная задача №" + id + " : "+ getTitle()+ " ("+ getType() + " ) Время создания "+
                dataTime + getDescription();
    }
}
