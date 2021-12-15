package com.example.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.example.elasticsearch.bean.User;
import com.example.elasticsearch.service.DSOneService;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
class ElasticsearchApplicationTests {

    @Resource
    private DSOneService dsOneService;

    @Autowired
    private RestHighLevelClient client;

    /**
     * 创建索引
     * @throws IOException
     */
    @Test
    void one() throws IOException {
        dsOneService.oneTest();
        dsOneService.twoTest(317);
        dsOneService.threeTest(371);
    }


    /**
     * 创建索引
     * @throws IOException
     */
    @Test
    void createIndex() throws IOException {
        //创建索引
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("kdp-01");
        //执行请求
        CreateIndexResponse response = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    /**
     * 获取索引
     * @throws IOException
     */
    @Test
    void exitIndex() throws IOException {
        //获取索引
        GetIndexRequest createIndexRequest = new GetIndexRequest("kdp-01");
        //执行请求
        GetIndexResponse response = client.indices().get(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(response.getAliases());
    }

    /**
     * 删除索引
     * @throws IOException
     */
    @Test
    void deleteIndex() throws IOException {
        //创建索引
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("kdp-01");
        //执行请求
        AcknowledgedResponse delete = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete.isFragment());
    }

    /**
     * 添加文档
     * @throws IOException
     */
    @Test
    void createDoc() throws IOException {
        //创建对象
        User user = new User("张三", 12, "男", "法外狂徒");
        //创建求求
        IndexRequest request = new IndexRequest("kdp-01");
        //规则
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");
        //放入请求
        IndexRequest source = request.source(JSON.toJSONString(user), XContentType.JSON);
        //客户端发送请求
        IndexResponse index = client.index(request, RequestOptions.DEFAULT);
        System.out.println(index.toString());
    }

    /**
     * 获取文档
     */
    @Test
    void isExxitDoc(){
        GetRequest getRequest = new GetRequest();
    }

    @Test
    public void pwdEncode(){
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
        //比较匹配
        boolean matches = bCryptPasswordEncoder.matches("123456", encode);
        System.out.println(matches);
    }
}
