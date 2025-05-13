package com.naruto.controller;

import com.naruto.assistant.XiaoZhiAgent;
import com.naruto.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author wenqunsheng
 * @date 2025/5/12 20:02
 */
@RestController
@RequestMapping("/xiaozhi")
public class XiaoZhiController {

    @Resource
    private XiaoZhiAgent xiaoZhiAgent;

    @Operation(summary = "对话")
    @PostMapping(value = "/chat", produces = "text/stream;charset=utf-8")
    public Flux<String> chat(@RequestBody ChatForm chatForm) {
        return xiaoZhiAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}
