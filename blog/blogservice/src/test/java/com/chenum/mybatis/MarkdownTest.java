package com.chenum.mybatis;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.junit.Test;

import java.util.List;

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
}
