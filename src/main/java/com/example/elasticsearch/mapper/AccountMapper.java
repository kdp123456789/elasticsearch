package com.example.elasticsearch.mapper;

import com.example.elasticsearch.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 账号表 Mapper 接口
 * </p>
 *
 * @author xuliqun
 * @since 2020-09-03
 */
@Mapper
public interface AccountMapper {

    @Select(" select * from t_account where id = #{id}  ")
    Account twoTest(@Param("id") Integer id);

}
