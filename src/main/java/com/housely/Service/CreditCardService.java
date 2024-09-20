package com.housely.Service;

import com.housely.Model.Card.CreditCard;
import com.housely.Repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    private final CreditCardRepository creditCardRepository;

    // Injecting the CreditCardRepository
    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public List<CreditCard> findAll(){
        return creditCardRepository.findAll();
    }

    public CreditCard save(CreditCard creditCard){
        return creditCardRepository.save(creditCard);
    }

    public CreditCard findByCreditCardNumber(String creditCardNumber){
        return creditCardRepository.findByCreditCardNumber(creditCardNumber).orElse(null);
    }

    public void deleteByCreditCardNumber(String creditCardNumber){
        creditCardRepository.deleteByCreditCardNumber(creditCardNumber);
    }
}
