package com.naruto.assistant;


import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @Author: naruto
 * @CreateTime: 2025-05-07-21:54
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "calculatorTools"  // 配置工具
)
public interface SeparateChatAssistant {

    @SystemMessage(fromResource = "systemMessage.txt")
    //@SystemMessage("你是我的好朋友，请用东北话回答问题")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @UserMessage("你是我的好朋友，请用东北话回答问题，并且添加一些表情符号。{{userMessage}}")
    String chat2(@MemoryId int memoryId, @V("userMessage") String userMessage);  // 有两个，或两个以上的参数时，就需要使用@V注解了

    @SystemMessage(fromResource = "user-prompt-template3.txt")
    String chat3(@MemoryId int memoryId, @UserMessage String userMessage, @V("username") String username, @V("age") int age);
}
