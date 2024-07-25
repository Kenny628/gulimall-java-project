package com._yzhheng.payment;

import com._yzhheng.rest.services.OmsOrderService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.net.Webhook;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WebhookController {

    @Autowired
    OmsOrderService omsOrderService;

    @Value("${stripe.webhookSecret}")
    private String secretKey;

    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook(@RequestBody String payload, HttpServletRequest request,
            HttpServletResponse response) {
        String secret = secretKey;

        try {
            Event event = Webhook.constructEvent(payload, request.getHeader("Stripe-Signature"), secret);

            // Handle the event
            switch (event.getType()) {
                case "checkout.session.completed":
                    // Handle successful payment
                    // https: // docs.stripe.com/metadata#prevent-fraud
                    Event.Data dataObject = event.getData();
                    System.out.println(dataObject.toJson().toString());
                    JSONObject obj = JSON.parseObject(dataObject.toJson().toString());
                    String orderSn = obj.getJSONObject("object").getJSONObject("metadata").getString("order_id");
                    System.out.println(orderSn);
                    // Update Order Status to Paid
                    // JsonObject metadata = dataObject.getObject()
                    // .get("metadata").getAsJsonObject();
                    // System.out.println("Retrived orderSn from Stripe: " +
                    // metadata.get("order_id").getAsString());
                    omsOrderService.setOrderStatusToPaid(orderSn);
                    return ResponseEntity.ok("Webhook handled: " + event.getType());

                case "checkout.session.expired":
                    // Handle failed payment
                    return ResponseEntity.ok("Webhook handled: " + event.getType());
                // Add more cases for other event types as needed
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("Unhandled event type: " + event.getType());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Webhook error: " + e.getMessage());
        }
    }

    @GetMapping("/hiiii")
    public ResponseEntity<String> hiu() {
        return ResponseEntity.ok("hi");

    }
}