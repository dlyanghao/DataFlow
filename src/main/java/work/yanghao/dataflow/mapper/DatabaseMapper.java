package work.yanghao.dataflow.mapper;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DatabaseMapper {

    void createTable(@Param("headList")List headList, @Param("tableName")String tableName);

    void insertData(@Param("headList") List headList,@Param("dataList") List dataList, @Param("tableName")String tableName);
}
