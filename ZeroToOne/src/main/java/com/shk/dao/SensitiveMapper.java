package com.shk.dao;

import com.shk.domain.DisallowWord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: sunhengkang
 * @date:2022/9/24
 */
@Mapper
public interface SensitiveMapper {
    @Select("select * from disallow_word;")
    List<DisallowWord> getdisallowWord();
}
