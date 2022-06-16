package com.example.monitoringsystem.Report;

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

// сохраняет отчет о работе в эксель
public class DataSaver {

    public void saveReport (ArrayList<Systemm> systems, File file) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();

        for (Systemm systemm : systems) {
            XSSFSheet sheet = workbook.createSheet(systemm.getSystemName());
            sheet.setColumnWidth(0, 7500);
        }

        workbook.write(new FileOutputStream(file));
        workbook.close();
    }
}
