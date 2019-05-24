package scheduler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Hello world!
 */
public class Samples {
    public static void main(String[] args) {

        String courseNamwe = "SQL essentials";
        int totalHours =       9;
        String day1 = "Tuesday,18:00,20:00";


        try {
//            File file = new File("");
//            FileInputStream fis = new FileInputStream(file);
//            InputStreamReader reader = new InputStreamReader(fis);
//            BufferedReader bufferedReader = new BufferedReader(reader);
//            Scanner scanner  = new Scanner(reader);
//            String s = bufferedReader.readLine();

            Path filePath = Paths.get("", "schedule.txt");
            List<String> strings = Files.readAllLines(filePath);
            System.out.println(strings);

            CourseInformation course = readCourseInfo(strings);
            System.out.println("Course: " + course);
            List<ScheduleLesson> schedules = readSchedule(strings);

            LocalDate start = LocalDate.now();
            generateLessons();


        } catch (IOException e) {
            System.out.println("File does not exists or cannot opened");
        }
    }

    private static List<ScheduleLesson> readSchedule(List<String> strings) {
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
        return schedules;
    };

    private static CourseInformation readCourseInfo(List<String> strings) {
        CourseInformation course = new CourseInformation();
        String name = strings.get(0);
        course.setName(name);

        String hours = strings.get(1);
        course.setTotalHours(Integer.parseInt(hours));

        return course;
    }

    public static void generateLessons() {
        int totalHours = 9;
        int scheduledHours = 0;


        ScheduleLesson scheduleLesson = new ScheduleLesson(DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(20, 0));
        List<Lesson> lessons = new ArrayList<>();
//        while (scheduledHours < totalHours) {
//
//            Lesson lesson = new Lesson();
//            lesson.schedule = scheduleLesson;
//
//            lessons.add(lesson);
//            scheduledHours += 2;
//
//        }

        System.out.println(lessons);


    }
}
