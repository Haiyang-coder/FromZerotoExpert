package com.shk.service;

import com.shk.domain.DisallowWord;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: sunhengkang
 * @date:2022/10/6
 */
public interface SensitiveService {
    List<DisallowWord> getdisallowWord();
}
