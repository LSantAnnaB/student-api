package com.santanna.studentapi.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.santanna.studentapi.domain.model.Adress;
import com.santanna.studentapi.domain.model.Student;

public class Helper {

  public static String[] HEADERS = {
          "Nome",
          "E-mail",
          "Telefone",
          "Curso",
          "Cpf",
          "Cep",
          "Número",
          "Rua",
          "bairro",
          "Cidade",
          "Estado"
  };

  public static String SHEET_NAME = "student_data";

  public static ByteArrayInputStream dataToExcel(List<Student> list, List<Adress> listAdres) {

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
        dataRow.createCell(1).setCellValue(student.getEmail());
        dataRow.createCell(2).setCellValue(student.getPhone());
        dataRow.createCell(3).setCellValue(student.getCourse());
        dataRow.createCell(4).setCellValue(student.getCpf());

        Adress address = listAdres.get(i);
        dataRow.createCell(5).setCellValue(address.getCep());
        dataRow.createCell(6).setCellValue(address.getLogradouro());
        dataRow.createCell(7).setCellValue(address.getNumero());
        dataRow.createCell(8).setCellValue(address.getBairro());
        dataRow.createCell(9).setCellValue(address.getLocalidade());
        dataRow.createCell(10).setCellValue(address.getUf());
      }

      workbook.write(out);
      workbook.close();
      out.close();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (Exception e) {
      throw new ExcelGenerationException("Error generating Excel file");
    }

  }
}
