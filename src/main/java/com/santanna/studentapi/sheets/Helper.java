package com.santanna.studentapi.sheets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.santanna.studentapi.domain.model.Student;
import com.santanna.studentapi.exception.SheetsExceptions;

public class Helper {

  public static String[] HEADERS = {
      "Nome do Aluno (a)",
      "Turno",
      "Responsável Financeiro",
      "Telefone",
      "Data da Matricula",
      "Duração do Contrato",
      "Valor"
  };

  public static String SHEET_NAME = "student_data";

  public static ByteArrayInputStream dataToExcel(List<Student> list) {

    try {

      Workbook workbook = new XSSFWorkbook();
      ByteArrayOutputStream out = new ByteArrayOutputStream();

      Sheet sheet = workbook.createSheet(SHEET_NAME);

      Row row = sheet.createRow(0);

      for (int i = 0; i < HEADERS.length; i++) {
        Cell cell = row.createCell(i);
        cell.setCellValue(HEADERS[i]);
      }

      int rowIndex = 1;
      for (int i = 0; i < list.size(); i++) {
        Row dataRow = sheet.createRow(rowIndex++);
        Student student = list.get(i);
        dataRow.createCell(0).setCellValue(student.getName());
        dataRow.createCell(1).setCellValue(student.getShift());
        dataRow.createCell(2).setCellValue(student.getResponsible());
        dataRow.createCell(3).setCellValue(student.getPhone());
        dataRow.createCell(4).setCellValue(student.getData());
        dataRow.createCell(5).setCellValue(student.getContractTime());
        dataRow.createCell(6).setCellValue(student.getPrice());
      }

      workbook.write(out);
      workbook.close();
      out.close();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (Exception e) {
      throw new SheetsExceptions("Error generating Excel file");
    }

  }
}
