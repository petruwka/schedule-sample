package scheduler;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;

public class SCheduleExcelGenerator {
    Workbook workbook;
    Sheet scheduleSheet;
    int lessons = 0;

    //    Workbook workbook = XSSFWro
    SCheduleExcelGenerator() {
        workbook = new XSSFWorkbook();
        scheduleSheet = workbook.createSheet("schedule");
    }

    public void addGenralSection(CourseInformation courseInformation) {
//        workbook.getSheet();
//        sheet.createCell(0, 0);
//        cell.setTExt(courseInformation.getName());
    }

    public void addLesson(Lesson lesson) {
        int rowNum = 2 + lessons + 1;

        Row row = scheduleSheet.createRow(rowNum);
        Cell date = row.createCell(0);
        date.setCellValue(lesson.getDate().format(DateTimeFormatter.BASIC_ISO_DATE));

        Cell timeFrom = row.createCell(1);
        timeFrom.setCellValue(lesson.getFrom().format(DateTimeFormatter.ISO_TIME));
        Cell timeTO = row.createCell(2);
        timeTO.setCellValue(lesson.getTo().format(DateTimeFormatter.ISO_TIME));

        lessons++;
        //
    }

    public void generate(Path target) throws IOException {
        workbook.write(Files.newOutputStream(target));
    }

}
