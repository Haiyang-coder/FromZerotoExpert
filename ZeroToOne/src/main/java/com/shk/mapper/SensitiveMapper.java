package com.shk.mapper;

import com.shk.pojo.DisallowWord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: sunhengkang
 * @date:2022/9/24
 */
public interface SensitiveMapper {
    @Select("select * from disallow_word;")
    List<DisallowWord> getdisallowWord();
}
