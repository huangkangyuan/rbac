package com.hl.dto;

import com.google.common.collect.Lists;
import com.hl.pojo.SysDept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
@ToString
public class DeptLevelDto extends SysDept {

    //树形结构
    //技术组  -->前端
    //       -->后台
    private List<DeptLevelDto> deptList = Lists.newArrayList();

    public static DeptLevelDto adapt(SysDept dept) {
        DeptLevelDto dto = new DeptLevelDto();
        //把dept对象转成dto
        BeanUtils.copyProperties(dept, dto);
        return dto;
    }
}
