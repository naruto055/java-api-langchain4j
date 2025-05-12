package com.naruto;

import com.naruto.assistant.SeparateChatAssistant;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wenqunsheng
 * @date 2025/5/12 20:13
 */
@SpringBootTest
public class ToolsTest {

    @Resource
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testCalculatorTools() {
        String answer = separateChatAssistant.chat(9, "1+2等于多少, 475695037565的平方根是多少");
        System.out.println(answer);
    }
}
