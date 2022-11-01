package pg.edu.map.exception;

public class PointNotFoundException extends RuntimeException{
    public PointNotFoundException(String mes) {
        super(mes);
    }
}
