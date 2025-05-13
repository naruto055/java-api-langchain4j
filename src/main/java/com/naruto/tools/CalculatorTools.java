package com.naruto.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.MemoryId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wenqunsheng
 * @date 2025/5/12 20:18
 */
@Slf4j
@Component
public class CalculatorTools {
    @Tool
    double sum(@MemoryId int memoryId, @P("加数1") double a, @P("加数2") double b) {
        log.info("调用加法运算，memoryId：{}", memoryId);
        return a + b;
    }

    @Tool
    double squareRoot(@MemoryId int memoryId, double x) {
        log.info("调用平方根运算，memoryId：{}", memoryId);
        return Math.sqrt(x);
    }
}
