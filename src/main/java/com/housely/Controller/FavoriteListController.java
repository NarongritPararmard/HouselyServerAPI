package com.housely.Controller;

import com.housely.Exception.FavoriteListException.FavoriteListException;
import com.housely.Model.Customer.Customer;
import com.housely.Model.Favorite.FavoriteList;
import com.housely.Service.CustomerService;
import com.housely.Service.FavoriteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer/{customerId}/favorite")
public class FavoriteListController {
    @Autowired
    private FavoriteListService favoriteListService ;
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public @ResponseBody List<FavoriteList> getAllFavoriteList(@PathVariable Long customerId) {
        Customer customer = customerService.findById(customerId);
        return customer.getFavorites();
    }

    @GetMapping("/{favoriteListId}")
    public @ResponseBody FavoriteList getFavoriteListById(@PathVariable Long customerId, @PathVariable Long favoriteListId) {
        try{
            customerService.findById(customerId);
            favoriteListService.findById(favoriteListId);
            return favoriteListService.findFavoriteInCustomerList(favoriteListId, customerId);
        }catch (Exception e){
            throw new FavoriteListException("FavoriteList with ID:" + favoriteListId + " not found in the customer's collection");
        }

    }

    @PostMapping
    public @ResponseBody FavoriteList addFavoriteList(@PathVariable Long customerId, @RequestBody FavoriteList favoriteList) {
        Customer customer = customerService.findById(customerId);
        favoriteList.setCustomer(customer);
        return favoriteListService.save(favoriteList);
    }

    @PutMapping("/update/{favoriteListId}")
    public ResponseEntity<?> updateFavoriteList(@PathVariable Long customerId, @PathVariable Long favoriteListId, @RequestBody FavoriteList updateFavoriteList) {
        try{
            Customer customer = customerService.findById(customerId);
            favoriteListService.findById(favoriteListId);
            updateFavoriteList.setFavoriteListId(favoriteListId);
            updateFavoriteList.setCustomer(customer);
            favoriteListService.save(updateFavoriteList);
            return new ResponseEntity<>(updateFavoriteList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{favoriteListId}")
    public ResponseEntity<?> deleteFavoriteList(@PathVariable Long customerId, @PathVariable Long favoriteListId) {
        try {
            customerService.findById(customerId);
            favoriteListService.findById(favoriteListId);
            favoriteListService.deleteById(favoriteListId);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
