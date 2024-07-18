package com._yzhheng.payment;

import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.net.Webhook;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WebhookController {

    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook(@RequestBody String payload, HttpServletRequest request) {
        String secret = "whsec_63d56f3ea1ed37f4a9e43d34ea480d266392a8d5f1815974d417cad3a44b6b0c";

        try {
            Event event = Webhook.constructEvent(payload, request.getHeader("Stripe-Signature"), secret);

            // Handle the event
            switch (event.getType()) {
                case "payment_intent.succeeded":
                    // Handle successful payment
                    break;
                case "payment_intent.payment_failed":
                    // Handle failed payment
                    break;
                // Add more cases for other event types as needed
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("Unhandled event type: " + event.getType());
            }

            return ResponseEntity.ok("Webhook handled: " + event.getType());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Webhook error: " + e.getMessage());
        }
    }
}