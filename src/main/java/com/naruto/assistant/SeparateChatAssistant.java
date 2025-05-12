package com.naruto.assistant;


import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @Author: naruto
 * @CreateTime: 2025-05-07-21:54
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider"
)
public interface SeparateChatAssistant {

    @SystemMessage(fromResource = "systemMessage.txt")
    //@SystemMessage("你是我的好朋友，请用东北话回答问题")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);
}
