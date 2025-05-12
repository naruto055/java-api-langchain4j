package com.naruto.assistant;


import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * 初级智能体
 *
 * @Author: naruto
 * @CreateTime: 2025-05-07-21:38
 */
@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemory = "chatMemory"
)
public interface MemoryChatAssistant {

    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。{{it}}")
    String chat(String chatMessage);
}
