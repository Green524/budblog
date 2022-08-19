package com.chenum.mybatis;

import com.chenum.dao.ArticleMapper;
import com.chenum.po.Article;
import com.chenum.util.JsonUtil;
import com.chenum.vo.ArticleVO;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MarkdownTest {

    String md = """
            # 维护模式
            维护模式主要拥有三个接口。
            ps:均不支持json，如果使用application/json 需要将long类型转为包装类，将对象包装为对象，一定程度影响效率
            ### 一.是否开启维护模式接口
            ```http
            GET/POST http://10.43.10.30:31046/maintenancemodemanager/query
            ```
            | 名称  |  说明  | 是否必须 | 数据类型 |
            | ----- | :----: | -------- | -------- |
            | value | 商户ID | true     | String   |
            响应示例：
            ```java
            {
                "code":200,
            	"message":"操作成功",
            	"result":false
            }
            ```
            ### 二.设置分组值
            ```http
            POST http://10.43.10.30:31046/maintenancemodemanager/set
            ```
            | 名称    | 说明             | 是否必须 | 数据类型 |
            | ------- | ---------------- | -------- | -------- |
            | setVal1 | 32位二进制字符串 | true     | String   |
            | setVal2 | 32位二进制字符串 | true     | String   |
            响应示例：
            ```java
            {
                "code": 200,
                "message": "操作成功",
                "result": null
            }
            ```
                        
            """;

    @Resource
    ArticleMapper articleMapper;

    @Test
    public void test(){
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        options.set(Parser.EXTENSIONS, List.of(TablesExtension.create()));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // You can re-use parser and renderer instances
        Node document = parser.parse(md);
        String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        System.out.println(html);
    }

//    @Test
    public String test1(){
        ArticleVO article = new ArticleVO();
        article.setContent(md);
        article.setTitle("ffff");
        article.setIsLike(true);
        article.setIsAdmiration(true);
        article.setIsComment(true);
        article.setAuthor(Lists.list(1,2));
        article.setContentTag("1,2,");
        article.setCreator("ccc");
        article.setCreateTime(new Date());
        article.setUpdateTime(article.getCreateTime());
        return JsonUtil.toJsonString(article);
    }

    @Test
    public void test2() throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPut put = new HttpPut("http://localhost:8842/blog/add");
        put.addHeader("Content-Type", "application/json; charset=UTF-8");
        String md = test1();
        System.out.println(md);
        HttpEntity entity = new StringEntity(md, StandardCharsets.UTF_8);
        put.setEntity(entity);
        CloseableHttpResponse response = client.execute(put, HttpClientContext.create());
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void test3() throws IOException {
        String lineSeparator=System.getProperty("line.separator");
        String str = String.valueOf(lineSeparator.charAt(1));
        System.out.println(str);
        System.out.println(md.replace(str,""));

    }

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\admin\\Desktop\\tmp.txt");
        byte[] b = new byte[1024];
        int len = fileInputStream.read(b);
        System.out.println(Arrays.toString(b));
    }


}
