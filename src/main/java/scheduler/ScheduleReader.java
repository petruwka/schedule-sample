package scheduler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleReader {
    public CourseInformation getCourse() {
        return course;
    }

    public List<ScheduleLesson> getSchedules() {
        return schedules;
    }

    private CourseInformation course;
    private List<ScheduleLesson> schedules;

    public void read(Path scheduleTxt) throws IOException {
        List<String> strings = Files.readAllLines(scheduleTxt);

        readCourseInfo(strings);
        readSchedule(strings);

    }

    private  void readCourseInfo(List<String> strings) {
        CourseInformation course = new CourseInformation();
        String name = strings.get(0);
        course.setName(name);

        String hours = strings.get(1);
        course.setTotalHours(Integer.parseInt(hours));

        this.course = course;
    }

    private void readSchedule(List<String> strings) {
        List<ScheduleLesson> schedules = new ArrayList<>();
        for (int i = 2; i < strings.size(); i++) {
            String scheduleString = strings.get(i);

            String[] split = scheduleString.split(",");
            DayOfWeek day = DayOfWeek.valueOf(split[0].toUpperCase());
            LocalTime from = LocalTime.parse(split[1]);
            LocalTime to = LocalTime.parse(split[2]);

            ScheduleLesson schedule = new ScheduleLesson(day, from, to);

            System.out.println("schedule " + (i - 2) + " " + schedule);
            schedules.add(schedule);


        }
        this.schedules = schedules;
    };



}
