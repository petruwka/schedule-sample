package scheduler;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LessonGeneratorTest {

    @Test
    public void shouldGenerateCorrectLesson() {
        int hours = 9;
        LocalDate start = LocalDate.of(2019, 6, 1);
        List<ScheduleLesson> onceAWeek = Arrays.asList(new ScheduleLesson(DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(21,0)));

        LessonGenerator lessonGenerator = new LessonGenerator(hours, start);
        List<Lesson> generatedLessons = lessonGenerator.generateLessons(onceAWeek);

        Assert.assertThat(generatedLessons, Matchers.hasSize(3));
        Assert.assertThat(generatedLessons, Matchers.hasItem(new Lesson(
                LocalDate.of(2019, 6,1),
                LocalTime.of(18, 0),
                LocalTime.of(21,0)))
        );
        // more asserts....
    }

}