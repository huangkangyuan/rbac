package com.hl.service;

import com.hl.common.RequestHolder;
import com.hl.dao.SysDeptMapper;
import com.hl.exception.ParamException;
import com.hl.param.DeptParam;
import com.hl.pojo.SysDept;
import com.hl.util.BeanValidator;
import com.hl.util.IpUtil;
import com.hl.util.LevelUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class SysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;

    public void save(DeptParam param) {
        BeanValidator.check(param);
        //技术组 1 --》前端 3 - 1
        //        --》前端 3 - 1
        if(checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同名称的部门");
        }
        SysDept dept = SysDept.builder().name(param.getName()).parentId(param.getParentId())
                .seq(param.getSeq()).remark(param.getRemark()).build();

        //最后设置的level为0.1
        dept.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()), param.getParentId()));

        dept.setOperator(RequestHolder.getCurrentUser().getUsername());
        dept.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        dept.setOperateTime(new Date());
        sysDeptMapper.insertSelective(dept);
    }

    private boolean checkExist(Integer parentId, String deptName, Integer deptId) {
        return true;
    }


    private String getLevel(Integer deptId) {
        //deptId = 1 --> level == 0
        SysDept dept = sysDeptMapper.selectByPrimaryKey(deptId);
        if (dept == null) {
            return null;
        }
        return dept.getLevel();
    }
}
