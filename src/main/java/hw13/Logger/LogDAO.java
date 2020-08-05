package hw13.Logger;



import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LogDAO {
    private final File logfile;

    public LogDAO(String name) {
        this.logfile=new File(name);
    }

    public Collection<Log> getAll() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(logfile)))) {
            Object readed = ois.readObject();
            @SuppressWarnings("unchecked")
            List<Log> logs = (ArrayList<Log>) readed;
            return logs;
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Deserialization error. Didn't you forget to include 'serialVersionUID field' in your entity?", ex);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("There isn't logfile", ex);
        } catch (IOException ex) {
            throw new RuntimeException("Something went wrong", ex);
        }
    }

    public Collection<Log> getAllByDate(LocalDate date) {
        return
                getAll().stream().filter(l->l.getTime().truncatedTo(ChronoUnit.DAYS).equals(date)).collect(Collectors.toList());
    }

    public void create(Log log) {
        Collection<Log> logs = getAll();
        logs.add(log);
        write(logs);
    }

    private void write(Collection<Log> logs) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(logfile)))) {
            oos.writeObject(logs);
        } catch (IOException ex) {
            throw new RuntimeException("logfile IOException", ex);
        }

    }
}
