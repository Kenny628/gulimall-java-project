package com._yzhheng.payment;

import com._yzhheng.rest.services.OmsOrderService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.PaymentIntent;
import com.stripe.model.checkout.Session;
import com.stripe.param.ChargeCreateParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.checkout.SessionCreateParams;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

        @Value("${stripe.currency}")
        private String currency;

        @Autowired
        OmsOrderService omsOrderService;
        // @PostMapping("/charge")
        // public ResponseEntity<String> chargeCard(@RequestParam(value = "amount",
        // required = true) String amount,
        // @RequestParam(value = "token", required = true) String tokenId) {
        // try {
        // // ChargeCreateParams createParams = new ChargeCreateParams.Builder()
        // // .setAmount(Long.parseLong(amount))
        // // .setCurrency(currency)
        // // .setSource(tokenId)
        // // .build();

        // PaymentIntentCreateParams createParams = PaymentIntentCreateParams.builder()
        // .setAmount(Long.parseLong(amount))
        // .setCurrency(currency)
        // .setConfirmationMethod(PaymentIntentCreateParams.ConfirmationMethod.AUTOMATIC)
        // .setPaymentMethod()
        // .setConfirm(true)
        // .build();

        // PaymentIntent paymentIntent = PaymentIntent.create(createParams);

        // // Charge charge = Charge.create(createParams);
        // return ResponseEntity.ok("Payment successful: " + charge.getId());
        // } catch (StripeException e) {
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment failed: "
        // + e.getMessage());
        // }
        // }
        //
        @PostMapping("/create-checkout-session")
        public ResponseEntity<String> chargeCard(HttpServletRequest request, HttpServletResponse response)
                        throws IOException, StripeException {
                String orderSn = request.getParameter("order_Sn");
                // String customerName = request.getParameter("payAmount");
                Map<String, String> metadata = new HashMap<>();
                metadata.put("order_id", orderSn);
                String YOUR_DOMAIN = "http://order.gulimall.com:8600";
                SessionCreateParams params = SessionCreateParams.builder().putAllMetadata(metadata)
                                .setMode(SessionCreateParams.Mode.PAYMENT)
                                .setSuccessUrl(YOUR_DOMAIN + "/success.html")
                                .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
                                .addLineItem(
                                                SessionCreateParams.LineItem.builder()
                                                                .setQuantity(1L)
                                                                .setPriceData(
                                                                                SessionCreateParams.LineItem.PriceData
                                                                                                .builder()
                                                                                                .setCurrency(currency)
                                                                                                .setUnitAmount(omsOrderService
                                                                                                                .getOrderStatus(orderSn)
                                                                                                                .getPayAmount()
                                                                                                                .multiply(new BigDecimal(
                                                                                                                                "100"))
                                                                                                                .longValueExact())
                                                                                                .setProductData(
                                                                                                                SessionCreateParams.LineItem.PriceData.ProductData
                                                                                                                                .builder()
                                                                                                                                .setName("Gulimll product") // Set
                                                                                                                                                            // the
                                                                                                                                                            // name
                                                                                                                                                            // of
                                                                                                                                                            // the
                                                                                                                                                            // product
                                                                                                                                .build())
                                                                                                .build())
                                                                .build())
                                .build();
                Session session = Session.create(params);

                response.sendRedirect(session.getUrl());
                return ResponseEntity.ok("Redirecting to payment...");
        };
}