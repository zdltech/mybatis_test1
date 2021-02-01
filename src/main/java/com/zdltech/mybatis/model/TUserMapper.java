package com.zdltech.mybatis.model;

import com.zdltech.mybatis.entity.TUserEntity;

import java.util.List;

public interface TUserMapper {
    List<TUserEntity> selectAll();
}
