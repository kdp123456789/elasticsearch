package com.example.elasticsearch.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @param <T> 泛型
 * @author zzl
 * @author Kalend
 * @date 2020/6/22 11:52
 * 基础业务接口
 */
public interface BaseService<T> extends IService<T> {

    /**
     * 根据id查询实体
     *
     * @param id 主键
     * @return 实体
     */
    T getOneById(Integer id);

    /**
     * 根据条件查询实体
     *
     * @param entity 实体对象
     * @return 实体
     */
    T getOne(T entity);

    /**
     * 逻辑删除
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean removeById(Integer id);

    /**
     * 根据条件查询符合条件的集合
     *
     * @param entity 实体对象，条件
     * @return 实体集合
     */
    List<T> list(T entity);

    /**
     * 根据条件查询符合条件的分页数据集合
     *
     * @param page   分页容器
     * @param entity 实体对象，条件
     * @return 实体分页集合
     */
    IPage<T> page(IPage<T> page, T entity);

    /**
     * 根据提交删除
     *
     * @param entity 对象条件
     * @return boolean
     */
    boolean remove(T entity);

    /**
     * 根据条件获取总数
     *
     * @param entity 对象条件
     * @return 总数
     */
    Integer count(T entity);

    /**
     * 新增一条数据如果数据库内没有相关重复的字段
     *
     * @param entity 数据对象
     * @param nonRepeatFields 需要判断是属性
     * @return 0 表内有相关重复数据、1 插入成功、-1 插入失败
     */
    int insertIfNotExist(T entity, SFunction<T, Object>... nonRepeatFields);

    /**
     * 新增一条数据如果数据库内没有相关重复的字段
     * 默认使用或连接q
     * @param entity 数据对象
     * @param nonRepeatFields 需要判断是属性
     * @return 0 表内有相关重复数据、1 插入成功、-1 插入失败
     */
    int insertIfNotExist(T entity, boolean useOr, SFunction<T, Object>... nonRepeatFields);

    /**
     * 根据id查询数据
     * 如果查询不到，则抛出异常
     * @param id
     * @return
     */
    T throwIfNotExistById(Integer id);

    /**
     * 根据id查询数据
     * 如果查询不到，则抛出异常，自定义异常信息
     * @param id
     * @param errorMsg
     * @return
     */
    T throwIfNotExistById(Integer id, String errorMsg);

}