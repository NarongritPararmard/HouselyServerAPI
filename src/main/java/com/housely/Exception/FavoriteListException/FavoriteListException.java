package com.housely.Exception.FavoriteListException;

public class FavoriteListException extends RuntimeException {
    public FavoriteListException(String message) {
        super("Error message : "+message);
    }
}
