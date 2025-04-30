package com.naruto;

import com.naruto.assistant.Assistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
