package com.naruto;

import com.naruto.bean.ChatMessages;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @author wenqunsheng
 * @date 2025/5/9 17:53
 */
@SpringBootTest
public class MongoCrudTest {

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void testInsert() {
        //mongoTemplate.insert(new ChatMessages(1L, "聊天记录"));
    }

    @Test
    public void testInsert2() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天2222222222记录");
        mongoTemplate.insert(chatMessages);
    }

    @Test
    public void testFindById() {
        ChatMessages chatMessages = mongoTemplate.findById("681dd19d9f63387fbf647ea4", ChatMessages.class);
        System.out.println(chatMessages);
    }

    @Test
    public void testUpdate() {
        Criteria criteria = Criteria.where("_id").is("10000");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "更新后的聊天记录");
        // 修改或新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    @Test
    public void testDelete() {
        Criteria criteria = Criteria.where("_id").is("10000");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }
}
