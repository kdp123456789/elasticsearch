package com.example.elasticsearch.mapper;

import com.example.elasticsearch.bean.Personal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 人员表 Mapper 接口
 * </p>
 *
 * @author xuliqun
 * @since 2020-09-03
 */
@Mapper
public interface PersonalMapper {

    @Select(" select * from t_personal  ")
    List<Personal> oneTest();

}
