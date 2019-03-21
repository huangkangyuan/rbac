package com.hl.dao;

import com.hl.beans.PageQuery;
import com.hl.dto.SearchLogDto;
import com.hl.pojo.SysLog;
import com.hl.pojo.SysLogWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysLogWithBLOBs record);

    int insertSelective(SysLogWithBLOBs record);

    SysLogWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SysLogWithBLOBs record);

    int updateByPrimaryKey(SysLog record);

    int countBySearchDto(@Param("dto") SearchLogDto dto);

    List<SysLog> getPageListBySearchDto(@Param("dto") SearchLogDto dto, @Param("page") PageQuery page);
}