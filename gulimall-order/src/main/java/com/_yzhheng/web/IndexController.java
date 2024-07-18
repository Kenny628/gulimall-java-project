package com._yzhheng.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com._yzhheng.exception.NoStockException;
import com._yzhheng.rest.services.OmsOrderService;
import com._yzhheng.vo.OrderConfirmVo;
import com._yzhheng.vo.OrderItemVo;
import com._yzhheng.vo.OrderSubmitVo;
import com._yzhheng.vo.SubmitOrderResponseVo;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    OmsOrderService omsOrderService;

    @GetMapping("/{page}.html")
    public String page(@PathVariable("page") String page) {
        return page;
    }

    @GetMapping("/toTrade")
    public String toConfirm(Model model) {

        OrderConfirmVo orderItems = omsOrderService.confirmOder();
        model.addAttribute("confirmOrder", orderItems);
        return "confirm";
    }

    @GetMapping("/payment")
    public String toPayment() {
        return "payment";
    }

    @PostMapping("/submitOrder")
    public String submitOrder(OrderSubmitVo orderSubmitVo, Model model, RedirectAttributes redirectAttributes) {
        // SubmitOrderResponseVo responseVo =
        // omsOrderService.submitOrder(orderSubmitVo);
        // 下单成功来到支付选择页
        // 下单失败回到订单确认页重新确认订单信息
        System.out.println("订单提交的数据：" + orderSubmitVo);
        try {
            // 下单操作
            SubmitOrderResponseVo responseVo = omsOrderService.submitOrder(orderSubmitVo);
            if (responseVo.getCode() == 0) {
                // 下单成功来到支付选择页面
                model.addAttribute("order", responseVo.getOrder());
                return "pay";
            } else {
                String msg = "下单失败，";
                switch (responseVo.getCode()) {
                    case 1:
                        msg += "令牌订单信息过期，请刷新再次提交";
                        break;
                    case 2:
                        msg += "订单商品价格发生变化，请确认后再次提交";
                        break;
                    case 3:
                        msg += "库存锁定失败，商品库存不足";
                        break;
                }
                redirectAttributes.addFlashAttribute("msg", msg);
                // 下单失败回到订单确认页重新确认订单信息
                return "redirect:http://order.gulimall.com:8600/toTrade";
            }
        } catch (Exception e) {
            if (e instanceof NoStockException) {
                String message = ((NoStockException) e).getMessage();
                redirectAttributes.addFlashAttribute("msg", message);
            }
            System.out.println(e.getMessage());
            return "redirect:http://order.gulimall.com:8600/toTrade";
        }
    }
}
