package bg.softuni.pathfinder.exception;

public class RouteNotFoundException extends RuntimeException{
    public RouteNotFoundException(String message){
        super(message);
    }

    public RouteNotFoundException(String message, Throwable ex){
        super(message, ex);
    }
}
