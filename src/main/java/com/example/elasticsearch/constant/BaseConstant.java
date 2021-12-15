package com.example.elasticsearch.constant;


public interface BaseConstant {

    /**
     * 默认为空消息
     */
    String DEFAULT_NULL_MESSAGE = "暂无承载数据";
    /**
     * 默认成功消息
     */
    String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    /**
     * 默认失败消息
     */
    String DEFAULT_FAILURE_MESSAGE = "操作失败";

    /**
     * 默认失败消息
     */
    String HEADER_TOKEN = "token";

    String USER = "user";

    String ADMIN = "admin";

    String REDIS_TOKEN_PREFIX = "LOGIN:TOKEN:";

    /**
     * contentType
     */
    String CONTENT_TYPE_NAME = "Content-type";

    /**
     * FEGIN 调用
     */
    String FEGIN_SERVER = "fegin-server";

    /**
     * 编码
     */
    String UTF_8 = "UTF-8";

    /**
     * 编码
     */
    String IS_DELETE = "is_delete";

    /**
     * 删除状态[0:正常,1:删除]
     */
    int DB_NOT_DELETE = 0;
    int DB_IS_DELETE = 1;

    /**
     * 数字常量
     */
    int NUM_0 = 0;
    int NUM_1 = 1;
    int NUM_2 = 2;
    int NUM_3 = 3;
    int NUM_4 = 4;
    int NUM_5 = 5;
    int NUM_6 = 6;
    int NUM_7 = 7;
    int NUM_8 = 8;
    int NUM_9 = 9;
}
