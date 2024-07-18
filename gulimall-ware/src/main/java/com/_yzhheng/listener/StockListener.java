package com._yzhheng.listener;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._yzhheng.rest.services.WmsWareSkuService;
import com._yzhheng.to.OrderTo;
import com._yzhheng.to.StockLockedTo;
import com._yzhheng.vo.OrderVo;
import com.rabbitmq.client.Channel;

@RabbitListener(queues = "stock.release.stock.queue")
@Service // TODO: Check @Service meaning
public class StockListener {

    @Autowired
    WmsWareSkuService wmsWareSkuService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    /*
     * 库存成功，订单回滚的情况，必须解锁
     * 自动扫描来确保这情况
     */
    @RabbitHandler
    public void releaseStock(StockLockedTo to, Message message, Channel channel) throws IOException {
        try {
            wmsWareSkuService.unlockStock(to);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
        }
    }

    /*
     * 订单关闭后触发的解锁逻辑
     */
    @RabbitHandler
    public void handleOrderCloseRelease(OrderVo ordervo, Message message, Channel channel) throws IOException {
        System.out.println("订单关闭准备解锁库存...");
        try {
            wmsWareSkuService.unlockStock(ordervo);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            System.out.println("订单关闭错误");
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
        }
    }
}
