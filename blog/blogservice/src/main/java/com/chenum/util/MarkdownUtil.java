package com.chenum.util;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.data.MutableDataSetter;

import java.util.List;

public class MarkdownUtil {

    private static final MutableDataSet options = new MutableDataSet();
    private static Parser parser;

    static {
        options.setFrom(ParserEmulationProfile.MARKDOWN)
                .set(Parser.EXTENSIONS, List.of(TablesExtension.create()));
        parser = Parser.builder(options).build();
    }

    private static final HtmlRenderer renderer = HtmlRenderer.builder(options).build();


    public static String md2Html(String md) {
        Node document = parser.parse(md);
        return renderer.render(document);
    }

    public static MutableDataSet set(MutableDataSetter dataSetter) {
        return options.setFrom(dataSetter);
    }
}
