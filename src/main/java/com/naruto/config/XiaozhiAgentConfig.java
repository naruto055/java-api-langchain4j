package com.naruto.config;

import com.naruto.store.MongoChatMemoryStore;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author wenqunsheng
 * @date 2025/5/12 19:58
 */
@Configuration
public class XiaozhiAgentConfig {

    @Resource
    private MongoChatMemoryStore mongoChatMemoryStore;

    @Bean
    public ChatMemoryProvider chatMemoryProviderXiaoZhi() {
        return memoryId -> MessageWindowChatMemory.builder().id(memoryId)
                .maxMessages(20)
                .chatMemoryStore(mongoChatMemoryStore)
                .build();
    }

    @Bean
    ContentRetriever contentRetrieverXiaozhi() {
        //使用FileSystemDocumentLoader读取指定目录下的知识库文档
        //并使用默认的文档解析器对文档进行解析
        Document document1 = FileSystemDocumentLoader.loadDocument("E:/BaiduNetdiskDownload/尚硅谷，小智医疗/资料/knowledge/医院信息.md");
        Document document2 = FileSystemDocumentLoader.loadDocument("E:/BaiduNetdiskDownload/尚硅谷，小智医疗/资料/knowledge/科室信息.md");
        Document document3 = FileSystemDocumentLoader.loadDocument("E:/BaiduNetdiskDownload/尚硅谷，小智医疗/资料/knowledge/神经内科.md");
        List<Document> documents = Arrays.asList(document1, document2, document3);
        //使用内存向量存储
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>
                ();
        //使用默认的文档分割器
        EmbeddingStoreIngestor.ingest(documents, embeddingStore);
        //从嵌入存储（EmbeddingStore）里检索和查询内容相关的信息
        return EmbeddingStoreContentRetriever.from(embeddingStore);
    }
}
