package com.shk.service.impl;

import com.shk.dao.SensitiveMapper;
import com.shk.dao.UserMapper;
import com.shk.domain.DisallowWord;
import com.shk.service.SensitiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: sunhengkang
 * @date:2022/10/6
 */
@Service
public class SensitiveServiceImpl implements SensitiveService {
    @Autowired
    SensitiveMapper sensitiveMapper;
    @Override
    public List<DisallowWord> getdisallowWord() {
        return sensitiveMapper.getdisallowWord();
    }
}
