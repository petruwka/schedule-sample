package scheduler;

import java.time.LocalDate;
import java.time.LocalTime;

public final class Lesson {
    private LocalDate date;
    private LocalTime from;
    private LocalTime to;

    public Lesson(LocalDate date, LocalTime from, LocalTime to) {
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getFrom() {
        return from;
    }

    public LocalTime getTo() {
        return to;
    }
}
