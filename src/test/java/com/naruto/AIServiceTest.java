package com.naruto;

import com.naruto.assistant.Assistant;
import com.naruto.assistant.MemoryChatAssistant;
import com.naruto.assistant.SeparateChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author wenqunsheng
 * @date 2025/4/30 11:42
 */
@SpringBootTest
public class AIServiceTest {

    @Autowired
    private QwenChatModel qwenChatModel;

    /**
     * 手动创建Assistant对象
     */
    @Test
    public void testChat() {
        Assistant assistant = AiServices.create(Assistant.class, qwenChatModel);
        String answer = assistant.chat("你好，你是谁");
        System.out.println(answer);
    }

    @Autowired
    private Assistant assistant;

    @Test
    public void testAssistant() {
        String answer = assistant.chat("你好，你是谁");
        System.out.println(answer);
    }

    /**
     * 测试聊天记忆
     */
    @Test
    public void testChatMemory() {
        String answer1 = assistant.chat("我是张三");
        System.out.println(answer1);

        String answer2 = assistant.chat("我是谁");
        System.out.println(answer2);
    }

    /**
     * 测试聊天记忆2
     */
    @Test
    public void testChatMemory2() {
        UserMessage userMessage1 = UserMessage.userMessage("我是张三");
        ChatResponse chatResponse1 = qwenChatModel.chat(userMessage1);
        AiMessage aiMessage1 = chatResponse1.aiMessage();
        System.out.println(aiMessage1.text());

        UserMessage userMessage2 = UserMessage.userMessage("我是谁");
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(userMessage1, aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
        System.out.println(aiMessage2.text());
    }

    /**
     * 测试聊天记忆3
     * 使用MessageWindowChatMemory
     */
    @Test
    public void testChatMemory3() {
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        Assistant assistant1 = AiServices.builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(chatMemory)
                .build();

        String answer1 = assistant1.chat("我是张三");
        System.out.println(answer1);

        String answer2 = assistant1.chat("我是谁");
        System.out.println(answer2);
    }

    @Resource
    private MemoryChatAssistant memoryChatAssistant;

    /**
     * 测试聊天记忆4
     * 使用MemoryChatAssistant，在MemoryChatAssistant中已经配置了MessageWindowChatMemory
     */
    @Test
    public void testChatMemory4() {
        String answer1 = memoryChatAssistant.chat("我是张三");
        System.out.println(answer1);

        String answer2 = memoryChatAssistant.chat("我是谁");
        System.out.println(answer2);
    }

    @Resource
    private SeparateChatAssistant separateChatAssistant;

    /**
     * 测试聊天记忆隔离
     */
    @Test
    public void testChatMemory5() {
        String answer1 = separateChatAssistant.chat(1, "我是张三");
        System.out.println(answer1);

        String answer2 = separateChatAssistant.chat(1, "我是谁");
        System.out.printf(answer2);

        String answer3 = separateChatAssistant.chat(2, "你是谁");
        System.out.println(answer3);
    }
}
