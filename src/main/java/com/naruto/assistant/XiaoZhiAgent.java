package com.naruto.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @author wenqunsheng
 * @date 2025/5/12 19:52
 */
@AiService(
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProviderXiaoZhi",
        wiringMode = AiServiceWiringMode.EXPLICIT,
        tools = "appointmentTools",
        contentRetriever = "contentRetrieverXiaozhi"
)
public interface XiaoZhiAgent {

    @SystemMessage("xiaozhi-prompt-template.txt")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
