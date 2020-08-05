package hw13.Logger;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;


public class Logger {
    private LogDAO logDAO;

    public Logger(LogDAO logDAO){
        this.logDAO=logDAO;
    }

    public void info(String message){
        logDAO.create(new Log(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), message));
    }

    public void error(String message){
        logDAO.create(new Log(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),String.format("[ERROR] %s", message)));

    }

    public Collection<Log> getAll(){
        return logDAO.getAll();
    }

    public Collection<Log> getAllByDate(LocalDate date){
        return logDAO.getAllByDate(date);
    }


}


