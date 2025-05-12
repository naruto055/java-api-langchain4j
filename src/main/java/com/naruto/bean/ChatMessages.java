package com.naruto.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author wenqunsheng
 * @date 2025/5/9 17:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("chat_messages")
public class ChatMessages {
    @Id
    private ObjectId messageId;

    /**
     * 存储当前聊天记录列表json字符串
     */
    private String content;

    /**
     * 聊天记忆id
     */
    private String memoryId;
}
