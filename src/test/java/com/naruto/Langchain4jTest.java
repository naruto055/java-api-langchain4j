package com.naruto;

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

    @Test
    public void testGPT() {
/*        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("https://aiproxy.hzh.sealos.run")
                .apiKey("sk-wrPsPqcp9Jh2X4ZYdFRw2c7bK9Ygt8iLSkw9pVl98yikGmCk")
                .modelName("gpt-4o-mini")
                .build();

        String answer = model.chat("Say 'Hello World'");
        System.out.println(answer); // Hello World*/

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
}
