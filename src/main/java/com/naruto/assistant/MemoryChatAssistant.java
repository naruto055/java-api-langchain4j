package com.naruto.assistant;


import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
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

    //@UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。{{it}}")    // 这个it占位符是固定的
    //String chat(String chatMessage);

    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。{{chatMessage}}")
    String chat(@V("chatMessage") String chatMessage);  // 明确指出占位符的名字就叫chatMessage
}
