package com.naruto;

import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wenqunsheng
 * @date 2025/4/30 9:34
 */
@SpringBootTest
public class Langchain4jTest {

    @Autowired
    private OpenAiChatModel model;

    @Autowired
    private OllamaChatModel ollamaChatModel;

    @Test
    public void testGPT() {

        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();

        String answer = model.chat("Say 'Hello World'");
        System.out.println(answer);
    }

    @Test
    public void testSpringBoot() {
        String answer = model.chat("我是誰？");
        System.out.println(answer);
    }

    @Test
    public void testDeepSeekAPI() {
        String answer = model.chat("你是谁？");
        System.out.println(answer);
    }

    /**
     * 调用ollma本地大模型
     */
    @Test
    public void testOllama() {
        String answer = ollamaChatModel.chat("你是谁");
        System.out.println(answer);
    }
}
