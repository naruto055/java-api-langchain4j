package com.naruto.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wenqunsheng
 * @date 2025/5/12 20:18
 */
@Slf4j
@Component
public class CalculatorTools {
    @Tool(name = "加法运算", value = "将两个参数a和b相加并返回运算结果")
    double sum(@P("加数1") double a, @P("加数2") double b) {
        log.info("调用加法运算");
        return a + b;
    }

    @Tool(name = "平方根运算", value = "计算给定参数的平方根并返回结果")
    double squareRoot(double x) {
        log.info("调用平方根运算");
        return Math.sqrt(x);
    }
}
