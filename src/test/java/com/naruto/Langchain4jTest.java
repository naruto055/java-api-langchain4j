package com.naruto;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

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

    @Autowired
    private QwenChatModel qwenChatModel;

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

    /**
     * 调用openai大模型
     * 在配置文件中可以修改请求的base-url，目前是通过阿里百炼调用deepseekv3模型
     */
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

    /**
     * 测试调用阿里千问
     */
    @Test
    public void testQwenModel() {
        String answer = qwenChatModel.chat("你是谁");
        System.out.println(answer);
    }

    /**
     * 测试文生图
     */
    @Test
    public void testDashScopeWanx() {
        WanxImageModel wanxImageModel = WanxImageModel.builder().modelName("wanx2.1-t2i-turbo")
                .apiKey("sk-b87fccf9a9aa4df49f62b63945a74c3f")
                .build();
        Response<Image> response = wanxImageModel.generate("奇幻森林精灵：在一片弥漫着轻柔薄雾的古老森林深处，阳光透过茂密枝叶洒下金色光斑。一位身材娇小、长着透明薄翼的精灵少女站在一朵硕大的蘑菇上。她有着海藻般的绿色长发，发间点缀着蓝色的小花，皮肤泛着珍珠般的微光。身上穿着由翠绿树叶和白色藤蔓编织而成的连衣裙，手中捧着一颗散发着柔和光芒的水晶球，周围环绕着五彩斑斓的蝴蝶，脚下是铺满苔藓的地面，蘑菇和蕨类植物丛生，营造出神秘而梦幻的氛围。");
        URI url = response.content().url();
        System.out.println(url);
    }
}
