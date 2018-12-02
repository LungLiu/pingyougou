package com.pinyougou.page.service.impl;

import com.pinyougou.page.service.ItemPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * 监听类（删除生成网页）
 */
@Component
public class PageDeleteListener implements MessageListener {

    @Autowired
    private ItemPageService itemPageService;

    @Override
    public void onMessage(Message message) {

        ObjectMessage objectMessage = (ObjectMessage) message;

        try {
            Long[] goodsIds = (Long[]) objectMessage.getObject();
            System.out.println("接收到消息：" + goodsIds);
            boolean b = itemPageService.deleteHtml(goodsIds);
            System.out.println("网页删除：" + b);

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
