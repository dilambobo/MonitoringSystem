package com.example.monitoringsystem.Report;

import com.example.monitoringsystem.Sensor.Sensor;
import com.example.monitoringsystem.System.Systemm;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

// сохраняет отчет о работе в эксель
public class DataSaver {

    public void saveReport (ArrayList<Systemm> systems, File file) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();

        for (Systemm systemm : systems) {
            XSSFSheet sheet = workbook.createSheet(systemm.getSystemName());
            sheet.setColumnWidth(0, 7500);

            int i = 1;
            XSSFRow upRow = sheet.createRow(0);
            upRow.createCell(0,CellType.STRING).setCellValue("Датчик");
            upRow.createCell(1,CellType.STRING).setCellValue("Показания");
            upRow.createCell(2,CellType.STRING).setCellValue("Исправность");
            for (Sensor sensor : systemm.getSensors()) {
                XSSFRow row = sheet.createRow(i);
                row.createCell(0, CellType.STRING).setCellValue(sensor.getSensorName());
                row.createCell(1, CellType.STRING).setCellValue(sensor.getMeasurement());
                row.createCell(2, CellType.STRING).setCellValue(sensor.getOperationAbility());
                i++;
            }
        }

        workbook.write(new FileOutputStream(file));
        workbook.close();
    }
}
