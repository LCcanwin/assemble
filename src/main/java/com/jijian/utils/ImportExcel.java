package com.jijian.utils;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
    *Author:chenchuan
    *Date:2019/8/19 17:53
    *Content:
  */

public class ImportExcel {

    /**
     * 获取EXCLE中的数据  获取2007 xls
     *
     * @param file       EXCEL文件
     * @param ignoreRows 忽略行
     * @return 将需要获取的EXCEL数据以Map集合进行返回（KEY：EXCLE工作表名称，VALUE：以二维数组返回当前工作表的内容）
     */
    @SuppressWarnings("deprecation")
    public static List<Map<String, Object>> getData07(File file, int ignoreRows, String[] keyTitle) {
        Map<String, String[][]> dataMap = new LinkedHashMap<>();
        Map<String, Object> mapValue = new HashMap<>();
        List<Map<String, Object>> listM = new ArrayList<>();
        try {
            XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
            XSSFCell cell = null;
            for (int sheetIndex = 0; sheetIndex < xwb.getNumberOfSheets(); sheetIndex++) {
                List<String[]> result = new ArrayList<String[]>();
                int rowSize = 0;
                XSSFSheet st = xwb.getSheetAt(sheetIndex);
                String sheetName = xwb.getSheetName(sheetIndex);
                for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
                    XSSFRow row = st.getRow(rowIndex);
                    if (row == null) {
                        continue;
                    }
                    int tempRowSize = row.getLastCellNum() + 1;
                    if (tempRowSize > rowSize) {
                        rowSize = tempRowSize;
                    }
                    String[] values = new String[rowSize];
                    Arrays.fill(values, "");
                    boolean hasValue = false;
                    for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                        String value = "";
                        cell = row.getCell(columnIndex);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case XSSFCell.CELL_TYPE_STRING:
                                    if (!"".equals(cell.getStringCellValue()) || cell.getStringCellValue() != null) {
                                        value = cell.getStringCellValue();
                                    } else {
                                        value = "";
                                    }
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
                                    if (cell.getCellStyle().getDataFormatString() != null && (cell.getCellStyle().getDataFormatString().contains("yyyy") || cell.getCellStyle().getDataFormatString().contains("m") || cell.getCellStyle().getDataFormatString().contains("d")) && cell.getCellStyle().getDataFormatString().endsWith("@")) {
                                        Date date = cell.getDateCellValue();
                                        if (date != null) {
                                            value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                                        } else {
                                            value = "";
                                        }
                                    } else {
                                        value = new DecimalFormat("0").format(cell
                                                .getNumericCellValue());
                                    }
                                    break;
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    if (!cell.getCellFormula().equals("") || cell.getCellFormula() != null) {
                                        //  value = cell.getCellFormula();
                                        value = cell.getNumericCellValue() + ""; // 返回到这一步就不要返回了
                                    } else {
                                        value = "0";
                                    }
                                    break;
                                case XSSFCell.CELL_TYPE_BLANK:
                                    break;
                                case XSSFCell.CELL_TYPE_ERROR:
                                    break;
                                case XSSFCell.CELL_TYPE_BOOLEAN:
                                    value = (cell.getBooleanCellValue() == true ? "Y"
                                            : "N");
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (value == null || value.trim().equals("")) {
                            continue;
                        }
                        values[columnIndex] = rightTrim(value);
                        hasValue = true;
                    }

                    if (hasValue) {
                        result.add(values);
                    }
                }
                String[][] returnArray = new String[result.size()][rowSize];
                for (int i = 0 ; i < returnArray.length; i++) {
                    returnArray[i] = result.get(i);
                }
                if (keyTitle.length != 0) {
                    returnArray[0] = keyTitle;
                }
                dataMap.put(sheetName, returnArray);
            }
            System.out.println("\t" + dataMap.toString());
            for (String sheetName : dataMap.keySet()) {
                String[][] data = dataMap.get(sheetName);
                for (int i = 0; i < data.length - 1; i++) {
                    for (int j = 0; j < data[i].length-1; j++) {
                        if (data[i][j]!=null) {
//	                        key = data[0][j];
                            mapValue.put(data[0][j], data[i + 1][j]);
                        }
                    }
                    listM.add(mapValue);
                    mapValue = new HashMap<>();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listM;
    }

    private static String rightTrim(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) != 0x20) {
                break;
            }
            length--;
        }
        return str.substring(0, length);
    }
    /**
     * 获取EXCLE中的数据 获取2003 xls
     *
     * @param file       EXCEL文件
     * @param ignoreRows 忽略行
     * @return 将需要获取的EXCEL数据以Map集合进行返回（KEY：EXCLE工作表名称，VALUE：以二维数组返回当前工作表的内容）
     */
    @SuppressWarnings("deprecation")
    public static List<Map<String, Object>> getData03(File file, int ignoreRows, String[] keyTitle) {
        Map<String, String[][]> dataMap = new LinkedHashMap<>();
        Map<String, Object> mapValue = new HashMap<>();
        List<Map<String, Object>> listM = new ArrayList<>();
        try {
            HSSFWorkbook xwb = new HSSFWorkbook(new FileInputStream(file));
            HSSFCell cell = null;
            for (int sheetIndex = 0; sheetIndex < xwb.getNumberOfSheets(); sheetIndex++) {
                List<String[]> result = new ArrayList<String[]>();
                int rowSize = 0;
                HSSFSheet st = xwb.getSheetAt(sheetIndex);
                String sheetName = xwb.getSheetName(sheetIndex);
                for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
                    HSSFRow row = st.getRow(rowIndex);
                    if (row == null) {
                        continue;
                    }
                    int tempRowSize = row.getLastCellNum() + 1;
                    if (tempRowSize > rowSize) {
                        rowSize = tempRowSize;
                    }
                    String[] values = new String[rowSize];
                    Arrays.fill(values, "");
                    boolean hasValue = false;
                    for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {
                        String value = "";
                        cell = row.getCell(columnIndex);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case XSSFCell.CELL_TYPE_STRING:
                                    if (!"".equals(cell.getStringCellValue()) || cell.getStringCellValue() != null) {
                                        value = cell.getStringCellValue();
                                    } else {
                                        value = "";
                                    }
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
                                    if (cell.getCellStyle().getDataFormatString() != null && (cell.getCellStyle().getDataFormatString().contains("yyyy") || cell.getCellStyle().getDataFormatString().contains("m") || cell.getCellStyle().getDataFormatString().contains("d")) && cell.getCellStyle().getDataFormatString().endsWith("@")) {
                                        Date date = cell.getDateCellValue();
                                        if (date != null) {
                                            value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                                        } else {
                                            value = "";
                                        }
                                    } else {
                                        value = new DecimalFormat("0").format(cell
                                                .getNumericCellValue());
                                    }
                                    break;
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    if (!cell.getCellFormula().equals("") || cell.getCellFormula() != null) {
                                        //  value = cell.getCellFormula();
                                        value = cell.getNumericCellValue() + ""; // 返回到这一步就不要返回了
                                    } else {
                                        value = "0";
                                    }
                                    break;
                                case XSSFCell.CELL_TYPE_BLANK:
                                    break;
                                case XSSFCell.CELL_TYPE_ERROR:
                                    break;
                                case XSSFCell.CELL_TYPE_BOOLEAN:
                                    value = (cell.getBooleanCellValue() == true ? "Y"
                                            : "N");
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (value == null || value.trim().equals("")) {
                            continue;
                        }
                        values[columnIndex] = rightTrim(value);
                        hasValue = true;
                    }

                    if (hasValue) {
                        result.add(values);
                    }
                }
                String[][] returnArray = new String[result.size()][rowSize];
                for (int i = 0 ; i < returnArray.length; i++) {
                    returnArray[i] = result.get(i);
                }
                if (keyTitle.length != 0) {
                    returnArray[0] = keyTitle;
                }
                dataMap.put(sheetName, returnArray);
            }
            System.out.println("\t" + dataMap.toString());
            for (String sheetName : dataMap.keySet()) {
                String[][] data = dataMap.get(sheetName);
                for (int i = 0; i < data.length - 1; i++) {
                    for (int j = 0; j < data[i].length-1; j++) {
                        if (data[i][j]!=null) {
//	                        key = data[0][j];
                            mapValue.put(data[0][j], data[i + 1][j]);
                        }
                    }
                    listM.add(mapValue);
                    mapValue = new HashMap<>();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listM;
    }

    public static List<Map<String, Object>> judgeExcel (File file, int ignoreRows, String[] keyTitle)throws IOException{
        InputStream is = new  FileInputStream(file);
        if(!is.markSupported()) {
            is = new PushbackInputStream(is, 8);
        }
        if(POIFSFileSystem.hasPOIFSHeader(is)) {
            return  getData03(file,ignoreRows,keyTitle);
        }else  if(POIXMLDocument.hasOOXMLHeader(is)) {
            return getData07(file,ignoreRows,keyTitle);
        }
        return null;
    }
}
