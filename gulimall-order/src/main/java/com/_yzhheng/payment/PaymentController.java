package com._yzhheng.payment;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
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

    @PostMapping("/charge")
    public ResponseEntity<String> chargeCard(@RequestParam(value = "amount", required = true) String amount,
            @RequestParam(value = "token", required = true) String tokenId) {
        try {
            ChargeCreateParams createParams = new ChargeCreateParams.Builder()
                    .setAmount(Long.parseLong(amount))
                    .setCurrency(currency)
                    .setSource(tokenId)
                    .build();

            Charge charge = Charge.create(createParams);
            return ResponseEntity.ok("Payment successful: " + charge.getId());
        } catch (StripeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment failed: " + e.getMessage());
        }
    }
}
