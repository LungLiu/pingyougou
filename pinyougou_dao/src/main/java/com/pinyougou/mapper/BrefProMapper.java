package com.pinyougou.mapper;

import com.pinyougou.pojo.BrefPro;
import com.pinyougou.pojo.BrefProExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrefProMapper {
    int countByExample(BrefProExample example);

    int deleteByExample(BrefProExample example);

    int deleteByPrimaryKey(Integer bpId);

    int insert(BrefPro record);

    int insertSelective(BrefPro record);

    List<BrefPro> selectByExample(BrefProExample example);

    BrefPro selectByPrimaryKey(Integer bpId);

    int updateByExampleSelective(@Param("record") BrefPro record, @Param("example") BrefProExample example);

    int updateByExample(@Param("record") BrefPro record, @Param("example") BrefProExample example);

    int updateByPrimaryKeySelective(BrefPro record);

    int updateByPrimaryKey(BrefPro record);
}