package com.housely.Controller.CreditCardController;

import com.housely.Model.Card.CreditCard;
<<<<<<< Updated upstream
import com.housely.Service.CreditCardService;
=======
import com.housely.Serevice.CreditCardService;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credit-card")
public class CreditCardController {
    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/all")
    public @ResponseBody List<CreditCard> getAllCreditCards() {
        return creditCardService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody CreditCard getCreditCardById( @PathVariable String id) {
        return creditCardService.findByCreditCardNumber(id);
    }

    @PostMapping
    public @ResponseBody CreditCard addCreditCard(@RequestBody CreditCard creditCard) {
        return creditCardService.save(creditCard);
    }

    @PutMapping("/{id}")
    public @ResponseBody CreditCard updateCreditCard(@PathVariable String id, @RequestBody CreditCard creditCard) {
        creditCard.setCreditCardNumber(id);
        return creditCardService.save(creditCard);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String deleteCreditCardById(@PathVariable String id) {
        if (creditCardService.findByCreditCardNumber(id) != null) {
            creditCardService.deleteByCreditCardNumber(id);
        }
        return String.format("Credit Card Number:%s was delete successfully!", id);
    }
}
