package vn.edu.ptit.toiec.usecases.Impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vn.edu.ptit.toiec.data.entities.Exam;
import vn.edu.ptit.toiec.data.repository.ExamRepository;
import vn.edu.ptit.toiec.usecases.ExcelService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private ExamRepository examRepository;

    private final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private final String[] COLUMNS_NAME = {"examName", "totalTime"};
    private final String SHEET_NAME = "exam";

    @Override
    // Kiểm tra xem định dạng của file có phải là Excel hay không
    public boolean isExcelFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())) return true;
        return false;
    }

    @Override
    // Lưu dữ liệu từ file Excel vào cơ sở dữ liệu
    public void save(MultipartFile file) {
        try {
            List<Exam> exams = this.convertToExam(file.getInputStream());
            examRepository.saveAll(exams);

        } catch (IOException e) {
            throw new RuntimeException("Lưu dữ liệu từ file Excel thất bại");
        }
    }

    @Override
    // Chuyển đổi dữ liệu từ InputStream của file Excel thành danh sách đối tượng Exam
    public List<Exam> convertToExam(InputStream inputStream) {
        try {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(SHEET_NAME);
            Iterator<Row> rows = sheet.iterator();

            List<Exam> exams = new ArrayList<>();

            int rowIndex = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (rowIndex == 0) {
                    rowIndex++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Exam exam = new Exam();

                int cellIndex = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIndex) {
                        case 0:
                            exam.setExamName(currentCell.getStringCellValue());
                            break;
                        case 1:
                            exam.setTotalTime(currentCell.getDateCellValue());
                            break;
                        default:
                            break;
                    }

                    cellIndex++;
                }

                exams.add(exam);
            }

            workbook.close();

            return exams;
        } catch (IOException e) {
            throw new RuntimeException("Chuyển đổi file Excel thất bại");
        }
    }
}
