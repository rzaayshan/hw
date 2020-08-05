package hw13.Logger;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log implements Serializable {
    private final LocalDateTime time;
    private final String message;

    private static final long serialVersionUID = 1L;

    public Log(LocalDateTime time, String message) {
        this.time = time;
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    String represent(){
        return String.format("%s %s",time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),message);
    }
}
