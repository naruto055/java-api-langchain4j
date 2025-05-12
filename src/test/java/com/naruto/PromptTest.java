package com.naruto;

import com.naruto.assistant.SeparateChatAssistant;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wenqunsheng
 * @date 2025/5/12 19:10
 */
@SpringBootTest
public class PromptTest {

    @Resource
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testPrompt() {
        String answer = separateChatAssistant.chat(3, "我是张三");
        System.out.println(answer);
    }

    @Test
    public void testPrompt2() {
        String answer = separateChatAssistant.chat(4, "今天几号");
        System.out.println(answer);
    }
}
