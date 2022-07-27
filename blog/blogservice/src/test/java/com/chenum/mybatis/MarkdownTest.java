package com.chenum.mybatis;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MarkdownTest {

    String md = "# 维护模式\n" +
            "\n" +
            "维护模式主要拥有三个接口。\n" +
            "\n" +
            "ps:均不支持json，如果使用application/json 需要将long类型转为包装类，将对象包装为对象，一定程度影响效率\n" +
            "\n" +
            "### 一.是否开启维护模式接口\n" +
            "\n" +
            "```http\n" +
            "GET/POST http://10.43.10.30:31046/maintenancemodemanager/query\n" +
            "```\n" +
            "\n" +
            "| 名称  |  说明  | 是否必须 | 数据类型 |\n" +
            "| ----- | :----: | -------- | -------- |\n" +
            "| value | 商户ID | true     | String   |\n" +
            "\n" +
            "响应示例：\n" +
            "\n" +
            "```java\n" +
            "{\n" +
            "    \"code\":200,\n" +
            "\t\"message\":\"操作成功\",\n" +
            "\t\"result\":false\n" +
            "}\n" +
            "```\n" +
            "\n" +
            "### 二.设置分组值\n" +
            "\n" +
            "```http\n" +
            "POST http://10.43.10.30:31046/maintenancemodemanager/set\n" +
            "```\n" +
            "\n" +
            "| 名称    | 说明             | 是否必须 | 数据类型 |\n" +
            "| ------- | ---------------- | -------- | -------- |\n" +
            "| setVal1 | 32位二进制字符串 | true     | String   |\n" +
            "| setVal2 | 32位二进制字符串 | true     | String   |\n" +
            "\n" +
            "```java\n" +
            "@Test\n" +
            "    public void test(){\n" +
            "//        MutableDataSet options = new MutableDataSet();\n" +
            "//        options.setFrom(ParserEmulationProfile.MARKDOWN);\n" +
            "//        options.set(Parser.EXTENSIONS, List.of(TablesExtension.create()));\n" +
            "//        Parser parser = Parser.builder(options).build();\n" +
            "//        HtmlRenderer renderer = HtmlRenderer.builder(options).build();\n" +
            "//\n" +
            "//        // You can re-use parser and renderer instances\n" +
            "//        Node document = parser.parse(md);\n" +
            "//        String html = renderer.render(document);  // \"<p>This is <em>Sparta</em></p>\\n\"\n" +
            "//        System.out.println(html);\n" +
            "        List<Extension> extensions = List.of(TablesExtension.create());\n" +
            "        Parser parser = Parser.builder().extensions(extensions).build();\n" +
            "        Node document = parser.parse(md);\n" +
            "\n" +
            "        HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();\n" +
            "        String html = renderer.render(document);  // \"<p>This is <em>Sparta</em></p>\\n\"\n" +
            "        System.out.println(html);\n" +
            "\n" +
            "    }\n" +
            "```\n" +
            "\n" +
            "\n" +
            "\n" +
            "响应示例：\n" +
            "\n" +
            "```java\n" +
            "{\n" +
            "    \"code\": 200,\n" +
            "    \"message\": \"操作成功\",\n" +
            "    \"result\": null\n" +
            "}\n" +
            "```\n" +
            "\n" +
            "\n" +
            "\n";

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
