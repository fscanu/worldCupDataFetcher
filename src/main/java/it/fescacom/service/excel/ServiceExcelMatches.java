package it.fescacom.service.excel;

import it.fescacom.domain.Match;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ServiceExcelMatches extends ServiceCRUDExcel {

    private static final String FILE_NAME = "MatchesResults.xlsx";

    public void createExcel(List<Match> matches) {
        XSSFWorkbook workbook = new XSSFWorkbook();

        createMatchesSheet(matches, workbook);

        writeFile(workbook);

    }

    private void writeFile(XSSFWorkbook workbook) {
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createMatchesSheet(List<Match> matches, XSSFWorkbook workbook) {
        XSSFSheet sheet = workbook.createSheet("WorldCup Matches Results");
        int rowNum = 0;
        System.out.println("Creating excel");

        for (Match match : matches) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            Cell opponentA = row.createCell(colNum++);
            opponentA.setCellValue(match.getOpponentA());
            Cell goalScoredA = row.createCell(colNum++);
            goalScoredA.setCellValue(match.getGoalScoredA());
            Cell opponentB = row.createCell(colNum++);
            opponentB.setCellValue(match.getOpponentB());
            Cell goalScoredB = row.createCell(colNum);
            goalScoredB.setCellValue(match.getGoalScoredB());

        }
    }

    public byte[] readExcel() {
        return new byte[0];
    }

    public void updateExcel() {

    }

    public void deleteExcel() {

    }
}
