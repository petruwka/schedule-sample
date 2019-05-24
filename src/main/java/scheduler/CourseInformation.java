package scheduler;

import java.time.LocalDate;
import java.util.Objects;

public class CourseInformation {
    private String name;
    private int totalHours;
    private LocalDate startDate = LocalDate.now();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseInformation that = (CourseInformation) o;
        return totalHours == that.totalHours &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalHours);
    }

    @Override
    public String toString() {
        return "CourseInformation{" +
                "name='" + name + '\'' +
                ", totalHours=" + totalHours +
                '}';
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}
