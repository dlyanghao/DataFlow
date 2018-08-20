package work.yanghao.dataflow.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.yanghao.dataflow.mapper.DatabaseMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Service
public class DataImportService {

    @Autowired
    private DatabaseMapper databaseMapper;
    
    private List<String> titleList;

    public void importDatabase(File file){

        if(file.getName().contains(".xls")||file.getName().contains(".xlsx"))
        {
            System.out.println("开始对xml文件进行解析");
            try {
                XSSFWorkbook sheets = new XSSFWorkbook(file);
                //获取表头字段
                XSSFSheet sheet1 = sheets.getSheet("sheet1");
                XSSFRow header = sheet1.getRow(0);
                titleList = new ArrayList<>();
                for(int i=0;i<header.getLastCellNum();i++)
                {
                    titleList.add(header.getCell(i).getStringCellValue());
                }

                createTable(titleList,"TestTableName");

                int lastRowNum = sheet1.getLastRowNum();
                ArrayList<String> arrs;
                for (int i = 1; i < lastRowNum ; i++) {
                    XSSFRow row = sheet1.getRow(i);
                    arrs = new ArrayList<>();
                    for (int j = 0; j <row.getLastCellNum() ; j++) {
                        Cell cell = row.getCell(j);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String str = cell.getStringCellValue();
                        arrs.add(str);
                    }
                    insertData(titleList,arrs,"TestTableName");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("上传文件不符合类型或格式不符合要求");
        }
        
        
        
    }

    public void createTable(List headList, String tableName){

        databaseMapper.createTable(headList,tableName);
    }

    public void insertData(List headList,List dataList,String tableName){
        databaseMapper.insertData(headList,dataList,tableName);
    }
}
