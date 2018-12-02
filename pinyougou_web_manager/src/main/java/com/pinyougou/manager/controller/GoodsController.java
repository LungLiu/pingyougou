package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;

import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojogroup.Goods;

import com.pinyougou.sellergoods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Arrays;
import java.util.List;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Reference
    private GoodsService goodsService;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbGoods> findAll() {
        return goodsService.findAll();
    }


    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows) {
        return goodsService.findPage(page, rows);
    }

    /**
     * 修改
     *
     * @param goods
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Goods goods) {
        try {
            goodsService.update(goods);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public Goods findOne(Long id) {
        return goodsService.findOne(id);
    }




    @Autowired
    private Destination queueSolrDeleteDestination;//用户在索引库中删除记录
    @Autowired
    private Destination topicPageDeleteDestination;//用户在索引库中删除商品详细页

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(final Long[] ids) {
        if (ids.length > 0) {
            try {
                goodsService.delete(ids);

//                itemSearchService.deleteByGoodsIds(Arrays.asList(ids));

                //从索引库中删除
                jmsTemplate.send(queueSolrDeleteDestination, new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createObjectMessage(ids);
                    }
                });


                //删除每个服务器上的详细页
                jmsTemplate.send(topicPageDeleteDestination, new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createObjectMessage(ids);
                    }
                });

                return new Result(true, "删除成功");
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "删除失败");
            }
        } else {
            return new Result(false, "请选择商品");
        }
    }

    /**
     * 查询+分页
     * @param goods
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbGoods goods, int page, int rows) {
        return goodsService.findPage(goods, page, rows);
    }




//    @Reference(timeout = 100000)
//    private ItemSearchService itemSearchService;

    @Autowired
    private Destination queueSolrDestination;//用于导入solr索引库的消息目标（点对点）
    @Autowired
    private Destination topicPageDestination;//用于生成商品详细页面的消息模板（发布订阅）
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 更新状态
     * @param ids
     * @param status
     * @return
     */
    @RequestMapping("/updateStatus")
    public Result updateStatus(Long[] ids, String status) {
        if (ids.length > 0) {
            try {
                goodsService.updateStatus(ids, status);

                if ("1".equals(status)) {//如果是审核通过
                    //****导入到索引库
                    //得到需要导入的SKU列表
                    List<TbItem> itemList = goodsService.findItemListByGoodsIdListAndStatus(ids, status);
                    //导入到solr
                    //itemSearchService.importList(itemList);

                    final String jsonString = JSON.toJSONString(itemList);//转换为json传输


                    jmsTemplate.send(queueSolrDestination, new MessageCreator() {

                        @Override
                        public Message createMessage(Session session) throws JMSException {

                            return session.createTextMessage(jsonString);
                        }
                    });

                    //****生成商品详细页
                    for (final Long goodsId : ids) {
//                        ItemPageService.genItemHtml(goodsId);

                        jmsTemplate.send(topicPageDestination, new MessageCreator() {

                            @Override
                            public Message createMessage(Session session) throws JMSException {
                                return session.createTextMessage(goodsId + "");
                            }
                        });
                    }
                }

                return new Result(true, "状态更新成功");

            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "状态更新失败");
            }
        } else {
            return new Result(false, "请选择商品");
        }
    }

//    @Reference(timeout = 100000)
//    private ItemPageService ItemPageService;

    /**
     * 生成商品详细页
     *
     * @param goodsId
     */
    @RequestMapping("/genHtml")
    public void genHtml(Long goodsId) {
//        ItemPageService.genItemHtml(goodsId);


    }
}
