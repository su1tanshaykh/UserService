package uz.isystem.userservice;

public class BadRequest extends RuntimeException {
    BadRequest(String message){
        super(message);
    }
}
