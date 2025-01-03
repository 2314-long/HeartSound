package com.heartsound.common.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heartsound.common.user.pojo.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
