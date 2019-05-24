package scheduler;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyApp {

    public static void main(String[] args) throws IOException {
        String scheduleTxtFile = "schedule.txt";

        // 1. read input data
        // 2a. parse data to class/object
        ScheduleReader scheduleReader = new ScheduleReader();
        scheduleReader.read(Paths.get(scheduleTxtFile));
        CourseInformation course = scheduleReader.getCourse();
        List<ScheduleLesson> schedule = scheduleReader.getSchedules();


        // 2b. generate lessons according to the schedule
        LessonGenerator lessonGenerator = new LessonGenerator(course.getTotalHours(), course.getStartDate());
        List<Lesson> lessons = lessonGenerator.generateLessons(schedule);

        // 3. generate excel according to lessons
        SCheduleExcelGenerator excelGenerator = new SCheduleExcelGenerator();
        for (Lesson lesson : lessons) {
            excelGenerator.addLesson(lesson);
        }

        excelGenerator.generate(Paths.get("sample.xlsx"));

    }

    private static List<Lesson> generateLessons() {
        return IntStream.range(1, 5)
                .mapToObj(MyApp::generateLesson)
                .collect(Collectors.toList());
    }

    private static Lesson generateLesson(int i) {
        return new Lesson(
                LocalDate.now().plusDays(i),
                LocalTime.of(18, 0),
                LocalTime.of(20, 0)
        );
    }
}
