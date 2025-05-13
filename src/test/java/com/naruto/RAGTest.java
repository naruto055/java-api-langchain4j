package com.naruto;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.List;

/**
 * @author wenqunsheng
 * @date 2025/5/13 10:09
 */
@SpringBootTest
public class RAGTest {

    @Test
    public void testRag() {
        //使用FileSystemDocumentLoader读取指定目录下的知识库文档
        //并使用默认的文档解析器TextDocumentParser对文档进行解析
        Document document = FileSystemDocumentLoader.loadDocument("E:/BaiduNetdiskDownload/尚硅谷，小智医疗/资料/knowledge/测试.txt");
        System.out.println(document.text());
    }

    @Test
    public void testDocument() {
        // 加载单个文档
        Document document = FileSystemDocumentLoader.loadDocument("E:/BaiduNetdiskDownload/尚硅谷，小智医疗/资料/knowledge/测试.txt", new TextDocumentParser());

        // 从一个目录中加载所有文档
        //List<Document> documents = FileSystemDocumentLoader.loadDocuments("E:/BaiduNetdiskDownload/尚硅谷，小智医疗/资料/knowledge", new TextDocumentParser());

        // 从一个目录中加载所有的.txt文档
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.pdf");
        List<Document> documents = FileSystemDocumentLoader.loadDocuments("E:/BaiduNetdiskDownload/尚硅谷，小智医疗/资料/knowledge", pathMatcher, new TextDocumentParser());
        documents.forEach(item -> {
            System.out.println("========================");
            System.out.println(item.metadata());
            System.out.println(item.text());
        });

        // 从一个目录及其子目录中加载所有文档
        //List<Document> documents = FileSystemDocumentLoader.loadDocumentsRecursively("E:/BaiduNetdiskDownload/尚硅谷，小智医疗/资料/knowledge", new TextDocumentParser());
    }

    /**
     * 解析PDF
     */
    @Test
    public void testParsePDF() {
        Document document = FileSystemDocumentLoader.loadDocument("E:/BaiduNetdiskDownload/尚硅谷，小智医疗/资料/knowledge/医院信息.pdf", new ApachePdfBoxDocumentParser());
        System.out.println(document);
    }
}
