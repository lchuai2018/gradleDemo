package cn.sishun.example.dao;

import cn.sishun.example.entity.VevorBaseInfo;

public interface VevorBaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VevorBaseInfo record);

    int insertSelective(VevorBaseInfo record);

    VevorBaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VevorBaseInfo record);

    int updateByPrimaryKey(VevorBaseInfo record);
}