package com.jijian.assemble.utils;
/**
@author chenchuan
@version 创建时间：2019年4月29日下午4:50:17
*/

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ExportToExcel {

    // 2007 版本以上 最大支持1048576行
    public  final static String  EXCEl_FILE_2007 = "2007";
    // 2003 版本 最大支持65536 行
    public  final static String  EXCEL_FILE_2003 = "2003";
    /**
     * <p>
     * 导出带有头部标题行的Excel <br>
     * 时间格式默认：yyyy-MM-dd hh:mm:ss <br>
     * </p>
     *
     * @param title 表格标题
     * @param headers 头部标题集合
    * @param map 数据集合
     * @param out 输出流
     * @param version 2003 或者 2007，不传时默认生成2003版本
     */
    public void exportExcel(String title, String[] headers, Map<String, List<String>> map, OutputStream out, String version) {
        if(StringUtils.isBlank(version) || EXCEL_FILE_2003.equals(version.trim())){
            exportExcel2003(title, headers, map, out, "yyyy-MM-dd HH:mm:ss");
        }else{
            exportExcel2007(title, headers, map, out, "yyyy-MM-dd HH:mm:ss");
        }
    }
    /**
     *此方法生成2007版本的excel,文件名后缀：xlsx <br>
     */
    @SuppressWarnings({ "resource", "deprecation" })
	public static void exportExcel2007(String filepath, String[] headers, Map<String, List<String>> map, OutputStream out, String pattern) {
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 生成一个表格
//        XSSFSheet sheet = workbook.createSheet(title);
        XSSFSheet sheet = workbook.createSheet("sheet1");
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(20);
        // 生成一个样式
        XSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(new XSSFColor(java.awt.Color.gray));
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        XSSFFont font = workbook.createFont();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setColor(new XSSFColor(java.awt.Color.BLACK));
        font.setFontHeightInPoints((short) 11);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        XSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE));
        style2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        XSSFFont font2 = workbook.createFont();
        font2.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);
        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell=null;
        for (int i = 0; i < headers.length; i++) {
            cell = row.createCell((short) i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style);
        }
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到,list中字符串的顺序必须和数组strArray中的顺序一致
        int i = 0;
        for (String str : map.keySet()) {
            row = sheet.createRow((int) i + 1);
            List<String> list = map.get(str);
            // 第四步，创建单元格，并设置值
            for (int j = 0; j < headers.length; j++) {
                row.createCell((short) j).setCellValue(list.get(j));
            }
            // 第六步，将文件存到指定位置
          /*  try {
                File file = new File(filepath);
                File parentFile = file.getParentFile();
                if(!parentFile.exists()){
                    parentFile.mkdirs();
                }
                FileOutputStream fout = new FileOutputStream(file);
                workbook.write(fout);
                fout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            i++;
         }
            try {
                workbook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    /**
     * <p>
     * 此方法生成2003版本的excel,文件名后缀：xls <br>
     * </p>

     */
    @SuppressWarnings("deprecation")
	public static void exportExcel2003(String filepath, String[] headers, Map<String, List<String>> map, OutputStream out, String pattern) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
//        HSSFSheet sheet = workbook.createSheet(filepath);
        // 设置表格默认列宽度为15个字节
        HSSFSheet sheet = workbook.createSheet("sheet1");
        sheet.setDefaultColumnWidth(20);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setColor(HSSFColor.WHITE.index);
        font.setFontHeightInPoints((short) 11);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.WHITE.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);
        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cellHeader =null;
        for (int i = 0; i < headers.length; i++) {
            cellHeader = row.createCell((short) i);
            cellHeader.setCellValue(headers[i]);
            cellHeader.setCellStyle(style);
        }
        int i = 0;
        List<String> listI = new ArrayList<>();
        for(String strI : map.keySet()){
        	listI.add(strI);
        }
        // 从大到小   Collections.sort(listI,Collections.reverseOrder()); 
        // 从小到大 
        Collections.sort(listI);
        for (String str : map.keySet()) {
            row = sheet.createRow((int) i + 1);
            List<String> list = map.get(str);

            // 第四步，创建单元格，并设置值
            for (int j = 0; j < headers.length; j++) {
                row.createCell((short) j).setCellValue(list.get(j));
            }

            // 第六步，将文件存到指定位置
//            try {
//                File file = new File(filepath+".xls");
//                File parentFile = file.getParentFile();
//                if(!parentFile.exists()){
//                    parentFile.mkdirs();
//                }
//                FileOutputStream fout = new FileOutputStream(file);
//                workbook.write(fout);
//                fout.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            i++;
        }
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void exportExcelDownLoad (String fileName, String filepath, String[] headers, Map < String, List < String >> map, HttpServletResponse response, String version){
            try {
                response.setContentType("application/vnd.ms-excel");
                if (StringUtils.isBlank(version) || EXCEL_FILE_2003.equals(version.trim())) {
                    response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
                    exportExcel2003(filepath, headers, map, response.getOutputStream(), "yyyy-MM-dd");
                } else {
                    response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
                   exportExcel2007(filepath, headers, map, response.getOutputStream(), "yyyy-MM-dd hh:mm:ss");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
