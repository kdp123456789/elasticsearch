package com.example.elasticsearch.service.serviceImpl;

import com.example.elasticsearch.mapper.PersonalMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 人员表 服务实现类
 * </p>
 *
 * @author xuliqun
 * @since 2020-09-03
 */
@Service
public class PersonalServiceImpl {

    @Resource
    private PersonalMapper personalMapper;

}
