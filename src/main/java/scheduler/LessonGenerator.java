package scheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LessonGenerator {

    private int totalHours;
    private LocalDate startDate;

    public LessonGenerator(int totalHours, LocalDate startDate) {
        this.totalHours = totalHours;
        this.startDate = startDate;
    }

    public List<Lesson> generateLessons(List<ScheduleLesson> schedule) {
        List<Lesson> lessons = new ArrayList<>();
//        int plannedHours = 0;
//        while plannedHours < totalHours
                // then add more lesson


        return lessons;


    }
}
